/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Reymundo
 */
public class ObtenerCambio {

//    public static void main(String[] args) throws IOException {
//        String cambio = Cambio();
//        
//        System.out.println("Cambio "+cambio);
//    }
//    
    public  String Cambio () throws MalformedURLException, IOException  {
         
       
        
        String text ="";
            URL url;
     
//            try {
            
            url = new URL("http://www.bcn.gob.ni/");
        
            URLConnection con = url.openConnection();
        
//            con.setConnectTimeout(3000);
            
            InputStream s = con.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
              
                text = text + line + "\n";
            }
            
//            } catch (MalformedURLException ex) {
//            Logger.getLogger(ObtenerCambio.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//            Logger.getLogger(ObtenerCambio.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
//            System.out.println(text);
            
            int Pos = text.indexOf("<p class=\"nlink-style\">"
                    + "<a href=\"/estadisticas/mercados_cambiarios/"
                    + "tipo_cambio/cordoba_dolar/index.php\" target=\"_blank\">"
                    + "Tipo de Cambio</a></p>\n" +
"                <p>");
            int Pos2 = text.indexOf(" (NIOxUSD) <br> 20-01-15 </p>");
//            System.out.println("POS: "+Pos);
//            System.out.println("POS2: "+Pos2);
            String Cambio = text.substring(Pos,Pos2);
//            System.out.println("Cambio: "+Cambio);
            int Pos3 = Cambio.indexOf("\">");
//            System.out.println("Pos3 "+Pos3);
            String Change = Cambio.substring(Pos3+140);
//            Change = Change.trim();
//            System.out.println("Cambio Final: "+Change);
//            int Largo = Change.trim().length();   
//            System.out.println("Largo: "+Largo); 
            
            return Change.trim();
    }
    
    
}

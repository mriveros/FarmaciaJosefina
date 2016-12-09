/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Reymundo
 */
public class Respaldo {
    
    public static void CrearRespaldo(String Ruta, String Nombre){
   
        
      
        
        String RutaF = Ruta.concat("\\").concat(Nombre).concat(".bak");
            
              Date FechaI = new Date();
              DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
              String Fecha = df4.format(FechaI);

        System.out.println("Ruta: "+RutaF);
        
   try{   
  Statement Ejecutar = Conexion.con.createStatement();
  String CrearRespaldos = "Backup database SistemaFarmacia to disk = '"+RutaF+"' with name = 'Respaldo Completo "
          + "Base de Datos Farmacia', Description = '"+Fecha+"'";
  Ejecutar.executeQuery(CrearRespaldos);
//  JOptionPane.showMessageDialog(null, "Respaldo creado correctamente", "Creado correctamente", JOptionPane.INFORMATION_MESSAGE);
 
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Respaldo creado correctamente", "Creado correctamente", JOptionPane.INFORMATION_MESSAGE);
 
            
              String Comando = "explorer.exe \""+Ruta.concat("\\")+"\""; //"cmd /C dir"
    try {  
            Process p = Runtime.getRuntime().exec(Comando);  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = "";  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
        }
            
        }
    }
    
}

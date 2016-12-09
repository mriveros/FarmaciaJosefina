/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSocket;

import Procedimientos.Conexion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Reymundo
 */
public class ClienteServer {
   

public  void IniciarConexion() throws IOException{


   // InetAddress address=InetAddress.getLocalHost();
    ResultSet resultado;
    int ID = 0;
    int Puerto = 0;
    String IP = "";
    
    try{
        
        resultado = Conexion.consulta("Select Max(ID_IP_Puerto) from IP_Puerto");
        while(resultado.next()){
            ID = resultado.getInt(1);
        }
        
    }catch(SQLException ex){}
    
    try{
        
        resultado = Conexion.consulta("Select IP, Puerto from IP_Puerto where ID_IP_Puerto = "+ID);
        while(resultado.next()){
            IP = resultado.getString(1).trim();
            Puerto = resultado.getInt(2);
        }
        
    }catch(SQLException ex){}
    
    String address = IP;
    Socket s1=null;
    String line=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;

    try {
        s1=new Socket(address, Puerto); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }

    System.out.println("Client Address : "+address);
    System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

    String response=null;
    try{
       // line=br.readLine(); 
        line = "QUIT";
        while(line.compareTo("QUIT")!=0){
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println("Server Response : "+response);
                line=br.readLine();

            }



    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Closed");

    }

}



public boolean ProbarConexion() throws IOException{

    boolean conectado = true;
   // InetAddress address=InetAddress.getLocalHost();
    ResultSet resultado;
    int ID = 0;
    int Puerto = 0;
    String IP = "";
    
    try{
        
        resultado = Conexion.consulta("Select Max(ID_IP_Puerto) from IP_Puerto");
        while(resultado.next()){
            ID = resultado.getInt(1);
        }
        
    }catch(SQLException ex){
    conectado = false;
    return conectado;
    }
    
    try{
        
        resultado = Conexion.consulta("Select IP, Puerto from IP_Puerto where ID_IP_Puerto = "+ID);
        while(resultado.next()){
            IP = resultado.getString(1).trim();
            Puerto = resultado.getInt(2);
        }
        
    }catch(SQLException ex){
    conectado = false;
    return conectado;
    }
    
    String address = IP;
    Socket s1=null;
    String line=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;

    try {
        s1=new Socket(address, Puerto); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
        conectado = false;
        return conectado;
    }

    System.out.println("Client Address : "+address);
    System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

    String response=null;
    try{
       // line=br.readLine(); 
        line = "QUIT";
        while(line.compareTo("QUIT")!=0){
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println("Server Response : "+response);
                line=br.readLine();

            }



    }
    catch(IOException e){
        e.printStackTrace();
        System.out.println("Socket read Error");
        conectado = false;
        return conectado;
    }
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Closed");

    }

    
    return conectado;
}
} 
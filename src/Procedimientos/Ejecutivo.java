
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Ejecutivo {

public static ResultSet resultado;

public static void Agregar_Ejecutivo(String Nombres,String Apellidos,String Télefono,String Cédula, String Correo,
        String Direccion, String Sexo, int ID_Proveedor, String Foto){


 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Ejecutivo](?,?,?,?,?,?,?,?,?,?)}");

                
                        consulta.setString(1, Nombres);
                        consulta.setString(2, Apellidos);
                        consulta.setString(3, Télefono);
                        consulta.setString(4, Cédula);
                        consulta.setInt(5, ID_Proveedor);
                        consulta.setString(6, Correo);
                        consulta.setString(7, Direccion);
                        consulta.setString(8, Sexo);
                        consulta.setString(9, Foto);
                        consulta.setInt(10, Ventanas.MenuPrincipal.ID_Usuario);
                        
                       
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Ejecutivo Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}
public static void Actualizar_Ejecutivo(int ID, String Nombres,String Apellidos,
        String Télefono,String Cédula, String Correo,String Direccion, String Sexo, 
        int ID_Proveedor, String Foto){
    
  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Ejecutivo](?,?,?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombres);
                        consulta.setString(3, Apellidos);
                        consulta.setString(4, Télefono);
                        consulta.setString(5, Cédula);
                        consulta.setInt(6, ID_Proveedor);
                        consulta.setString(7, Correo);
                        consulta.setString(8, Direccion);
                        consulta.setString(9, Sexo);
                        consulta.setString(10, Foto);
                        consulta.setInt(11, MenuPrincipal.ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Ejecutivo Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_Ejecutivo(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Ejecutivo] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Ejecutivo Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_Ejecutivo(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Ejecutivo] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Ejecutivo Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Ejecutivo(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Ejecutivo] from [dbo].[Ejecutivo] where [ID_Ejecutivo] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Ejecutivo] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Ejecutivo Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Ejecutivo] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Ejecutivo Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

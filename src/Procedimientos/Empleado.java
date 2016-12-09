
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Empleado {

public static ResultSet resultado;

public static void Agregar_Empleado(String Nombres,String Apellidos,String Télefono,String Cédula, String Correo,
        String Direccion, double Comision, String Foto, String Area){


 
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Empleado](?,?,?,?,?,?,?,?,?,?,?)}");

                
                        consulta.setString(1, Nombres);
                        consulta.setString(2, Apellidos);
                        consulta.setString(3, Télefono);
                        consulta.setString(4, Cédula);
                        consulta.setString(5, Correo);
                        consulta.setString(6, Direccion);
                        consulta.setString(7, Foto);
                        consulta.setInt(8, MenuPrincipal.ID_Usuario);
                        consulta.setDouble(9, 0);
                        consulta.setDouble(10, Comision);
                        consulta.setString(11, Area);
                        
                       
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Empleado Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}
public static void Actualizar_Empleado(int ID, String Nombres,String Apellidos,
        String Télefono,String Cédula, String Correo,String Direccion, 
        double Comision, String Foto, String Area){
    
  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Empleado](?,?,?,?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                         consulta.setString(2, Nombres);
                        consulta.setString(3, Apellidos);
                        consulta.setString(4, Télefono);
                        consulta.setString(5, Cédula);
                        consulta.setString(6, Correo);
                        consulta.setString(7, Direccion);
                        consulta.setString(8, Foto);
                        consulta.setInt(9, MenuPrincipal.ID_Usuario);
                        consulta.setDouble(10, 0);
                        consulta.setDouble(11, Comision);
                        consulta.setString(12, Area);
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Empleado Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_Empleado(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Empleado] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Empleado Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_Empleado(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Empleado] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Empleado Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Empleado(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Empleado] from [dbo].[Empleado] where [ID_Empleado] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Empleado] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Empleado Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Empleado] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Empleado Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

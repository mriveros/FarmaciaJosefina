
package Procedimientos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Proveedor {

public static ResultSet resultado;

public static void Agregar_Proveedor(String Nombre,String NoRuc,String Télefono,String TipoProveedor, String Correo,
        String Direccion, String Foto){


 int ID= 0;
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Proveedor](?,?,?,?,?,?,?,?)}");

       
                        
                        consulta.setString(1, Nombre);
                        consulta.setString(2, NoRuc);
                        consulta.setString(3, Télefono);
                        consulta.setString(4, TipoProveedor);
                        consulta.setString(5, Correo);
                        consulta.setString(6, Direccion);
                        consulta.setString(7, Foto);
                        consulta.setInt(8, Ventanas.MenuPrincipal.ID_Usuario);
                        //consulta.registerOutParameter(9, java.sql.Types.INTEGER);
                        
                    
                      
                        consulta.execute();
                        
                  //      ID=consulta.getInt(9);
                        

         JOptionPane.showMessageDialog(null,"Datos del Proveedor Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}
public static void Actualizar_Proveedor(int ID, String Nombre,String NoRuc,String Télefono,String TipoProveedor, String Correo,
        String Direccion, String Foto){
    
  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Proveedor](?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, NoRuc);
                        consulta.setString(4, Télefono);
                        consulta.setString(5, TipoProveedor);
                        consulta.setString(6, Correo);
                        consulta.setString(7, Direccion);
                        consulta.setString(8, Foto);
                        consulta.setInt(9, Ventanas.MenuPrincipal.ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Proveedor Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_Proveedor(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Proveedor] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Proveedor Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_Proveedor(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Proveedor] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Proveedor Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Proveedor(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Proveedor] from [dbo].[Proveedor] where [ID_Proveedor] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Proveedor] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Proveedor Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Proveedor] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Proveedor Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

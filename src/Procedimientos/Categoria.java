
package Procedimientos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Categoria {

public static ResultSet resultado;

public static void Agregar_Categoria(String Nombre, String Descripcion){


 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Categoria](?,?,?)}");

                
                        consulta.setString(1, Nombre);
                        consulta.setString(2, Descripcion);
                        consulta.setInt(3, Ventanas.MenuPrincipal.ID_Usuario);
                        
                       
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de la Categoria Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}
public static void Actualizar_Categoria(int ID, String Nombre, String Descripcion){
    
  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Categoria](?,?,?,?)}");

                        consulta.setInt(1,ID);
                         consulta.setString(2, Nombre);
                        consulta.setString(3, Descripcion);
                        consulta.setInt(4, Ventanas.MenuPrincipal.ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de la Categoria Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_Categoria(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Categoria] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Categoria Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_Categoria(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Categoria] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Categoria Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Categoria(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Categoria] from [dbo].[Categoria] where [ID_Categoria] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Categoria] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Categoria Desactivada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Categoria] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Categoria Activada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

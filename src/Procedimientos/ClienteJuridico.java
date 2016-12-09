
package Procedimientos;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteJuridico {

public static ResultSet resultado;

public static int Agregar_ClienteJuridico(String Nombre,String NoRuc,String Télefono, double Descuento, String Correo,
        String Direccion, String Foto){

BigDecimal DescuentoD = BigDecimal.valueOf(Descuento);
 
int ID_ClienteJ = 0;
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_ClienteJuridico](?,?,?,?,?,?,?,?,?)}");

       
                        
                        consulta.setString(1, Nombre);
                        consulta.setString(2, NoRuc);
                        consulta.setString(3, Télefono);
                        consulta.setBigDecimal(4, DescuentoD);
                        consulta.setString(5, Correo);
                        consulta.setString(6, Direccion);
                        consulta.setString(7, Foto);
                        consulta.setInt(8, Ventanas.MenuPrincipal.ID_Usuario);
                        consulta.registerOutParameter(9, java.sql.Types.INTEGER);
                        
                    
                      
                        consulta.execute();
                        
                        ID_ClienteJ =consulta.getInt(9);
                    
                       

         JOptionPane.showMessageDialog(null,"Datos del ClienteJuridico Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
        
         return ID_ClienteJ;
}
public static void Actualizar_ClienteJuridico(int ID, String Nombre,String NoRuc,String Télefono,double Descuento, String Correo,
        String Direccion, String Foto){
    
  BigDecimal DescuentoD = BigDecimal.valueOf(Descuento);

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_ClienteJuridico](?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, NoRuc);
                        consulta.setString(4, Télefono);
                        consulta.setBigDecimal(5, DescuentoD);
                        consulta.setString(6, Correo);
                        consulta.setString(7, Direccion);
                        consulta.setString(8, Foto);
                        consulta.setInt(9, Ventanas.MenuPrincipal.ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del ClienteJuridico Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_ClienteJuridico(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_ClienteJuridico] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"ClienteJuridico Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_ClienteJuridico(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_ClienteJuridico] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"ClienteJuridico Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_ClienteJuridico(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_ClienteJuridico] from [dbo].[ClienteJuridico] where [ID_ClienteJuridico] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_ClienteJuridico] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"ClienteJuridico Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_ClienteJuridico] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"ClienteJuridico Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

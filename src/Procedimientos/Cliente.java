
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cliente {

public static ResultSet resultado;

public static void Agregar_Cliente(String Nombres,String Apellidos,String Télefono,String Cédula, String Correo,
        String Direccion, String Sexo, double Descuento, String Foto, int ID_ClienteJuridico, String Representante){

        BigDecimal DescuentoD = BigDecimal.valueOf(Descuento);
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Cliente](?,?,?,?,?,?,?,?,?,?,?,?)}");

                        consulta.setString(1, Nombres);
                        consulta.setString(2, Apellidos);
                        consulta.setString(3, Télefono);
                        consulta.setString(4, Cédula);
                        consulta.setBigDecimal(5, DescuentoD);
                        consulta.setString(6, Correo);
                        consulta.setString(7, Direccion);
                        consulta.setString(8, Sexo);
                        consulta.setString(9, Foto);
                        consulta.setInt(10, Ventanas.MenuPrincipal.ID_Usuario);
                        consulta.setInt(11, ID_ClienteJuridico);
                        consulta.setString(12, Representante);
                        
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Cliente Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}

        
public static void Actualizar_Cliente(int ID, String Nombres,String Apellidos,
        String Télefono,String Cédula, String Correo,String Direccion, String Sexo, 
        double Descuento, String Foto, int ID_ClienteJuridico, String Representante){
    
  
        BigDecimal DescuentoD = BigDecimal.valueOf(Descuento);
        
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Cliente](?,?,?,?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombres);
                        consulta.setString(3, Apellidos);
                        consulta.setString(4, Télefono);
                        consulta.setString(5, Cédula);
                        consulta.setBigDecimal(6, DescuentoD);
                        consulta.setString(7, Correo);
                        consulta.setString(8, Direccion);
                        consulta.setString(9, Sexo);
                        consulta.setString(10, Foto);
                        consulta.setInt(11, MenuPrincipal.ID_Usuario);
                         consulta.setInt(12, ID_ClienteJuridico);
                  //      consulta.setString(13, Representante);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Cliente Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
        
}



public static void Desactivar_Cliente(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Cliente] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Cliente Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}



public static void Activar_Cliente(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Cliente] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Cliente Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Cliente(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Cliente] from [dbo].[Cliente] where [ID_Cliente] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Cliente] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Cliente Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Cliente] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Cliente Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}


}

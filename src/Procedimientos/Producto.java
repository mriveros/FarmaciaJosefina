
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Producto {

public static ResultSet resultado;

public static void Agregar_Producto(String Nombre, String Codigo, int ID_Categoria, int ID_Proveedor, 
       String Descripcion, String Controlado, int StockMin, String TipoMedicamento, double MargenGanancia,
       String Presentacion, int UnidsXCaja, String Foto, int ID_Laboratorio, String ExcludIVA){

      int UnidsDisponibles = 0;
      double PrecioVenta = 0;
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Producto](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

                
                        consulta.setString(1, Nombre);
                        consulta.setString(2, Codigo);
                        consulta.setInt(3, ID_Categoria);
                        consulta.setInt(4, ID_Proveedor);
                        consulta.setInt(5, ID_Laboratorio);
                        consulta.setString(6, Descripcion);
                        consulta.setString(7, Controlado);
                        consulta.setInt(8, UnidsDisponibles);
                        consulta.setDouble(9, PrecioVenta);
                        consulta.setInt(10, StockMin);
                        consulta.setString(11, TipoMedicamento);
                        consulta.setDouble(12, MargenGanancia);
                        consulta.setString(13, Presentacion);
                        consulta.setInt(14, UnidsXCaja);
                        consulta.setString(15, Foto);
                        consulta.setInt(16, Ventanas.MenuPrincipal.ID_Usuario);
                        consulta.setString(17, ExcludIVA);
                        
                       
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Producto Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}
public static void Actualizar_Producto(int ID, String Nombre, String Codigo, int ID_Categoria, int ID_Proveedor, 
       String Descripcion, String Controlado, int StockMin, String TipoMedicamento, double MargenGanancia,
       String Presentacion, int UnidsXCaja, String Foto, int ID_Laboratorio, String ExcludIVA){
    
//     try {
//
//        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_PrecioVenta](?,?,?)}");
//
//                        consulta.setInt(1,ID);
//                        consulta.setDouble(2, MargenGanancia);
//                        consulta.setInt(3, MenuPrincipal.ID_Usuario);
//                        consulta.execute();
//
//         JOptionPane.showMessageDialog(null,"Precio de Venta Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
//
//        } catch (SQLException ex) {
//
//        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
//
//        }
//  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Actualizar_Producto](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombre);
                        consulta.setString(3, Codigo);
                        consulta.setInt(4, ID_Categoria);
                        consulta.setInt(5, ID_Proveedor);
                        consulta.setInt(6, ID_Laboratorio);
                        consulta.setString(7, Descripcion);
                        consulta.setString(8, Controlado);
                        consulta.setInt(9, StockMin);
                        consulta.setString(10, TipoMedicamento);
                        consulta.setDouble(11, MargenGanancia);
                        consulta.setString(12, Presentacion);
                        consulta.setInt(13, UnidsXCaja);
                        consulta.setString(14, Foto);
                        consulta.setInt(15, Ventanas.MenuPrincipal.ID_Usuario);
                        consulta.setString(16, ExcludIVA);
                        
                        
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Producto Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}



public static void Desactivar_Producto(int ID){
    
    try{
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Producto] (?)}");

     consulta.setInt(1, ID);
     consulta.execute();
     
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
     //JOptionPane.showMessageDialog(null,"Producto Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
}

public static void Activar_Producto(int ID){
  
    try{
        
            
        
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Producto] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 

//    JOptionPane.showMessageDialog(null,"Producto Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Activar_Desactivar_Producto(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select [Estado_Producto] from [dbo].[Producto] where [ID_Producto] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Producto] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Producto Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Producto] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Producto Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
}

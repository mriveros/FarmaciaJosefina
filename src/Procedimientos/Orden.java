
package Procedimientos;



import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Orden {

public static ResultSet resultado;


    
public static int Agregar_Orden(int ID_Empleado, String NombreCliente, int ID_Cliente, Date Fecha_Orden,
double Descuento, int ID_TipoCambio,  String TipoFactura, String Cancelada){   
    
         
    
   long FechaC = Fecha_Orden.getTime();
   java.sql.Date FechaCo = new java.sql.Date(FechaC);
   
   int ID = 0;
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Orden] (?,?,?,?,?,?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Empleado);
                        consulta.setString(2, NombreCliente);
                        consulta.setInt(3, ID_Cliente);
                        consulta.setDate(4,FechaCo);
                        consulta.setDouble(5, Descuento);
                        consulta.setInt(6, ID_TipoCambio);
                        consulta.setString(7, TipoFactura);
                        consulta.setInt(8, MenuPrincipal.ID_Usuario);
                        consulta.setString(9, Cancelada);
                        consulta.registerOutParameter(10, java.sql.Types.INTEGER);
                      
                        consulta.execute();
                        
                       ID = consulta.getInt(10);

         JOptionPane.showMessageDialog(null,"Orden Realizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }

    return ID;
    
    }



public static void Agregar_DetalleOrden(int ID_Orden, int ID_Producto, int UnidadesVendidas, String Presentacion,
        double PrecioVenta){   
    
     
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_DetalleOrden] (?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Orden);
                        consulta.setInt(2, ID_Producto);
                        consulta.setInt(3, UnidadesVendidas);
                        consulta.setString(4, Presentacion);
                        consulta.setDouble(5, PrecioVenta);
                       
                      
                        consulta.execute();

     //    JOptionPane.showMessageDialog(null,"Detaelle Orden Guardada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }

    }
public static void DisminuirInventario(int ID_Producto, int UnidsVendidas){   
 
  //java.sql.Date FechaV = new java.sql.Date(Fecha1.getTime());
          
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[DisminuirInventario](?,?)}");

                
                        consulta.setInt(1, ID_Producto);
                        consulta.setInt(2, UnidsVendidas);
                        

                        consulta.execute();

     //    JOptionPane.showMessageDialog(null,"Disminución Realizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}

public static void Agregar_OrdenFactura(int ID_Orden, double Subtotal, double IVA, String Descuento, double Total){   
    
         

    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_OrdenFacturar] (?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Orden);
                        consulta.setDouble(2, Subtotal);
                        consulta.setDouble(3, IVA);
                        consulta.setString(4,Descuento);
                        consulta.setDouble(5, Total);
                    
                      
                        consulta.execute();
                        
                  

     //    JOptionPane.showMessageDialog(null,"Orden Factura Realizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

     
    }
}


public static void Pagar_Orden(int ID_Venta, String Moneda, String ModoVenta, double Recibido){   
    
         

    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Pagar_Factura] (?,?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Venta);
                        consulta.setInt(2, MenuPrincipal.ID_Usuario );
                        consulta.setString(3,Moneda);
                        consulta.setString(4,ModoVenta);
                        consulta.setDouble(5, Recibido);
                        consulta.setInt(6, MenuPrincipal.ID_Usuario);
                      
                        consulta.execute();
                        
                  

      //   JOptionPane.showMessageDialog(null,"Orden Pagada Realizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

     
    }
}


public static void Agregar_DetalleFactura(int ID_Orden, String Producto, int UnidadesVendidas,
        double PrecioVenta, double Total, String Presentacion
        ){   
    
     
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_OrdenFact] (?,?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Orden);
                        consulta.setInt(2, UnidadesVendidas);
                        consulta.setString(3, Producto);
                        consulta.setDouble(4, PrecioVenta);
                        consulta.setDouble(5, Total);
                        consulta.setString(6, Presentacion);
                       
                      
                        consulta.execute();

      //   JOptionPane.showMessageDialog(null,"Detaelle Orden Guardada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }

    }


}

package Procedimientos;



import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Proforma {

public static ResultSet resultado;


    
public static int Agregar_Proforma(int ID_Empleado, String NombreCliente, int ID_Cliente, Date Fecha_Proforma,
double Descuento, int ID_TipoCambio,  String TipoFactura){   
    
         
    
   long FechaC = Fecha_Proforma.getTime();
   java.sql.Date FechaCo = new java.sql.Date(FechaC);
   
   int ID = 0;
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Proforma] (?,?,?,?,?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Empleado);
                        consulta.setString(2, NombreCliente);
                        consulta.setInt(3, ID_Cliente);
                        consulta.setDate(4,FechaCo);
                        consulta.setDouble(5, Descuento);
                        consulta.setInt(6, ID_TipoCambio);
                        consulta.setString(7, TipoFactura);
                        consulta.setInt(8, MenuPrincipal.ID_Usuario);
                        consulta.registerOutParameter(9, java.sql.Types.INTEGER);
                      
                        consulta.execute();
                        
                       ID = consulta.getInt(9);

         JOptionPane.showMessageDialog(null,"Proforma Realizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }

    return ID;
    
    }



public static void Agregar_DetalleProforma(int ID_Proforma, int ID_Producto, int UnidadesVendidas, String Presentacion,
        double PrecioVenta){   
    
     
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_DetalleProforma] (?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Proforma);
                        consulta.setInt(2, ID_Producto);
                        consulta.setInt(3, UnidadesVendidas);
                        consulta.setString(4, Presentacion);
                        consulta.setDouble(5, PrecioVenta);
                       
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Detaelle Proforma Guardada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }

    }



}
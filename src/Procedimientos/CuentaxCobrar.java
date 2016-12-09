
package Procedimientos;



import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class CuentaxCobrar {

public static ResultSet resultado;


    
public static void Agregar_Cuenta(int ID_Cliente, int ID_Orden, Date Fecha_Orden,
double Total){   
    
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(Fecha_Orden);     
     
     calendar.add(Calendar.DAY_OF_YEAR, 30);
     Date Limite = calendar.getTime();
    
   long FechaC = Fecha_Orden.getTime();
   java.sql.Date FechaCo = new java.sql.Date(FechaC);
   
   
     
   
   long FechaLimit = Limite.getTime();
   java.sql.Date FechaLimi = new java.sql.Date(FechaLimit);
   
   
    try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_CuentaxCobrar] (?,?,?,?,?)}");

                
                        consulta.setInt(1, ID_Cliente);
                        consulta.setInt(2, ID_Orden);
                        consulta.setDouble(3, Total);
                        consulta.setDate(4,FechaCo);
                        consulta.setDate(5, FechaLimi);
                       
                      
                        consulta.execute();
                        
                 

         JOptionPane.showMessageDialog(null,"Cuenta por Cobrar Agregada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }


    
    }




}
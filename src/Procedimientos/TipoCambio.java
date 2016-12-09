
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TipoCambio {

public static ResultSet resultado;

public static void Agregar_TipoCambio(double NuevoCambio, String BCN){

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Tipo_Cambio] (?,?,?)}");

                
                        consulta.setDouble(1, NuevoCambio);
                        consulta.setString(2, BCN);
                        consulta.setInt(3, MenuPrincipal.ID_Usuario);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Tipo de Cambio Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}

}
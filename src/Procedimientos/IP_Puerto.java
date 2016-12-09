
package Procedimientos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class IP_Puerto {

public static ResultSet resultado;

public static void Agregar_IP_Puerto(String IP, int Puerto){

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_IP_Puerto] (?,?)}");

                
                        consulta.setString(1, IP);
                        consulta.setInt(2, Puerto);

                        consulta.execute();

       //  JOptionPane.showMessageDialog(null,"Tipo de Cambio Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage());

        }
}

}
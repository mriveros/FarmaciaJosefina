package Procedimientos;

import Ventanas.MenuPrincipal;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Compra {

    public static ResultSet resultado;

    public static int Agregar_Compra(int ID_Proveedor, int ID_Ejecutivo,
            Date Fecha_Compra, String Modo_Compra, int Tiempo_Pago, String No_Factura, String Cancelado) {

        long FechaC = Fecha_Compra.getTime();
        java.sql.Date FechaComp = new java.sql.Date(FechaC);

        int ID_Compra = 0;

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Compra](?,?,?,?,?,?,?,?,?)}");

            consulta.setInt(1, ID_Proveedor);
            consulta.setInt(2, ID_Ejecutivo);
            consulta.setInt(3, MenuPrincipal.ID_Usuario);
            consulta.setDate(4, FechaComp);
            consulta.setString(5, Modo_Compra);
            consulta.setInt(6, Tiempo_Pago);
            consulta.setString(7, No_Factura);
            consulta.setString(8, Cancelado);
            consulta.registerOutParameter(9, java.sql.Types.INTEGER);

            consulta.execute();

            ID_Compra = consulta.getInt(9);

           
            JOptionPane.showMessageDialog(null, "Compra Realizada Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ID_Compra;

    }

    
    public static void Modificar_DetalleCompra(int ID_DetCompra, 
            Date Fecha_Vencimiento, int Unids_Compradas, double Costo_Compra, BigDecimal Descuento,
            String Modo_Adquisicion, String Incluye_IVA, String Permite_Devolucion,
            int Cantidad_Devolucion, String Incluye_Vineta, double Cantidad_Vineta, double DescuentoMonet) {

        long FechaV = Fecha_Vencimiento.getTime();
        java.sql.Date FechaVenc = new java.sql.Date(FechaV);

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_DetalleCompra](?,?,?,?,?,?,?,?,?,?,?,?)}");

            consulta.setInt(1, ID_DetCompra);
            consulta.setDate(2, FechaVenc);
            consulta.setInt(3, Unids_Compradas);
            consulta.setDouble(4, Costo_Compra);
            consulta.setBigDecimal(5, Descuento);
            consulta.setString(6, Modo_Adquisicion);
            consulta.setString(7, Incluye_IVA);
            consulta.setString(8, Permite_Devolucion);
            consulta.setInt(9, Cantidad_Devolucion);
            consulta.setString(10, Incluye_Vineta);
            consulta.setDouble(11, Cantidad_Vineta);
            consulta.setDouble(12, DescuentoMonet);

            consulta.execute();

//            System.out.println("ID: "+ID_Compra);
//            System.out.println("IDP: "+ID_Producto);
//            System.out.println("FechaV: "+FechaVenc.toString());
//            System.out.println("Unid: "+Unids_Compradas);
//            System.out.println("CU: "+Costo_Compra);
//            System.out.println("Desc: "+Descuento);
//            System.out.println("Modo: "+Modo_Adquisicion);
//            System.out.println("IVA: "+Incluye_IVA);
//            System.out.println("Devol: "+Permite_Devolucion);
//            System.out.println("Cant Dev: "+Cantidad_Devolucion);
//            System.out.println("Vine: "+Incluye_Vineta);
//            System.out.println("Cant Vine: "+Cantidad_Vineta);
//            System.out.println("DescMonet: "+DescuentoMonet);
            
         // JOptionPane.showMessageDialog(null, "Compra Realizada Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

            }   catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//
//        }
        }
    
    public static void CambiarNoFactura(int ID, String No){
          try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_NoFactura] (?,?)}");

            consulta.setInt(1, ID);
            consulta.setString(2, No);
           

            consulta.execute();

       //     JOptionPane.showMessageDialog(null, "Devolución Realizada Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    
    public static void Agregar_DetalleCompra(int ID_Compra, int ID_Producto,
            Date Fecha_Vencimiento, int Unids_Compradas, double Costo_Compra, BigDecimal Descuento,
            String Modo_Adquisicion, String Incluye_IVA, String Permite_Devolucion,
            int Cantidad_Devolucion, String Incluye_Vineta, double Cantidad_Vineta, double DescuentoMonet) {

        long FechaV = Fecha_Vencimiento.getTime();
        java.sql.Date FechaVenc = new java.sql.Date(FechaV);

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_DetalleCompra](?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            consulta.setInt(1, ID_Compra);
            consulta.setInt(2, ID_Producto);
            consulta.setDate(3, FechaVenc);
            consulta.setInt(4, Unids_Compradas);
            consulta.setDouble(5, Costo_Compra);
            consulta.setBigDecimal(6, Descuento);
            consulta.setString(7, Modo_Adquisicion);
            consulta.setString(8, Incluye_IVA);
            consulta.setString(9, Permite_Devolucion);
            consulta.setInt(10, Cantidad_Devolucion);
            consulta.setString(11, Incluye_Vineta);
            consulta.setDouble(12, Cantidad_Vineta);
            consulta.setDouble(13, DescuentoMonet);

            consulta.execute();

//            System.out.println("ID: "+ID_Compra);
//            System.out.println("IDP: "+ID_Producto);
//            System.out.println("FechaV: "+FechaVenc.toString());
//            System.out.println("Unid: "+Unids_Compradas);
//            System.out.println("CU: "+Costo_Compra);
//            System.out.println("Desc: "+Descuento);
//            System.out.println("Modo: "+Modo_Adquisicion);
//            System.out.println("IVA: "+Incluye_IVA);
//            System.out.println("Devol: "+Permite_Devolucion);
//            System.out.println("Cant Dev: "+Cantidad_Devolucion);
//            System.out.println("Vine: "+Incluye_Vineta);
//            System.out.println("Cant Vine: "+Cantidad_Vineta);
//            System.out.println("DescMonet: "+DescuentoMonet);
            
        //    JOptionPane.showMessageDialog(null, "Detalle Compra Realizada Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

            }   catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//
//        }
        }
    

    public static void Agregar_DevoluciónC(int ID_DetalleCompra, String FechaDevolución, int ID_Producto, int Unids_Devueltas,
            double Costo_Devolución, Date Fecha_Devolucion) {

        long FechaDev = Fecha_Devolucion.getTime();
        java.sql.Date FechaD = new java.sql.Date(FechaDev);

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Devolucion] (?,?,?,?,?,?)}");

            consulta.setInt(1, ID_DetalleCompra);
            consulta.setInt(2, ID_Producto);
            consulta.setInt(3, Unids_Devueltas);
            consulta.setDouble(4, Costo_Devolución);
            consulta.setInt(5, MenuPrincipal.ID_Usuario);
            consulta.setDate(6, FechaD);

            consulta.execute();

       //     JOptionPane.showMessageDialog(null, "Devolución Realizada Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }

    public static void Desactivar_Inventario(int ID_DetalleCompra, int ID_Producto, int Unids_Inactivas,
            double CostoUnit, Date Fecha_Inactiva) {

        long FechaI = Fecha_Inactiva.getTime();
        java.sql.Date FechaInact = new java.sql.Date(FechaI);

        try {

            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Inventario] (?,?,?,?,?,?)}");

            consulta.setInt(1, ID_DetalleCompra);
            consulta.setInt(2, ID_Producto);
            consulta.setInt(3, Unids_Inactivas);
            consulta.setDouble(4, CostoUnit);
            consulta.setInt(5, MenuPrincipal.ID_Usuario);
            consulta.setDate(6, FechaInact);

            consulta.execute();

     //       JOptionPane.showMessageDialog(null, "Inventario Desactivado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }

    public static void Anular_Compra(int ID) {

        try {
            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Anular_Compra] (?)}");

            consulta.setInt(1, ID);
            consulta.execute();
            
             JOptionPane.showMessageDialog(null,"Compra anulada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    
    }

//    public static void Activar_Compra(int ID) {
//
//        try {
//
//            CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Compra] (?)}");
//
//            consulta.setInt(1, ID);
//            consulta.execute();
//
////    JOptionPane.showMessageDialog(null,"Compra Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
//    }

//    public static void Activar_Desactivar_Compra(int ID) {
//
//        try {
//
//            String estado = null;
//            resultado = Conexion.consulta("Select [Estado_Compra] from [dbo].[Compra] where [ID_Compra] = " + ID);
//            while (resultado.next()) {
//
//                estado = resultado.getString(1);
//            }
//
//            if ("Activo".equals(estado)) {
//                CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Compra] (?)}");
//
//                consulta.setInt(1, ID);
//                consulta.execute();
//                JOptionPane.showMessageDialog(null, "Compra Desactivado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
//
//            }
//
//            if ("Inactivo".equals(estado)) {
//                CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Compra] (?)}");
//
//                consulta.setInt(1, ID);
//                consulta.execute();
//                JOptionPane.showMessageDialog(null, "Compra Activado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
//    }

}

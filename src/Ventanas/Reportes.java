/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Procedimientos.Conexion;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
 
/**
 *
 * @author ReymundoAsus
 */
public class Reportes extends javax.swing.JDialog {

    /**
     * Creates new form FotoModo
     */
    public Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
              try {
            this.setIconImage(new ImageIcon(getClass().getResource("Icono.png")).getImage());
        } catch (NullPointerException ex) {
        }
         
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Report2.png"))); // NOI18N
        jButton4.setMnemonic('I');
        jButton4.setText("Reporte de Inventario a Agotarse");
        jButton4.setToolTipText("");
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Report3.png"))); // NOI18N
        jButton5.setMnemonic('V');
        jButton5.setText("Reporte Producto Proximo a Vencerse");
        jButton5.setToolTipText("");
        jButton5.setContentAreaFilled(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Report4.png"))); // NOI18N
        jButton8.setMnemonic('V');
        jButton8.setText("Reporte de Compras Significativas Semanal");
        jButton8.setToolTipText("Crear Respaldo de la Base de Datos");
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Report5.png"))); // NOI18N
        jButton6.setMnemonic('V');
        jButton6.setText("Reporte de Ventas del Día");
        jButton6.setToolTipText("");
        jButton6.setContentAreaFilled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(640, 306));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//     MP.setVisible(false);
        
//        rdBusc.setSelected(true);        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

//     MenuPrincipal MP;
//
//    public void setMP(MenuPrincipal MP) {
//        this.MP = MP;
////    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                 
        File miDir = new File ("");
        String reporte = miDir.getAbsolutePath()+"\\src\\Reportes\\ProdAgotarse.jasper";

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(reporte, null,Conexion.con);
        } catch (JRException ex) {

            //                Logger.getLogger(InventarioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jp, false);
        view.setTitle("Productos a agotarse - Sistema de Inventario y Facturación RJ");

        view.setZoomRatio((float) 0.95);
        view.setVisible(true);

        view.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        view.toFront(); 

          
       // this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     
                     Calendar c1 = GregorianCalendar.getInstance();
   //     SimpleDateFormat sdf;
  //      sdf = new SimpleDateFormat("dd/MM/yyyy");
        c1.add(Calendar.MONTH, 5);
//        System.out.println("Fecha Formateada: "+sdf.format(c1.getTime())); 
        Date Fecha = c1.getTime();

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("Fecha", Fecha);

          
            File miDir = new File ("");
        String reporte = miDir.getAbsolutePath()+"\\src\\Reportes\\UnidsVencerse.jasper";

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(reporte, parametros, Conexion.con);
        } catch (JRException ex) {

            //                Logger.getLogger(InventarioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jp, false);
        view.setTitle("Unidades a vencerse - Sistema de Inventario y Facturación RJ");

        view.setZoomRatio((float) 0.95);
        view.setVisible(true);

        view.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        view.toFront();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    File miDir = new File ("");
        String reporte = miDir.getAbsolutePath()+"\\src\\Reportes\\VentasTotales.jasper";

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(reporte, null,Conexion.con);
        } catch (JRException ex) {

            //                Logger.getLogger(InventarioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jp, false);
        view.setTitle("Ventas Diaria - Sistema de Inventario y Facturación RJ");

        view.setZoomRatio((float) 0.95);
        view.setVisible(true);

        view.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        view.toFront();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//    MP.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
   File miDir = new File ("");
        String reporte = miDir.getAbsolutePath()+"\\src\\Reportes\\ComprasXDia.jasper";

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(reporte, null,Conexion.con);
        } catch (JRException ex) {

            //                Logger.getLogger(InventarioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jp, false);
        view.setTitle("Compras Significativas por Semana - Sistema de Inventario y Facturación RJ");

        view.setZoomRatio((float) 0.95);
        view.setVisible(true);

        view.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        
        view.toFront();      // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reportes dialog = new Reportes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

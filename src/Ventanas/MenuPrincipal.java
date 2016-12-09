/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import Procedimientos.Conexion;
import JLayer.WaitLayerUI;
import com.keffect.effects.animatedEffects.Shape;
import com.keffectpanel.KEffectPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.edisoncor.gui.util.Avatar;

/**
 *
 * @author Reymundo Tenorio
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("Icono.png")).getImage());
        } catch (NullPointerException ex) {
        }
         
        initComponents();
        
        
         jlayer = new JLayer<>(this.jPanel1, wui);
        stopper = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                wui.stop();
            }
        });
        
        MenuPrincipal.jlayer.setSize(this.jPanel1.getX(), this.jPanel1.getY());
        this.add(jlayer);
        
        reloj(); 
       
    }
    
     public static void setWaitProcess() {
        wui.start();
        if (!stopper.isRunning()) {
            stopper.start();
        }
    }
     
      public static void setProcess() {
        setWaitProcess();
    }
      
    static WaitLayerUI wui = new WaitLayerUI();
    static Timer stopper ;
    static JLayer<JPanel> jlayer;
    
    
    public static String UsuarioBD;
    public static int ID_Usuario = 1;

    public void setID_Usuario(int ID_Usuario) {
        MenuPrincipal.ID_Usuario = ID_Usuario;
    }
    
    public void setUsuarioBD(String UsuarioBD) {
        MenuPrincipal.UsuarioBD = UsuarioBD;
    }

    private ResultSet resultado;
    
    
   
    private String Area;

   
  
    
      public void Iniciar(){
        
         
      MyAvatar.setAmount(0);
      //MyAvatar.setOpaque(true);
        
      
      List Avatares = new ArrayList();

      String Privilegio = "Publico";
      
            try{
                
            resultado = Conexion.consulta("Select [Privilegio] from [dbo].[Usuario] where [ID_Empleado] = '"+ID_Usuario+"'");
  
            while(resultado.next()){

            Privilegio = resultado.getString(1);
            
            }
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
       
      
      if("Administrador".equalsIgnoreCase(UsuarioBD) || "sa".equalsIgnoreCase(UsuarioBD) ||
              "Administrador".equalsIgnoreCase(Privilegio)){
          
          
            
         
  Avatares.add(new Avatar("Proveedor", LoadImage("/Imagenes/Proveedor.png")));
  Avatares.add(new Avatar("Ejecutivo", LoadImage("/Imagenes/Ejecutivo.png")));
  Avatares.add(new Avatar("Categoría", LoadImage("/Imagenes/Categorias.png")));
  Avatares.add(new Avatar("Producto", LoadImage("/Imagenes/Producto.png")));
  Avatares.add(new Avatar("Cliente", LoadImage("/Imagenes/Cliente.png")));
  Avatares.add(new Avatar("Pedido", LoadImage("/Imagenes/Compras.png")));
  Avatares.add(new Avatar("Inventario", LoadImage("/Imagenes/Inventario.png")));  
  Avatares.add(new Avatar("Venta", LoadImage("/Imagenes/Factura.png")));  
  Avatares.add(new Avatar("Proforma", LoadImage("/Imagenes/Proforma.png")));  
  Avatares.add(new Avatar("Cajero", LoadImage("/Imagenes/Cajero.png")));
  Avatares.add(new Avatar("Reportes", LoadImage("/Imagenes/Ireport.png")));  
  Avatares.add(new Avatar("Empleado", LoadImage("/Imagenes/Empleados.png")));  
  Avatares.add(new Avatar("Configuración", LoadImage("/Imagenes/Config.png")));  
  
     MyAvatar.setAvatars(Avatares);
     
       
      }
      else{
          
      try{
          resultado = Conexion.consulta("Select Area from EmpleadoV where ID_Empleado = "+ID_Usuario);
          
          while(resultado.next()){
              Area = resultado.getString(1);
          }
          
      }catch(SQLException ex){} 
               
    if("Ventas".equalsIgnoreCase(Area)){
 
  Avatares.add(new Avatar("Inventario", LoadImage("/Imagenes/Inventario.png")));  
  Avatares.add(new Avatar("Venta", LoadImage("/Imagenes/Factura.png")));  
  Avatares.add(new Avatar("Proforma", LoadImage("/Imagenes/Proforma.png")));  
 
     MyAvatar.setAvatars(Avatares);
    }
    
    if("Caja".equals(Area)){
      
        Avatares.add(new Avatar("Cajero", LoadImage("/Imagenes/Cajero.png")));
 
     MyAvatar.setAvatars(Avatares);
    }
       
      }
      
 
        
    }
      
      private static Image LoadImage(String Filename){
        try{ 
            
            return ImageIO.read(JFrame.class.getResource(Filename));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MyAvatar = new org.edisoncor.gui.panel.PanelAvatarChooser();
        btnclosesession = new javax.swing.JButton();
        LabelUser = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menú Principal");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1 = PanelEffect;
        jPanel1.setLayout(new java.awt.BorderLayout());

        MyAvatar.setColorPrimario(new java.awt.Color(102, 102, 255));
        MyAvatar.setColorSecundario(new java.awt.Color(0, 0, 153));
        MyAvatar.setGradiente(org.edisoncor.gui.panel.Panel.Gradiente.CIRCULAR);
        MyAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo 2.jpg"))); // NOI18N
        MyAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyAvatarMouseClicked(evt);
            }
        });

        btnclosesession.setBackground(new java.awt.Color(153, 153, 0));
        btnclosesession.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnclosesession.setForeground(new java.awt.Color(255, 255, 255));
        btnclosesession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar Sesión.png"))); // NOI18N
        btnclosesession.setMnemonic('c');
        btnclosesession.setText(" Cerrar Sesión");
        btnclosesession.setToolTipText("Cerrar Sesión");
        btnclosesession.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnclosesession.setContentAreaFilled(false);
        btnclosesession.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnclosesession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclosesessionActionPerformed(evt);
            }
        });

        LabelUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("Usuario: ");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MyAvatarLayout = new javax.swing.GroupLayout(MyAvatar);
        MyAvatar.setLayout(MyAvatarLayout);
        MyAvatarLayout.setHorizontalGroup(
            MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyAvatarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MyAvatarLayout.createSequentialGroup()
                        .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(btnclosesession)))
                .addGap(30, 30, 30))
        );
        MyAvatarLayout.setVerticalGroup(
            MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyAvatarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnclosesession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        jPanel1.add(MyAvatar, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(802, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MyAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyAvatarMouseClicked

           String Privilegio = "Publico";
            try{
                
            resultado = Conexion.consulta("Select [Privilegio] from [dbo].[Usuario] where [ID_Empleado] = '"+ID_Usuario+"'");
  
            while(resultado.next()){

            Privilegio = resultado.getString(1);
            
            }
            
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

            if("sa".equalsIgnoreCase(UsuarioBD) || "Administrador".equalsIgnoreCase(UsuarioBD)
                    ||"Administrador".equalsIgnoreCase(Privilegio)){
        
        
        if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
            switch(MyAvatar.getAvatarIndex()+1){
            
             case 1 : 
                 ProveedorP Pr = new ProveedorP();
                 Pr.setMP(this);
                 Pr.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 2 : 
                 EjecutivoP Ej = new EjecutivoP();
                 Ej.setMP(this);
                 Ej.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 3 : 
                 CategoriaP Ct = new CategoriaP();
                 Ct.setMP(this);
                 Ct.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 4 : 
                 ProductoP Pro = new ProductoP();
                 Pro.setMP(this);
                 Pro.setVisible(true);
                 this.setVisible(false);
                 break;
               
             case 5 : 
                 ModoCliente Cl = new ModoCliente(this, true);
                 Cl.setMP(this);
                 Cl.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 6 : 
                 ComprasP Cp = new ComprasP();
                 Cp.setMP(this);
                 Cp.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 7 : 
                 InventarioP Iv = new InventarioP();
                 Iv.setMP(this);
                 Iv.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 8 : 
                 PedidosP Fc;
            try {
                Fc = new PedidosP();
            
                 Fc.setMP(this);
                 Fc.setVisible(true);
                 this.setVisible(false);
                 } catch (UnknownHostException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                 break;
                 
             case 9 :
                 ProformaP PF = new ProformaP();
                 PF.setMP(this);
                 PF.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 10 :
                 FacturacionP FP;
            try {
                FP = new FacturacionP();
           
                 FP.setMP(this);
                 FP.setVisible(true);
                 this.setVisible(false); 
            } catch (UnknownHostException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                 break;
                 
             case 11: 

                  Reportes Rp = new Reportes(this, true);
//                 Fc.setMP(this);
                  Rp.setVisible(true);
                  Rp.toFront();
//                 this.setVisible(false);
                 break;
                    
           case 12: 

                 EmpleadoP EM = new EmpleadoP();
                 EM.setMP(this);
                 EM.setVisible(true);
                 this.setVisible(false);
                 break;
               
            case 13: 

                 Configuraciones CF = new Configuraciones(null, false);
                 CF.setMP(this);
                 CF.setVisible(true);
                 CF.toFront();
                 this.setVisible(false);
                 break;
                    
                 
             default:  break;
            
                
            }
        }
            }
            
            if("Publico".equalsIgnoreCase(Privilegio))
            {
                if("Ventas".equalsIgnoreCase(Area))
                {
             if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
            switch(MyAvatar.getAvatarIndex()+1){
            
            
             case 1: 
                 InventarioP Iv = new InventarioP();
                 Iv.setMP(this);
                 Iv.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 2 : 
                 PedidosP Fc;
            try {
                Fc = new PedidosP();
            
                 Fc.setMP(this);
                 Fc.setVisible(true);
                 this.setVisible(false);
                 } catch (UnknownHostException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                 break;
                 
             case 3 :
                 ProformaP PF = new ProformaP();
                 PF.setMP(this);
                 PF.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             default:  break;
            
                
            }
             }
                }
             if("Caja".equalsIgnoreCase(Area)){
                 
             
                  if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
            switch(MyAvatar.getAvatarIndex()+1){
            
           
             case 1:
                 FacturacionP FP;
            try {
                FP = new FacturacionP();
           
                 FP.setMP(this);
                 FP.setVisible(true);
                 this.setVisible(false); 
            } catch (UnknownHostException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
                 break;
                 
             default:  break;
            
                
            }
             }
             }
             }
            
    }//GEN-LAST:event_MyAvatarMouseClicked

    
java.util.Calendar calendario; 
int dia, mes, año, hora, minutos, segundos; 

    public void reloj() { 
calendario = new java.util.GregorianCalendar(); 
segundos = calendario.get(Calendar.SECOND); 
javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() { 
        
        
@ Override 
public void actionPerformed(java.awt.event.ActionEvent ae) { 
java.util.Date actual = new java.util.Date(); 
calendario.setTime(actual); 
dia = calendario.get(Calendar.DAY_OF_MONTH); 
mes = (calendario.get(Calendar.MONTH) + 1); 
año = calendario.get(Calendar.YEAR); 
hora = calendario.get(Calendar.HOUR_OF_DAY); 
minutos = calendario.get(Calendar.MINUTE); 
segundos = calendario.get(Calendar.SECOND); 
//String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a  EEEEEEEEE, dd 'de' MMMMM 'de' yyyy");

String fecha = format.format(actual);

lblFecha.setText(fecha);

//String hour = String.format("%tI : %tM : %tS %Tp", calendario); 
//String date = String.format("%02d / %02d / %02d", dia, mes, año); 
//label.setText("<html><center>" + hour + "<br>" + date); 
 
} 
}); 

timer.start(); 
} 

    
    private void btnclosesessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclosesessionActionPerformed

        int f = JOptionPane.showConfirmDialog(this,"Está Seguro Que Desea Cerrar Sesión?","Cerrar Sesión",JOptionPane.YES_NO_OPTION);

        if(f==JOptionPane.YES_OPTION){
      
            IniciarSesion ns;
            try {
                ns = new IniciarSesion();
           
            ns.setVisible(true);
            ns.toFront();

             } catch (IOException ex) {
              
            }
            this.dispose();
        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btnclosesessionActionPerformed

    KEffectPanel PanelEffect = new KEffectPanel();
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  
      this.setResizable(false);
     
      PanelEffect.setEffect(new Shape(1500));
      PanelEffect.startEffect();
      

      setProcess();
      
      LabelUser.setText("Usuario: "+UsuarioBD);
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
Salir();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    public void Salir(){
        
 int f = JOptionPane.showConfirmDialog(this,"Está Seguro Que Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);
        
               
        if(f==JOptionPane.YES_OPTION){
        
        try {
                JavaSplash.Main.serverSocket.close();
            } catch (IOException | NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Error al Cerrar Servidor","Error",JOptionPane.ERROR_MESSAGE);
            }
            
                
            System.exit(0);
                }
               
        
    }
    
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUser;
    private org.edisoncor.gui.panel.PanelAvatarChooser MyAvatar;
    private javax.swing.JButton btnclosesession;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}

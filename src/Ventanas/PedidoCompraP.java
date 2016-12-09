/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.CustomTextField;
import Procedimientos.Compra;
import Procedimientos.Conexion;
import com.keffect.effects.animatedEffects.EntryBoucing;
import com.keffect.effects.animatedEffects.Shape;
import com.keffectpanel.KEffectPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Reymundo Tenorio
 */
public class PedidoCompraP extends javax.swing.JDialog {

    /**
     * Creates new form CompraP
     */
    public PedidoCompraP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        try {
            this.setIconImage(new ImageIcon(getClass().getResource("Icono.png")).getImage());
        } catch (NullPointerException ex) {
        }

        initComponents();
        this.setResizable(false);
        txtNoFactura.setEnabled(true);

        PanelVer.setVisible(false);
        cmbProducto.setEnabled(false);
        Tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jFechaVence1.setVisible(false);


        /*COPIAR PEGAR DESACTIVAR*/
//         JTextComponent.KeyBinding[] newBindings = {
////        new JTextComponent.KeyBinding(
////          KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK),
////          DefaultEditorKit.beepAction),
//        new JTextComponent.KeyBinding(
//          KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK),
//          DefaultEditorKit.beepAction),
////        new JTextComponent.KeyBinding(
////            KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK),
////            DefaultEditorKit.beepAction)
////      
//         };
//            
//    Keymap k = txtNombre.getKeymap();
//    JTextComponent.loadKeymap(k, newBindings, txtNombre.getActions());
//    
        txtunids.setTransferHandler(null);
        txtUnidsBoni.setTransferHandler(null);
        txtVineta.setTransferHandler(null);
        txtCostoUnit.setTransferHandler(null);
        txttotal.setTransferHandler(null);
        jFecha.setTransferHandler(null);
        jFechaVence.setTransferHandler(null);

        lblBonifi.setVisible(false);
//        lblDevol.setVisible(false);
        lblTiempo.setVisible(false);
        lblVineta.setVisible(false);

        txtUnidsBoni.setVisible(false);
        //    cmbDevol.setVisible(false);
        cmbTiempo.setVisible(false);
        txtVineta.setVisible(false);

        //   PanelProducto.setVisible(false);
        btnDesactivar.setVisible(true);

        Date Hoy = new Date();

        jFecha.setMaxSelectableDate(Hoy);
        jFechaVence.setMinSelectableDate(Hoy);

        cmbTiempo.setSelectedIndex(31);
//        MultipleEffect effects = new MultipleEffect();
//				effects.addEffect(new ShadowFrame(20));
//				effects.addEffect(new Shadow(1000));
//				effects.addEffect(new SplitHorizontalFade(1000));
//				effects.addEffect(new SplitVerticalFade(2000));
//				effects.addEffect(new DarkenReverse(6000,50));
//                                
        // PanelEffect.setEffect(effects);                    

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
        TabbedPane = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        PanelNuevo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0));
        lblVineta1 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0));
        btnsave = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbprov = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbEjecutivo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        rdEfectivo = new javax.swing.JRadioButton();
        rdCredito = new javax.swing.JRadioButton();
        lblTiempo = new javax.swing.JLabel();
        cmbTiempo = new javax.swing.JComboBox();
        txtNoFactura = new javax.swing.JTextField();
        PanelProducto = new javax.swing.JPanel();
        txtunids = new javax.swing.JTextField();
        txtCostoUnit = new javax.swing.JTextField();
        jFechaVence = new com.toedter.calendar.JDateChooser();
        cmbDesc = new javax.swing.JComboBox();
        txttotal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        ckIVA = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        lblBonifi = new javax.swing.JLabel();
        txtUnidsBoni = new javax.swing.JTextField();
        ckBonificacion = new javax.swing.JCheckBox();
        ckDevol = new javax.swing.JCheckBox();
        ckVineta = new javax.swing.JCheckBox();
        lblVineta = new javax.swing.JLabel();
        txtVineta = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        PanelVer = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbbusc = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        jFechaVence1 = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnDesactivar = new javax.swing.JButton();
        btnshowall = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btncancel3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TabbedPane.setColorDeBorde(new java.awt.Color(0, 204, 204));
        TabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneStateChanged(evt);
            }
        });
        TabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabbedPaneMousePressed(evt);
            }
        });

        //KEffectPanel effectPanel = new KEffectPanel();
        //PanelNuevo = effectPanel;
        PanelNuevo = PanelEffect;
        PanelNuevo.setBackground(new java.awt.Color(0, 153, 204));
        PanelNuevo.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.add(filler1);

        lblVineta1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblVineta1.setForeground(new java.awt.Color(255, 255, 255));
        lblVineta1.setText("Total a Pagar   ");
        lblVineta1.setToolTipText("Cantidad Viñeta");
        lblVineta1.setPreferredSize(new java.awt.Dimension(126, 34));
        jPanel1.add(lblVineta1);

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotalPagar.setForeground(new java.awt.Color(204, 102, 0));
        txtTotalPagar.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalPagar.setToolTipText("Total de Compra");
        txtTotalPagar.setPreferredSize(new java.awt.Dimension(240, 34));
        jPanel1.add(txtTotalPagar);
        jPanel1.add(filler2);

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnsave.setMnemonic('g');
        btnsave.setText("Guardar");
        btnsave.setToolTipText("Guardar Registro");
        btnsave.setContentAreaFilled(false);
        btnsave.setEnabled(false);
        btnsave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave);

        btncancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btncancel.setMnemonic('c');
        btncancel.setText("Cancelar");
        btncancel.setToolTipText("Cancelar / Salir");
        btncancel.setContentAreaFilled(false);
        btncancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel);

        PanelNuevo.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(0, 153, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Proveedor");

        cmbprov.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbprov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cmbprov.setToolTipText("Seleccione Proveedor");
        cmbprov.setEnabled(false);
        cmbprov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbprovItemStateChanged(evt);
            }
        });
        cmbprov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbprovKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ejecutivo");

        cmbEjecutivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbEjecutivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cmbEjecutivo.setToolTipText("Seleccione Proveedor");
        cmbEjecutivo.setEnabled(false);
        cmbEjecutivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbEjecutivoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha");

        jFecha.setDateFormatString("dd-MM-yyyy");
        jFecha.setEnabled(false);
        jFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdFechaKeyTyped(evt);
            }
        });

        jFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdFechaKeyReleased(evt);
            }
        });

        jFecha.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdFechaKeyPressed(evt);
            }
        });

        jFecha.getDateEditor().getUiComponent().setToolTipText("Seleccione Fecha");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modo de Pago");

        jPanel13.setOpaque(false);
        jPanel13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel13KeyTyped(evt);
            }
        });
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        buttonGroup1.add(rdEfectivo);
        rdEfectivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        rdEfectivo.setSelected(true);
        rdEfectivo.setText("Efectivo");
        rdEfectivo.setEnabled(false);
        rdEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rdEfectivo.setOpaque(false);
        rdEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rdEfectivoKeyTyped(evt);
            }
        });
        jPanel13.add(rdEfectivo);

        buttonGroup1.add(rdCredito);
        rdCredito.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdCredito.setForeground(new java.awt.Color(255, 255, 255));
        rdCredito.setText("Crédito");
        rdCredito.setEnabled(false);
        rdCredito.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rdCredito.setOpaque(false);
        rdCredito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdCreditoItemStateChanged(evt);
            }
        });
        rdCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rdCreditoKeyTyped(evt);
            }
        });
        jPanel13.add(rdCredito);

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempo.setText("Tiempo para Pagar");

        cmbTiempo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTiempo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "1 día", "2 días", "3 días", "4 días", "5 días", "6 días", "7 días", "8 días", "9 días", "10 días", "11 días", "12 días", "13 días", "14 días", "15 días", "16 días", "17 días", "18 días", "19 días", "20 días", "21 días", "22 días", "23 días", "24 días", "25 días", "26 días", "27 días", "28 días", "29 días", "30 días", "31 días", "32 días", "33 días", "34 días", "35 días", "36 días", "37 días", "38 días", "39 días", "40 días", "41 días", "42 días", "43 días", "44 días", "45 días", "46 días", "47 días", "48 días", "49 días", "50 días", "51 días", "52 días", "53 días", "54 días", "55 días", "56 días", "57 días", "58 días", "59 días", "60 días", "61 días", "62 días", "63 días", "64 días", "65 días", "66 días", "67 días", "68 días", "69 días", "70 días", "71 días", "72 días", "73 días", "74 días", "75 días", "76 días", "77 días", "78 días", "79 días", "80 días", "81 días", "82 días", "83 días", "84 días", "85 días", "86 días", "87 días", "88 días", "89 días", "90 días", "91 días", "92 días", "93 días", "94 días", "95 días", "96 días", "97 días", "98 días", "99 días", "100 días" }));
        cmbTiempo.setToolTipText("Seleccione Tiempo para Pagar Deuda");
        cmbTiempo.setEnabled(false);
        cmbTiempo.setName(""); // NOI18N
        cmbTiempo.setPreferredSize(new java.awt.Dimension(220, 23));
        cmbTiempo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTiempoItemStateChanged(evt);
            }
        });

        txtNoFactura.setBackground(new java.awt.Color(255, 255, 204));
        CustomTextField customTextField1 = new CustomTextField(100);
        txtNoFactura = customTextField1;
        customTextField1.setPlaceholder("No. Factura Proveedor");
        customTextField1.setFont(new java.awt.Font("Tahoma", 1, 16));
        customTextField1.setForeground(Color.BLACK);
        customTextField1.setPlaceholderForeground(Color.LIGHT_GRAY);
        txtNoFactura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNoFactura.setEnabled(false);
        txtNoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoFacturaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbEjecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbprov, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbprov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEjecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoFactura)))
                .addContainerGap())
        );

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        PanelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelProducto.setOpaque(false);

        txtunids.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtunids.setToolTipText("Ingrese Unidades");
        txtunids.setEnabled(false);
        txtunids.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtunidsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtunidsKeyTyped(evt);
            }
        });

        txtCostoUnit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCostoUnit.setToolTipText("Ingrese Costo Unitario");
        txtCostoUnit.setEnabled(false);
        txtCostoUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoUnitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoUnitKeyTyped(evt);
            }
        });

        jFechaVence.setDateFormatString("MM-yyyy");
        jFechaVence.setEnabled(false);
        jFechaVence.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        cmbDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbDesc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Sin Descuento>", "1 %", "2 %", "3 %", "4 %", "5 %", "6 %", "7 %", "8 %", "9 %", "10 %", "11 %", "12 %", "13 %", "14 %", "15 %", "16 %", "17 %", "18 %", "19 %", "20 %", "21 %", "22 %", "23 %", "24 %", "25 %", "26 %", "27 %", "28 %", "29 %", "30 %", "31 %", "32 %", "33 %", "34 %", "35 %", "36 %", "37 %", "38 %", "39 %", "40 %", "41 %", "42 %", "43 %", "44 %", "45 %", "46 %", "47 %", "48 %", "49 %", "50 %", "51 %", "52 %", "53 %", "54 %", "55 %", "56 %", "57 %", "58 %", "59 %", "60 %", "61 %", "62 %", "63 %", "64 %", "65 %", "66 %", "67 %", "68 %", "69 %", "70 %", "71 %", "72 %", "73 %", "74 %", "75 %", "76 %", "77 %", "78 %", "79 %", "80 %", "81 %", "82 %", "83 %", "84 %", "85 %", "86 %", "87 %", "88 %", "89 %", "90 %", "91 %", "92 %", "93 %", "94 %", "95 %", "96 %", "97 %", "98 %", "99 %", "100 %" }));
        cmbDesc.setToolTipText("Seleccione El Tipo de Moneda");
        cmbDesc.setEnabled(false);
        cmbDesc.setName(""); // NOI18N
        cmbDesc.setPreferredSize(new java.awt.Dimension(220, 23));
        cmbDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDescItemStateChanged(evt);
            }
        });

        txttotal.setEditable(false);
        txttotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttotal.setForeground(new java.awt.Color(204, 102, 0));
        txttotal.setToolTipText("Total de Compra");

        btnAgregar.setBackground(new java.awt.Color(0, 153, 153));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAgregar.setText("Agregar Compra");
        btnAgregar.setToolTipText("Agregar Producto a La Lista de Productos");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        ckIVA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ckIVA.setForeground(new java.awt.Color(255, 255, 255));
        ckIVA.setText("Incluye I.V.A.");
        ckIVA.setToolTipText("Incluye I.V.A");
        ckIVA.setEnabled(false);
        ckIVA.setOpaque(false);
        ckIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckIVAItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Vencimiento");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo Unitario");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Producto");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Unidades");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descuento");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total de Compra");

        cmbProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cmbProducto.setToolTipText("Seleccione Producto");
        cmbProducto.setEnabled(false);
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });
        cmbProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbProductoKeyTyped(evt);
            }
        });

        lblBonifi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblBonifi.setForeground(new java.awt.Color(255, 255, 255));
        lblBonifi.setText("Unidades Bonifación");

        txtUnidsBoni.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUnidsBoni.setToolTipText("Ingrese Unidades Bonificación");
        txtUnidsBoni.setEnabled(false);
        txtUnidsBoni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnidsBoniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidsBoniKeyTyped(evt);
            }
        });

        ckBonificacion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ckBonificacion.setForeground(new java.awt.Color(255, 255, 255));
        ckBonificacion.setText("Incluye Bonificación");
        ckBonificacion.setToolTipText("Incluye Bonificación");
        ckBonificacion.setEnabled(false);
        ckBonificacion.setOpaque(false);
        ckBonificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckBonificacionItemStateChanged(evt);
            }
        });

        ckDevol.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ckDevol.setForeground(new java.awt.Color(255, 255, 255));
        ckDevol.setText("Permite Devolución");
        ckDevol.setToolTipText("Permite Devolución");
        ckDevol.setEnabled(false);
        ckDevol.setOpaque(false);

        ckVineta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ckVineta.setForeground(new java.awt.Color(255, 255, 255));
        ckVineta.setText("Incluye Viñeta");
        ckVineta.setToolTipText("Incluye Viñeta");
        ckVineta.setEnabled(false);
        ckVineta.setOpaque(false);
        ckVineta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckVinetaItemStateChanged(evt);
            }
        });
        ckVineta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckVinetaActionPerformed(evt);
            }
        });

        lblVineta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblVineta.setForeground(new java.awt.Color(255, 255, 255));
        lblVineta.setText("Cantidad Viñeta");
        lblVineta.setToolTipText("Cantidad Viñeta");

        txtVineta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtVineta.setToolTipText("Unidades Disponibles del Producto");
        txtVineta.setEnabled(false);
        txtVineta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVinetaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVinetaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PanelProductoLayout = new javax.swing.GroupLayout(PanelProducto);
        PanelProducto.setLayout(PanelProductoLayout);
        PanelProductoLayout.setHorizontalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelProductoLayout.createSequentialGroup()
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelProductoLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductoLayout.createSequentialGroup()
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ckDevol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ckIVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ckVineta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ckBonificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(46, 46, 46)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addComponent(lblVineta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(txtVineta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelProductoLayout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtCostoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelProductoLayout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtunids, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelProductoLayout.createSequentialGroup()
                            .addComponent(lblBonifi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtUnidsBoni, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFechaVence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        PanelProductoLayout.setVerticalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaVence, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtunids, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCostoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(8, 8, 8)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckBonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBonifi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnidsBoni, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckDevol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckVineta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVineta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVineta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jFechaVence.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdFechaKeyTyped(evt);
            }
        });

        jFechaVence.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdFechaKeyReleased(evt);
            }
        });

        jFechaVence.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdFechaKeyPressed(evt);
            }
        });

        jFechaVence.getDateEditor().getUiComponent().setToolTipText("Seleccione Fecha");

        jPanel3.add(PanelProducto, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.BorderLayout());

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProductos.getTableHeader().setReorderingAllowed(false);
        TablaProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaProductosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaProductosFocusLost(evt);
            }
        });
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        PanelNuevo.add(jPanel6, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Nuevo", PanelNuevo);

        PanelVer = PanelEffect2;
        PanelVer.setBackground(new java.awt.Color(0, 153, 204));
        PanelVer.setLayout(new javax.swing.BoxLayout(PanelVer, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Por: ");

        cmbbusc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbbusc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No.", "Fecha Compra", "Proveedor", "Empleado", "Modo Compra", "Tiempo Para Pagar", "Cancelada", "Estado" }));
        cmbbusc.setToolTipText("Buscar Por:");
        cmbbusc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbuscItemStateChanged(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBuscar.setToolTipText("Buscar");
        CustomTextField customTextField9 = new CustomTextField(100);
        txtBuscar = customTextField9;
        customTextField9.setPlaceholder("Ingrese Información a Buscar");
        customTextField9.setFont(new java.awt.Font("Tahoma", 0, 16));
        customTextField9.setForeground(Color.BLACK);
        customTextField9.setPlaceholderForeground(Color.LIGHT_GRAY);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        /*txtBuscar = new AutoComplete.AutoCompletar();
        ((AutoCompletar)txtBuscar).setDesplegable(new DesplegableJPopUPMenu(txtBuscar));
        ModeloAutoCompletar modelo1 = new ModeloVendNames();
        ((AutoCompletar)txtBuscar).setModelo(modelo1);
        ((AutoCompletar)txtBuscar).getDesplegable().setForeground(new Color(102,153,255));
        ((AutoCompletar)txtBuscar).addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscTyped(evt);
            }
        });
        ((AutoCompletar)txtBuscar).setToolTipText("Ingresar Dato a Buscar");*/

        jFechaVence1.setDateFormatString("dd-MM-yyyy");
        jFechaVence1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jFechaVence1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFechaVence1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbbusc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(298, 298, 298)
                    .addComponent(jFechaVence1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(767, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbusc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jFechaVence1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jFechaVence1.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdFechaKeyTyped(evt);
            }
        });

        jFechaVence1.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdFechaKeyReleased(evt);
            }
        });

        jFechaVence1.getDateEditor().getUiComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdFechaKeyPressed(evt);
            }
        });

        jFechaVence.getDateEditor().getUiComponent().setToolTipText("Seleccione Fecha");

        jPanel7.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.setToolTipText("Lista Registros");
        Tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaFocusLost(evt);
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(Tabla);

        jPanel7.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));

        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDesactivar.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DesctivarR.png"))); // NOI18N
        btnDesactivar.setMnemonic('D');
        btnDesactivar.setText("Anular");
        btnDesactivar.setToolTipText("Desactivar");
        btnDesactivar.setContentAreaFilled(false);
        btnDesactivar.setEnabled(false);
        btnDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesactivar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnDesactivarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnDesactivarFocusLost(evt);
            }
        });
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        jPanel5.add(btnDesactivar);

        btnshowall.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnshowall.setForeground(new java.awt.Color(255, 255, 255));
        btnshowall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TablaTodos.png"))); // NOI18N
        btnshowall.setMnemonic('m');
        btnshowall.setText("Mostrar Todos");
        btnshowall.setToolTipText("Mostrar Todos Los Registros");
        btnshowall.setContentAreaFilled(false);
        btnshowall.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnshowall.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnshowall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowallActionPerformed(evt);
            }
        });
        jPanel5.add(btnshowall);

        btnprint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnprint.setForeground(new java.awt.Color(255, 255, 255));
        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imprimir.png"))); // NOI18N
        btnprint.setMnemonic('i');
        btnprint.setText("Imprimir");
        btnprint.setToolTipText("Imprimir/Mostrar Reporte");
        btnprint.setContentAreaFilled(false);
        btnprint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnprint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel5.add(btnprint);

        btncancel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncancel3.setForeground(new java.awt.Color(255, 255, 255));
        btncancel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btncancel3.setMnemonic('c');
        btncancel3.setText("Cancelar");
        btncancel3.setToolTipText("Cancelar / Salir");
        btncancel3.setContentAreaFilled(false);
        btncancel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancel3ActionPerformed(evt);
            }
        });
        jPanel5.add(btncancel3);

        jPanel7.add(jPanel5, java.awt.BorderLayout.SOUTH);

        PanelVer.add(jPanel7);

        TabbedPane.addTab("Ver", PanelVer);

        getContentPane().add(TabbedPane, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1360, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    private MenuPrincipal MP;
//
//    public void setMP(MenuPrincipal MP) {
//        this.MP = MP;
//    }
    public void Enviar(ArrayList Producto, ArrayList Cantidad)
            throws MessagingException {
        // Propiedades de la conexión

        String CorreoDestino = "@hotmail.com";
        String CorreoRemitente = "@gmail.com";
        String ContrasenaRemitente = "";

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", CorreoRemitente);
        props.setProperty("mail.smtp.auth", "true");

        // Preparamos la sesion
        Session session = Session.getDefaultInstance(props);

        String DireccionCorreo = CorreoDestino;

        // Construimos el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(CorreoRemitente));
        message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(DireccionCorreo));
//            message.addRecipient(
//                Message.RecipientType.TO,
//                new InternetAddress("jrojas6787@gmail.com"));

        // message.setSubject("Intento de Acceso al Sistema", "ISO-8859-1");
        message.setSubject("Pedido Farmacia Josefina", "UTF-8");

        BodyPart Texto = new MimeBodyPart();

        String Dia;

        Date Fecha = new Date();

        long Time = Fecha.getTime();

        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        Date Date = new Date(Time);
        String Hora = sdf.format(Date);
        //String AM_PM  = Fecha.substring(Fecha.length()-2, Fecha.length());
        //Fecha = Fecha.substring(0,Fecha.length()-3);

        String FechaF = df4.format(Date);

//  String NombreDia;
//  
//    switch(i.getDay()){
//     case 0:
//      NombreDia="Domingo, ";
//         break;
//     case 1:
//      NombreDia="Lunes, ";
//         break;
//     case 2:
//      NombreDia="Martes, ";
//         break;
//     case 3:
//      NombreDia="Miércoles, ";
//         break;
//     case 4:
//      NombreDia="Jueves, ";
//         break;
//     case 5:
//      NombreDia="Viernes, ";
//         break;
//     case 6:
//      NombreDia="Sábado, ";
//         break;
//     default:
//      NombreDia="Ninguno, ";
//         break;
//  }
//     String FechaFinal = NombreDia.concat(Fecha).concat(" "+AM_PM);
        String FechaFinal = FechaF.concat(" ").concat(Hora);

        Dia = FechaFinal;

        String Contenido
                = "<div style=\"background-color:#16A6C3;  border-color: #0e6b7e; border-style: inset; border-width: 4px;\">"
                //  + "<div align=\"center\"><img src=\"http://nicaventura.tk/css/images/Farmacia.jpg\" "
                // + "alt=\"Reymundo\" style=\"margin-bottom:20px; margin-top:20px; "
                //  + "padding-bottom:20px; padding-top:20px; height: 199px; "
                //   + "width: 734px;\"/></div>"
                + "<header><h1 style=\"color: #e9f4ad; font-weight: bold; "
                + "margin-bottom:28px; font-size: 22px; text-align: center;\">Sistema de Inventario"
                + " y Facturación Farmacia Josefina</h1></header>"
                + "<p><h3 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px;  "
                + "margin-top:10px; font-size: 18px; "
                + "text-align: left;\">Se le solicita los siguientes Productos: "
                + "</h3></p>";

        for (int i = 0; i < Producto.size(); i++) {
            Contenido = Contenido + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                    + " margin-top:10px; font-size: 18px;"
                    + " text-align: left;\">"
                    + "Producto: " + Producto.get(i) + "</h4></p>"
                    + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                    + " margin-top:10px; font-size: 18px;"
                    + " text-align: left;\">"
                    + "Cantidad: " + Cantidad.get(i) + "</h4></p>"
                    + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                    + " margin-top:10px; font-size: 18px;"
                    + " text-align: left;\">"
                    + "======================================================================================</h4></p>";
        }

        Contenido = Contenido + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Fecha y Hora de Solicitud: " + Dia + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "=============================================================================== </h4></p>"
                + "</div>";

        Texto.setContent(Contenido,
                //   "text/html; charset=\"ISO-8859-1\"");
                "text/html; charset=\"UTF-8\"");

        // Lo enviamos.
        Transport t = session.getTransport("smtp");
        t.connect(CorreoRemitente, ContrasenaRemitente);

        try {

            t.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException ex) {

            JOptionPane.showMessageDialog(this, "Error al enviar el correo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Cierre.
        t.close();

        JOptionPane.showMessageDialog(null, "Los datos de su cuenta han sido enviados a su correo electrónico",
                "Revise su correo", JOptionPane.INFORMATION_MESSAGE);

    }

    public void jdFechaKeyTyped(KeyEvent evt) {

        char a = evt.getKeyChar();

        evt.consume();
        Toolkit.getDefaultToolkit().beep();

    }

    public void jdFechaKeyPressed(KeyEvent evt) {
        char a = evt.getKeyChar();

        evt.consume();
        Toolkit.getDefaultToolkit().beep();

    }

    public void jdFechaKeyReleased(KeyEvent evt) {
        char a = evt.getKeyChar();

        evt.consume();
        Toolkit.getDefaultToolkit().beep();

    }

    public static ResultSet resultado;

    public void SetProveedor(String Proveedor) {
        cmbprov.setSelectedItem(Proveedor);
    }

    public void SetEjecutivo(String Ejecutivo) {
        cmbEjecutivo.setSelectedItem(Ejecutivo);
    }

    public void SetProducto(String Producto) {
        cmbProducto.setSelectedItem(Producto);
    }

    private int[] Proveedores;
    private int[] Ejecutivos;
    private int[] Productos;

    int ID_Compra;

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void Guardar() {

        int ID_Proveedor, ID_Ejecutivo, ID_Producto, Tiempo_Pago, Unids_Compradas,
                Cantidad_Devolucion;
        Date Fecha_Compra, Fecha_Vencimiento;
        String Modo_Compra, Modo_Adquisicion, Incluye_IVA, Permite_Devolucion, Incluye_Vineta, No_Factura,
                Cancelado;
        double Costo_Compra, Cantidad_Vineta, DescuentoMonet;
        BigDecimal Descuento;

//Descuento = BigDecimal.valueOf(Double.valueOf(SelectCombo5));
        int SelectCombo = cmbprov.getSelectedIndex();
        int SelectCombo2 = cmbEjecutivo.getSelectedIndex();
        int SelectCombo3 = cmbTiempo.getSelectedIndex();

        if (SelectCombo == 0) {

            JOptionPane.showMessageDialog(this, "Seleccione El Proveedor", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (SelectCombo2 == 0) {

            JOptionPane.showMessageDialog(this, "Seleccione El Ejecutivo", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rdCredito.isSelected()) {

            if (SelectCombo3 == 0) {

                JOptionPane.showMessageDialog(this, "Seleccione El Tiempo para Pagar Deuda", "Seleccione", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

        Fecha_Compra = jFecha.getDate();

        if (Fecha_Compra == null) {

            JOptionPane.showMessageDialog(this, "Seleccione La Fecha de Compra", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        No_Factura = txtNoFactura.getText().trim();

        if ("".equals(No_Factura)) {

            JOptionPane.showMessageDialog(this, "Ingrese el no. de la factura de la compra", "ingrese", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int Seleccion = TablaProductos.getRowCount();

        if (Seleccion <= 0) {
            JOptionPane.showMessageDialog(this, "No ha realizado nínguna Compra", "Sin Compra", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rdCredito.isSelected()) {

            Modo_Compra = "Crédito";
            Tiempo_Pago = SelectCombo3;
            Cancelado = "Pendiente";

        } else {
            Modo_Compra = "Efectivo";
            Tiempo_Pago = 0;
            Cancelado = "Cancelada";
        }

        ID_Proveedor = Proveedores[SelectCombo];
        ID_Ejecutivo = Ejecutivos[SelectCombo2];

//        ID_CompraC = Compra.Agregar_Compra(ID_Proveedor, ID_Ejecutivo, Fecha_Compra,
//                    Modo_Compra, Tiempo_Pago, No_Factura, Cancelado);
//
//        ID_CompraC++;
        for (int i = 0; i < TablaProductos.getRowCount(); i++) {

            ID_Producto = (int) this.TablaProductos.getValueAt(i, 1);
            String Prod = this.TablaProductos.getValueAt(i, 2).toString();
            Fecha_Vencimiento = (Date) this.TablaProductos.getValueAt(i, 3);
            Unids_Compradas = (int) this.TablaProductos.getValueAt(i, 4);
            Costo_Compra = (double) this.TablaProductos.getValueAt(i, 5);
            Descuento = BigDecimal.valueOf((int) this.TablaProductos.getValueAt(i, 6));
            Incluye_IVA = (String) this.TablaProductos.getValueAt(i, 7);
            Modo_Adquisicion = (String) this.TablaProductos.getValueAt(i, 9);
            Incluye_Vineta = (String) this.TablaProductos.getValueAt(i, 10);
            Cantidad_Vineta = Double.valueOf(this.TablaProductos.getValueAt(i, 11).toString());
            Permite_Devolucion = (String) this.TablaProductos.getValueAt(i, 12);
            Cantidad_Devolucion = (int) this.TablaProductos.getValueAt(i, 13);

            int UnidsXCaja = 0;

            try {

                resultado = Conexion.consulta("Select UnidsXCaja from ProductoV where ID_Producto =" + ID_Producto);

                while (resultado.next()) {
                    UnidsXCaja = resultado.getInt(1);
                }

            } catch (SQLException ex) {
            }

            if (UnidsXCaja != 0) {
                Unids_Compradas = Unids_Compradas * UnidsXCaja;
                Costo_Compra = Costo_Compra / UnidsXCaja;
            }

            if (rdCredito.isSelected()) {

                DescuentoMonet = 0;

            } else {
                double Des = Descuento.doubleValue();
                double DesPorc = Des / 100;
                DescuentoMonet = (DesPorc) * (Unids_Compradas * Costo_Compra);

            }

            int ID_DCompra = Integer.parseInt(IDDetalle.get(i));

            Compra.Modificar_DetalleCompra(ID_DCompra, Fecha_Vencimiento,
                    Unids_Compradas, Costo_Compra, Descuento, Modo_Adquisicion,
                    Incluye_IVA, Permite_Devolucion, Cantidad_Devolucion,
                    Incluye_Vineta, Cantidad_Vineta, DescuentoMonet);
        }

        Compra.CambiarNoFactura(ID_Compra, txtNoFactura.getText().trim());

        this.dispose();

    }

    public void Aceptar() {
        int SelectCombo = cmbprov.getSelectedIndex();
        int SelectCombo2 = cmbEjecutivo.getSelectedIndex();
        int SelectCombo3 = cmbTiempo.getSelectedIndex();

        if (SelectCombo == 0) {

            JOptionPane.showMessageDialog(this, "Seleccione El Proveedor", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (SelectCombo2 == 0) {

            JOptionPane.showMessageDialog(this, "Seleccione El Ejecutivo", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (rdCredito.isSelected()) {

            if (SelectCombo3 == 0) {

                JOptionPane.showMessageDialog(this, "Seleccione El Tiempo para Pagar Deuda", "Seleccione", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Date Fecha_Compra;

        Fecha_Compra = jFecha.getDate();

        if (Fecha_Compra == null) {

            JOptionPane.showMessageDialog(this, "Seleccione La Fecha de Compra", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cmbprov.setEnabled(false);
        PanelProducto.setVisible(true);
//        btnBuscarProv.setEnabled(false);
//        btnAceptar.setEnabled(false);
    }

    public void Agregar() {

        int ID_Producto, Unids_Compradas,
                Unid_Devolucion, Unids_Bono = 0;
        Date Fecha_Vencimiento;
        String Incluye_IVA, Permite_Devolucion, Incluye_Vineta;
        double Costo_Compra, Cantidad_Vineta;
        int Descuento;

        int SelectCombo4 = cmbProducto.getSelectedIndex();
        int SelectCombo5 = cmbDesc.getSelectedIndex();
//int SelectCombo6 = cmbDevol.getSelectedIndex();

        String CantidadVine = txtVineta.getText().trim();
        String Unids = txtunids.getText().trim();
        String Costo = txtCostoUnit.getText().trim();
        String UnidsBoni = "-";

        if (ckBonificacion.isSelected()) {
            UnidsBoni = txtUnidsBoni.getText().trim();
        }

        Fecha_Vencimiento = jFechaVence.getDate();

        Descuento = SelectCombo5;

        if (SelectCombo4 == 0) {

            JOptionPane.showMessageDialog(this, "Seleccione El Producto", "Seleccione", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ckDevol.isSelected()) {

//if(SelectCombo6==0){
//            JOptionPane.showMessageDialog(this,"Seleccione El Porcentaje de Devolución","Seleccione",JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        }

        if (ckVineta.isSelected()) {
            if ("".equals(CantidadVine)) {
                JOptionPane.showMessageDialog(this, "Ingrese La Cantidad de la Viñeta", "Ingrese", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cantidad_Vineta = Double.parseDouble(CantidadVine);

            if (Cantidad_Vineta <= 0) {
                JOptionPane.showMessageDialog(this, "La Cantidad de Viñeta de la Compra debe Ser Mayor que Cero (0)",
                        "La Cantidad de Viñeta de la Compra debe Ser Mayor que Cero (0)", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if ("".equals(Unids)) {

            JOptionPane.showMessageDialog(this, "Ingrese La Cantidad a Comprar", "Ingrese", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Unids_Compradas = Integer.parseInt(Unids);

        if (Unids_Compradas <= 0) {
            JOptionPane.showMessageDialog(this, "La Cantidad de Unidades de la Compra debe Ser Mayor que Cero (0)",
                    "Unidades de la Compra debe Ser Mayor que Cero (0)", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ("".equals(Costo)) {
            JOptionPane.showMessageDialog(this, "Ingrese El Costo Unitario", "Ingrese", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Costo_Compra = Double.parseDouble(Costo);

        if (Costo_Compra <= 0) {
            JOptionPane.showMessageDialog(this, "El Costo Unitario de la Compra debe Ser Mayor que Cero (0)",
                    "Costo Unitario de la Compra debe Ser Mayor que Cero (0)", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ckBonificacion.isSelected()) {
            if ("".equals(UnidsBoni)) {
                JOptionPane.showMessageDialog(this, "Ingrese La Cantidad de Unidades de Bonificación", "Ingrese", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Unids_Bono = Integer.parseInt(UnidsBoni);

            if (Unids_Bono <= 0) {
                JOptionPane.showMessageDialog(this, "La Cantidad de Unidades de Bonificación debe Ser Mayor que Cero (0)",
                        "Unidades de Bonificación debe Ser Mayor que Cero (0)", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (Fecha_Vencimiento == null) {
            JOptionPane.showMessageDialog(this, "Ingrese La Fecha de Vencimiento", "Ingrese", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Unids_Compradas = Integer.parseInt(Unids);
        Costo_Compra = Double.parseDouble(Costo);

        if (ckIVA.isSelected()) {
            Incluye_IVA = "Si";
        } else {
            Incluye_IVA = "No";
        }

        if (ckDevol.isSelected()) {
            Permite_Devolucion = "Si";
            Unid_Devolucion = Unids_Compradas;
        } else {
            Permite_Devolucion = "No";
            Unid_Devolucion = 0;
        }

        if (ckVineta.isSelected()) {
            Incluye_Vineta = "Si";
            Cantidad_Vineta = Double.parseDouble(CantidadVine);
        } else {
            Incluye_Vineta = "No";
            Cantidad_Vineta = Double.parseDouble("0");
        }

        double Total = (Unids_Compradas * Costo_Compra);
        double Desc = (Unids_Compradas * Costo_Compra) * (Descuento / 100);
        Total = Total - Desc;

        DecimalFormat df = new DecimalFormat("#0.00");

        String TotalF = df.format(Total);
        TotalF.replace(',', '.');

        String Cost = df.format(Costo_Compra);
        Cost.replace(',', '.');
        Costo_Compra = Double.valueOf(Cost);

        String Vine = df.format(Cantidad_Vineta);
        CantidadVine.replace(',', '.');
        Cantidad_Vineta = Double.parseDouble(Vine);

        String Pagar = txtTotalPagar.getText();

        double Pay;

        if ("".equals(Pagar)) {

            Pay = Double.valueOf(TotalF);
        } else {
            Pay = Double.parseDouble(Pagar) + Double.valueOf(TotalF);
        }

        String TT = df.format(Pay);
        TT.replace(',', '.');
        txtTotalPagar.setText(TT);

        ID_Producto = Productos[SelectCombo4];
        String Producto = (String) cmbProducto.getSelectedItem();

        Object Datos[] = new Object[14];
        Datos[0] = false;
        Datos[1] = ID_Producto;
        Datos[2] = Producto;
        Datos[3] = Fecha_Vencimiento;
        Datos[4] = Unids_Compradas;
        Datos[5] = Costo_Compra;
        Datos[6] = Descuento;
        Datos[7] = Incluye_IVA;
        Datos[8] = TotalF;
        Datos[9] = "Normal";
        Datos[10] = Incluye_Vineta;
        Datos[11] = Cantidad_Vineta;
        Datos[12] = Permite_Devolucion;
        Datos[13] = Unid_Devolucion;

        modelProducto.addRow(Datos);

        if (ckBonificacion.isSelected()) {

            Total = (Unids_Bono * Costo_Compra);
            Desc = (Unids_Compradas * Costo_Compra) * (Descuento / 100);
            Total = Total - Desc;

            TotalF = df.format(Total);
            TotalF.replace(',', '.');

            Datos[0] = false;
            Datos[1] = ID_Producto;
            Datos[2] = Producto;
            Datos[3] = Fecha_Vencimiento;
            Datos[4] = Unids_Bono;
            Datos[5] = Costo_Compra;
            Datos[6] = Descuento;
            Datos[7] = Incluye_IVA;
            Datos[8] = TotalF;
            Datos[9] = "Bonificación";
            Datos[10] = "No";
            Datos[11] = Double.parseDouble("0");
            Datos[12] = Permite_Devolucion;
            Datos[13] = Unid_Devolucion;

            modelProducto.addRow(Datos);
        }

        IDDetalle.add(String.valueOf(ID_DetalleCompra));

        TablaProductos.setModel(modelProducto);

        cmbProducto.setSelectedIndex(0);
        txtunids.setText("");
        ID_DetalleCompra = 0;

        ckIVA.setSelected(false);

        ckBonificacion.setEnabled(false);
        ckDevol.setEnabled(false);
        ckVineta.setEnabled(false);
        txtCostoUnit.setEnabled(false);
        txtUnidsBoni.setEnabled(false);
        cmbDesc.setEnabled(false);
        jFechaVence.setEnabled(false);
        btnAgregar.setEnabled(false);

        CleanProducto();

    }

    ArrayList<String> IDDetalle = new ArrayList<String>();

    public void CleanAll() {

        modelProducto.setRowCount(0);
        txtUnidsBoni.setText("");
        txtVineta.setText("");
        txtCostoUnit.setText("");
        txttotal.setText("");
        txtunids.setText("");
        txtNoFactura.setText("");
        txtTotalPagar.setText("");
        jFecha.setDate(new Date());
        jFechaVence.setDate(new Date());
        cmbprov.setSelectedIndex(0);
        cmbDesc.setSelectedIndex(0);
//        cmbDevol.setSelectedIndex(0);
        cmbEjecutivo.setSelectedIndex(0);
        cmbProducto.setSelectedIndex(0);
        cmbTiempo.setSelectedIndex(0);
        rdEfectivo.setSelected(true);
        ckBonificacion.setSelected(false);
        ckDevol.setSelected(false);
        ckIVA.setSelected(false);
        ckVineta.setSelected(false);
        PanelProducto.setVisible(false);
    }

    public void CleanProducto() {

        txtUnidsBoni.setText("");
        txtVineta.setText("");
        txtCostoUnit.setText("");
        txttotal.setText("");
        txtunids.setText("");
        jFechaVence.setDate(new Date());
        cmbDesc.setSelectedIndex(0);
//        cmbDevol.setSelectedIndex(0);
        cmbProducto.setSelectedIndex(0);
        ckBonificacion.setSelected(false);
        ckDevol.setSelected(false);
        ckIVA.setSelected(false);
        ckVineta.setSelected(false);
    }

    public void EnableAll() {
        //      cmbprov.setEnabled(true);
        cmbDesc.setEnabled(true);
//        cmbDevol.setEnabled(true);
        //    cmbProducto.setEnabled(true);
        cmbTiempo.setEnabled(true);
        cmbEjecutivo.setEnabled(true);
        rdCredito.setEnabled(true);
        rdEfectivo.setEnabled(true);
        txtUnidsBoni.setEnabled(true);
        txtVineta.setEnabled(true);
        txtCostoUnit.setEnabled(true);
        txttotal.setEnabled(true);
        txtunids.setEnabled(true);
        txtNoFactura.setEnabled(true);
        jFecha.setEnabled(true);
        jFechaVence.setEnabled(true);
//        btnAceptar.setEnabled(true);
        btnAgregar.setEnabled(true);
        btnsave.setEnabled(true);
//        btnBuscarProv.setEnabled(true);
//        btnBuscarEje.setEnabled(true);
//        btnBuscarProd.setEnabled(true);
        //  ckIVA.setEnabled(true);
        ckBonificacion.setEnabled(true);
        ckDevol.setEnabled(true);
        ckVineta.setEnabled(true);
        // PanelProducto.setVisible(true);

    }

    public void DisableAll() {
        cmbprov.setEnabled(false);
        cmbDesc.setEnabled(false);
//        cmbDevol.setEnabled(false);
        cmbEjecutivo.setEnabled(false);
        cmbProducto.setEnabled(false);
        cmbTiempo.setEnabled(false);
        rdCredito.setEnabled(false);
        rdEfectivo.setEnabled(false);
        txtUnidsBoni.setEnabled(false);
        txtVineta.setEnabled(false);
        txtCostoUnit.setEnabled(false);
        txttotal.setEnabled(false);
        txtunids.setEnabled(false);
        //  txtNoFactura.setEnabled(false);
        jFecha.setEnabled(false);
        jFechaVence.setEnabled(false);
//        btnAceptar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnsave.setEnabled(false);
//        btnBuscarProv.setEnabled(false);
//        btnBuscarEje.setEnabled(false);
//        btnBuscarProd.setEnabled(false);
        //  ckIVA.setEnabled(false);
        ckBonificacion.setEnabled(false);
        ckDevol.setEnabled(false);
        ckVineta.setEnabled(false);
        PanelProducto.setVisible(false);

    }

    public void ActualizarTabla() {
//
//        Titulo();
//
//        model.setRowCount(0);
//        Tabla.setModel(model);
//
//        try {
//
//            resultado = Conexion.consulta("Select * from [dbo].[CompraV]");
//
//            while (resultado.next()) {
//                Object[] Datos = new Object[13];
//
//                DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                Datos[0] = String.valueOf(resultado.getInt(1));
//                Datos[1] = String.valueOf(resultado.getString(2));
//
//                java.util.Date FechaC = resultado.getDate(3);
//                String FechaComp = df3.format(FechaC);
//
//                Datos[2] = String.valueOf(FechaComp);
//
//                String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                Datos[3] = Empleado;
//                Datos[4] = resultado.getString(6);
//
//                String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                Datos[5] = Ejecutivo;
//                Datos[6] = String.valueOf(resultado.getInt(9));
//                Datos[7] = String.valueOf(resultado.getDouble(10));
//                Datos[8] = resultado.getString(11);
//                Datos[9] = String.valueOf(resultado.getInt(12));
//                Datos[10] = resultado.getString(13);
//                java.util.Date FechaI = resultado.getDate(14);
//
//                String Fecha = df4.format(FechaI);
//                Datos[11] = Fecha;
//                
//                Datos[12] = resultado.getString(15);
//
//                model.addRow(Datos);
//
//            }
//
//            Tabla.setModel(model);
//
////        Tabla.getColumnModel().getColumn( 10 ).setCellEditor( new Celda_CheckBox() );
////        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
////        Tabla.getColumnModel().getColumn( 10 ).setCellRenderer(new Render_CheckBox());      
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }

    }

    public void Buscar() {

//        Titulo();
//
//        int index = cmbbusc.getSelectedIndex() + 1;
//
//        switch (index) {
//
//            case 1:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [ID_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                         Object[] Datos = new Object[13];
//
//                DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                Datos[0] = String.valueOf(resultado.getInt(1));
//                Datos[1] = String.valueOf(resultado.getInt(2));
//
//                java.util.Date FechaC = resultado.getDate(3);
//                String FechaComp = df3.format(FechaC);
//
//                Datos[2] = String.valueOf(FechaComp);
//
//                String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                Datos[3] = Empleado;
//                Datos[4] = resultado.getString(6);
//
//                String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                Datos[5] = Ejecutivo;
//                Datos[6] = resultado.getInt(9);
//                Datos[7] = resultado.getDouble(10);
//                Datos[8] = resultado.getString(11);
//                Datos[9] = resultado.getInt(12);
//                Datos[9] = resultado.getString(13);
//                java.util.Date FechaI = resultado.getDate(14);
//
//                String Fecha = df4.format(FechaI);
//                Datos[10] = Fecha;
//                
//                Datos[11] = resultado.getString(15);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 2:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Nombres_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[13];
//
//                DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                Datos[0] = String.valueOf(resultado.getInt(1));
//                Datos[1] = String.valueOf(resultado.getInt(2));
//
//                java.util.Date FechaC = resultado.getDate(3);
//                String FechaComp = df3.format(FechaC);
//
//                Datos[2] = String.valueOf(FechaComp);
//
//                String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                Datos[3] = Empleado;
//                Datos[4] = resultado.getString(6);
//
//                String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                Datos[5] = Ejecutivo;
//                Datos[6] = resultado.getInt(9);
//                Datos[7] = resultado.getDouble(10);
//                Datos[8] = resultado.getString(11);
//                Datos[9] = resultado.getInt(12);
//                Datos[9] = resultado.getString(13);
//                java.util.Date FechaI = resultado.getDate(14);
//
//                String Fecha = df4.format(FechaI);
//                Datos[10] = Fecha;
//                
//                Datos[11] = resultado.getString(15);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 3:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Apellidos_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[13];
//
//                DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                Datos[0] = String.valueOf(resultado.getInt(1));
//                Datos[1] = String.valueOf(resultado.getInt(2));
//
//                java.util.Date FechaC = resultado.getDate(3);
//                String FechaComp = df3.format(FechaC);
//
//                Datos[2] = String.valueOf(FechaComp);
//
//                String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                Datos[3] = Empleado;
//                Datos[4] = resultado.getString(6);
//
//                String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                Datos[5] = Ejecutivo;
//                Datos[6] = resultado.getInt(9);
//                Datos[7] = resultado.getDouble(10);
//                Datos[8] = resultado.getString(11);
//                Datos[9] = resultado.getInt(12);
//                Datos[9] = resultado.getString(13);
//                java.util.Date FechaI = resultado.getDate(14);
//
//                String Fecha = df4.format(FechaI);
//                Datos[10] = Fecha;
//                
//                Datos[11] = resultado.getString(15);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 4:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Cedula_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[12];
//
//                        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                        Datos[0] = String.valueOf(resultado.getInt(1));
//                        Datos[1] = String.valueOf(resultado.getInt(2));
//
//                        java.util.Date FechaC = resultado.getDate(3);
//                        String FechaComp = df3.format(FechaC);
//
//                        Datos[2] = String.valueOf(FechaComp);
//
//                        String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                        Datos[3] = Empleado;
//                        Datos[4] = resultado.getString(6);
//
//                        String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                        Datos[5] = Ejecutivo;
//                        Datos[6] = resultado.getInt(9);
//                        Datos[7] = resultado.getDouble(10);
//                        Datos[8] = resultado.getString(11);
//                        Datos[9] = resultado.getInt(12);
//                        java.util.Date FechaI = resultado.getDate(13);
//
//                        String Fecha = df4.format(FechaI);
//                        Datos[10] = Fecha;
//                        Datos[11] = resultado.getString(14);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 5:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Sexo_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[12];
//
//                        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                        Datos[0] = String.valueOf(resultado.getInt(1));
//                        Datos[1] = String.valueOf(resultado.getInt(2));
//
//                        java.util.Date FechaC = resultado.getDate(3);
//                        String FechaComp = df3.format(FechaC);
//
//                        Datos[2] = String.valueOf(FechaComp);
//
//                        String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                        Datos[3] = Empleado;
//                        Datos[4] = resultado.getString(6);
//
//                        String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                        Datos[5] = Ejecutivo;
//                        Datos[6] = resultado.getInt(9);
//                        Datos[7] = resultado.getDouble(10);
//                        Datos[8] = resultado.getString(11);
//                        Datos[9] = resultado.getInt(12);
//                        java.util.Date FechaI = resultado.getDate(13);
//
//                        String Fecha = df4.format(FechaI);
//                        Datos[10] = Fecha;
//                        Datos[11] = resultado.getString(14);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 6:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Nombre_Proveedor] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[12];
//
//                        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                        Datos[0] = String.valueOf(resultado.getInt(1));
//                        Datos[1] = String.valueOf(resultado.getInt(2));
//
//                        java.util.Date FechaC = resultado.getDate(3);
//                        String FechaComp = df3.format(FechaC);
//
//                        Datos[2] = String.valueOf(FechaComp);
//
//                        String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                        Datos[3] = Empleado;
//                        Datos[4] = resultado.getString(6);
//
//                        String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                        Datos[5] = Ejecutivo;
//                        Datos[6] = resultado.getInt(9);
//                        Datos[7] = resultado.getDouble(10);
//                        Datos[8] = resultado.getString(11);
//                        Datos[9] = resultado.getInt(12);
//                        java.util.Date FechaI = resultado.getDate(13);
//
//                        String Fecha = df4.format(FechaI);
//                        Datos[10] = Fecha;
//                        Datos[11] = resultado.getString(14);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            case 7:
//
//                try {
//                    model.setRowCount(0);
//                    String Buscar = txtBuscar.getText();
//                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Estado_Compra] like '%" + Buscar + "%'");
//
//                    while (resultado.next()) {
//
//                        Object[] Datos = new Object[12];
//
//                        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//
//                        Datos[0] = String.valueOf(resultado.getInt(1));
//                        Datos[1] = String.valueOf(resultado.getInt(2));
//
//                        java.util.Date FechaC = resultado.getDate(3);
//                        String FechaComp = df3.format(FechaC);
//
//                        Datos[2] = String.valueOf(FechaComp);
//
//                        String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();
//
//                        Datos[3] = Empleado;
//                        Datos[4] = resultado.getString(6);
//
//                        String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();
//
//                        Datos[5] = Ejecutivo;
//                        Datos[6] = resultado.getInt(9);
//                        Datos[7] = resultado.getDouble(10);
//                        Datos[8] = resultado.getString(11);
//                        Datos[9] = resultado.getInt(12);
//                        java.util.Date FechaI = resultado.getDate(13);
//
//                        String Fecha = df4.format(FechaI);
//                        Datos[10] = Fecha;
//                        Datos[11] = resultado.getString(14);
//
//                        model.addRow(Datos);
//
//                    }
//
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "No Encontrado");
//                }
//
//                break;
//
//            default:
//
//                break;
//
//        }
//        Tabla.setModel(model);
    }

    int IDD;

    public void CargarDatos(int ID_Compra) {
        String Proveedor = "";
        String Agente = "";
        String ModoPago = "";
        Date Fecha = new Date();
        String Tiempo = "";

        try {

            resultado = Conexion.consulta("Select ID_Compra, Fecha_Compra, Nombre_Proveedor, "
                    + "Nombres_Ejecutivo, Apellidos_Ejecutivo, ModoCompra, Tiempo_Pago"
                    + " from CompraV where ID_Compra = " + ID_Compra);

            while (resultado.next()) {
                IDD = resultado.getInt(1);
                Fecha = resultado.getDate(2);
                Proveedor = resultado.getString(3);
                Agente = resultado.getString(4).trim() + " " + resultado.getString(5);
                ModoPago = resultado.getString(6);
                Tiempo = resultado.getString(7);
            }

        } catch (SQLException ex) {
        }

        cmbprov.setSelectedItem(Proveedor);
        cmbEjecutivo.setSelectedItem(Agente);

        if ("Efectivo".equals(ModoPago)) {
            rdEfectivo.setSelected(true);
        } else {
            rdCredito.setSelected(true);
        }

        jFecha.setDate(Fecha);
        cmbTiempo.setSelectedItem(Tiempo);

        int ID_Detalle = 0;
        Date Fecha_Vencimiento = new Date();
        String Producto = "";
        int Unids_Compradas = 0;
        double Costo_Compra = 0;
        int Descuento = 0;
        String Incluye_IVA = "No";
        double TotalF = 0;
        String ModoAdqui = "Normal";
        String Incluye_Vineta = "No";
        int Cantidad_Vineta = 0;
        String Permite_Devolucion = "No";
        int Unid_Devolucion = 0;

        try {

            resultado = Conexion.consulta("Select * from DetalleCompraV where ID_Compra = " + ID_Compra);

            while (resultado.next()) {
                ID_Detalle = resultado.getInt(1);
                resultado.getInt(2);
                resultado.getString(3);
                resultado.getString(4);
                Producto = resultado.getString(5).trim() + " " + resultado.getString(6).trim() + " x"
                        + resultado.getString(7).trim() + " " + resultado.getString(8).trim() + " "
                        + resultado.getString(9).trim();
                Fecha_Vencimiento = resultado.getDate(10);
                Unids_Compradas = resultado.getInt(11);
                Costo_Compra = resultado.getDouble(12);
                Descuento = resultado.getInt(13);
                Incluye_IVA = resultado.getString(14);
                TotalF = resultado.getDouble(15);
                ModoAdqui = resultado.getString(16);
                Incluye_Vineta = resultado.getString(17);
                Cantidad_Vineta = resultado.getInt(18);
                Permite_Devolucion = resultado.getString(19);
                Unid_Devolucion = resultado.getInt(20);

                Object Datos[] = new Object[14];
                Datos[0] = false;
                Datos[1] = ID_Detalle;
                Datos[2] = Producto;
                Datos[3] = Fecha_Vencimiento;
                Datos[4] = Unids_Compradas;
                Datos[5] = Costo_Compra;
                Datos[6] = Descuento;
                Datos[7] = Incluye_IVA;
                Datos[8] = TotalF;
                Datos[9] = ModoAdqui;
                Datos[10] = Incluye_Vineta;
                Datos[11] = Cantidad_Vineta;
                Datos[12] = Permite_Devolucion;
                Datos[13] = Unid_Devolucion;

                modelProducto.addRow(Datos);

            }

        } catch (SQLException ex) {

        }

    }

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Buscar();
// TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    public void ActivarBotones() {

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1) {

            String Estado = ((String) this.Tabla.getModel().getValueAt(Fila, 12));

            if ("Activo".equalsIgnoreCase(Estado)) {
                btnDesactivar.setEnabled(true);
            }
            if ("Anulada".equalsIgnoreCase(Estado)) {
                btnDesactivar.setEnabled(false);
            }

        } else {

            btnDesactivar.setEnabled(false);

        }

    }


    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
//
//        ActivarBotones();
//
//        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
//
//            int Fila = Tabla.getSelectedRow();
//
//            if (Fila > -1) {
//
//                String ID = (String) Tabla.getValueAt(Fila, 0);
//                int ID_Compra = Integer.valueOf(ID);
//
//                BuscarDetalleCompra BuscarDetComp = new BuscarDetalleCompra(this, true);
//                BuscarDetComp.setID_Compra(ID_Compra);
//                BuscarDetComp.setVisible(true);
//
//            }
//            //  Seleccionar();
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaMouseClicked

    private void TablaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaFocusLost

        ActivarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaFocusLost

    public void Anular() {

        int Opcion;

        Opcion = JOptionPane.showConfirmDialog(this, "Está Seguro Que Desea Anular La Compra ?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (Opcion == JOptionPane.YES_OPTION) {

            int ID;
            int UnidsCompradas, UnidsInvent;
            int Fila = Tabla.getSelectedRow();

            ID = Integer.parseInt(this.Tabla.getModel().getValueAt(Fila, 0).toString());

            try {

                resultado = Conexion.consulta("Select [Unidades_Compradas],[UnidsEnInventario]"
                        + " from [dbo].[DetalleCompra] where [ID_Compra] = " + ID);

                while (resultado.next()) {

                    UnidsCompradas = resultado.getInt(1);
                    UnidsInvent = resultado.getInt(2);

                    if (UnidsCompradas > UnidsInvent) {

                        JOptionPane.showMessageDialog(this, "Compra no puede ser anulada, unidades ya fueron utilizadas",
                                "No anulado", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                }

            } catch (SQLException ex) {
            }

            Compra.Anular_Compra(ID);

        }

    }


    private void btnshowallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowallActionPerformed

        ActualizarTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnshowallActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:

        File miDir = new File("");
        String reporte = miDir.getAbsolutePath() + "\\src\\Reportes\\Compra.jasper";

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(reporte, null, Conexion.con);
        } catch (JRException ex) {

//                Logger.getLogger(ProveedorP.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jp, false);
        view.setTitle("Compras - Sistema de Inventario y Facturación RJ");

        view.setZoomRatio((float) 0.70);
        view.setVisible(true);

        view.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        view.toFront();
        //     this.toBack();

        //    this.setExtendedState(javax.swing.JFrame.CROSSHAIR_CURSOR); 

    }//GEN-LAST:event_btnprintActionPerformed

    private void btncancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancel3ActionPerformed
//        MP.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancel3ActionPerformed

    private void TabbedPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabbedPaneMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TabbedPaneMousePressed

    private void TabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneStateChanged

        int index = TabbedPane.getSelectedIndex();
        if (index == 0) {

            PanelEffect.setEffect(new EntryBoucing(1000));
            PanelEffect.startEffect();
        }
        if (index == 1) {

            PanelEffect2.setEffect(new Shape(1000));
            PanelEffect2.startEffect();
            txtBuscar.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_TabbedPaneStateChanged

    KEffectPanel PanelEffect = new KEffectPanel();
    KEffectPanel PanelEffect2 = new KEffectPanel();

    public void Iniciar() {
        int MaxProv = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Proveedor) from Proveedor");

            while (resultado.next()) {

                MaxProv = resultado.getInt(1);
            }

        } catch (SQLException ex) {
        }

        MaxProv++;

        int i = 1;

        Proveedores = new int[MaxProv];
        Proveedores[0] = 0;

        try {

            resultado = Conexion.consulta("Select ID_Proveedor, Nombre_Proveedor from Proveedor "
                    + "where Estado_Proveedor = 'Activo'");

            while (resultado.next()) {

                Proveedores[i] = resultado.getInt(1);
                cmbprov.addItem(resultado.getString(2).trim());
                i++;
            }

        } catch (SQLException ex) {
        }

        //  String Dia, Mes, Ano;
//
//        Calendar c = new GregorianCalendar();
//
//        Dia = Integer.toString(c.get(Calendar.DATE));
//        Mes = Integer.toString(c.get(Calendar.MONTH)+1);
//        Ano = Integer.toString(c.get(Calendar.YEAR));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String strFecha =Dia+"-"+Mes+"-"+Ano ;
//        Date Fecha;
//        try {
//
//            Fecha = sdf.parse(strFecha);
//
//            jdFechaNacimiento.setMaxSelectableDate(Fecha);
//
//        } catch (ParseException ex) {
//        }
//      
        txtNoFactura.requestFocus();

        TituloProducto();

        ActualizarTabla();

        cmbprov.requestFocus();
        cmbProducto.setEnabled(false);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//                this.panelColor = new JPanel();
//		this.panelColor.setBackground(Color.BLACK);
//		this.panelColor.setBorder(new LineBorder(new Color(0, 0, 0)));
//		this.panelColor.setBounds(133, 618, 43, 32);
//                
//     PanelEffect.setEffect(new SplitHorizontalFade (1000,panelColor.getBackground()));
//     PanelEffect.startEffect();

        PanelEffect.setEffect(new EntryBoucing(1000));
        PanelEffect.startEffect();

//Date now = new Date();
//
//DateFormat df =  DateFormat.getDateInstance();
//DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
//DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
//DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
//DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
//String s =  df.format(now);
//String s1 = df1.format(now);
//String s2 = df2.format(now);
//String s3 = df3.format(now);
//String s4 = df4.format(now);
//System.out.println("(Default) Hoy es:" + s);
//System.out.println("(SHORT)   Hoy es:" + s1);
//System.out.println("(MEDIUM)  Hoy es:" + s2);
//System.out.println("(LONG)    Hoy es:" + s3);
//System.out.println("(FULL)    Hoy es:" + s4);
        //this.setResizable(false);
        int MaxProv = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Proveedor) from Proveedor");

            while (resultado.next()) {

                MaxProv = resultado.getInt(1);
            }

        } catch (SQLException ex) {
        }

        MaxProv++;

        int i = 1;

        Proveedores = new int[MaxProv];
        Proveedores[0] = 0;

        try {

            resultado = Conexion.consulta("Select ID_Proveedor, Nombre_Proveedor from Proveedor "
                    + "where Estado_Proveedor = 'Activo'");

            while (resultado.next()) {

                Proveedores[i] = resultado.getInt(1);
                cmbprov.addItem(resultado.getString(2).trim());
                i++;
            }

        } catch (SQLException ex) {
        }

        //  String Dia, Mes, Ano;
//
//        Calendar c = new GregorianCalendar();
//
//        Dia = Integer.toString(c.get(Calendar.DATE));
//        Mes = Integer.toString(c.get(Calendar.MONTH)+1);
//        Ano = Integer.toString(c.get(Calendar.YEAR));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String strFecha =Dia+"-"+Mes+"-"+Ano ;
//        Date Fecha;
//        try {
//
//            Fecha = sdf.parse(strFecha);
//
//            jdFechaNacimiento.setMaxSelectableDate(Fecha);
//
//        } catch (ParseException ex) {
//        }
//      
        txtNoFactura.requestFocus();

        TituloProducto();

        ActualizarTabla();

        cmbprov.requestFocus();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    public void TituloProducto() {

        Object[] Titulo = {"", "ID", "Producto", "Fecha Vencimiento", "Unidades", "Costo Unitario", "Descuento(%)",
            "Incluye IVA", "Total", "Adquisición", "Incluye Viñeta", "Cantidad Viñeta",
            "Permite Devolución", "Cantidad Devolución"};

        modelProducto.setColumnIdentifiers(Titulo);

        this.TablaProductos.setModel(modelProducto);

        TablaProductos.getColumnModel().getColumn(1).setMaxWidth(0);
        TablaProductos.getColumnModel().getColumn(1).setMinWidth(0);
        TablaProductos.getColumnModel().getColumn(1).setPreferredWidth(0);

        JTableHeader header = TablaProductos.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        TablaProductos.setDefaultRenderer(Object.class, new FormatoTabla());

        CheckBoxHeader();

    }

    public void Titulo() {
        Object[] Titulo = {"No.", "No. Factura", "Fecha Compra", "Empleado",
            "Proveedor", "Ejecutivo", "Unidades Totales", "Costo Total", "Modo de Compra", "Tiempo para Pagar",
            "Cancelada", "Fecha Ingreso", "Estado"};

        model.setColumnIdentifiers(Titulo);

        this.Tabla.setModel(model);

        JTableHeader header = Tabla.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        Tabla.setDefaultRenderer(Object.class, new FormatoTablaC());

    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //    MP.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void TablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaFocusGained

        ActivarBotones();    // TODO add your handling code here:
    }//GEN-LAST:event_TablaFocusGained

    private void TablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMousePressed

        ActivarBotones();  // TODO add your handling code here:
    }//GEN-LAST:event_TablaMousePressed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed

        // MP.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        Guardar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveActionPerformed


    private void cmbprovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbprovKeyTyped
        char a = evt.getKeyChar();

        if (a == KeyEvent.VK_ENTER) {

        }
// TODO add your handling code here:
    }//GEN-LAST:event_cmbprovKeyTyped


    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        ActivarBotones();
        Anular();
        ActualizarTabla();
// TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnDesactivarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDesactivarFocusGained
        ActivarBotones();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarFocusGained

    private void btnDesactivarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDesactivarFocusLost
        ActivarBotones();     // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarFocusLost

    private void cmbEjecutivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbEjecutivoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEjecutivoKeyTyped

    private void rdEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdEfectivoKeyTyped
        char a = evt.getKeyChar();

        if (a == KeyEvent.VK_ENTER) {

        }         // TODO add your handling code here:
    }//GEN-LAST:event_rdEfectivoKeyTyped

    private void rdCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdCreditoKeyTyped
        char a = evt.getKeyChar();

        if (a == KeyEvent.VK_ENTER) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_rdCreditoKeyTyped

    private void jPanel13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel13KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13KeyTyped

    private void txtunidsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunidsKeyReleased

        char a = evt.getKeyChar();

        String x1 = "";

        if (Character.isDigit(a) || (Character.isISOControl(a) && !"".equals(txtunids.getText()))) {
            x1 = txtunids.getText();
        }

        if (!"".equals(x1)) {

            try {

                int x = Integer.parseInt(x1);

                if (x > Integer.MAX_VALUE) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }
                if (x <= 0) {
                    txtunids.setText("");
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }

            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }        // TODO add your handling code here:

        String Unidades = txtunids.getText().trim();
        int Unids = 0;
        if (!"".equals(Unidades)) {
            Unids = Integer.parseInt(Unidades);
        }
        String CU = txtCostoUnit.getText().trim();
        double CostoU = 0;
        if (!"".equals(CU)) {
            CostoU = Double.valueOf(CU);
        }

        int Desc = 0;
        Desc = cmbDesc.getSelectedIndex();
        double TotalC = 0;
        float DescT = 0;
        DescT = Desc;
        DescT = DescT / 100;
        TotalC = (Unids * CostoU);
        TotalC = TotalC - (TotalC * DescT);

        if (ckIVA.isSelected()) {
            TotalC = 0;
            DescT = Desc;
            DescT = DescT / 100;
            TotalC = (Unids * CostoU);
            TotalC = TotalC - (TotalC * DescT);
            TotalC = (TotalC * 0.15) + TotalC;
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        String Total = df.format(TotalC);
        Total.replace(',', '.');

        txttotal.setText(Total);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunidsKeyReleased

    private void txtunidsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunidsKeyTyped
        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

        //    add your handling code here:
    }//GEN-LAST:event_txtunidsKeyTyped

    private void txtCostoUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoUnitKeyReleased

        String Unidades = txtunids.getText().trim();
        int Unids = 0;
        if (!"".equals(Unidades)) {
            Unids = Integer.parseInt(Unidades);
        }
        String CU = txtCostoUnit.getText().trim();
        double CostoU = 0;
        if (!"".equals(CU)) {
            CostoU = Double.valueOf(CU);
        }

        int Desc = 0;
        Desc = cmbDesc.getSelectedIndex();
        double TotalC = 0;
        float DescT = 0;
        DescT = Desc;
        DescT = DescT / 100;
        TotalC = (Unids * CostoU);
        TotalC = TotalC - (TotalC * DescT);

        if (ckIVA.isSelected()) {
            TotalC = 0;
            DescT = Desc;
            DescT = DescT / 100;
            TotalC = (Unids * CostoU);
            TotalC = TotalC - (TotalC * DescT);
            TotalC = (TotalC * 0.15) + TotalC;
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        String Total = df.format(TotalC);
        Total.replace(',', '.');

        txttotal.setText(Total);        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoUnitKeyReleased

    private void txtCostoUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoUnitKeyTyped
        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a) && a != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            return;
        }

        if ("0".equals(txtCostoUnit.getText()) && txtCostoUnit.getCaretPosition() == 1 && a != '.' && !Character.isISOControl(a)) {
            txtCostoUnit.setText(txtCostoUnit.getText() + ".");
//        return;
        }

        if (a == '.' && txtCostoUnit.getText().contains(".")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            return;
        }

        String x1 = "";
        if (Character.isDigit(a) || (Character.isISOControl(a) && !"".equals(txtCostoUnit.getText()))) {
            x1 = txtCostoUnit.getText();
        }
        if (Character.isDigit(a) || (a == '.')) {
            x1 = txtCostoUnit.getText().concat(String.valueOf(a));
        }

        if (!"".equals(x1)) {

            try {

                Double x = Double.parseDouble(x1);

                if (x > Double.MAX_VALUE) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }

            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoUnitKeyTyped

    private void cmbDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDescItemStateChanged

        String Unidades = txtunids.getText().trim();
        int Unids = 0;
        if (!"".equals(Unidades)) {
            Unids = Integer.parseInt(Unidades);
        }
        String CU = txtCostoUnit.getText().trim();
        double CostoU = 0;
        if (!"".equals(CU)) {
            CostoU = Double.valueOf(CU);
        }

        int Desc = 0;
        Desc = cmbDesc.getSelectedIndex();
        double TotalC = 0;
        float DescT = 0;
        DescT = Desc;
        DescT = DescT / 100;
        TotalC = (Unids * CostoU);
        TotalC = TotalC - (TotalC * DescT);

        if (ckIVA.isSelected()) {
            TotalC = 0;
            DescT = Desc;
            DescT = DescT / 100;
            TotalC = (Unids * CostoU);
            TotalC = TotalC - (TotalC * DescT);
            TotalC = (TotalC * 0.15) + TotalC;
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        String Total = df.format(TotalC);
        Total.replace(',', '.');

        txttotal.setText(Total);        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDescItemStateChanged

    public void Validar() {

        for (int i = 0; i < TablaProductos.getRowCount(); i++) {

            double cost = Double.valueOf(TablaProductos.getModel().getValueAt(i, 4).toString());
            // System.out.println("cost "+cost);

            if (cost == 0) {
//               
                btnsave.setEnabled(false);
                return;
            }

            btnsave.setEnabled(true);

        }
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        Agregar();

        Validar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void ckIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckIVAItemStateChanged

        String Unidades = txtunids.getText().trim();
        int Unids = 0;
        if (!"".equals(Unidades)) {
            Unids = Integer.parseInt(Unidades);
        }
        String CU = txtCostoUnit.getText().trim();
        double CostoU = 0;
        if (!"".equals(CU)) {
            CostoU = Double.valueOf(CU);
        }

        int Desc = 0;
        Desc = cmbDesc.getSelectedIndex();
        double TotalC = 0;
        float DescT = 0;
        DescT = Desc;
        DescT = DescT / 100;
        TotalC = (Unids * CostoU);
        TotalC = TotalC - (TotalC * DescT);

        if (ckIVA.isSelected()) {
            TotalC = 0;
            DescT = Desc;
            DescT = DescT / 100;
            TotalC = (Unids * CostoU);
            TotalC = TotalC - (TotalC * DescT);
            TotalC = (TotalC * 0.15) + TotalC;
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        String Total = df.format(TotalC);
        Total.replace(',', '.');

        txttotal.setText(Total);        // TODO add your handling code here:
    }//GEN-LAST:event_ckIVAItemStateChanged

    private void cmbProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductoKeyTyped

    private void cmbTiempoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTiempoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTiempoItemStateChanged

    private void txtUnidsBoniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidsBoniKeyReleased

        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

        String x1 = "";

        if (Character.isDigit(a) || (Character.isISOControl(a) && !"".equals(txtUnidsBoni.getText()))) {
            x1 = txtUnidsBoni.getText();
        }

        if (!"".equals(x1)) {

            try {

                int x = Integer.parseInt(x1);

                if (x > Integer.MAX_VALUE) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }
                if (x <= 0) {
                    txtUnidsBoni.setText("");
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }

            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidsBoniKeyReleased

    private void txtUnidsBoniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidsBoniKeyTyped
        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidsBoniKeyTyped

    private void ckBonificacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckBonificacionItemStateChanged
        if (ckBonificacion.isSelected()) {
            txtUnidsBoni.setEnabled(true);
            lblBonifi.setEnabled(true);
            txtUnidsBoni.setVisible(true);
            lblBonifi.setVisible(true);

        } else {
            txtUnidsBoni.setEnabled(false);
            lblBonifi.setEnabled(false);
            txtUnidsBoni.setVisible(false);
            lblBonifi.setVisible(false);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_ckBonificacionItemStateChanged

    private void ckVinetaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckVinetaItemStateChanged
        if (ckVineta.isSelected()) {
            txtVineta.setEnabled(true);
            lblVineta.setEnabled(true);
            txtVineta.setVisible(true);
            lblVineta.setVisible(true);

        } else {
            txtVineta.setEnabled(false);
            lblVineta.setEnabled(false);
            txtVineta.setVisible(false);
            lblVineta.setVisible(false);

        }         // TODO add your handling code here:
    }//GEN-LAST:event_ckVinetaItemStateChanged

    private void ckVinetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckVinetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckVinetaActionPerformed

    private void txtVinetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVinetaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVinetaKeyReleased

    private void txtVinetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVinetaKeyTyped
        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a) && a != '.') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            return;
        }

        if ("0".equals(txtVineta.getText()) && txtVineta.getCaretPosition() == 1 && a != '.' && !Character.isISOControl(a)) {
            txtVineta.setText(txtVineta.getText() + ".");
//        return;
        }

        if (a == '.' && txtVineta.getText().contains(".")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            return;
        }

        String x1 = "";
        if (Character.isDigit(a) || (Character.isISOControl(a) && !"".equals(txtVineta.getText()))) {
            x1 = txtVineta.getText();
        }
        if (Character.isDigit(a) || (a == '.')) {
            x1 = txtVineta.getText().concat(String.valueOf(a));
        }

        if (!"".equals(x1)) {

            try {

                Double x = Double.parseDouble(x1);

                if (x > Double.MAX_VALUE) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }

            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtVinetaKeyTyped

    private void rdCreditoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdCreditoItemStateChanged

        if (rdCredito.isSelected()) {
            cmbTiempo.setEnabled(true);
            lblTiempo.setEnabled(true);
            cmbTiempo.setVisible(true);
            lblTiempo.setVisible(true);

        } else {
            cmbTiempo.setEnabled(false);
            lblTiempo.setEnabled(false);
            cmbTiempo.setVisible(false);
            lblTiempo.setVisible(false);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_rdCreditoItemStateChanged

    private void cmbprovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbprovItemStateChanged

        cmbEjecutivo.removeAllItems();
        cmbProducto.removeAllItems();

        cmbEjecutivo.addItem("<Seleccione>");
        cmbProducto.addItem("<Seleccione>");

        int SelectCombo = cmbprov.getSelectedIndex();

        if (SelectCombo == 0) {
            cmbEjecutivo.setEnabled(false);
            cmbProducto.setEnabled(false);

        } else {
            cmbEjecutivo.setEnabled(true);
            //  cmbProducto.setEnabled(true);

        }

        int ID_Proveedor = Proveedores[SelectCombo];

        int MaxProv = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Ejecutivo) from Ejecutivo");

            while (resultado.next()) {

                MaxProv = resultado.getInt(1);
            }

        } catch (SQLException ex) {
        }

        MaxProv++;

        int i = 1;

        Ejecutivos = new int[MaxProv];
        Ejecutivos[0] = 0;

        try {

            resultado = Conexion.consulta("Select ID_Ejecutivo, Nombres_Ejecutivo, Apellidos_Ejecutivo from Ejecutivo "
                    + "where Estado_Ejecutivo = 'Activo' and ID_Proveedor = " + ID_Proveedor);

            while (resultado.next()) {

                Ejecutivos[i] = resultado.getInt(1);
                cmbEjecutivo.addItem(resultado.getString(2).trim() + " " + resultado.getString(3).trim());
                i++;
            }

        } catch (SQLException ex) {
        }

        int MaxProv2 = 0;

        try {

            resultado = Conexion.consulta("Select Max(ID_Producto) from Producto");

            while (resultado.next()) {

                MaxProv2 = resultado.getInt(1);
            }

        } catch (SQLException ex) {
        }

        MaxProv2++;

        int i2 = 1;

        Productos = new int[MaxProv2];
        Productos[0] = 0;

        try {

            resultado = Conexion.consulta("Select ID_Producto, [Nombre_Producto], "
                    + "[Presentacion], [UnidsXCaja], [Tipo_Medicamento], [Contenido] from Producto "
                    + "where Estado_Producto = 'Activo' and ID_Proveedor = " + ID_Proveedor);

            while (resultado.next()) {

                Productos[i2] = resultado.getInt(1);
                cmbProducto.addItem(resultado.getString(2).trim() + " " + resultado.getString(3).trim() + " x"
                        + resultado.getString(4).trim() + " " + resultado.getString(5).trim() + " " + resultado.getString(6).trim());
                i2++;
            }

        } catch (SQLException ex) {
        }

// TODO add your handling code here:
    }//GEN-LAST:event_cmbprovItemStateChanged

    int ID_DetalleCompra = 0;

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked
//        ActivarEliminar();      

        if (evt.getClickCount() == 2) {
            //  int UnidsCompradas, UnidsInvent;
            int Fila = TablaProductos.getSelectedRow();

            if (Fila >= 0) {
                String Producto = "";
                int Unidades = 0;
                int ID_Det = 0;
                String IVA = "";

                ID_Det = Integer.parseInt(this.TablaProductos.getModel().getValueAt(Fila, 1).toString());
                Producto = this.TablaProductos.getModel().getValueAt(Fila, 2).toString();
                Unidades = Integer.parseInt(this.TablaProductos.getModel().getValueAt(Fila, 4).toString());
                IVA = this.TablaProductos.getModel().getValueAt(Fila, 7).toString();

                this.modelProducto.removeRow(Fila);
                this.TablaProductos.setModel(modelProducto);

                cmbProducto.setSelectedItem(Producto);
                txtunids.setText(String.valueOf(Unidades));
                ID_DetalleCompra = ID_Det;
                if ("Si".equals(IVA)) {
                    ckIVA.setSelected(true);
                } else {
                    ckIVA.setSelected(false);

                }
                ckBonificacion.setEnabled(true);
                ckDevol.setEnabled(true);
                ckVineta.setEnabled(true);
                txtCostoUnit.setEnabled(true);
                txtUnidsBoni.setEnabled(true);
                cmbDesc.setEnabled(true);
                jFechaVence.setEnabled(true);
                btnAgregar.setEnabled(true);
                jFechaVence.setDate(new Date());

            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto",
                        "Seleccione", JOptionPane.ERROR_MESSAGE);

            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_TablaProductosMouseClicked

    private void TablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMousePressed
        //   ActivarEliminar();
        //  ActivarEliminar();           // TODO add your handling code here:
    }//GEN-LAST:event_TablaProductosMousePressed

    private void TablaProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaProductosFocusGained
        //    ActivarEliminar();           // TODO add your handling code here:
    }//GEN-LAST:event_TablaProductosFocusGained

    private void TablaProductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaProductosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaProductosFocusLost

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
        int Index = cmbProducto.getSelectedIndex();

        if (Index > 0) {

            int ID_P = Productos[Index];
            String Exclud = "No";

            try {

                resultado = Conexion.consulta("Select [Exclud_IVA] from Producto "
                        + "where ID_Producto = " + ID_P);

                while (resultado.next()) {

                    Exclud = resultado.getString(1);
                }

                if ("Si".equals(Exclud)) {
                    ckIVA.setSelected(false);
                }

                if ("No".equals(Exclud)) {
                    ckIVA.setSelected(true);
                }

            } catch (SQLException ex) {
            }

        } else {
            ckIVA.setSelected(false);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_cmbProductoItemStateChanged

    private void jFechaVence1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFechaVence1PropertyChange

        Titulo();

        int index = cmbbusc.getSelectedIndex() + 1;

        switch (index) {

            case 2:

                try {
                    String Buscar = "";

                    try {
                        Buscar = jFechaVence1.getDate().toString();
                    } catch (NullPointerException ex) {
                        return;
                    }
                    DateFormat FormatD = new SimpleDateFormat("yyyy-MM-dd");
                    Buscar = FormatD.format(jFechaVence1.getDate());

                    model.setRowCount(0);

                    resultado = Conexion.consulta("Select * from [dbo].[CompraV] where [Fecha_Compra]"
                            + " like '%" + Buscar + "%'");

                    while (resultado.next()) {

                        Object[] Datos = new Object[13];

                        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);

                        Datos[0] = String.valueOf(resultado.getInt(1));
                        Datos[1] = String.valueOf(resultado.getInt(2));

                        java.util.Date FechaC = resultado.getDate(3);
                        String FechaComp = df3.format(FechaC);

                        Datos[2] = String.valueOf(FechaComp);

                        String Empleado = resultado.getString(4).trim() + " " + resultado.getString(5).trim();

                        Datos[3] = Empleado;
                        Datos[4] = resultado.getString(6);

                        String Ejecutivo = resultado.getString(7).trim() + " " + resultado.getString(8).trim();

                        Datos[5] = Ejecutivo;
                        Datos[6] = resultado.getInt(9);
                        Datos[7] = resultado.getDouble(10);
                        Datos[8] = resultado.getString(11);
                        Datos[9] = resultado.getInt(12);
                        Datos[9] = resultado.getString(13);
                        java.util.Date FechaI = resultado.getDate(14);

                        String Fecha = df4.format(FechaI);
                        Datos[10] = Fecha;

                        Datos[11] = resultado.getString(15);
                        model.addRow(Datos);

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No Encontrado");
                }

                break;

            default:
                break;
        }

        Tabla.setModel(model);
        // TODO add your handling code here:
    }//GEN-LAST:event_jFechaVence1PropertyChange

    private void cmbbuscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbuscItemStateChanged

        int index = cmbbusc.getSelectedIndex();

        if (index == 1) {
            jFechaVence1.setVisible(true);
            txtBuscar.setVisible(false);
            txtBuscar.setText("");
            jFechaVence1.requestFocus();

        } else {
            jFechaVence1.setVisible(false);
            jFechaVence1.setDate(new Date());
            txtBuscar.setVisible(true);
            txtBuscar.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbuscItemStateChanged

    private void txtNoFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoFacturaKeyTyped

        char a = evt.getKeyChar();

        if (!Character.isDigit(a) && !Character.isISOControl(a) && !Character.isLetter(a)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtNoFacturaKeyTyped

    DefaultTableModel model = new DefaultTableModel() {

        Class[] types = new Class[]{
            java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;

            //all cells false
        }
    };

    DefaultTableModel modelProducto = new DefaultTableModel() {

        Class[] types = new Class[]{
            java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class,
            java.util.Date.class, java.lang.Integer.class, java.lang.Double.class,
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.Double.class,
            java.lang.String.class, java.lang.Integer.class

        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            if (column == 0) {
                return true;
            } else {
                return false;
            }
            //all cells false

        }
    };

    public class FormatoTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

            if (String.valueOf(table.getValueAt(row, 9)).equalsIgnoreCase("Bonificación")) {

                if (column == 9) {
                    setBackground(new Color(153, 255, 153));
                } else {
                    setBackground(Color.WHITE);
                }

            } else {
                setForeground(Color.BLACK);
            }

//   if(String.valueOf(table.getValueAt(row,9)).equalsIgnoreCase("Si"))  {
//      setForeground(Color.GREEN);
//  }
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            return this;
        }
    }

    public class FormatoTablaC extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

            if (String.valueOf(table.getValueAt(row, 12)).equalsIgnoreCase("Anulada")) {

                setForeground(Color.RED);
            } else {
                setForeground(Color.BLACK);
            }

//   if(String.valueOf(table.getValueAt(row,9)).equalsIgnoreCase("Si"))  {
//      setForeground(Color.GREEN);
//  }
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            return this;
        }
    }

    public class CheckBoxHeader extends JCheckBox implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(header.getBackground());
                    rendererComponent.setFont(header.getFont());
                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("Selecc. Todo");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {
            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int columna = tableView.convertColumnIndexToModel(viewColumn);

                if (viewColumn == this.column && e.getClickCount() == 1 && columna != -1) {
                    doClick();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((JTableHeader) e.getSource()).repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public void CheckBoxHeader() {

        TableColumn tc = TablaProductos.getColumnModel().getColumn(0);  //No Columna
        tc.setCellEditor(TablaProductos.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(TablaProductos.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));

    }

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = TablaProductos.getRowCount(); x < y; x++) {
                TablaProductos.setValueAt(checked, x, 0);  //No Columna
            }
            TablaProductos.requestFocus();
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoCompraP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PedidoCompraP dialog = new PedidoCompraP(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelNuevo;
    private javax.swing.JPanel PanelProducto;
    private javax.swing.JPanel PanelVer;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader TabbedPane;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btncancel3;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnshowall;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ckBonificacion;
    private javax.swing.JCheckBox ckDevol;
    private javax.swing.JCheckBox ckIVA;
    private javax.swing.JCheckBox ckVineta;
    private javax.swing.JComboBox cmbDesc;
    private javax.swing.JComboBox cmbEjecutivo;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JComboBox cmbTiempo;
    private javax.swing.JComboBox cmbbusc;
    private javax.swing.JComboBox cmbprov;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private com.toedter.calendar.JDateChooser jFecha;
    private com.toedter.calendar.JDateChooser jFechaVence;
    private com.toedter.calendar.JDateChooser jFechaVence1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblBonifi;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblVineta;
    private javax.swing.JLabel lblVineta1;
    private javax.swing.JRadioButton rdCredito;
    private javax.swing.JRadioButton rdEfectivo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCostoUnit;
    private javax.swing.JTextField txtNoFactura;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtUnidsBoni;
    private javax.swing.JTextField txtVineta;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtunids;
    // End of variables declaration//GEN-END:variables
}

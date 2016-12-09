/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;


import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import static com.googlecode.javacv.cpp.opencv_core.cvClearMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import static java.lang.System.currentTimeMillis;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;

/**
 *
 * @author Reymundo Tenorio
 */
public final class Alerta extends  javax.swing.JFrame implements MouseListener {

    /**
     * Creates new form WebCam
     * @param Device
     * @throws java.io.IOException
     */
    public Alerta(int Device) throws IOException {
        
     // this.setUndecorated(true);
         
        File F = new File("");
        
        String RutaFarmacia = F.getAbsolutePath()+"\\Farmacia\\";
        String RutaCaptura = F.getAbsolutePath()+"\\Farmacia\\Capturas\\";
 
        File Farmacia = new File(RutaFarmacia);
       
        if(!Farmacia.exists()){
            Farmacia.mkdir();
        }
        
        File Captura = new File(RutaCaptura);
       
        if(!Captura.exists()){
            Captura.mkdir();
        }
         
        
      WC = new WebCamCap();
      WC.setWebCam(this);
      WC.setCamara(Device);
//      WC.setDispositivos(Dispositivos);
      
     
     
         
    }   
    
    IniciarSesion Inicio;

    public void setInicio(IniciarSesion Inicio) {
        this.Inicio = Inicio;
    }
    
     
    ProcesandoInfo P;

    
    
    String [] Usuario = new String [Limite];
    String [] Contrasena = new String [Limite];
    Timestamp [] Fecha = new Timestamp [Limite];
    
    String User;
    String Pass;
    String Correo;
    
    ContrasenaOlvidada ConOlv;

    public void setConOlv(ContrasenaOlvidada ConOlv) {
        this.ConOlv = ConOlv;
    }
      

    public void setUser(String User) {
        this.User = User;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
 
    
    public void SetUsuario (String Usuario, int Pos){
        
    this.Usuario [Pos] = Usuario;
    
    }
    
    public void SetContrasena (String Contrasena, int Pos){
        
    this.Contrasena [Pos] = Contrasena;
    
    }
    
    public void SetFecha (Timestamp Fecha, int Pos){
        
    this.Fecha [Pos] = Fecha;
    
    }
    
    
    
    public void Empezar(ProcesandoInfo P) throws IOException, MessagingException{
      
     this.P = P;
        
      Runnable Camera = WC;
      
      setHome();
     
      Thread Cam = new Thread (Camera);
      Cam.start();
  
      try {
                 Thread.sleep(6000);
             } catch (InterruptedException ex) {
               }
   
      
         WC.GuardarImagen();
    }
    
    String RecordarContra = "Desactivado";

    public void setRecordarContra(String RecordarContra) {
        this.RecordarContra = RecordarContra;
    }
    
    
    
    public void setHome(){
         File F = new File("");
          String RutaFarmacia;
          
         if("Activado".equals(RecordarContra)){
         RutaFarmacia = F.getAbsolutePath()+"\\Farmacia\\Capturas\\RecuperarContrasena\\";
         }
         else
         {
          RutaFarmacia = F.getAbsolutePath()+"\\Farmacia\\Capturas\\AlertaIntruso\\";
         }
        Home = new File(RutaFarmacia);
       
        if(!Home.exists()){
            Home.mkdir();
        }
        
     
        initComponents();
//        
       
        
    }
   
   
     
 
   
//    private Dispositivos Dispositivos;
//
//    public void setDispositivos(Dispositivos Dispositivos) {
//        this.Dispositivos = Dispositivos;
//    }
    
    
   

   
     public File Home;
     
     public static int Limite = 3;
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        ViewWebCam = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WebCam Capture - Reymundo Tenorio");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 5));

        Contenedor.setBackground(new java.awt.Color(0, 153, 204));
        Contenedor.setLayout(new java.awt.BorderLayout());

        ViewWebCam.setBackground(new java.awt.Color(0, 153, 204));
        ViewWebCam.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()), "Vista Previa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ViewWebCam.setLayout(new java.awt.GridBagLayout());
        ViewWebCam.add(lblPic, new java.awt.GridBagConstraints());

        Contenedor.add(ViewWebCam, java.awt.BorderLayout.CENTER);

        getContentPane().add(Contenedor, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(759, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
   public void VideoCapture(Image imagen) throws IOException{
      
        ViewWebCam.removeAll();
        
        ImageIcon icon = new ImageIcon(imagen);
        lblPic.setIcon(icon);
        
        ViewWebCam.add(lblPic);
        ViewWebCam.updateUI();  
 
   }
  
  
   private final WebCamCap WC; 
   
//   private int Camara;
// 
//    public void setCamara(int Camara) {
//        this.Camara = Camara;
//    }
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
      this.setResizable(false);
      this.toFront();
     
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Cerrar();
            // TODO add your handling code here:
        } catch (MessagingException ex) {
           
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            Cerrar();          // TODO add your handling code here:
        } catch (MessagingException ex) {
          
        }
    }//GEN-LAST:event_formWindowClosed

      AlertaSesion Alerta = new AlertaSesion();
      ContrasenaOlvidar COlv = new ContrasenaOlvidar();
  
    public void Cerrar() throws MessagingException{
        
      
    WC.Apagar();
    
   
       if("Activado".equals(RecordarContra)){  
         COlv.setInicio(ConOlv);
         COlv.Enviar(User, Pass, new java.sql.Timestamp(currentTimeMillis()), Correo , this.P);  
         }
       else{
     Alerta.setInicio(Inicio);
     Alerta.Enviar(Usuario, Contrasena, Fecha);
       }
  
    WC.Finish();
   
      
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
            java.util.logging.Logger.getLogger(Alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Alerta(0).setVisible(true);
                } catch (IOException ex) {
                   
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPanel ViewWebCam;
    private javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 public class WebCamCap implements Runnable {
  
    private Alerta WebCam;
    private  boolean Flag;
    private opencv_core.IplImage img;
    private String XML_FILE = "\\haarcascade_frontalface_default.xml";
    private boolean Face;
    private boolean Auto;
    private int Camara;
    

//    private Dispositivos Dispositivos;
//
//        public void setDispositivos(Dispositivos Dispositivos) {
//            this.Dispositivos = Dispositivos;
//        }
        public void setAuto(boolean Auto) {
            this.Auto = Auto;
        }

    
        public void setFace(boolean Face) {
            this.Face = Face;
        }
    

        public void setWebCam(Alerta WebCam) {
            this.WebCam = WebCam;
            this.Flag = true;
            this.Face = false;
            this.Auto = false;
            this.Camara = 1;
        }

        public void setCamara(int Camara) {
            this.Camara = Camara;
        }
     
        public void Apagar() {
        this.Flag = false;
        this.Face = false;
        this.Auto = false;
//      this.Dispositivos.dispose();
              
       }
        
        public void Finish(){
         this.WebCam.dispose();
        }
 
       
        public int Contador = 0;
        
    public void GuardarImagen() throws IOException, MessagingException{
       
    
 

    String Ruta = Home.getAbsolutePath();
    Ruta = Ruta.concat("\\");
    
  
 
    Timestamp i = new java.sql.Timestamp(currentTimeMillis());
//    int Dia, Mes, Ano, Hora, Mins, Seg, Nanos, Zone;
    int Nanos;
//    
//    Dia = i.getDay();
//    Mes = i.getMonth()+1;
//    Ano = i.getYear();
//    Hora = i.getHours();
//    Mins = i.getMinutes();
//    Seg = i.getSeconds();

//    Zone = i.getTimezoneOffset();
    
//   String Pic = "Capture_"+Dia+"_"+Mes+"_"+Ano+"_"+Hora+"_"+Mins+"_"+Seg+
//           "_"+Nanos+"_"+Zone +".jpg" ;
//   String Path = Ruta+Pic;
    
  Nanos = i.getNanos(); 
  long Time = i.getTime();
   
  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh_mm_ss a");
  Date Date = new Date(Time);
  String Fecha = sdf.format(Date);
  String AM_PM  = Fecha.substring(Fecha.length()-2, Fecha.length());
  Fecha = Fecha.substring(0,Fecha.length()-3);
    
     String Path = Ruta.concat("IMG_").concat(Fecha).
     concat(String.valueOf(Nanos)).concat("_"+AM_PM).concat(".jpg");
      
     try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
               }
     
    cvSaveImage(Path, img);
   

        if(Alerta != null){
            
              Alerta.Foto(Path, Contador);
              Alerta.setNombreFoto("IMG_".concat(Fecha).
             concat(String.valueOf(Nanos)).concat("_"+AM_PM).concat(".jpg"), Contador);
 
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
               }
              }
        
        if(COlv!=null){
             COlv.Foto(Path, Contador);
             COlv.setNombreFoto("IMG_".concat(Fecha).
             concat(String.valueOf(Nanos)).concat("_"+AM_PM).concat(".jpg"), Contador);
 
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
               }
        }
        
        Contador++;
        
     
        if(Contador >= Limite){
              
//          try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException ex) {
//               }            
        this.WebCam.Cerrar();
        return;
        }
        
        
//      try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException ex) {
//               }
//      
//    this.Apagar();
//    this.WebCam.Cerrar();
    
      WC.GuardarImagen();
 
        }
       
           
        @Override
        public synchronized void run() {
     
        while(Flag){        
            
     File File = new File("");
     XML_FILE = File.getAbsolutePath()+XML_FILE;   
     FrameGrabber grabber = new OpenCVFrameGrabber(Camara);  
      
     try {      
       
      grabber.start();   
  
      WebCam.lblPic.setSize(grabber.getImageWidth(), grabber.getImageHeight());
   
     int Total_Faces = 0;
     
      while (Flag) {

       
          
       img = grabber.grab();
       
 
       if (img != null) {      
        
         cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise;
         
         if(Face){
        

           
            
		opencv_objdetect.CvHaarClassifierCascade cascade = new 
		opencv_objdetect.CvHaarClassifierCascade(cvLoad(XML_FILE));
                
		opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();
		opencv_core.CvSeq sign = cvHaarDetectObjects(
				img,
				cascade,
				storage,
				1.5,
				3,
				CV_HAAR_DO_CANNY_PRUNING);

		cvClearMemStorage(storage);

		Total_Faces = sign.total();		

		for(int i = 0; i < Total_Faces; i++){
			opencv_core.CvRect r = new opencv_core.CvRect(cvGetSeqElem(sign, i));
			cvRectangle (   img,
					cvPoint(r.x(), r.y()),
					cvPoint(r.width() + r.x(), r.height() + r.y()),
					opencv_core.CvScalar.CYAN,
					1,
					CV_AA,
					0 );

		}

         }
    
          Image imagen;
          imagen = img.getBufferedImage();

 if(Auto == true && Total_Faces > 0){
 
     GuardarImagen();
 

}
           try {
               WebCam.VideoCapture(imagen);
           } catch (IOException ex) {
            }
        
       }
       }
      
      
      if(Flag == false){
          grabber.stop();
      }
      }
     catch (FrameGrabber.Exception | IOException e) {
     }      catch (MessagingException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }
     
     
        }
     
}
  
  
  
}



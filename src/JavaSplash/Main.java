package JavaSplash;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Reymundo Tenorio
 */
public class Main {

public static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

        
        
  try {
     
UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
    
    } catch (UnsupportedLookAndFeelException ex) 
    {
            JOptionPane.showMessageDialog(null, "Error al Iniciar Apariencia","Error",JOptionPane.ERROR_MESSAGE);
    }
                 
    try {
      serverSocket = new ServerSocket(2812);
    } catch (IOException ex) {
       
    
        JOptionPane.showMessageDialog(null, "El Sistema Actualmente se Encuentra en Ejecución","Sistema en Ejecución",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
        
                 
        new ScreenSplashNew().animar();   
        
        
    }

}

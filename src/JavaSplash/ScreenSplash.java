package JavaSplash;

import Ventanas.IniciarSesion;
import java.awt.*;
import java.awt.SplashScreen;
import java.io.IOException;

/**
 *
 * @author Reymundo Tenorio
 */
public final class ScreenSplash {

  final SplashScreen splash ;

  final String[] texto = { "Sistema de Inventario y Facturación","Configuraciones" ,"Librerias", "Conexión",
                          "Ventanas","Iconos","Propiedades","Servidor","Base de Datos",
                          "Reymundo Tenorio", "Javier Rojas", "Universidad Nacional de Ingeniería",
                          "Iniciando..."};

  public ScreenSplash() {
	 splash = SplashScreen.getSplashScreen();
  }

   public void animar() throws IOException
   {
       
        
        
       if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<texto.length; i++)
            {                       
                //se pinta texto del array
                g.setColor( new Color(4,52,101));//Color de Fondo
	        g.fillRect(203, 328,280,12);//Para tapar Texto Anterior
                g.setColor(Color.white);//Color de texto	        
                g.drawString("Cargando "+texto[i-1]+"...", 203, 338);                
                g.setColor(Color.ORANGE);//Color de barra de progeso
              g.fillRect(204, 308,(i*650/texto.length), 12);//La barra de progreso
                  //  g.fillRect(204, 308,3, 12);//la barra de progreso
                //se pinta una linea segmentada encima de la barra verde
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.ORANGE);//Color de barra de progeso
                g.setColor( new Color(4,52,101));
               g.drawLine(205,314, 800, 314);    
          //       g.drawLine(205,314, 510, 314);
                //se actualiza todo
                splash.update();
		try {
		 Thread.sleep(100);
                 
                 //350
                  //  Thread.sleep(600);
		} catch(InterruptedException e) { }
            }
	   splash.close();
	}
        
      IniciarSesion ns = new IniciarSesion();
      ns.setVisible(true);
      ns.toFront();
   }

  
    
}

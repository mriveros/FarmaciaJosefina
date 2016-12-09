/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Reymundo Tenorio
 */

public class GuardarLeerCamara {
    
    
    
public void GuardarCamara(int Camara) {
     
       
           DataOutputStream archivo = null;
       
          File miDir = new File (".");

        
                try {

                     archivo = new DataOutputStream( new FileOutputStream(miDir.getAbsolutePath()+"Camara.dat") );

     

        archivo.writeInt(Camara);
        
        archivo.close();

               }
                catch(FileNotFoundException fnfe) {
               
                }
                catch (IOException ioe) { 
              
                }

       }
    
    
public int DatoCamara() throws  IOException {

        int Camara = 0;
        
        DataInputStream archivo = null;
            File miDir = new File (".");
        
        try{
       
            archivo = new DataInputStream( new FileInputStream(miDir.getAbsolutePath()+"Camara.dat") );

            while (true) {
            
         Camara=archivo.readInt();
         
            }
            
        }
        catch(FileNotFoundException fnfe) { 
           
        }catch (IOException ioe) {
   
        }

    archivo.close();

    return Camara;
    
        
    }

    

    
}

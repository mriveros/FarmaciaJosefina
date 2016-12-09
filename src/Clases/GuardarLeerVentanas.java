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

public class GuardarLeerVentanas {
    
    
    
public void GuardarVentanas(boolean Ventanas) {
     
       
           DataOutputStream archivo = null;
       
          File miDir = new File (".");

        
                try {

                     archivo = new DataOutputStream( new FileOutputStream(miDir.getAbsolutePath()+"Ventanas.dat") );

     

        archivo.writeBoolean(Ventanas);
        
        archivo.close();

               }
                catch(FileNotFoundException fnfe) {
               
                }
                catch (IOException ioe) { 
              
                }

       }
    
    
public boolean DatoVentanas() throws  IOException {

        boolean Ventanas = false;
        
        DataInputStream archivo = null;
            File miDir = new File (".");
        
        try{
       
            archivo = new DataInputStream( new FileInputStream(miDir.getAbsolutePath()+"Ventanas.dat") );

            while (true) {
            
         Ventanas=archivo.readBoolean();
         
            }
            
        }
        catch(FileNotFoundException fnfe) { 
           
        }catch (IOException ioe) {
   
        }

    archivo.close();

    return Ventanas;
    
        
    }

    

    
}

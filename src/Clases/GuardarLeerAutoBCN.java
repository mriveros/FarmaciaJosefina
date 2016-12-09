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

public class GuardarLeerAutoBCN {
    
    
    
public void GuardarBCN(boolean BCN) {
     
       
           DataOutputStream archivo = null;
       
          File miDir = new File (".");

        
                try {

                     archivo = new DataOutputStream( new FileOutputStream(miDir.getAbsolutePath()+"BCN.dat") );

     

        archivo.writeBoolean(BCN);
        
        archivo.close();

               }
                catch(FileNotFoundException fnfe) {
               
                }
                catch (IOException ioe) { 
              
                }

       }
    
    
public boolean DatoBCN() throws  IOException {

        boolean BCN = false;
        
        DataInputStream archivo = null;
            File miDir = new File (".");
        
        try{
       
            archivo = new DataInputStream( new FileInputStream(miDir.getAbsolutePath()+"BCN.dat") );

            while (true) {
            
         BCN=archivo.readBoolean();
         
            }
            
        }
        catch(FileNotFoundException fnfe) { 
           
        }catch (IOException ioe) {
   
        }

    archivo.close();

    return BCN;
    
        
    }

    

    
}

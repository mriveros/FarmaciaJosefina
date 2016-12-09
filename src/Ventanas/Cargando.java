/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author Reymundo
 */
public class Cargando extends Thread {

	

	@Override
	public void run() {

            Loading Load = new Loading();
            Load.setVisible(true);
           
            
	}


}
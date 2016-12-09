/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Reymundo
 */
import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

class AnimatedJFrame extends JFrame implements Runnable
{
Thread t;
 public AnimatedJFrame()
 {

 // Set frame properties
 setTitle("Animated JFrame");
 setSize(500,500);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setUndecorated(true);

 // Set some shape, i want a circle
 setShape(new Ellipse2D.Double(0,0,500,500));

 // Set background for the frame's content pane
 getContentPane().setBackground(Color.BLUE
 );

 // Set opacity, don't make it opaque, that's my wish!
 //setOpacity(0.5f);

 setVisible(true);

 // Create a new thread, run() is written in this class (Runnable implemented)
 t=new Thread(this);

 // Start the thread
 t.start();
 }

public void run()
{
 try
 {

 // Get the width of the screen, so that the frame has to go till end!
 int width=Toolkit.getDefaultToolkit().getScreenSize().width;

  // Start the loop
  for(int i=0;i<=width;i++)
  {

  // If i value equals width (i.e. reaches end of screen), start from starting of the screen (i.e. i=0) so looped forever
  if(i==width) i=0;

  // Set location, x-coordinate changes but y-coordinate is constant
  setLocation(i,55);

  // Get the effect!
  Thread.sleep(1);

  }

 }catch(Exception e){}

 }

 public static void main(String args[])
 {
 new AnimatedJFrame();
 }

}
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
import java.awt.*;
import javax.swing.*;

public class JPanelMenu extends JMenuBar{

//public static void main(String[] args) {
//    JFrame f = new JFrame("Menu Test");
//    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    JMenu jmenu = new JMenu("J Menu");
////    jmenu.add(new JMenuItem("Menu Item"));
//
//    JPanelMenu m = new JPanelMenu("Menu");
//    m.add(jmenu);
////    m.add(new JMenuItem("Menu Item 1"));
////    m.add(new JMenuItem("Menu Item 2"));
//
//    JPanel background = new JPanel();
//    background.add(m);      
//    f.setContentPane(background);
//    f.pack();
//    f.setVisible(true);
//}

//This is the JMenu that is shown
private JMenu menu;

public JPanelMenu(String title) {
    super();
    menu = new JMenu(title);
    super.add(menu);
}

@Override
public Component add(Component comp) {
    //You add the the JMenu instead of the JMenuBar
    return menu.add(comp);
}

@Override
public JMenu add(JMenu c) {
    //You add the the JMenu instead of the JMenuBar
    return (JMenu) menu.add(c);
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    //Include these two lines to remove the button look
    //Or remove this method to keep the button look
    //g.setColor(getBackground());
    //g.fillRect(0, 0, getWidth(), getHeight());
}

@Override
protected void paintBorder(Graphics g) {
    //Remove this line to remove the underline look
    //when you remove the button look
    //An alternative is to you setBorderPainted(false);
    //when you create the object or in the constructor
    //Or remove this method to keep the border
    //super.paintBorder(g);
}
}

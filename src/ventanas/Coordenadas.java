/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
public interface MouseListener {
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);
public void mouseClicked(MouseEvent e);
public void mouseEntered(MouseEvent e);
public void mouseExited(MouseEvent e);

}
 */
package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author tarde
 */
public class Coordenadas extends JFrame{

   
   
    JLabel lx,ly;
    JTextField tx,ty;
    JPanel jp;
    JPanel p;
  
   
    Coordenadas() {
        
        this.setSize(500,500);
        this.setTitle("Cordenada");
        this.setLayout(new FlowLayout());
        
        lx = new JLabel("x : ");
        ly = new JLabel("y : ");
        tx = new JTextField(10);
        ty = new JTextField(10);
        jp = new JPanel();
        
        
        
        jp.setBackground(Color.yellow);
        jp.add(lx);
        jp.add(tx);
        jp.add(ly);
        jp.add(ty);
        
        
        this.add("North",jp);
        this.addMouseListener(new Raton());
        this.setVisible(true);
        
        
        
        
    }
    
    
    public static void main(String[] args) {
      new Coordenadas();
       
    }
    
     class Raton extends Coordenadas {
         
 
        public void mouseClicked(MouseEvent e) {
            tx.setText(e.getX()+"");
            ty.setText(e.getY()+"");
            System.out.println("sdfsvd");
        }
        
    }
     
    
    
    
    
    

}

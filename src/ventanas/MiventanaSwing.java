/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public class MiventanaSwing extends JFrame implements ActionListener {

    class Ventana2 extends JFrame implements ActionListener {

        Ventana2() {
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                    b.setEnabled(true);
                }
            });
            this.setSize(400, 400);
            this.setLayout(new FlowLayout());
            this.setVisible(true);
        }
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    JButton b;
    JTextField txt;


    MiventanaSwing() {
        ImageIcon img = new ImageIcon("C:\\fulstack sina\\projectofundomentos\\fullstack\\html\\images\\barg.png");
        b = new JButton("ABRE", img);
        txt = new JTextField(20);
        b.addActionListener(this);
        b.setEnabled(true);
        
        this.add(b);
        this.add(txt);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new MiventanaSwing();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            
            txt.setText("Holaaa!!!");
           
                b.setEnabled(false);
                new Ventana2();
           
            
            
                
           
            
        }
        if(e.getSource() == txt) {
            txt.setText("");
        }
    }

}

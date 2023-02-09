/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.*;
/**
 *
 * @author tarde
 */
public class Miventana extends Frame implements ActionListener{
    Button b;
    TextField txt;
    Miventana() {
        b = new Button("Enviar");
        txt = new TextField(20);
        b.setPreferredSize(new Dimension(100,20));
        b.setBounds(100, 100, 100, 100);
        
        b.addActionListener(this);
        this.add(b);
        this.add(txt);
        this.setTitle("Mi ventana");
        this.setSize(500,500);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Miventana();
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b) {
            txt.setText("pulsado"); 
        }
    }
    
}

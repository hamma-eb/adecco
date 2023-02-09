
import java.applet.Applet;
import java.awt.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tarde
 */
public class Boton extends Applet{
    Button b;
    TextField txt;
    public void init() {
        b = new Button("enviar");
        txt =  new TextField(15);
        this.add(b);
        this.add(txt);
    }
    
    public boolean action(Event e,Object obj) {
        
            System.out.println("ss"+e.x+"");
            txt.setText("");
        
        return true;
    }
   
}

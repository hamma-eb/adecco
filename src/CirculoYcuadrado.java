
import com.sun.glass.ui.Size;
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
public class CirculoYcuadrado extends Applet{
    
    void update() {
        
    }

    public boolean mouseDown(Event e,int x,int y) {
            Graphics g = this.getGraphics();
            
            if(x < this.size().width /2) {
                g.fillOval(x-25, y-25, 50, 50);
            }else {
                g.fillRect(x-25, y-25, 50, 50);
            }
            
        return true;
    }
}

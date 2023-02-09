
import java.applet.Applet;
import java.awt.*;
import java.util.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tarde
 */
public class CirculosTest extends Applet{
    Graphics g;
    ArrayList sircules;
    public void init() {
        g = this.getGraphics();
    }
    
    void pintar() {
        for (int i = 0; i < sircules.size(); i++) {
            Circul circul = (Circul) sircules.get(i);
            g.fillOval(circul.x, circul.y, circul.w, circul.h);
        }
    }
    
    
}

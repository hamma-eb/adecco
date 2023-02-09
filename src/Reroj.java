
import java.applet.Applet;
import java.awt.*;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tarde
 */
public class Reroj extends Applet implements Runnable {
    
    Thread t;
    Date date;
    int hora;
    int minuto;
    int segundo;
    
    public void init() {
        date = new Date();
        hora = date.getHours();
        minuto = date.getMinutes();
        segundo = date.getSeconds();
    }
    
    public void start() {
        if(t == null) {
            t = new Thread(this);
            t.start();
        }
       
    }
    public void stop() {
        if(t != null) {
            t.stop();
            t = null;
        }
       
    }
    public void paint(Graphics g) {
        g.fillRect(this.size().width-100, 0, 100, 50);
        g.setColor(Color.yellow);
        if(segundo > 10) {
            g.drawString(hora+" : "+minuto+" : "+segundo, this.size().width-80, 30);
        }else {
            g.drawString(hora+" : "+minuto+" : 0"+segundo, this.size().width-80, 30);
        }
        if(minuto > 10) {
            g.drawString(hora+" : "+minuto+" : "+segundo, this.size().width-80, 30);
        }else {
            g.drawString(hora+" : 0"+minuto+" : "+segundo, this.size().width-80, 30);
        }
        if(hora > 10) {
            g.drawString(hora+" : "+minuto+" : "+segundo, this.size().width-80, 30);
        }else {
            g.drawString("0"+hora+" : "+minuto+" : "+segundo, this.size().width-80, 30);
        }
        
    }
    public void run() {
        
        while (true) {
            date = new Date();
            hora = date.getHours();
            minuto = date.getMinutes();
            segundo = date.getSeconds();
            System.out.println(segundo);
            
            repaint();
            try {
                t.sleep(1000);
            } catch (Exception e) {
            }
            
        }
        
    }
}

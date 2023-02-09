
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tarde
 */
public class MoverPlota extends Applet implements Runnable {

    class Plota {

        int x;
        int y;
        int wh;
        int sx;
        int sy;
        int ss;

        public Plota(int x, int y, int wh, int s) {
            this.x = x;
            this.y = y;
            this.wh = wh;
            this.sx = s;
            this.sy = s;
            this.ss = s;
        }

        void muve(int w, int h) {
            if(this.x + this.wh >= w) {
                this.sx = -this.ss;
            }
            if(this.x <= 0) {
                this.sx = this.ss;
                
            }
            
            if(this.y + this.wh >= h) {
                this.sy = -this.ss;
            }
            if(this.y <= 0) {
                this.sy = this.ss;
                
            }
            this.x += this.sx;
            this.y += this.sy;
            

        }

    }
    ArrayList plotas;
    Graphics g;
    Plota plota;
    Thread t;

    public void init() {

        plotas = new ArrayList();
        g = this.getGraphics();
        plota = new Plota((this.size().width / 2) - 25, (this.size().height / 2) - 25, 50, 1);

    }

    public void start() {
        if (t == null) {

            t = new Thread(this);
            t.start();
        }

    }

    public void stop() {
        if (t != null) {
            t.stop();
            t = null;
        }

    }

    public void paint(Graphics g) {
        
        try {
            g.drawString("Crea una pelota con un click Elige una pelota y puedes cambiar el tamaño con (F y D) y la velocidad con (S y A)", 0, 10);
            for (int i = 0; i < plotas.size(); i++) {
                Plota p = (Plota) plotas.get(i);
                g.setColor(Color.CYAN);
                g.fillOval(p.x, p.y, p.wh, p.wh);
            }
        } catch (Exception e) {
        }

    }

    public void run() {

        while (true) {

            for (int i = 0; i < plotas.size(); i++) {
                Plota p = (Plota) plotas.get(i);
                p.muve(this.size().width, this.size().height);
               
            }

            plota.muve(this.size().width, this.size().height);

            try {
                t.sleep(10);
                repaint();
            } catch (Exception e) {
            }

        }
    }

    void select(int x, int y) {
        boolean test = false;
        for (int i = 0; i < plotas.size(); i++) {

            Plota p = (Plota) plotas.get(i);
            if (x >= p.x && x <= p.x + p.wh && y >= p.y && y <= p.y + p.wh) {
                plota = p;
                test = true;
            }
        }
        if (test == false) {
            Plota newPlota = new Plota(x - 25, y - 25, 50, 2);
            plotas.add(newPlota);
        }
    }

    public boolean mouseDown(Event e, int x, int y) {
        select(x, y);
        repaint();
        return true;
    }

    public boolean keyDown(Event e, int key) {
        System.out.println(key);
        switch (key) {
            case 1004:

                if (plota.y >= 0) {
                    plota.y = plota.y - plota.ss;
                }
                break;
            case 1005:
                if (plota.y + plota.wh <= this.size().height) {
                    plota.y = plota.y + plota.ss;
                }
                break;
            case 1006:
                if (plota.x >= 0) {
                    plota.x = plota.x - plota.ss;
                }
                break;
            case 1007:
                if (plota.x + plota.wh <= this.size().width) {
                    plota.x = plota.x + plota.ss;
                }
                break;
            case 115:
                plota.ss += 10;
                break;
            case 97:
                plota.ss -= 10;
                break;
            case 100:
                plota.wh += 10;
                break;
            case 102:
                plota.wh -= 10;
                break;

        }
        repaint();
        return true;
    }

}

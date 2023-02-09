
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
public class Tenis extends Applet implements Runnable {
    Graphics g;
    Plota plota;
    Raketa raketa;
    
    Thread t;
    class Plota {
        int w;
        int h;
        int x;
        int y;
        float sx;
        float sy;
        float ss;
        float jazebe = 0.05F;
        Color color;

        public Plota(int w, int h, int x, int y, float sx, float sy, float ss, Color color) {
            this.w = w;
            this.h = h;
            this.x = x;
            this.y = y;
            this.sx = sx;
            this.sy = sy;
            this.ss = ss;
            this.color = color;
        }
        void draw() {
            g.setColor(this.color);
            g.fillOval(this.x,this.y,this.w, this.h);
        }
        void update(int w,int h) {
            if(this.x  <= raketa.x+raketa.w && this.y + this.h >= raketa.y && this.y <= raketa.y+raketa.h) {
                
                this.sx = this.ss;
            }
            if(this.x + this.w >= w) {
                this.sx = -this.ss;
            }
            if(this.y <= 0) {
                this.sy = this.ss;
            }
            if(this.y  >= h) {
                this.sy = -this.ss;
            }
            if(this.y < raketa.y +(raketa.h/2) && this.x  <= raketa.x+raketa.w ) {
                this.sy = ((this.y+(this.h/2))-(raketa.y +(raketa.h/2)))/30;
            }
            if(this.y > raketa.y +(raketa.h/2) && this.x  <= raketa.x+raketa.w) {
                this.sy = ((this.y+(this.h/2))-(raketa.y +(raketa.h/2)))/30;
            }
            
            this.x += this.sx;
            this.y += this.sy;
            
        }
       
    }
    class Raketa {
        int w;
        int h;
        int x;
        int y;
        int sx;
        int ss;
        Color color;

        public Raketa(int w, int h, int x, int y, int sx, int ss, Color color) {
            this.w = w;
            this.h = h;
            this.x = x;
            this.y = y;
            this.sx = sx;
            this.ss = ss;
            this.color = color;
        }
        
        void draw() {
            g.setColor(this.color);
            g.fillRect(this.x,this.y, this.w, this.h);
        }
        void update() {
            
        }
        
        
    }
    
    
    
    
    public void init() {
        g = getGraphics();
        plota = new Plota(50, 50, (this.size().width/2)-25,(this.size().height/2)-25 , 2.0F, 0F, 2F, Color.RED);
        raketa = new Raketa(20, 100, 20, (this.size().height/2)-50, 5, 5, Color.BLUE);
    }
    
    public void paint(Graphics g) {
        
    }

    public void start() {
        if(t == null){
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

    public void run() {
        while (true) {
            g.clearRect(0,0,this.size().width,this.size().height);
            plota.draw();
            plota.update(this.size().width,this.size().height);
            
            raketa.draw();
            
            
            
            try {
                t.sleep(10);
                
            } catch (Exception e) {
            }
            
        }
    }
    
    public boolean keyDown(Event e,int key) {
        System.out.println(key);
        if(key == 1004 && raketa.y > 0 ) {
            raketa.y -= raketa.ss;
        }
        if(key == 1005 && raketa.y+raketa.h < this.size().height) {
            raketa.y += raketa.ss;
        }
        return true;
    }
}

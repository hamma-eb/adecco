
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
public class MiAplet extends Applet{
    String paises[] = {"españa","iran","ingiltera","turkia"};
    public void init() {
        this.setBackground(Color.yellow);

    }
    public void paint(Graphics g) {
        g.setFont(new Font("Arial",Font.BOLD,22));
        for (int i = 0; i < paises.length; i++) {
            g.drawString(paises[i], 10, (i+1)*20);
        }
        g.drawLine(0,0, 100, 0);
        g.drawLine(100,0, 100, 100);
        g.drawLine(100,100, 0, 100);
        g.drawLine(0,0, 100, 0);
        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 200, 100);
        g.fillRect(300, 0, 100, 100);
        g.drawOval(400, 30, 100, 100);
        g.fillOval(500, 300, 50, 50);
        g.drawRoundRect(0, 400, 100, 100, 20, 20);
        g.fillArc(200, 200, 100, 100, 0, 90);
        
    }
    
}


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
public class Pintar extends Applet{
    Button borrar;
    Button asul;
    Button rojo;
    Color color;
    Label lTabano;
    Choice lista;
    Graphics G;
    
    int tabanos[] = {10,20,30};
    
    
    public void init() {
        G = this.getGraphics();
        borrar = new Button("Borra");
        asul = new Button("asul");
        rojo = new Button("rojo");
        color = Color.BLUE;
        lTabano = new Label("tabaño: "+tabanos[0]+"");
        lista = new Choice();
        asul.setBounds(0, 0, 500, 200);
        lista.add(""+tabanos[0]+"");
        lista.add(""+tabanos[1]+"");
        lista.add(""+tabanos[2]+"");
        this.add(borrar);
        this.add(asul);
        this.add(rojo);
        this.add(lTabano);
        this.add(lista);
        
        
    }
    
    void pintar(int x,int y) {
        int w = Integer.parseInt(lista.getSelectedItem());
        G.setColor(color);
        G.fillOval(x-(w/2), y-(w/2),w , w);
    }
    
    public boolean action(Event e,Object obj) {
        if(obj.equals("asul")) {
            color = Color.BLUE;
        }else {
            color = Color.RED;
        }
        if(obj.equals(obj)) {
            lTabano.setText("tabaño: "+lista.getSelectedItem());
        }
        if(obj.equals("Borra")) {

            G.clearRect(0, 0, this.size().width, this.size().height);
        }
        return true;
    }
    
    public boolean mouseDrag(Event e,int x,int y) {
        pintar(x, y);
        return true;
    }
}

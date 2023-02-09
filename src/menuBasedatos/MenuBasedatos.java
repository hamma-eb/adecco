package menuBasedatos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tarde
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

public class MenuBasedatos extends Frame implements ActionListener {
    
    static Connection con = null;
    static Statement st = null;
    MenuBar mbarra;
    Menu m1, m2, m3, m4;
    MenuItem m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m41, m42;
    Label stado;
    TextArea ta;

    MenuBasedatos() {
        
        
        this.setTitle("pasedatos");
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        stado = new Label("Estado:                                ");
        stado.setBackground(Color.yellow);
        this.add("South", stado);
        ta = new TextArea();
        this.add(ta);
        mbarra = new MenuBar();
        m1 = new Menu("BD");
        m2 = new Menu("sententias");
        m3 = new Menu("Precompilados");
        m4 = new Menu("Transacciones");

        m11 = new MenuItem("Cargar DRV");
        m12 = new MenuItem("Conectar");
        m12.enable(false);
        m13 = new MenuItem("Desconnectar");
        m13.enable(false);
        m14 = new MenuItem("salir");

        m21 = new MenuItem("ALTA");
        m21.enable(false);
        m22 = new MenuItem("BAJA");
        m23 = new MenuItem("MODIFICACION");
        m24 = new MenuItem("CONSULTAR TABLA");

        m31 = new MenuItem("BUSCADOR");
        m31.enable(false);

        m41 = new MenuItem("INSETAR");
        m42 = new MenuItem("COMITAR");

        m11.addActionListener(this);
        m12.addActionListener(this);
        m13.addActionListener(this);
        m14.addActionListener(this);
        m21.addActionListener(this);
        m22.addActionListener(this);
        m23.addActionListener(this);
        m24.addActionListener(this);
        m31.addActionListener(this);
        m41.addActionListener(this);
        m42.addActionListener(this);

        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.addSeparator();
        m1.add(m14);

        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m2.add(m24);

        m3.add(m31);
        m4.add(m41);
        m4.add(m42);

        mbarra.add(m1);
        mbarra.add(m2);
        mbarra.add(m3);
        mbarra.add(m4);

        this.setMenuBar(mbarra);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuBasedatos();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == m11) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver cargado");
                stado.setText("Estado : " + m11.getLabel() + " : Driver cargado");
                m12.enable(true);
            } catch (ClassNotFoundException cne) {
                System.out.println("Driver no cargado" + cne.getMessage());
                stado.setText("Estado : " + m11.getLabel() + " Driver no cargado");
            }

        }
        if (e.getSource() == m12) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/almacen", "root", "");
                System.out.println("conectados a almacen");
                stado.setText("Estado : " + m12.getLabel() + " : conectados a almacen");
                m13.enable(true);
                m21.enable(true);
                m31.enable(true);
            } catch (SQLException sqe) {
                System.out.println("no se puede conectar a almacen");
                stado.setText("Estado : " + m12.getLabel() + " : no se puede conectar a almacen");
            }
            System.out.println(con);

            stado.setText("Estado : " + m12.getLabel());
        }
        if (e.getSource() == m13) {
            try {
                con.close();
                System.out.println("discanectados a almacen");
                stado.setText("Estado : " + m13.getLabel() + " : discanectados a almacen");
            } catch (SQLException sqe) {
                System.out.println("no se pudo dosconectar a almacen lisiento mucho chaval");
                stado.setText("Estado : " + m13.getLabel() + " : no se pudo dosconectar a almacen lisiento mucho chaval");
            }
            stado.setText("Estado : " + m13.getLabel());
        }
        if (e.getSource() == m14) {
            stado.setText("Estado : " + m14.getLabel());
        }
        if (e.getSource() == m21) {
            new Coche().setVisible(true);
            stado.setText("Estado : " + m21.getLabel());
        }
        if (e.getSource() == m22) {
            stado.setText("Estado : " + m22.getLabel());
        }
        if (e.getSource() == m23) {
            stado.setText("Estado : " + m23.getLabel());
        }
        if (e.getSource() == m24) {
            try {
                //Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/almacen", "root", "");
                ResultSet rs = null;
                String sql3 = "select * from coches";
                st = con.createStatement();
                rs = st.executeQuery(sql3);
                while (rs.next()) {
                    ta.append(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + Integer.parseInt(rs.getString(4)));
                }
            } catch (SQLException sqe) {
            }
            stado.setText("Estado : " + m24.getLabel());
        }
        if (e.getSource() == m31) {

            new CocheBuscador().setVisible(true);
            stado.setText("Estado : " + m31.getLabel());
        }
        if (e.getSource() == m41) {
            try {
                con.rollback();
                new Coche().setVisible(true);
            } catch (SQLException sqe) {
                
            }
            stado.setText("Estado : " + m41.getLabel());
        }
        if (e.getSource() == m42) {
            try {
                con.commit();
            } catch (SQLException sqe) {
                
            }
            stado.setText("Estado : " + m42.getLabel());
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import static java.lang.Class.forName;
import java.sql.*;

/**
 *
 * @author tarde
 */
public class BaseDatosRef {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver cargado");
        } catch (Exception e) {
            System.out.println("Driver no cargado" + e.getMessage());
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/almacen", "root", "");
            System.out.println("conectados a almacen");
        } catch (SQLException sqe) {
            System.out.println("no se puede conectar a almacen");
        }

        String sql1 = "insert into productos values ('090-J','cafeteria termica',33,2.34)";
        String sql2 = "delete from productos where canfidad = 33";
        try {
            st = con.createStatement();
            int n = st.executeUpdate(sql2);
            System.out.println("" + n);
            if (n == 1) {
                System.out.println("registro borrado");
            } else if (n == -1) {
                System.out.println("registros borrados");
            } else {
                System.out.println("registro no borrado");
            }
        } catch (SQLException sqe) {
            System.out.println("Nooo!");
        }
         /**
         * ***************************************
         */
         try {
            con.setAutoCommit(false);
            
        } catch (SQLException ex) {
            
        }
         
         
         String sql4 = "insert into productos values (?,?,?,?)";
         PreparedStatement pst;
         try {
            pst =con.prepareStatement(sql4);
            pst.setString(1, "001-Z");
            pst.setString(2, "camera");
            pst.setInt(3, 44);
            pst.setFloat(4, 200.50F);
            pst.executeUpdate();
            con.commit();
             System.out.println("nivel de aislamiento "+ con.getTransactionIsolation());
        } catch (SQLException sqe) {
            System.out.println("pst no");
        }
        
         
         
        try {
            ResultSet rs = null;
            String sql3 = "select * from coches";
            st = con.createStatement();
            rs = st.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
            }
        } catch (SQLException sqe) {
            
        }

        try {
            con.close();
            System.out.println("discanectados a almacen");
        } catch (SQLException e) {
            System.out.println("no se pudo dosconectar a almacen lisiento mucho chaval");
        }

       

    }
}

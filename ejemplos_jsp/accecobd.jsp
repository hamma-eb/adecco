<html>
    
<body>
    <style>
        *{
            margin: 10px;
        }
         div {
            display: flex;
            flex-direction: row;
        }
    </style>
    <%@ page import= "java.sql.*" %>
    <%@ page errorPage="./error.html" %>
    <%@ page contentType="text/html"%>
    <%@ page pageEncoding= "UTF-8" %>
    
    <%
        Connection con = null;
        Statement st = null;
    %> 
    <%
        try {
            Class.forName("com.mysql.jdbc.Driver");
            %><h1>driver cargado</h1><%
        } catch (Exception e) {
            %><h1>driver no cargado</h1><%
        }
    %>
    <%
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mundial_catar", "root", "");
            %><h1>msql conectado</h1><%
        } catch (SQLException sqe) {
            %><h1>msql no ha conectado</h1><%
        }

         try {
            ResultSet rs = null;
            String sql = "select * from peores_e";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                %>
                <div>
                    <h1><%= rs.getString(2) %></h1>
                    <h1><%= rs.getString(3) %></h1>
                    <h3><%= rs.getString(4) %></h3>
                    <h3><%= rs.getString(5) %></h3>
                    <h3><%= rs.getString(6) %></h3>
                    <h3><%= rs.getString(7) %></h3>
                     <img src="<%= rs.getString(8) %>" alt="">
                </div>
                <%
            }
        } catch (SQLException sqe) {
            
        }
    %>

    

   
</body>
</html>
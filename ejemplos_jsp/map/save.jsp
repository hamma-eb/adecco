<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%@ page import= "java.sql.*" %>

<%
    String x = request.getParameter("x");
    String y = request.getParameter("y");
    String sexo = request.getParameter("bandera");
    String tipodequeja = request.getParameter("ganados");
    String descripcion = request.getParameter("jugados");
    

        Connection con = null;
        Statement st = null;
   
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
        } catch (Exception e) {
           
        }
   
   
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mundial_catar", "root", "");
           
        } catch (SQLException sqe) {
           
        }

         String sql = "insert into peores_e(nombre,seleccion,pjugados,pganados,pperdidos,ppempatados,bandera) values ('"+nombre+"','"+bandera+"',"+Integer.parseInt(jugados)+","+Integer.parseInt(ganados)+","+Integer.parseInt(perdidos)+","+Integer.parseInt(empatados)+",'"+bandera+"')";
        
          try {
            st = con.createStatement();
            
            int n = st.executeUpdate(sql);
            %><a href="./index.html" id="a"></a>
<script>
    document.getElementById("a").click();
</script></h1><%
            
            if (n == 1) {
               
            } else if (n == -1) {
               
            } else {
               
            }
        } catch (SQLException sqe) {
            
            
        }
%>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <style>
        * {
            margin: 0;
            padding: 0;
        }
        body {
            display: flex;
            
        }
        .map1 {
            margin: 100px auto;
       
        }
    </style>
</head>
<body>
    <%@ page import= "java.sql.*" %>
    <a href="./map.jsp" id="a"></a>
<%
    String name = "test";
   
    
    
    
   
        Connection con = null;
        Statement st = null;
   
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
        } catch (Exception e) {
           
        }
   
   
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost/"+name+"", "root", "");
           
        } catch (SQLException sqe) {
           
        }

         String sql = "CREATE TABLE `"+name+"`.`distritos` (`codigo` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(100) NOT NULL , PRIMARY KEY (`codigo`)) ENGINE = InnoDB;";
        String sql1 = "CREATE TABLE `"+name+"`.`t_quejas` (`codigo` INT NOT NULL , `sexo` VARCHAR(1) NOT NULL , `tipo` VARCHAR(20) NOT NULL , `descripcion` VARCHAR(300) NOT NULL , `x` INT NOT NULL , `y` INT NOT NULL ) ENGINE = InnoDB;";
          try {
            st = con.createStatement();
            
            int n1 = st.executeUpdate(sql);
            int n2 = st.executeUpdate(sql1);
            %><a href="./index.html" id="a"></a>
            <script>
                document.getElementById("a").click();
            </script></h1><%
            
         
        } catch (SQLException sqe) {
            
            
        }
%>
    
   
</body>
</html>
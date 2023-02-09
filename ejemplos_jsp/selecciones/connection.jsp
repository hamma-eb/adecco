<%@ page import= "java.sql.*" %>

<%
    String nombre = request.getParameter("nombre");
    String seleccion = request.getParameter("seleccion");
    String bandera = request.getParameter("bandera");
    String ganados = request.getParameter("ganados");
    String jugados = request.getParameter("jugados");
    String perdidos = request.getParameter("perdidos");
    String empatados = request.getParameter("empatados");
    
    
    
   
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
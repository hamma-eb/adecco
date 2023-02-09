<html>

<body>
    <%@ include file = "./html.html" %>
    <% 
        
        //@page 
        String dni = request.getParameter("dni");
        if(dni == null) {
           
        }else {
             out.write("<h1>"+ dni + "</h1>");
        }
        
    %>

</body>

</html>
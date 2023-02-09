<html>
<head>
</head>
<%@page import="java.util.*"%>
<% 
Vector v=(Vector)application.getAttribute("opinion"); 

v.addElement(session.getAttribute("nombre")
+"> "+request.getParameter("opinion"));
    
%>
<body bgcolor="navy" text="steelblue">
<form action="chat_abajo.jsp" method="post">
<h2> teclee su opinion:</h2><br>
<input type="text" size="30" name="opinion"><br>
<input type="submit" value="Enviar">
</form>
</body>
</html>


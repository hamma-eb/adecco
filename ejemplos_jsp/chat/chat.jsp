<html>
<head>
</head>
<%@ page import="java.util.*" %>

<% 	
	Vector v=new Vector();

session.putValue("nombre",request.getParameter("nombre")); 
application.setAttribute("opinion",v); 
%>
<frameset rows="60%,*">
    <frame src="chat_arriba.jsp">
    <frame src="chat_abajo.jsp">
</frameset>
</html>    
<html>
<head>
</head>
<META HTTP-EQUIV="REFRESH" CONTENT="5">
<%@ page import="java.util.*" %>
<% 
	Vector v=(Vector)application.getAttribute("opinion");
	for(int i=0;i<v.size();i++)
	{
		out.write("<font color=\"orange\"   size=\"+2\"  >"
			+"  "+(String)v.elementAt(i)
			+"<br>");
	}
	%>
<br>
<body bgcolor="steelblue" >
</body>
</html>


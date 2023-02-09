<%
String backcolor = "";
String fontcolor = ""; 
Cookie cc[] =request.getCookies();
StringBuffer st = new StringBuffer(); 
for(int i = 0;i<cc.length;i++) {
    
    if(cc[i].getName().equals("backcolor") ) {
        backcolor = cc[i].getValue();
        
    }
    if(cc[i].getName().equals("fontcolor")) {
        fontcolor = cc[i].getValue();
    }
}




        //out.write(st.toString());
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <style>
        *{
            color: <%= fontcolor %>;
        }
    </style>
</head>
<body bgcolor="<%= backcolor %>" >
    
    
    <% String name = (String)session.getAttribute("nombre"); %>

    
    <h1>hola buenas dias <%= name %></h1>

    
   
</body>
</html>
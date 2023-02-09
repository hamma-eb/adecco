<html>
<body>
    <h1>sesion creada</h1>
    <% session.setAttribute("nombre","sina"); %>

    <% Cookie c = new Cookie("backcolor","red");
    Cookie c1 = new Cookie("fontcolor","blue");
    response.addCookie(c);
    response.addCookie(c1);
    out.write("cookie guardado");
    %>
</body>
</html>
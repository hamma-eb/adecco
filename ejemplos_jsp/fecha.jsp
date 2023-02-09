
<html lang="en">
<body>
    <%= new java.util.Date() %>
    
    <% 
        int sina = 27;
        String[] names = {"sina","hamma","farshad"};
        
        
    %>
    <h1><%= sina %></h1>

    <% for(int i = 0 ; i < 3 ; i++) { %>
      <h1> <%= names[i] %> </h1>
    <% } %>

     <% for(int i = 0 ; i < 3 ; i++) { 
      out.write("<h1>"+ names[i] + "</h1>");  
    
    } %>

    <%! 
        int visitas = 0;
        
    %>
    <% visitas ++; %>
    <h1><%= visitas %></h1>
</body>
</html>

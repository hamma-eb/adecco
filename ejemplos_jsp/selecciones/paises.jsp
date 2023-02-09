
<html>
     <style>
        * {
            margin: 0;
            padding: 0;

        }
        body {
            background-color: rgb(128, 180, 180);
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h1 {
            background-color: aquamarine;
            border-radius: 5px;
            padding: 5px;
            margin: 10px;
            text-align: center; 
        }
        select {
            margin: 10px;
            width: 300px;
            height: 50px;
            color: aliceblue;
            background-color: burlywood;
        }
        img {
            width: 200px;
            height: 200px;
            border-radius: 100px;
            object-fit: cover;
        }
        div {
            display: flex;
             flex-direction: column;
            align-items: center;
        }
    </style>
<body>
   

     <%@ page import= "java.sql.*" %>
     <%@ page errorPage="./error.html" %>
    <%@ page contentType="text/html"%>
    <%@ page pageEncoding= "UTF-8" %>
    
    <script>
        const paises = [];
        function Pais(data = {}) {
            this.data = data;
            this.paszamine = document.createElement("div");
            this.paszamine.className = "paszamine";
            this.nombre = document.createElement("h1");
            this.nombre.innerHTML = " Nombre :"+this.data.nombre;
            this.seleccion = document.createElement("h1");
            this.seleccion.innerHTML = " Seleccion :"+this.data.seleccion;
            this.jugados = document.createElement("h1");
            this.jugados.innerHTML = " Jugados :"+ this.data.jugados;
            this.ganados = document.createElement("h1");
            this.ganados.innerHTML = " Ganados :"+this.data.ganados;
            this.perdidos = document.createElement("h1");
            this.perdidos.innerHTML =" Perdidos :"+ this.data.perdidos;
            this.empatados = document.createElement("h1");
            this.empatados.innerHTML = " Empatados :"+this.data.empatados;
            this.bandera = document.createElement("img");
            this.bandera.src = "../images/"+this.data.bandera+".png";
            this.paszamine.appendChild(this.nombre);
            this.paszamine.appendChild(this.seleccion);
            this.paszamine.appendChild(this.jugados);
            this.paszamine.appendChild(this.ganados);
            this.paszamine.appendChild(this.perdidos);
            this.paszamine.appendChild(this.empatados);
            this.paszamine.appendChild(this.bandera);
            document.getElementById("root").innerHTML = "";
            document.getElementById("root").appendChild(this.paszamine);
        }
    </script>
    <%
        Connection con = null;
        Statement st = null;
    %> 
    <%
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
        } catch (Exception e) {
            
        }
   
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mundial_catar", "root", "");
           
        } catch (SQLException sqe) {
            
        }

         try {
            ResultSet rs = null;
            String sql = "select * from peores_e";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            %>
                <select name="" id="paises">
            
                <%
            while (rs.next()) {
                %>
                <script>
                    paises.push({nombre:"<%=rs.getString(2)%>",seleccion:"<%= rs.getString(3)%>",jugados:"<%= rs.getString(4) %>",ganados:"<%= rs.getString(5) %>",perdidos:"<%= rs.getString(6) %>",empatados:"<%= rs.getString(7) %>",bandera:"<%= rs.getString(8) %>"});
                </script>
                <option value="<%= rs.getString(2) %>"><%= rs.getString(2) %></option>
       
                <%
            }
            %> </select> <%
        } catch (SQLException sqe) {
            
        }
    %>
    <div id="root"></div>
     <script>
         const select = document.getElementById("paises");
        select.addEventListener("change",(e)=> {
            paises.forEach(e_ => {
                if(e.target.value == e_.nombre ) {
                    new Pais(e_);
                }
            })
        })
    </script>

</body>
</html>
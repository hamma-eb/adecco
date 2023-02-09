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
        #root {
            margin: 0 auto;
        }
        .map1 {
            margin: 100px auto;
           
       
        }
         .t_punto {
            width: 5px;
            height: 5px;
            border-radius: 5px;
            background-color: brown;
            position: absolute;
        }
         .form {
           
            display: flex;
            flex-direction: column;
            align-items: center;
           
        }
        .form input {
            width: 200px;
            height: 30px;
            margin: 10px;
        }
        .form select {
            width: 200px;
            height: 30px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <div id="root">

    </div>
    
   

     <script>
        const root = document.getElementById("root");
        let mapSelect = "";
       
       function setAttribute(name,value) {
            let objeto = {
                name:name,
                value:value
            }
            return objeto;  
        }
        function createElement(apend = document.createElement("div"),data = {name:"div",innerhtml:"",class:"",src:"",atribute: [{name:"",value:""}]}) {
           let element = document.createElement(data.name);
           data.innerhtml ? element.innerHTML = data.innerhtml : null;
           data.class ? element.className = data.class : null;           
           data.src ? element.src = data.src : null;           
           data.atribute ? data.atribute.forEach(e => {
                element.setAttribute(e.name,e.value);
           }) : null;
           apend ? apend.appendChild(element) : null;   
           return element;    
        }
        function setMap(name) {
            
            if(name == "arganzuela" || name == "retiro" || name == "moncloa" || name == "salamanca") {
                mapSelect = name;
                root.innerHTML = "";
                console.log(root);
                new Map2();
            }
            if(name == "realizar") {

            }
            if(name == "marcar") {
                root.innerHTML = "";
                new Marcar(mapSelect);
            }
            

        }  
        function setPunto(x,y) {
            root.innerHTML = "";
            new Formulario(x,y);

        } 
        function Map1() {
            this.img = createElement(root,{name:"img",src:"./img/mapadistritos2.gif",class:"map1",atribute:[setAttribute("usemap","#image-map")]});
            this.map = createElement(root,{name:"map",atribute:[setAttribute("name","image-map")]});
            this.area1 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","64,358,92,367,138,379,167,396,185,415,208,436,232,455,247,456,276,445,294,433,306,417,312,391,316,371,294,348,278,322,266,304,235,295,217,305,195,307,170,302,150,287,123,283,96,288,73,312,68,334,65,345"),setAttribute("shape","poly")]});
            this.area2 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","331,348,346,344,354,331,361,315,367,302,382,287,394,272,401,258,396,247,395,230,361,231,339,229,321,220,298,214,272,200,259,184,226,170,232,197,236,223,239,249,234,273,222,288,220,295,234,294,254,297,267,304,279,324,290,340,300,353,312,364,318,366"),setAttribute("shape","poly")]});
            this.area3 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","97,282,96,266,81,252,66,240,56,230,53,221,50,208,59,198,74,189,88,178,98,168,105,153,102,135,100,116,98,102,96,92,109,93,125,98,142,105,154,110,161,119,177,122,194,130,217,142,222,156,226,178,231,204,235,229,236,249,233,263,227,277,220,289,215,298,202,303,184,301,168,293,157,285,141,279,116,277"),setAttribute("shape","poly")]});
            this.area4 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","223,144,238,144,250,135,259,121,265,103,266,80,276,68,295,73,309,80,327,78,349,71,372,54,391,41,401,39,408,57,409,81,410,98,404,108,402,127,401,151,398,163,398,183,398,197,389,210,393,223,374,227,352,227,334,223,315,215,295,209,273,195,252,177,229,168"),setAttribute("shape","poly")]});
            this.area1.addEventListener("click",()=> {
                setMap("arganzuela")
            })
            this.area2.addEventListener("click",()=> {
                setMap("retiro")
            })
            this.area3.addEventListener("click",()=> {
                setMap("moncloa")
            })
            this.area4.addEventListener("click",()=> {
                setMap("salamanca")
            })
            
        }
         function Map2() {
            this.img = createElement(root,{name:"img",src:"./img/consultasymarcar.jpg",class:"map1",atribute:[setAttribute("usemap","#image-map1")]});
            this.map = createElement(root,{name:"map",atribute:[setAttribute("name","image-map1")]});
            this.area1 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","286,28,382,46,457,89,482,138,448,202,391,234,283,258,212,256,206,211,220,164,252,120,279,66,284,46"),setAttribute("shape","poly")]});
            this.area2 = createElement(this.map,{name:"area",atribute:[setAttribute("coords","180,252,97,228,44,196,20,152,37,97,97,56,178,32,242,26,282,27,276,66,246,117,220,154,202,204,208,255"),setAttribute("shape","poly")]});
            this.area1.addEventListener("click",()=> {
                setMap("realizar");
            })
            this.area2.addEventListener("click",()=> {
                setMap("marcar");
            })
        }
          

        function Marcar(name) {
            this.image = createElement(root,{name:"img",src:"./img/"+name+".jpg",class:"map1"});
            
            this.image.addEventListener("click",(e)=> {
                let pos = this.image.getBoundingClientRect();
                let x = e.pageX - pos.left;
                let y = e.pageY - pos.top;
                let punto = createElement(root,{name:"div",class:"t_punto"});
                punto.style.left = e.pageX - 2.5 + "px";
                punto.style.top = e.pageY - 2.5 + "px";
                alert("Estas seguro??");
                setPunto(x,y);
            })
        }
         function Formulario(x,y) {
            this.form = createElement(root,{name:"form",class:"form",atribute:[setAttribute("action","./save.jsp")]});
            this.x = createElement(this.form,{name:"input",atribute:[setAttribute("name","x"),setAttribute("value",x),setAttribute("type","hidden")]});
            this.y = createElement(this.form,{name:"input",atribute:[setAttribute("name","y"),setAttribute("value",y),setAttribute("type","hidden")]});
            //this.sexoL = createElement(this.form,{name:"label",innerhtml:"Sexo:",atribute:[setAttribute("for","sexo")]});
            this.sexoS = createElement(this.form,{name:"select",atribute:[setAttribute("name","sexo"),setAttribute("id","sexo")]});
            this.sexoO1 = createElement(this.sexoS,{name:"option",innerhtml:"Masculino",atribute:[setAttribute("value","m")]});
            this.sexoO2 = createElement(this.sexoS,{name:"option",innerhtml:"Femenino",atribute:[setAttribute("value","f")]});
            //this.tqL = createElement(this.form,{name:"label",innerhtml:"Tipo de queja:",atribute:[setAttribute("for","tipodequeja")]});
            this.tqS = createElement(this.form,{name:"select",atribute:[setAttribute("name","tipodequeja"),setAttribute("id","tipodequeja")]});
            this.tqO1 = createElement(this.tqS,{name:"option",innerhtml:"Ambiental",atribute:[setAttribute("value","ambiental")]});
            this.tqO2 = createElement(this.tqS,{name:"option",innerhtml:"Social",atribute:[setAttribute("value","social")]});
            this.tqO2 = createElement(this.tqS,{name:"option",innerhtml:"Confilictiva",atribute:[setAttribute("value","confilictiva")]});
            this.text = createElement(this.form,{name:"textarea",atribute:[setAttribute("cols","30"),setAttribute("rows","10"),setAttribute("name","descripcion")]});
            this.submit = createElement(this.form,{name:"input",atribute:[setAttribute("value","Guardar"),setAttribute("type","submit")]});
        }
        new Map1();
    </script>
</body>
</html>
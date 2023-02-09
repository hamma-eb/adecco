<?php
$x = $_GET["x"];
$y = $_GET["y"];


?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            border: 0;
            margin: 0;
            padding: 0;
        }

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
           
        }
        .paszamine {
            width: 800px;
            height: 1000px;
            height: auto;
            display: flex;
            
        }
        .paszamine h4 {
            position: absolute;
            display: none;
            width: 300px;
            font-size: 20px;
            background-color: white;
            
        }
        .paszamine_d {
            
            display: flex;
            flex-direction: column;
            align-items: center;
            
        }
        .paszamine_d select {
            width: 200px;
            height: 50px;
            font-size: 20px;

        }
        .paszamine_d h4 {
            
            width: 400px;
            font-size: 30px;
            
        }
        .imgDiv {
            position: relative;
            display: grid;
            background-color: gray;

        }
        .imgDiv input {
            position: absolute;
        }
        .imgDiv img {
            width: 100px;
            position: absolute;
           
        }
    </style>
</head>

<body>
    <script>
        let rabetecarbari;

        function CrateElement(data = {
            name: "div",
            inerhtml: undefined,
            id: undefined,
            class: undefined,
            type: undefined,
            value: undefined,
            style: undefined,
            src: undefined,
            atriviuts: [{
                name: undefined,
                value: undefined
            }]
        }) {
            let element = document.createElement(data.name);
            if (data.inerhtml !== undefined) element.innerHTML = data.inerhtml;
            if (data.id !== undefined) element.id = data.id;
            if (data.class !== undefined) element.className = data.class;
            if (data.type !== undefined) element.type = data.type;
            if (data.value !== undefined) element.value = data.value;
            if (data.style !== undefined) element.style.cssText = data.style;
            if (data.src !== undefined) element.src = data.src;
            if (data.atriviuts !== undefined) {
                data.atriviuts.forEach(e => {
                    element.setAttribute(e.name, e.value);
                })
            }
            return element;
        }
        let sitios = [{
                img: "./images/cabaña.png",
                discripcion: "sdflkasd sdlvksndf sdflvnsd vsjdfvns",
            },
            {
                img: "./images/chalet.png",
                discripcion: "sdflkasd sdlvksndf sdflvnsd vsjdfvns",
            },
            {
                img: "./images/Edificio.png",
                discripcion: "sdflkasd sdlvksndf sdflvnsd vsjdfvns",
            }
        ]





        function RabetCarbari() {
            this.body = document.querySelector("body");
            this.paszamine_d = CrateElement({name:"div",class:"paszamine_d"});
            this.select = CrateElement({name:"select",class:"select"});
            for (let index = 0; index < 3; index++) {
                let option = CrateElement({name:"option",value:index,inerhtml:`image: ${index+1}`});
                this.select.appendChild(option);
            }
           
            this.imgD = CrateElement({name:"img"});
            this.discripcion = CrateElement({name:"h4"});
            this.paszamine = CrateElement({name:"div",class:"paszamine"});
            this.imgDiv = CrateElement({
                name: "div",
                class: "imgDiv"
            });
            this.imgInput = CrateElement({
                name: "input",
                type: "image",
                src: localStorage.getItem("image")
            });
            this.imgMap = CrateElement({
                name: "img",
                
            });
            this.discripcion_m = CrateElement({name:"h4"})
            this.Crate();
            this.select.addEventListener("change",()=> {
                this.imgMapPosition(Number(this.select.value));
            })
            this.imgInput.addEventListener("mousemove",()=> {
                this.discripcion_m.style.display = "none";
            })
            this.imgMap.addEventListener("mousemove",()=> {
                this.discripcion_m.style.display = "block";
            })

        }
        RabetCarbari.prototype.Crate = function() {
            this.imgDiv.appendChild(this.imgInput);
            this.imgDiv.appendChild(this.imgMap);
            this.imgDiv.appendChild(this.discripcion_m);
            this.paszamine.appendChild(this.imgDiv);
            this.paszamine_d.appendChild(this.select);
            this.paszamine_d.appendChild(this.imgD);
            this.paszamine_d.appendChild(this.discripcion);
            this.body.appendChild(this.paszamine_d);
            this.body.appendChild(this.paszamine);
        }
        RabetCarbari.prototype.imgMapPosition = function(no) {
            let x = <?php echo $x; ?>;
            let y = <?php echo $y; ?>;
            this.imgD.src = sitios[no].img;
            this.discripcion.innerHTML = sitios[no].discripcion;
            this.imgMap.src = sitios[no].img;
            this.discripcion_m.innerHTML = sitios[no].discripcion;
            let imgP = this.imgMap.getBoundingClientRect();
            this.imgMap.style.cssText = `margin-left: ${x-(imgP.width/2)}px;margin-top:${y-(imgP.height/2)}px`;
            this.discripcion_m.style.cssText = `margin-left: ${x}px;margin-top:${y}px`;

        }
        RabetCarbari.prototype.imgDiscripsionP = function() {

        }
        rabetecarbari = new RabetCarbari();
    </script>
</body>

</html>
function Fichas(no ,p = 1) {
    this.p = p;
    this.paszamine = document.createElement("div");
    this.paszamine.className = "fichas";
    this.img = document.createElement("img");
    this.img.src = "./images/fichas.png";
    this.h3 = document.createElement("h3");
    this.h3.innerHTML = no;

    this.paszamine.appendChild(this.img);
    this.paszamine.appendChild(this.h3);

    document.querySelector("body").appendChild(this.paszamine);

    this.paszamine.style.cssText = `transition: all 1s;left: 10px;top:0`;

    this.muve();
}
Fichas.prototype.muve = function() {
    let timer = setTimeout(timer_ , 200);
    let paszamine = this.paszamine;
    let p = this.p;
    if (p == 2) {
        paszamine.style.cssText += `left: 2000px;top:100px`;
    }
    function timer_() {
        if (p == 1) {
            paszamine.style.cssText += `left: 550px;top:100px`;
        }else {
            paszamine.style.cssText += `left: 950px;top:100px`;
        }
    }
}


function getMessage1(cart = 0, cartas_ = []) {
    console.log(cart,cartas);
    let sum = 0;
    cartas_.forEach(e => {
        sum += e;

    })

    if (cart + sum == 21) {
        let timer = setTimeout(timer_,700);
        
        
        puntos += punto;
        puntos_h3.innerHTML = `puntos: ${puntos}`;
        
        fichas.forEach(e => {
            e.paszamine.style.cssText = `transition: all 1s ;left: 10px;top:0`;
        })
        function timer_() {
            alert("felicidades");
            cartas = [];
            background.innerHTML = "";
            fichas.forEach(e => {
                e.paszamine.remove();
            })
            fichas = [];
            bancodeFichas += punto;
            localStorage.setItem("fichas",bancodeFichas);
            no_fichas.innerHTML = bancodeFichas;
            button.value = "Empieza jugar con 10 Fichas";
        }
    }
    if(cart+ sum !== 21 && sum + cart < 21) {
        cartas.push(cart);
       
        
    }
    if(sum + cart > 21) {
        let timer = setTimeout(timer_,500);
        if (puntos > 0) {
            puntos -= punto/2;
            puntos_h3.innerHTML = `puntos: ${puntos}`;
        }
       
        fichas.forEach(e => {
            e.paszamine.style.cssText = `transition: all 1s;left: 2000px;top:0`;
        })
        function timer_() {
            alert("perdiste");
            fichas.forEach(e => {
                e.paszamine.remove();
            })
            fichas = [];
            cartas = [];
            
            background.innerHTML = "";
            button.value = "Empieza jugar con 10 Fichas";
            
        }
    }
}
function getRandomCard() {
    return Math.floor(Math.random() * 11) + 1;
}
let bancodeFichas = localStorage.getItem("fichas") || 100;
let no_fichas = document.getElementById("no_fichas");
no_fichas.innerHTML = bancodeFichas;
let punto = 10;
let puntos_h3 = document.getElementById("puntos");
let puntos = 0;
let button = document.getElementById("button");
let background = document.getElementById("background");
let cart;
let cartas = [];
let fichas = [];
button.addEventListener("click", () => {
    
    if(button.value == "Empieza jugar con 10 Fichas" && bancodeFichas > 0) {
        button.value = "Dame carta";
        fichas.push(new Fichas(punto,1));
        fichas.push(new Fichas(punto,2));
        bancodeFichas -= punto;
        localStorage.setItem("fichas",bancodeFichas);
        no_fichas.innerHTML = bancodeFichas;
    }else{

        let numero = getRandomCard()
        let cart = document.createElement("img");
        cart.src = `./images/g${numero}.png`;
    
        background.appendChild(cart);
        
        getMessage1(numero,cartas);
    }

    if (bancodeFichas <= 0) {
        let comprar = prompt("compra fichas");
    
        bancodeFichas = comprar;
        localStorage.setItem("fichas",bancodeFichas);
        no_fichas.innerHTML = bancodeFichas;
    }

})


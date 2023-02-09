function Yem(canvas,yilan,x,y,w,h,color) {
    this.canvas = canvas;
    this.yilan = yilan;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
}
Yem.prototype.draw = function() {
    this.canvas.ctx.fillStyle = this.color;
    this.canvas.ctx.fillRect(this.x,this.y,this.w,this.h);
}
Yem.prototype.update = function() {
    let sar = this.yilan.badan[this.yilan.badan.length-1] ;
    if(sar.x +sar.w > this.x && sar.y + sar.h > this.y && sar.x < this.x + this.w && sar.y < this.y + this.h) {
        this.yilan.add();
        this.canvas.addYem();
    }
}

function Badan(yilan, x, y, w, h, color) {
    this.yilan = yilan;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
}
Badan.prototype.draw = function () {
    canvas.ctx.fillStyle = this.color;
    canvas.ctx.fillRect(this.x, this.y, this.w, this.h);
}
Badan.prototype.update = function () {

}

function Yilan(canvas, s) {
    this.canvas = canvas;
    this.badan = [];
    this.s = s;
    this.andaze = 6;
    this.key = 38;
    this.crate();
    window.addEventListener("keydown", (e) => {
        console.log(e.keyCode);
        this.key = e.keyCode;
    })
}
Yilan.prototype.crate = function () {
    let x = 200;
    let y = 200;
    for (let index = 0; index < this.andaze; index++) {
        this.badan.push(new Badan(this, x, y, 10, 10));
        y -= 10;
    }
}
Yilan.prototype.draw = function () {
    this.badan.forEach(e => {
        e.draw();
    })
}
Yilan.prototype.update = function () {
    if(this.badan[this.badan.length-1].x < 0) {
        this.badan[this.badan.length-1].x = innerWidth -10;
    }
    if(this.badan[this.badan.length-1].x + 10 >= innerWidth) {
        this.badan[this.badan.length-1].x = 0 ;
    }
    if(this.badan[this.badan.length-1].y < 0) {
        this.badan[this.badan.length-1].y = innerHeight -10;
    }
    if(this.badan[this.badan.length-1].y + 10 > innerHeight) {
        this.badan[this.badan.length-1].y = 0 ;
    }
    if (this.canvas.frame % this.s == 0) {
        switch (this.key) {

            case 38:
                this.badan.splice(0, 1);
                let pos = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos.x, pos.y - 10, 10, 10));
                break;
            case 39:
                this.badan.splice(0, 1);
                let pos1 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos1.x + 10, pos1.y, 10, 10));
                break;
            case 40:
                this.badan.splice(0, 1);
                let pos2 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos2.x, pos2.y + 10, 10, 10));
                break;

            case 37:
                this.badan.splice(0, 1);
                let pos3 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos3.x - 10, pos3.y, 10, 10));
                break;
        }
       
    }
}
Yilan.prototype.add = function () {
    if (this.canvas.frame % this.s == 0) {
        switch (this.key) {
            case 38:  
                let pos = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos.x, pos.y - 10, 10, 10));
                break;
            case 39:
                let pos1 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos1.x + 10, pos1.y, 10, 10));
                break;
            case 40:
                let pos2 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos2.x, pos2.y + 10, 10, 10));
                break;
            case 37:
                let pos3 = this.badan[this.badan.length - 1];
                this.badan.push(new Badan(this, pos3.x - 10, pos3.y, 10, 10));
                break;
        }
      
    }
}



function Canvas() {
    this.body = document.querySelector("body");
    this.canvas = document.createElement("canvas");
    this.ctx;
    this.frame = 0;
    this.yilan = new Yilan(this, 10);
    this.yem = new Yem(this,this.yilan,Math.floor(Math.random()*innerWidth-20)+20,Math.floor(Math.random()*innerHeight-20)+20,15,15);;
}
Canvas.prototype.addYem = function() {
    this.yem.x = Math.floor(Math.random()*innerWidth-20)+20;
    this.yem.y = Math.floor(Math.random()*innerHeight-20)+20,15,15;
}
Canvas.prototype.crate = function () {
    this.body.appendChild(this.canvas);
    this.canvas.width = innerWidth;
    this.canvas.height = innerHeight;
    this.ctx = this.canvas.getContext("2d");

}
Canvas.prototype.draw = function () {
    this.ctx.clearRect(0, 0, innerWidth, innerHeight);
    this.yilan.draw();
    this.yem.draw();
}
Canvas.prototype.update = function () {
    this.frame++;
    this.yilan.update();
    this.yem.update();
}
Canvas.prototype.anim = function () {
    canvas.draw();
    canvas.update();
    requestAnimationFrame(canvas.anim);
   
}


const canvas = new Canvas();
canvas.crate();
canvas.anim();

requestAnimationFrame(canvas.anim);
requestAnimationFrame(canvas.anim);


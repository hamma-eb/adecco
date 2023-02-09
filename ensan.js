import { Cheshm } from "./cheshm.js";

function Ensan(esm,famil,sen) {

    this.esm = esm;
    this.famil = famil;
    this.sen = sen;
    this.cheshm = new Cheshm(this,"zard",20);
    window.addEventListener("click",()=> {
        this.sen++;
        this.alert();
    })
    
}
Ensan.prototype.alert = function(name) {
    console.log(this.cheshm);
}


export {Ensan};
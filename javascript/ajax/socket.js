const socket = io();
socket.emit("text_load");
socket.on("text_load",(text,text2)=> {
    alert(text);
   
})
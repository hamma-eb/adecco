<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

    <?php
    $db = mysqli_connect("localhost","root","","test");
    $select = mysqli_query($db,"SELECT * FROM `user`");
    $select1 = mysqli_fetch_array($select);
   
    $email = $_GET["email"];
    $ciudad = $_GET["ciudades"];
    
    mysqli_query($db,"INSERT INTO user (email,ciudad) VALUES ('$email','$ciudad')");
    echo "<h1>tus datos</h1>";
    echo ("email: ".$_GET["email"]);
    echo "<br>";
    echo "<br>";
    echo ("ciudad: ".$_GET["ciudades"]);

   

    
   
    ?>
</body>
</html>
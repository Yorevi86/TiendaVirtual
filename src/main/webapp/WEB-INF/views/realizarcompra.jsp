<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Awesome tienda</title>
</head>
<body>
    <%
    if (request.getAttribute("mensaje") != null){
    	out.println(request.getAttribute("mensaje"));
    }
    %>
    <br>
    <button type="button" onclick="location.href='index'">Volver a la página principal</button>
</body>
</html>
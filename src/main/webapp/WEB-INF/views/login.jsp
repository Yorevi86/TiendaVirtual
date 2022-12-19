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
    if (request.getSession().getAttribute("validationMessage") != null){
        out.println("<p>" + request.getSession().getAttribute("validationMessage") + "</p>");
    }
    request.getSession().setAttribute("validation", "ko");
    %>
    <form name="login" action="./tienda" method="get">
        <p>Nombre de usuario:</p>
        <input type="text" name="login" id="login">

        <p>Contraseña:</p>
        <input type="password" name="password" id="password">
        <p></p>
        <input type="submit" value="Enviar">
    </form>
    <br>
    <p>Aun no eres miembro? Unete, va, no seas asi.</p>
    <input type="button" value="Registrarse" onclick="location.href='signup'">
</body>
</html>
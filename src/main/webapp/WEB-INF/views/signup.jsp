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
    if(request.getAttribute("errores") != null){
        out.println("Corregir los errores en:<br>" + request.getAttribute("errores"));
    }
    %>
    <form name="login" action="./validation" method="get">
        <p>Nombre de usuario:</p>
        <input type="text" name="login" id="login">

        <p>Contraseña:</p>
        <input type="password" name="password" id="password">

        <p>Nombre:</p>
        <input type="text" name="name" id="name">

        <p>Apellidos:</p>
        <input type="text" name="surname" id="surname">

        <p>Direccion:</p>
        <input type="text" name="address" id="address">

        <p>Provincia:</p>
        <select required name="state" id="state" class="form-control">
            <option value="0" label="Elige la provincia" selected="selected">Elige la provincia</option>
            <option value="�lava/Araba">�lava/Araba</option>
            <option value="Albacete">Albacete</option>
            <option value="Alicante">Alicante</option>
            <option value="Almer�a">Almer�a</option>
            <option value="Asturias">Asturias</option>
            <option value="�vila">�vila</option>
            <option value="Badajoz">Badajoz</option>
            <option value="Baleares">Baleares</option>
            <option value="Barcelona">Barcelona</option>
            <option value="Burgos">Burgos</option>
            <option value="C�ceres">C�ceres</option>
            <option value="C�diz">C�diz</option>
            <option value="Cantabria">Cantabria</option>
            <option value="Castell�n">Castell�n</option>
            <option value="Ceuta">Ceuta</option>
            <option value="Ciudad Real">Ciudad Real</option>
            <option value="C�rdoba">C�rdoba</option>
            <option value="Cuenca">Cuenca</option>
            <option value="Gerona/Girona">Gerona/Girona</option>
            <option value="Granada">Granada</option>
            <option value="Guadalajara">Guadalajara</option>
            <option value="Guip�zcoa/Gipuzkoa">Guip�zcoa/Gipuzkoa</option>
            <option value="Huelva">Huelva</option>
            <option value="Huesca">Huesca</option>
            <option value="Ja�n">Ja�n</option>
            <option value="La Coru�a/A Coru�a">La Coru�a/A Coru�a</option>
            <option value="La Rioja">La Rioja</option>
            <option value="Las Palmas">Las Palmas</option>
            <option value="Le�n">Le�n</option>
            <option value="L�rida/Lleida">L�rida/Lleida</option>
            <option value="Lugo">Lugo</option>
            <option value="Madrid">Madrid</option>
            <option value="M�laga">M�laga</option>
            <option value="Melilla">Melilla</option>
            <option value="Murcia">Murcia</option>
            <option value="Navarra">Navarra</option>
            <option value="Orense/Ourense">Orense/Ourense</option>
            <option value="Palencia">Palencia</option>
            <option value="Pontevedra">Pontevedra</option>
            <option value="Salamanca">Salamanca</option>
            <option value="Segovia">Segovia</option>
            <option value="Sevilla">Sevilla</option>
            <option value="Soria">Soria</option>
            <option value="Tarragona">Tarragona</option>
            <option value="Tenerife">Tenerife</option>
            <option value="Teruel">Teruel</option>
            <option value="Toledo">Toledo</option>
            <option value="Valencia">Valencia</option>
            <option value="Valladolid">Valladolid</option>
            <option value="Vizcaya/Bizkaia">Vizcaya/Bizkaia</option>
            <option value="Zamora">Zamora</option>
            <option value="Zaragoza">Zaragoza</option>
          </select>

        <p>Localidad:</p>
        <input type="text" name="city" id="city">

        <p>C�digo postal:</p>
        <input type="text" name="postalCode" id="postalCode">

        <p>Tel�fono:</p>
        <input type="text" name="phoneNumber" id="phoneNumber">

        <input type="submit" value="Enviar">
    </form>
</body>
</html>
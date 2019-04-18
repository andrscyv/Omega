<%-- 
    Document   : NewUser
    Created on : 18/04/2019, 12:19:18 AM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear nuevo usuario</title>
    </head>
    <body>
        <h1>Crear nuevo usuario</h1>
        
        <form>
            Usuario: <input type="text" name="userName" value="" />
            Contraseña: <input type="password" name="password" value="" />
            Nombre de la base de datos: <input type="text" name="dbName" value="" />
            <input type="submit" value="OK" />
        </form>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 21/02/2017, 08:11:01 PM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>¡Bienvenido a CineMAS!</h1> <br>
        Permitenos recomendarte una Película <br> <br>
        <form action="GetSuggestion">
            Zona: <select name="zona">
                <option>Centro</option>
                <option>No Centro</option>
            </select> <br>
            Tipo de película: <select name="tipo">
                <option>Comedia</option>
                <option>No Comedia</option>
            </select> <br> <br>
            <input type="reset" value="Limpiar" />
            <input type="submit" value="Ver Recomendación" />
        </form>
        
    </body>
</html>

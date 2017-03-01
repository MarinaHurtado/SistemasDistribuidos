<%-- 
    Document   : index
    Created on : 10/02/2017, 05:39:22 PM
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
        <h1>Sistema de Cotización de Seguros de Auto</h1>
        Datos personales
        <form action="auto.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="txtAp" value="" /></td>
                    </tr>
                    <tr>
                        <td>Género</td>
                        <td><input type="radio" name="genero" value="Hombre" />Hombre
                            <input type="radio" name="genero" value="Mujer" />Mujer
                        </td>
                    </tr>
                    <tr>
                        <td>Edad</td>
                        <td><input type="text" name="txtEdad" value="" /></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td><select name="ddEdo">
                                <option>Jalisco</option>
                                <option>DF</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" name="btnLimpiar" /></td>
                        <td><input type="submit" value="Enviar" name="btnEnviar" /></td>
                    </tr>

                </tbody>
            </table>
        </form>
    </body>
</html>

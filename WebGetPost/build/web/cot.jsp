<%-- 
    Document   : cot
    Created on : 14/02/2017, 08:12:27 PM
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
        <h1>Cotización de Seguro para Automóvil</h1>
        <%
            out.println("<b>Estimado Sr(a): " + request.getParameter("txtNombreII")+ " " + request.getParameter("txtApII") + " </b>");
            out.println("<br>Genero: " + request.getParameter("txtGeneroII")+ " ");
            out.println("<br>Edad: " + request.getParameter("txtEdadII")+ " ");
            out.println("<br>Estado: " + request.getParameter("txtEdoII")+ " ");
            out.println("<br>Marca: " + request.getParameter("ddMarca")+ " ");
            out.println("<br>Modelo: " + request.getParameter("txtModelo")+ " ");
            out.println("<br>Placas: " + request.getParameter("txtPlacas")+ " ");
        %>
        
        <br>
        <h1>La cotización de su seguro es: </h1>
        <%
        out.println("<b> $" + Math.floor(Math.random() * 10 * Integer.parseInt(request.getParameter("txtModelo"))) + " pesos </b>"); %>
    </body>
</html>

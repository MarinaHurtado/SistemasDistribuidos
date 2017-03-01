<%-- 
    Document   : puntofinal
    Created on : 16/02/2017, 08:16:21 PM
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
        <%
            if(request.getParameter("nombre")!=null){
                out.print("Nombre: " + request.getParameter("nombre"));
            }
            
            if(request.getParameter("apellido")!=null){
                out.print("Apellidos: " + request.getParameter("apellido"));
            }
        %>
    </body>
</html>

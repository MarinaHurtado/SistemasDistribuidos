<%-- 
    Document   : page1
    Created on : 16/03/2017, 08:18:59 PM
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
        <h1>Nombre: <%out.println(request.getParameter("Name"));%></h1>
        <h1>Edad: <%out.println(request.getParameter("Age"));%></h1>
    </body>
</html>

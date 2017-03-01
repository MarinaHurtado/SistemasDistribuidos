<%-- 
    Document   : Welcome
    Created on : 17/02/2017, 05:36:41 PM
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
            out.println("<h1>Welcome " + request.getParameter("nombre") + " </h1>");
        %>
    </body>
</html>

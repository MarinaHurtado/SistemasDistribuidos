<%-- 
    Document   : profile
    Created on : 24/02/2017, 05:23:34 PM
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
            HttpSession ss = request.getSession();
            out.println("<h2> Hi " +ss.getAttribute("nombre") +"-Session. This is your profile!</h2><br><hr><br>");
        %>
        <a href="SignOut">Sign out</a>
        
    </body>
</html>

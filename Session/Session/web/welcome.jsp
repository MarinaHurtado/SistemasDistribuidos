<%-- 
    Document   : welcome
    Created on : 24/02/2017, 05:23:41 PM
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
            if (!request.getParameter("password").equals("123456"))
                response.sendRedirect("index.jsp");
        
            HttpSession ss = request.getSession();
            ss.setAttribute("nombre", request.getParameter("nombre"));
            out.println("<h2> Welcome " +ss.getAttribute("nombre") + "</h2> <br><hr><br>");
        %>
        
        <a href="profile.jsp">Visit your profile! :P</a>     
            
    </body>
</html>

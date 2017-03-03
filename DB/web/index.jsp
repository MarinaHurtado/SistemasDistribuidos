<%-- 
    Document   : index
    Created on : 28/02/2017, 09:20:58 PM
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
        <form action="DataPresenter" name="x">
            <h1> Retrieve Database Records </h1>
            <input type="submit" value="Retrieve Data" />
            <%
              HttpSession ss = request.getSession();
              ss.setAttribute("Counter", 0);
            %>
        </form>
    </body>
</html>

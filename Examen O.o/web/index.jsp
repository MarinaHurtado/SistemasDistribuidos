<%-- 
    Document   : index
    Created on : 10/03/2017, 04:23:43 PM
    Author     : sdist
--%>

<%@page import="java.util.*"%>
<%@page import="java.rmi.*"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen</title>
    </head>
    <body>
        <div>Legacy</div>
        <form action="Serv">
            Datum: <input type="text" name="txtDt" value="Dato" />   <input type="submit" value="Send" name="btnSend" />
        </form>
        
    </body>
</html>

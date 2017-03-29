<%-- 
    Document   : index
    Created on : 28/03/2017, 08:59:12 PM
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
        <h1>Hello World!</h1>
        <%--
        P1: <input type="text" name="txtP1" value="" /> </br>
        P2: <input type="text" name="txtP2" value="" /> </br>
        --%>
        
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webserviceclient.MyWebService_Service service = new webserviceclient.MyWebService_Service();
	webserviceclient.MyWebService port = service.getMyWebServicePort();
	 // TODO initialize WS operation arguments here
	int p1 = 3;
	int p2 = 6;
	// TODO process result here
	int result = port.add(p1, p2);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>

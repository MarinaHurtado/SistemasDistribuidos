<%-- 
    Document   : scroll
    Created on : 3/03/2017, 04:29:18 PM
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
        <form action="scroll.jsp">
        <h1>Scrolling Database Result</h1>
        <%
            
            HttpSession ss = request.getSession();
            Integer counter = (Integer)ss.getAttribute("Counter");
            
            if(request.getParameter("next") != null){
                //out.println("Wiiii");
                counter++;
            }
            else if (request.getParameter("previous") != null)
                counter--;
            
            ss.setAttribute("Counter", counter);
            
            Object[][] arr = (Object[][])ss.getAttribute("ResultSet");
            
            if(arr!=null){
                out.println("ID: " + arr[counter][0] + "<br>");
                out.println("Name: " + arr[counter][1] + "<br>");
                out.println("Balance: " + arr[counter][2] + "<br>");
            }
        %>
        <hr>
        <input type="submit" value="<" name="previous" <% 
            if(counter==0)
                out.print("disabled=\"disabled\"");%> />
        <input type="submit" value=">" name="next" <% 
            if(counter==arr.length-1)
                out.print("disabled=\"disabled\"");%> />/>
        </form>
    </body>
</html>

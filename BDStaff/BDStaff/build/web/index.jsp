<%-- 
    Document   : index
    Created on : 2/03/2017, 08:20:04 PM
    Author     : sdist
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Staff</h1>
        <%
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/BDStaff","root","1234");

            Statement query = con.createStatement();
            ResultSet rs;
            
            if(request.getParameter("btnAdd") != null){
                query.executeUpdate("INSERT INTO STAFF VALUES (" 
                        +request.getParameter("idAdd") +",'" 
                        +request.getParameter("nameAdd") +"'," 
                        +request.getParameter("balanceAdd") +")");
            }
            
            if(request.getParameter("btnRemove") != null){
                query.executeUpdate("DELETE FROM STAFF where ID=" 
                        +request.getParameter("idRemove"));
            }
            
            if(request.getParameter("btnUpdate") != null){
                query.executeUpdate("UPDATE STAFF SET BALANCE = "
                        +request.getParameter("balanceUpdate") +", "
                        +"NAME = '" +request.getParameter("nameUpdate") 
                        +"' where ID = " +request.getParameter("idUpdate"));
            }

            rs = query.executeQuery("SELECT * FROM STAFF");
            while(rs.next()) {
                out.println(" Id: "+ rs.getInt("ID"));
                out.println(" Name: "+ rs.getString("NAME"));
                out.println(" Balance: "+ rs.getString("BALANCE") +" <br>");

            }
            con.commit();
            con.close();
        %>
        
        <form action="index.jsp">
            <h2>Add a record</h2>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="idAdd" value="" /></td>
                        <td>Name:</td>
                        <td><input type="text" name="nameAdd" value="" /></td>
                        <td>Balance:</td>
                        <td><input type="text" name="balanceAdd" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit" name="btnAdd" />
        </form>
        
        <form action="index.jsp">
            <h2>Delete a record</h2>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="idRemove" value="" /></td>                        
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit" name="btnRemove" />
        </form>
        
        <form action="index.jsp">
            <h2>Update a record</h2>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="idUpdate" value="" /></td>
                        <td>Name:</td>
                        <td><input type="text" name="nameUpdate" value="" /></td>
                        <td>Balance:</td>
                        <td><input type="text" name="balanceUpdate" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit" name="btnUpdate" />
        </form>
        
    </body>
</html>

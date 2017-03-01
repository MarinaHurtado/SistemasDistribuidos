<%-- 
    Document   : resultado
    Created on : 10/02/2017, 05:16:55 PM
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
        <form action="cot.jsp" method="POST">
            <h2> Datos personales </h2> 
            <%
            out.println("Estimado Sr(a): " + request.getParameter("txtNombre") + " " + request.getParameter("txtAp") + " ");
            out.println("<br>Genero: " + request.getParameter("genero") + " ");
            out.println("<br>Edad: " + request.getParameter("txtEdad")+ " ");
            out.println("<br>Estado: " + request.getParameter("ddEdo") + " ");
            %>
            
            <input type="hidden" name="txtNombreII" value="
            <%
                if (request.getParameter("txtNombre") != null){
                    out.print(request.getParameter("txtNombre"));
                }
            %> " />

            <input type="hidden" name="txtApII" value="
            <%
                if (request.getParameter("txtAp") != null){
                    out.print(request.getParameter("txtAp"));
                }
            %> " />

            <input type="hidden" name="txtGeneroII" value="
            <%
                if (request.getParameter("genero") != null){
                    out.print(request.getParameter("genero"));
                }
            %> " />

            <input type="hidden" name="txtEdadII" value="
            <%
                if (request.getParameter("txtEdad") != null){
                    out.print(request.getParameter("txtEdad"));
                }
            %> " />

            <input type="hidden" name="txtEdoII" value="
            <%
                    out.print(request.getParameter("ddEdo"));
            %> " />

            <h2> Datos del auto </h2>
        
            <table border="1">
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Marca: </td>
                        <td><select name="ddMarca">
                                <option>Chevrolet</option>
                                <option>No Chevrolet</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Modelo: </td>
                        <td><input type="text" name="txtModelo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Placas:</td>
                        <td><input type="text" name="txtPlacas" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" name="btnLimpiarII" /></td>
                        <td><input type="submit" value="Enviar" name="btnEnviarII" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>

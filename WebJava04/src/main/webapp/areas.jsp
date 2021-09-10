<%-- 
    Document   : areas
    Created on : 10/09/2021, 02:04:29 PM
    Author     : josea
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%--validacion de sesion--%>
<%
HttpSession misession= (HttpSession) request.getSession();
String usuario= (String) misession.getAttribute("usuario");  
if(misession == null || misession.getAttribute("usuario") == null){
      out.print("<link rel=\"stylesheet\" \n"
                + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
      out.println("<center>");           
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a class='btn btn-primary' href='/WebJava04/login.jsp'>Ir a pagina de acceso</a>");
      out.println("</center>");
      return;
  }    
%>

<% 
    String driver = "com.mysql.cj.jdbc.Driver";
    String url   = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    String user   = "root";
    String pass   = "";

    Class.forName(driver);
    Connection xcon = DriverManager.getConnection(url, user, pass);

    String sql = "select * from areas";
    Statement stm = xcon.createStatement();
    ResultSet rs = stm.executeQuery(sql);

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Areas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
        
        

        <div class="container">
            <h3>Usuario Logeado: <b><% out.print(usuario); %></b></h3>
            <h3><a class='btn btn-danger' href="/WebJava04/ServletSesion">Cerrar Sesion</a></h3>
            <h1>Listado de Areas</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">CODIGO</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rs.next()) {
                            out.print("<tr>");
                            out.print("<td>" + rs.getString(1) + "</td>");
                            out.print("<td>" + rs.getString(2) + "</td>");
                            out.print("<td>" + rs.getString(3) + "</td>");
                            out.print("</tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>

</html>

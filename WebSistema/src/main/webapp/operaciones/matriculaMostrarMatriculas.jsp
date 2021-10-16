<%-- 
    Document   : matriculaMostrarMatriculas
    Created on : 15/10/2021, 08:20:51 PM
    Author     : josea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
HttpSession misession= (HttpSession) request.getSession();
String usuario= (String) misession.getAttribute("usuario");   
if(misession == null || misession.getAttribute("usuario") == null){
      out.print("<link rel=\"stylesheet\" \n"
                + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
      out.println("<center>");           
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a class='btn btn-warning' href='/WebSistema/sesiones/login.jsp'>Ir a pagina de acceso</a>");
      out.println("</center>");
      return;
  }    
%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" 
              href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
    <div class="card" style="width: 50rem; padding: 30px 0px 0px 30px;">
        <h4 class="display-8">Seleccionar Alumno</h4>
        <form method=POST action="/WebSistema/controladorPrincipal">
            <input type=HIDDEN name=accion value="matriculaMostrarMatriculas">
            <input type=HIDDEN name=modo value="busqueda">
            <table class="table table-striped table-hover">
            <tbody>
            <tr><td>
            Buscar Alumno: <input name="xcod" value="<c:out value='${codigo}'/>"
                size=60>
            </td></tr>
            <tr><td>
            <select name="xcodAlumno" size="10" class="form-control" id="exampleFormControlSelect2">
              <c:forEach items="${arrMatriculas}" var="matricula">
                <option value=<c:out value='${matricula.nro_doc}'/> >
                   <c:out value='${matricula.nro_doc}'/>
                </option>
              </c:forEach>
            </select>
            </td></tr>
            <tr><td>
            <input type=submit name=boton class="btn btn-primary" value="Buscar">
            <input type=submit name=boton class="btn btn-dark" value="Registrar">
            </td></tr>
            </tbody>
            </table>
        </form>
    </div>
    </body>
</html>


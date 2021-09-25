<%-- 
    Document   : editar
    Created on : 24/09/2021, 08:19:50 PM
    Author     : josea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" 
              href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
        
        
    </head>
    <body>
        <sql:setDataSource var="xcon" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC"
                           user="root"
                           password=""/>

        <sql:query dataSource="${xcon}"
                sql="select * from t_usuarios where codigo = ${xcod}"
                var="result"/>
        
        <div class="card" style="width: 50rem;padding: 30px 0px 0px 30px;">
            <h4 class="display-8"><c:out value='${titulo}'/></h4>
            <form name=mod_opcion method=POST action="/tareaLab05/controlador_datos">
                <input type=HIDDEN name=accion value="GRABAR_U">
                <input type=hidden name=operacion value='<c:out value='${operacion}'/>'>
                <c:forEach var="row" items="${result.rows}">                   
                    <input type=hidden name=xcod value="<c:out value='${row.codigo}'/>">
                </c:forEach>

                <table class="table table-striped table-hover">
                    <tbody>
                        <c:forEach var="row" items="${result.rows}">
                        <tr><th>Codigo: </th>
                            <td><c:out value='${row.codigo}'/> </td> </tr>
                        <tr><th>Nombre: </th>
                            <td><input name=xnom value="<c:out value='${row.nombre}'/>"
                                       size=40></td></tr>
                        <tr><th>Clave: </th>
                            <td><input name=xclave value="<c:out value='${row.clave}'/>" 
                                       size=15></td></tr>
                        <tr><th>Estado:</th>
                            <td><c:choose>
                                    <c:when test="${row.estado=='X'}">
                                        <input type=radio name=xest value=A>Activo
                                        <input type=radio name=xest value=X checked>Inactivo
                                    </c:when>
                                    <c:otherwise>
                                        <input type=radio name=xest value=A checked>Activo
                                        <input type=radio name=xest value=X>Inactivo
                                    </c:otherwise>
                                </c:choose>
                            </td></tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type=submit name=boton class="btn btn-primary" value="GRABAR">
                <input type=submit name=boton class="btn btn-dark" value="CANCELAR">
            </form>
        </div>
    </body>
</html>

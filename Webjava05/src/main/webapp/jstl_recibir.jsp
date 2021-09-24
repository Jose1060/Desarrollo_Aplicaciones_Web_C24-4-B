<%-- 
    Document   : jstl_recibir
    Created on : 17/09/2021, 02:38:58 PM
    Author     : josea
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recibir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
        <div class="container mt-5">
            <div style="width: 450px; text-align: center; margin: 50px auto;">
            <h1>Tabla de Multiplicar</h1>
            Tabla del <c:out value="${tabla}"/>
            <br>
            <ul class="list-group">
                <c:forEach var="contador" begin="1" end="10">
                    <c:set var="producto" value="${contador*tabla}"/>
                    <li class="list-group-item">
                        <c:out value="${contador} x ${tabla} = ${producto}"/>
                    </li>
                </c:forEach>
            </ul>
            <a class="btn btn-primary btn-lg" href="/WebJava05/jstl_enviar.jsp" role="button">Volver</a>
            </div>
        </div>
    </body>

</html>

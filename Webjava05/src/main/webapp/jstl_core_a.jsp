<%-- 
    Document   : jslt_core_a
    Created on : 17/09/2021, 01:17:00 PM
    Author     : josea
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Core_A</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
        <c:set  var="variable1" value="Hola"/>
        <c:set  var="variable2" value="Mundo"/>
        <div class="container mt-5">
            <div class="row">
                <div class="col">
                    <div class="card text-dark bg-warning mb-3" style="max-width: 18rem;">
                        <div class="card-header">Uso de Core</div>
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="Valor de variable1 y variable2: "/></h5>
                            <p class="card-text"><c:out value="${variable1} ${variable2}"/></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>

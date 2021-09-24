<%-- 
    Document   : jstl_enviar
    Created on : 17/09/2021, 02:36:11 PM
    Author     : josea
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enviar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
        <div class="container mt-5">
            <form name="form" action="/Webjava05/Controlador">
                <div style="width: 250px; text-align: center; margin: 50px auto;">
                <h1>Generar Tabla de Multiplicar</h1>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Seleccione la tabla a generar:</label>
                    <select name="tabla" class="form-control" id="exampleFormControlSelect1">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            </form>
        </div>
    </body>

</html>



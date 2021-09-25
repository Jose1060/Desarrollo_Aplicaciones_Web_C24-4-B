<%-- 
    Document   : FormOperaciones
    Created on : 24/09/2021, 07:33:28 PM
    Author     : josea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" 
              href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container mt-5">
            <div class="row">
                <div class="col">
                    <div class="card text-dark bg-warning mb-3" style="max-width: 18rem;">
                        <div class="card-header">Uso de Core</div>
                        <div class="card-body">
                            <form action="/tareaLab05/controlador" method="post">
                                Numero 1:<br>
                                <input type="text" name="num1" maxlength="50"><br>
                                Numero 2:<br>
                                <input type="text" name="num2" maxlength="50"><br>
                                Operacion:<br>
                                <select name="op"><br>
                                    <option value="suma">Suma</option>
                                    <option value="resta" selected="selected">Resta</option>
                                    <option value="multiplicacion">Multiplicacion</option>
                                    <option value="division">Division</option>
                                </select> <br>
                                <br><input type=submit name=boton class="btn btn-primary" value="Calcular">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>

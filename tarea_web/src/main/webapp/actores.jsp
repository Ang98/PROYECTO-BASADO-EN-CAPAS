<%-- 
    Document   : actores
    Created on : 30/06/2020, 12:22:13 AM
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor</title>
    </head>
    <body>

        <div class="container">

            <h1>CREAR ACTORES</h1>

            <form action="Crear" method="POST">
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="titulo">NOMBRE</label>
                            <input type="text" class="form-control" id="titulo" name="nombre" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="titulo">APELLIDO</label>
                            <input type="text" class="form-control" id="titulo" name="apellido" aria-describedby="emailHelp">
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-0">
                        <button type="Submit" class="btn btn-primary">Agregar</button>
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col-sm-8">
                    <p style="color:green;">${requestScope.mensaje2}</p>
                    <p style="color:red;">${requestScope.mensaje1}</p>
                    <p style="color:red;">${requestScope.error}</p>
                </div>

            </div>

            <div class="row">
                <div class="col-sm-8">
                    <a href="peliculas.jsp">PELICULAS</a>
                </div>

            </div>


        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


    </body>
</html>

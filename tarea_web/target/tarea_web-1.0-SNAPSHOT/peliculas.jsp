<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>PELICULAS</title>


    </head>
    <body>


        <div class="container">
            <h1>CREAR PELICULAS</h1>

            <form onSubmit="return false">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="titulo">TITULO</label>
                            <input type="text" class="form-control" id="titulo" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="anio">AÑO</label>
                            <input type="number" class="form-control" id="anio">
                            <div id="ani_c" style="display: none" class="alert alert-danger" role="alert">
                                INGRESE UN AÑO VALIDO (ejem: desde 1900 hasta 2020)
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="descripcion">DESCRIPCION</label>
                            <textarea class="form-control" id="descripcion" rows="4"></textarea>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label >NOMBRE DEL ACTOR</label>
                            <input type="text" class="form-control" id="actn"  aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label >APELLIDO DEL ACTOR</label>
                            <input type="text" class="form-control" id="actp"  aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <button id="btnactor" class="btn btn-primary">Agregar Actor</button>
                        </div>
                        <div id="alertActN" style="display: none" class="alert alert-danger" role="alert">
                            Actor no encontrado, agreguelo !!
                        </div>
                        <div id="alertActS" style="display: none" class="alert alert-success" role="alert">
                            Actor encontado
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="descripcion">Actores</label>
                            <textarea id="areaActor" class="form-control" id="descripcion" rows="4" disabled></textarea>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-0">
                        <button id="btnpelicula" class="btn btn-primary">Crear Pelicula</button>
                    </div>
                </div>
            </form>

            <div class="alertas">


                <div class="row">
                    <div class="col-sm">
                        <div id="peli_a" style="display: none" class="alert alert-warning" role="alert">
                            No se han agregado actores
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-sm">
                        <div id="peli" style="display: none" class="alert alert-warning" role="alert">
                            Rellene los datos porfavor
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div id="peliN" style="display: none" class="alert alert-danger" role="alert">
                            La pelicula ya existe
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div id="peliS" style="display: none" class="alert alert-success" role="alert">
                            La pelicula fue creada
                        </div>
                    </div>
                </div>

            </div>
            <a href="actores.jsp">ACTORES</a>
        </div>

        <!-- Optional JavaScript -->

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

        <script>
                var lista = new Array();
                var a = "";
                $("#btnactor").click(function () {
                    //datos
                    var midata = {nombre: document.getElementById("actn").value,
                        apellido: document.getElementById("actp").value};
                    var actno = document.getElementById("alertActN");
                    var actsi = document.getElementById("alertActS");
                    //hacer la llamada
                    $.post("Buscar", midata, function (data) {


                        if (data.id != 0 && data != "") {
                            lista.push(data);
                            a = data.nombres + " " + data.apellidos + " ," + a;
                            document.getElementById("areaActor").value = a;
                            if (actsi.style.display === "none") {
                                actsi.style.display = "block";
                                actno.style.display = "none";
                            }
                        } else {

                            actsi.style.display = "none";
                            actno.style.display = "block";
                        }
                    });


                    document.getElementById("actn").value = "";
                    document.getElementById("actp").value = "";

                });


                $("#btnpelicula").click(function () {
                    var peli = document.getElementById("peli");
                    var peli_a = document.getElementById("peli_a");
                    var peliN = document.getElementById("peliN");
                    var peliS = document.getElementById("peliS");
                    var ani = document.getElementById("ani_c");
                    var titulo = document.getElementById("titulo").value;
                    var anio = document.getElementById("anio").value;
                    var descripcion = document.getElementById("descripcion").value;
                    var midata = {titulo, anio, descripcion};

                    if (titulo == "", anio == "", descripcion == "") {
                        peli.style.display = "block";
                    } else {
                        peli.style.display = "none";
                        peliS.style.display = "none";
                        peliN.style.display = "none";
                    }

                    if (lista.length == 0) {

                        peli_a.style.display = "block";
                    } else {
                        peli_a.style.display = "none";
                        peliS.style.display = "none";
                        peliN.style.display = "none";
                    }

                    if (anio < 1900 || anio > 2020) {

                        ani.style.display = "block";
                    } else {
                        ani.style.display = "none";
                        peliS.style.display = "none";
                        peliN.style.display = "none";
                    }

                    if (peli_a.style.display == "none" && peli.style.display == "none" && ani.style.display == "none") {
                        var crear = false;
                        $.get("VerificarPelicula", midata, function (data) {
                            if (data == "NO") {
                                peliS.style.display = "block";
                                peliN.style.display = "none";
                                crearpelicula(midata);

                                document.getElementById("titulo").value = "";
                                document.getElementById("anio").value = "";
                                document.getElementById("descripcion").value = "";
                                document.getElementById("areaActor").value = "";
                                document.getElementById("alertActN").style.display = "none";
                                document.getElementById("alertActS").style.display = "none";


                            } else {
                                peliS.style.display = "none";
                                peliN.style.display = "block";
                            }



                        });
                    }



                });

                function crearpelicula(x) {
                    $.post("CrearPelicula", x, function (data) {
                        console.log(data)
                        $.post("BuscarPelicula", x, function (peli) {

                            lista.forEach(function (e) {

                                var film_id = peli.id;
                                var actor_id = e.id;

                                var midata = {film_id, actor_id}
                                
                                $.post("CrearFilmActor", midata, function (result) {

                                    

                                });
                            });
                            console.log("PELICULA CON ACTORES TERMINADO")
                            
                            lista=[];
                            a="";
                        });

                    });
                }

        </script> 


    </body>
</html>
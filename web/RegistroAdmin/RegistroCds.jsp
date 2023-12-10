<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Resources/style.css">
        <script src="Resources/script.js"></script>
        
        <title>Biblioteca UDB</title>
        <script>
            setTimeout(function () {
                document.getElementById("msj").style.display = "none";
            }, 4000);
        </script>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <img src="Resources/images/udb.png" alt="" width="30" height="24">
            <a class="navbar-brand" href="PrestarControlador?menu=Menu&noCarnet=${us.getNoCarnet()}">BIBLIOTECA UDB</a>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">

                    <li class="nav-item dropdown">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Prestar Material
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="PrestarControlador?menu=PrestarLib&accion=Listar&noCarnet=${us.getNoCarnet()}">Libros</a>
                            <a class="dropdown-item" href="PrestarControlador?menu=PrestarObr&accion=Listar&noCarnet=${us.getNoCarnet()}">Obras</a>
                            <a class="dropdown-item" href="PrestarControlador?menu=PrestarRev&accion=Listar&noCarnet=${us.getNoCarnet()}">Revistas</a>
                            <a class="dropdown-item" href="PrestarControlador?menu=PrestarCds&accion=Listar&noCarnet=${us.getNoCarnet()}">CDs</a>
                            <a class="dropdown-item" href="PrestarControlador?menu=PrestarTsi&accion=Listar&noCarnet=${us.getNoCarnet()}">Tesis</a>
                        </div>
                    </li>

                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="DevolverControlador?menu=Devolver&accion=Listar&noCarnet=${us.getNoCarnet()}">Devolver Material</a>
                    </li>

                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="AdministracionControlador?menu=Actualizar&accion=Actualizar&noCarnet=${us.getNoCarnet()}">Actualizar Préstamos</a>
                    </li>
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="UsuarioControlador?menu=PagarMora&accion=Listar&noCarnet=${us.getNoCarnet()}">Pagar Recargo</a>
                    </li>
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="UsuarioControlador?menu=Usuario&accion=Listar&noCarnet=${us.getNoCarnet()}">Registrar Usuario</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Registrar Material
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="LibroControlador?menu=Libro&accion=Listar&noCarnet=${us.getNoCarnet()}">Libros</a>
                            <a class="dropdown-item" href="ObraControlador?menu=Obra&accion=Listar&noCarnet=${us.getNoCarnet()}">Obras</a>
                            <a class="dropdown-item" href="RevistaControlador?menu=Revista&accion=Listar&noCarnet=${us.getNoCarnet()}">Revistas</a>
                            <a class="dropdown-item" href="CdControlador?menu=CD&accion=Listar&noCarnet=${us.getNoCarnet()}">CDs</a>
                            <a class="dropdown-item" href="TesisControlador?menu=Tesis&accion=Listar&noCarnet=${us.getNoCarnet()}">Tesis</a>
                        </div>
                    </li>

                </ul>
            </div>

            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                    ${us.getNombre().toUpperCase()}
                    ${us.getApellido().toUpperCase()}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="Resources/images/login.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${us.getUsername().toUpperCase()}</a>
                    <a class="dropdown-item" href="#">${us.getNoCarnet().toUpperCase()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="LoginControlador" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                    </form>
                </div>
            </div>
        </nav>

        <div id="msj" class="${config}" role="alert">
            ${mensaje}
        </div>   
        
        <h3 class="text-center m-4" style=" font-weight: bold;">Registro de CD´s</h3>

        <div class="d-flex">
            <div class="col-12">
                <div class="card bg-light">
                    <form action="CdControlador?menu=CD&noCarnet=${us.getNoCarnet()}" method="POST">
                        <div class="card-body">

                            <div class="form-group d-flex">
                                <div class="col-lg-2">
                                    <input type="text" name="txtCod" placeholder="Código CD" value="${cds.getCodCd()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtTitulo" placeholder="Titulo" value="${cds.getTitulo()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtAutor" placeholder="Autor" value="${cds.getAutor()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtPais" placeholder="País" value="${cds.getPais()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtAnio" placeholder="Año publicación" value="${cds.getAnioPublicacion()}" class="form-control" required="true">
                                </div>

                            </div>

                            <div class="form-group d-flex">
                                <div class="col-lg-2">
                                    <input type="text" name="txtVolumen" placeholder="Volumen" value="${cds.getVolumen()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtIdioma" placeholder="Idioma" value="${cds.getIdioma()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtGenero" placeholder="Género" value="${cds.getGenero()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" name="txtUbicacion" placeholder="Ubicación" value="${cds.getUbicacion()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-2">
                                    <input type="number" name="txtUnidad" placeholder="Unidades" value="${cds.getUnidades()}" class="form-control" required="true">
                                </div>
                                <div class="col-lg-1">
                                    <input type="submit" name="accion" value="Registrar" class="btn btn-dark">
                                </div>
                                <div class="col-lg-1">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-danger">                                   
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
<br>                                
            <div class="container-sm table-responsive block2" >
                <div class="col-sm-12 text-center">
                    <table class="table table-hover table-striped" style="background-color: lightgray;">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Titulo</th>
                                <th>Autor</th>
                                <th>Pais</th>
                                <th>Año</th>
                                <th>Volumen</th>
                                <th>Idioma</th>
                                <th>Genero</th>
                                <th>Ubicacion</th>
                                <th>Unidades</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="cd" items="${lista}">
                                <tr>
                                    <td>${cd.getCodCd()}</td>
                                    <td>${cd.getTitulo()}</td>
                                    <td>${cd.getAutor()}</td>
                                    <td>${cd.getPais()}</td>
                                    <td>${cd.getAnioPublicacion()}</td>
                                    <td>${cd.getVolumen()}</td>
                                    <td>${cd.getIdioma()}</td>
                                    <td>${cd.getGenero()}</td>
                                    <td>${cd.getUbicacion()}</td>
                                    <td>${cd.getUnidades()}</td>
                                    <td>
                                        <a class="btn btn-warning" href="CdControlador?menu=CD&accion=Editar&CodCd=${cd.getCodCd()}&noCarnet=${car}">Editar</a>
                                        <a class="btn btn-danger" href="CdControlador?menu=CD&accion=Eliminar&CodCd=${cd.getCodCd()}&noCarnet=${car}">Eliminar</a>
                                    </td>
                                </tr>  
                            </c:forEach>    
                        </tbody>
                    </table>                   
                </div>
            </div>
<br>
<br>

  <footer class="bg-dark text-light text-center p-3">
    <div class="container">
      <p>&copy; 2023 BIBLIOTECA UDB.
          <br>Todos los derechos reservados.</p>
    </div>
  </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-yGBVx2Jd8hRyi6LOaxwn4I6TXm2DOHPh6aOW9uL9H6EGgoDZvR8GBCYzSHcceNXP" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

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
            <a class="navbar-brand" href="#">
      <img src="Resources/images/udb.png" alt="" width="40" height="34">
    </a>
            <a class="navbar-brand" href="ConsultarUsuarios?menu=Menu">BIENVENIDO A TU BIBLIOTECA UDB</a>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">

                    <li class="nav-item dropdown">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light dropdown-toggle" href="" role="button" data-toggle="dropdown" aria-expanded="false">
                            Consultar Material
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="ConsultarUsuarios?menu=ConsultarLib&accion=Listar">Libros</a>
                            <a class="dropdown-item" href="ConsultarUsuarios?menu=ConsultarObr&accion=Listar">Obras</a>
                            <a class="dropdown-item" href="ConsultarUsuarios?menu=ConsultarRev&accion=Listar">Revistas</a>
                            <a class="dropdown-item" href="ConsultarUsuarios?menu=ConsultarCds&accion=Listar">CD's</a>
                            <a class="dropdown-item" href="ConsultarUsuarios?menu=ConsultarTsi&accion=Listar">Tesis</a>
                        </div>
                    </li>

                </ul>
            </div>

            <div class="dropdown">
                <li class="nav-item active" style="list-style: none ;">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="login.jsp">Iniciar Sesión</a>
                </li>       
            </div>
        </nav>

        <div id="msj" class="${config}" role="alert">
            ${mensaje}
        </div>

        <div class="back2">
            <div class="titulo"><h1 class="text-center mb-5 text-white" style=" font-weight: bold;">Formulario de Consulta de Obras</h1></div>
            <div class="container block1">

                <div class="card col-sm-12 col-lg-9 bg-light">
                    <div class="card-body">
                        <form action="ConsultarUsuarios?menu=ConsultarObr" method="POST">

                            <div class="form-inline">
                                <input type="search" name="texto" class="form-control" required="true">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-dark">
                            </div>

                        </form>
                    </div>
                </div>

            </div>

        </div>

        <div class="container-sm table-responsive block2">
            <div class="col-sm-12 text-center">
                <table class="table table-hover table-striped" style="background-color: lightgray;"">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Titulo</th>
                            <th>Autor</th>
                            <th>No Páginas</th>
                            <th>Editorial</th>
                            <th>Pais</th>
                            <th>ISBN</th>
                            <th>Año</th>
                            <th>Idioma</th>
                            <th>Genero</th>
                            <th>Ubicacion</th>
                            <th>Unidades</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="ob" items="${lista}">
                            <tr>
                                <td>${ob.getCodOb()}</td>
                                <td>${ob.getTitulo()}</td>
                                <td>${ob.getAutor()}</td>
                                <td>${ob.getNoPagina()}</td>
                                <td>${ob.getEditorial()}</td>
                                <td>${ob.getPais()}</td>
                                <td>${ob.getIsbn()}</td>
                                <td>${ob.getAnioPublicacion()}</td>
                                <td>${ob.getIdioma()}</td>
                                <td>${ob.getGenero()}</td>
                                <td>${ob.getUbicacion()}</td>
                                <td>${ob.getUnidades()}</td>
                            </tr>  
                        </c:forEach>    
                    </tbody>

                </table>
            </div>
        </div>
<br>
<br>
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

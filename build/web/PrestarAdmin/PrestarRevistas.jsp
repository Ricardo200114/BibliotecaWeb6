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
                            
            <div class="back3">
                <div class="titulo"><h1 class="text-center mb-5 text-white" style=" font-weight: bold;">Préstamo de Revistas</h1></div>
                <div class="container block1">
                    <div class="card col-sm-12 bg-light">
                        <div class="card-body">
                            <form action="PrestarControlador?menu=PrestarRev&noCarnet=${us.getNoCarnet()}" method="POST">
                                <div class="form-group">
                                    <label>No de Carnet:</label>
                                    <input type="text" name="txtCarnet" class="form-control" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Código de revista:</label>
                                    <input type="text" name="txtCod" class="form-control" required="true">
                                </div>
                                <input type="submit" name="accion" value="Prestar" class="btn btn-dark">
                            </form>
                        </div>
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
                                <th>Editorial</th>
                                <th>ISBN</th>
                                <th>Periodicidad</th>
                                <th>Fecha de Publicación</th>
                                <th>Tamaño</th>
                                <th>Idioma</th>
                                <th>Ubicacion</th>
                                <th>Unidades</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="rev" items="${lista}">
                                <tr>
                                    <td>${rev.getCodRe()}</td>
                                    <td>${rev.getTitulo()}</td>
                                    <td>${rev.getEditorial()}</td>
                                    <td>${rev.getIsbn()}</td>
                                    <td>${rev.getPeriodicidad()}</td>
                                    <td>${rev.getFecha()}</td>
                                    <td>${rev.getTamanio()}</td>
                                    <td>${rev.getIdioma()}</td>
                                    <td>${rev.getUbicacion()}</td>
                                    <td>${rev.getUnidades()}</td>
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

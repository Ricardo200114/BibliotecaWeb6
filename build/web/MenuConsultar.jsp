<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Resources/style2.css">
        <script src="Resources/script.js"></script>
        
        <title>Biblioteca UDB</title>
    </head>
    <body class="menu">

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

        <div class="shadow">

            <div class="container py-5">
                <div class="abc"><h2 class="text-center mb-3 text-white" style=" font-weight: bold;">Bienvenido al menú de Consultas</h2></div>
                <div class="abc"><h5 class="text-center mb-5 text-white" style=" font-weight: bold;">Selecciona el material que deseas consultar:</h5></div>
                <div class="row text-center abc">
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4">
                        <div class="card">
                            <figure>
                                <img class="imagen" src="Resources/images/pila-de-libros.png">
                            </figure>
                            <div class="contenido d-grid">
                                 <a class="btn btn-dark" href="ConsultarUsuarios?menu=ConsultarLib&accion=Listar" role="button">Libros</a>

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4">
                        <div class="card">
                            <figure>
                                <img class="imagen" src="Resources/images/libro.png">
                            </figure>
                            <div class="contenido d-grid">
                                <a class="btn btn-dark" href="ConsultarUsuarios?menu=ConsultarObr&accion=Listar" role="button">Obras</a>

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4">
                        <div class="card">
                            <figure>
                                <img class="imagen" src="Resources/images/revista.png">
                            </figure>
                            <div class="contenido d-grid">
                                <a class="btn btn-dark" href="ConsultarUsuarios?menu=ConsultarRev&accion=Listar" role="button">Revistas</a>

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4">
                        <div class="card">
                            <figure>
                                <img class="imagen" src="Resources/images/disco-de-vinilo.png">
                            </figure>
                            <div class="contenido d-grid">
                                <a class="btn btn-dark" href="ConsultarUsuarios?menu=ConsultarCds&accion=Listar" role="button">CD´s</a>

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4">
                        <div class="card">
                            <figure>
                                <img class="imagen" src="Resources/images/tesisgra.png">
                            </figure>
                            <div class="contenido d-grid">
                                <a class="btn btn-dark" href="ConsultarUsuarios?menu=ConsultarTsi&accion=Listar" role="button">Tesis</a>

                            </div>
                        </div>
                    </div>               
                </div>

            </div>

        </div>
<br>
<br>
<br>
<br>


  <footer class="bg-dark text-light text-center p-3">
    <div class="container">
      <p>&copy; 2023 BIBLIOTECA UDB. 
          <br>
          Todos los derechos reservados.</p>
    </div>
  </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-yGBVx2Jd8hRyi6LOaxwn4I6TXm2DOHPh6aOW9uL9H6EGgoDZvR8GBCYzSHcceNXP" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
        <div id="msj" class="${config}" role="alert">
            ${mensaje}
        </div>
        
        <div class="wrapper">
            <div class="container main">
                <div class="row">
                    <div class="col-md-6 side-image">
                        <div class="d-flex flex-column justify-content-center align-items-center h-100">
                            <div class="text text-center">
                                <p>"Viviendo la experiencia<br>virtual"</p> 
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 right">
                         <div class="input-box">
                             <header><h5>Restablece tu contraseña</h5></header>
                            <form class="form-sing" action="/BibliotecaWeb4/LoginControlador" method="post">
                                <div class="form-group">
                                    <label>Ingresa tu Usuario:</label>
                                    <input type="text" name="txtUser" class="form-control" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Ingresa tu No Carnet:</label>
                                    <input type="text" name="txtCarnet" class="form-control" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Nueva Contraseña:</label>
                                    <input type="password" name="txtNPass" class="form-control" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Confirmar Contraseña:</label>
                                    <input type="password" name="txtCPass" class="form-control" required="true">
                                </div>
                                <input type="submit" name="accion" value="Cambiar" class="btn btn-dark btn-block">
                            </form>
                         </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

package blb.Controlador;

import blb.Modelo.Usuarios;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios u = new Usuarios();
    String user, pass, noCarnet, nPass, cPass;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("Ingresar")) {

            //SE OBTIENE EL USERNAME Y PASSWORD DE LOS CAJAS DE TEXTO DEL FORMULARIO
            user = request.getParameter("txtuser").toUpperCase();
            pass = request.getParameter("txtpass");

            //SE OBTIENE EL USUARIO Y LEUGO SE ALMACENA EN UN NUEVO OBJETO DEL MISMO TIPO
            u = ud.iniciarSesion(user, pass);
            
            //SE VALIDA QUE EL USUARIO OBTENIDO NO SEA NULO
            if (u != null) {
                
                String noCarnet = u.getNoCarnet();

                //SI EL USUARIO ES ESTUDIANTE O PROFESOR SE MANDA A LA PAGINA MENU.JSP
                if (u.getOficio().equals("ESTUDIANTE") || u.getOficio().equals("PROFESOR")) {
                    
                    String url = "PrestarUsuarios?menu=Menu&noCarnet=" + noCarnet;
                    response.sendRedirect(url);

                    //SI EL USUARIO ES ADMINISTRADOR SE MANDA A AL PAGINA MENUADMIN.JSP
                } else if (u.getOficio().equals("ADMINISTRADOR")) {
                    
                    String url = "PrestarControlador?menu=Menu&noCarnet=" + noCarnet;
                    response.sendRedirect(url);
                    
                }

                //SI EL USUARIO NO EXISTE ENTONCES SOLO SE MANDA A LA MISMA PAGINA DE LOGIN 
            } else {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "Error, verifica que el usuario o contraseña sean las correctas...");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            //SI EL USERNAME O CONTRASEÑA SON INCORRECTAS ENTONCES SOLO SE MANDA A LA MISMA PAGINA DE LOGIN
        }
        
        else if (accion.equals("Cambiar")) {
            
            user = request.getParameter("txtUser").toUpperCase();
            noCarnet = request.getParameter("txtCarnet").toUpperCase();
            nPass = request.getParameter("txtNPass");
            cPass = request.getParameter("txtCPass");
            
            u = ud.verificarUsuario(user, noCarnet);
            
            if (u == null) {
//                System.out.println("Este usuario no existe, verifica tus credenciales...");
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "Error, verifica que tu nombre de usuario y No Carnet sean correctos...");
                request.getRequestDispatcher("RestablecerContraseña.jsp").forward(request, response);
            } 
            else {
                
                if(!nPass.equals(cPass) || !cPass.equals(nPass)) {
//                    System.out.println("Error, las contraseñas deben de ser iguales...");
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "Error, verifica que las contraseñas sean iguales...");
                    request.getRequestDispatcher("RestablecerContraseña.jsp").forward(request, response);
                } 
                else {
                    
                    u.setPassword(nPass);
                    ud.restablecerContraseña(u);
//                    System.out.println("Contraseña cambiada con exito...");
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "Contraseña cambiada con exito...");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } 
                
            }
            
        }
        
        else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package blb.Controlador;

import blb.Modelo.Usuarios;
import blb.ModeloDAO.UsuarioDao;
import blb.Validaciones.Validaciones;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios u = new Usuarios();
    Validaciones vl = new Validaciones();
    DecimalFormat df = new DecimalFormat("#.##");
    String nCarnet;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        //EL CARNET SE OBTIENE DEL LOGIN AL MOMENTO DE LOGEARSE...
        nCarnet = request.getParameter("noCarnet");
        u = ud.consultarPorId(nCarnet);
        //SE MANDA EL OBJETO USUARIO AL MENU PARA MOSTRAR LOS DATOS DEL USUARIO EN LA BARRA DE NAVEGACION...
        request.setAttribute("us", u);

        if (menu.equals("Usuario")) {

            switch (accion) {
                case "Listar":

                    listarUsuario(request);

                    break;
                case "Registrar":

                    registrarUsuario(request, response);

                    break;
                case "Editar":

                    editarUsuario(request, response);

                    break;
                case "Actualizar":

                    actualizarUsuario(request, response);

                    break;
                case "Eliminar":
                    
                    eliminarUsuario(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/Usuario/RegistroUsuarios.jsp").forward(request, response);

        } 
        
        else if (menu.equals("PagarMora")) {
            
            switch (accion) {
                case "Listar":
                    
                    listarMora(request);
                    
                    break;
                case "Pagar":
                    
                    pagarMora(request, response);
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("/Usuario/PagarAdministracion.jsp").forward(request, response);
        }
        
        else if (menu.equals("PagarUsuarioMora")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);
            
            switch (accion) {
                case "Listar":
                    
                    listarUsuariosMora(request);
                    
                    break;
                case "Pagar":
                    
                    pagarUsuarioMora(request, response);
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("/Usuario/PagarUsuario.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarUsuario(HttpServletRequest request) {

        try {
            List lista = ud.listarUsuario();
            request.setAttribute("lista", lista);
            request.setAttribute("car",nCarnet);
        } catch (Exception e) {
        }

    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {

        try {
            
            String noCarnet = request.getParameter("txtCarnet").toUpperCase();
            String nombre = request.getParameter("txtNombre").toUpperCase();
            String apellido = request.getParameter("txtApellido").toUpperCase();
            String oficio = request.getParameter("txtOficio").toUpperCase();
            String username = request.getParameter("txtUsername").toUpperCase();
            String pass = request.getParameter("txtPass");
            double mora = 0.0;

            if (!noCarnet.matches("^[A-Za-z]{2}\\d{6}$")) {
                System.out.println(noCarnet);
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El no de Carnet debe de llevar 2 letras y 6 numeros...");
                request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);
                return;
            }

            if (ud.validarRepetido(noCarnet)) {

                u.setNoCarnet(noCarnet);
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setOficio(oficio);
                u.setUsername(username);
                u.setPassword(pass);
                u.setRecargoMora(mora);
                ud.registrarUsuario(u);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "!Usuario registrado con exito¡");
                request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);

            } else {

                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "El usuario que estas tratando de registrar ya existe...");
                request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);

            }

        } catch (IOException | ServletException e) {
        }

    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) {

        try {

            String Carnet = request.getParameter("NoCarnet").toUpperCase();
            Usuarios us = ud.consultarPorId(Carnet);
            request.setAttribute("user", us);
            request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);

        } catch (IOException | ServletException e) {
        }

    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {

        try {
           
            String nCar = request.getParameter("txtCarnet").toUpperCase();
            String nomb = request.getParameter("txtNombre").toUpperCase();
            String apell = request.getParameter("txtApellido").toUpperCase();
            String ofi = request.getParameter("txtOficio").toUpperCase();
            String usn = request.getParameter("txtUsername").toUpperCase();
            String passw = request.getParameter("txtPass");

            if (!nCar.matches("^[A-Za-z]{2}\\d{6}$")) {
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El no de Carnet debe de llevar 2 letras y 6 numeros...");
                request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);
                return;
            }

            u = new Usuarios();
            u.setNombre(nomb);
            u.setApellido(apell);
            u.setOficio(ofi);
            u.setUsername(usn);
            u.setPassword(passw);
            u.setNoCarnet(nCar);
            ud.actualizarUsuario(u);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "!Usuario actualizado con exito¡");
            request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);

        } catch (IOException | ServletException e) {
        }

    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {

        try {
            
            nCarnet = request.getParameter("NoCarnet").toUpperCase();
            ud.eliminarUsuario(nCarnet);
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "!Usuario eliminado con exito¡");
            request.getRequestDispatcher("UsuarioControlador?menu=Usuario&accion=Listar").forward(request, response);

        } catch (IOException | ServletException e) {
        }

    }

    private void pagarMora(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String noCarnet = request.getParameter("txtCarnet").toUpperCase();
            double pago = Double.parseDouble(request.getParameter("txtPago"));
            
            u = ud.consultarPorId(noCarnet);
            
            if (u == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro el usuario con No Carnet " + noCarnet);
                request.getRequestDispatcher("UsuarioControlador?menu=PagarMora&accion=Listar").forward(request, response);
                return;
            }
            
            if (u.getRecargoMora() == 0) {
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "No se encontro ningun recargo...");
                request.getRequestDispatcher("UsuarioControlador?menu=PagarMora&accion=Listar").forward(request, response);
                return;
            }
            
            if (pago < u.getRecargoMora()) {
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El recargo es mayor a la cantidad ingresada...");
                request.getRequestDispatcher("UsuarioControlador?menu=PagarMora&accion=Listar").forward(request, response);
                return;
            }
            
            double pagoMora = pago - u.getRecargoMora();
            String pagoMoraExacto = df.format(pagoMora);
            u.setRecargoMora(0);
            ud.pagarRecargo(u);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "El pago se realizo con exito, tu cambio es: $" + pagoMoraExacto);
            request.getRequestDispatcher("UsuarioControlador?menu=PagarMora&accion=Listar").forward(request, response);
                
            
        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void listarMora(HttpServletRequest request) {
        try {
            List lista = ud.listarUsuariosConMora();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void listarUsuariosMora(HttpServletRequest request) {
        try {
            
            String noCarnet = request.getParameter("noCarnet");
            
            u = ud.consultarPorId(noCarnet);
            request.setAttribute("us", u);
        } catch (Exception e) {
        }
    }

    private void pagarUsuarioMora(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String noCarnet = request.getParameter("txtCarnet").toUpperCase();
            double pago = Double.parseDouble(request.getParameter("txtPago"));
            
            u = ud.consultarPorId(noCarnet);
            
            if (u.getRecargoMora() == 0) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro ningun recargo...");
                request.getRequestDispatcher("UsuarioControlador?menu=PagarUsuarioMora&accion=Listar&noCarnet="+ u.getNoCarnet()).forward(request, response);
                return;
            }
            
            if (pago < u.getRecargoMora()) {
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El recargo es mayor a la cantidad ingresada...");
                request.getRequestDispatcher("UsuarioControlador?menu=PagarUsuarioMora&accion=Listar&noCarnet="+ u.getNoCarnet()).forward(request, response);
                return;
            }
            
            double pagoMora = pago - u.getRecargoMora();
            String pagoMoraExacto = df.format(pagoMora);
            u.setRecargoMora(0);
            ud.pagarRecargo(u);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "El pago se realizo con exito, tu cambio es: $" + pagoMoraExacto);
            request.getRequestDispatcher("UsuarioControlador?menu=PagarUsuarioMora&accion=Listar&noCarnet="+ u.getNoCarnet()).forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

}

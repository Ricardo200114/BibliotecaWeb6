package blb.Controlador;

import blb.Modelo.Revistas;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.RevistaDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RevistaControlador", urlPatterns = {"/RevistaControlador"})
public class RevistaControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios us;
    RevistaDao rd = new RevistaDao();
    Revistas r;
    String cId;
    
    String carnet;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        //EL CARNET SE OBTIENE DEL LOGIN AL MOMENTO DE LOGEARSE...
        carnet = request.getParameter("noCarnet");
        us = ud.consultarPorId(carnet);
        //SE MANDA EL OBJETO USUARIO AL MENU PARA MOSTRAR LOS DATOS DEL USUARIO EN LA BARRA DE NAVEGACION...
        request.setAttribute("us", us);

        if (menu.equals("Revista")) {

            switch (accion) {
                case "Listar":

                    listarRevista(request);

                    break;
                case "Registrar":

                    registrarRevista(request, response);

                    break;
                case "Editar":

                    editarRevista(request, response);

                    break;
                case "Actualizar":

                    actualizarRevista(request, response);

                    break;
                case "Eliminar":

                    eliminarRevista(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/RegistroAdmin/RegistroRevistas.jsp").forward(request, response);
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

    private void listarRevista(HttpServletRequest request) {
        try {
            List lista = rd.listarRevista();
            request.setAttribute("lista", lista);
            request.setAttribute("car",carnet);
        } catch (Exception e) {
        }
    }

    private void registrarRevista(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String periodicidad = request.getParameter("txtPeriodicidad").toUpperCase();
            String fecha = request.getParameter("txtFecha").toUpperCase();
            String tamanio = request.getParameter("txtTamanio");
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            if (!cod.matches("REV\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Revista debe de ser de la siguiente forma (REV0000)...");
                request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
                return;
            }

            if (rd.validarRepetido(cod)) {
                
                r = new Revistas(unidades,cod,titulo,editorial,isbn,periodicidad,fecha,tamanio,idioma,ubicacion);
                rd.registrarRevista(r);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Revista registrada con exito...");
                request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);

            } else {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Revista que estas tratando de ingresar ya existe ...");
                request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void editarRevista(HttpServletRequest request, HttpServletResponse response) {

        try {
            cId = request.getParameter("CodRe").toUpperCase();
            Revistas re = rd.consultarPorId(cId);
            request.setAttribute("re", re);
            request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void actualizarRevista(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String periodicidad = request.getParameter("txtPeriodicidad").toUpperCase();
            String fecha = request.getParameter("txtFecha").toUpperCase();
            String tamanio = request.getParameter("txtTamanio");
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            r = rd.consultarPorId(cod);
            
            if (!cod.matches("REV\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Revista debe de ser de la siguiente forma (REV0000)...");
                request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
                return;
            }
            
            if (r == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Revista que estas tratando de modificar no existe...");
                request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
                return;
            }

            r = new Revistas(unidades,cId,titulo,editorial,isbn,periodicidad,fecha,tamanio,idioma,ubicacion);
            rd.actualizarRevista(r);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Revista modificada con exito...");
            request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void eliminarRevista(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            cId = request.getParameter("CodRe").toUpperCase();
            rd.eliminarRevista(cId);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Revista eliminada con exito...");
            request.getRequestDispatcher("RevistaControlador?menu=Revista&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

}

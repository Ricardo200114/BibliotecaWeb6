package blb.Controlador;

import blb.Modelo.Tesis;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.TesisDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TesisControlador", urlPatterns = {"/TesisControlador"})
public class TesisControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios us;
    TesisDao td = new TesisDao();
    Tesis t = new Tesis();
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

        if (menu.equals("Tesis")) {

            switch (accion) {
                case "Listar":

                    listarTesis(request);

                    break;
                case "Registrar":

                    registrarTesis(request, response);

                    break;
                case "Editar":

                    editarTesis(request, response);

                    break;
                case "Actualizar":

                    actualizarTesis(request, response);

                    break;
                case "Eliminar":

                    eliminarTesis(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/RegistroAdmin/RegistroTesis.jsp").forward(request, response);
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

    private void listarTesis(HttpServletRequest request) {
        try {
            List lista = td.listarTesis();
            request.setAttribute("lista", lista);
            request.setAttribute("car",carnet);
        } catch (Exception e) {
        }
    }

    private void registrarTesis(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String ciudad = request.getParameter("txtCiudad").toUpperCase();
            String universidad = request.getParameter("txtUniversidad").toUpperCase();
            int noPagina = Integer.parseInt(request.getParameter("txtPagina"));
            String fecha = request.getParameter("txtFecha").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));

            if (!cod.matches("TSI\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Tesis debe de ser de la siguiente forma (TSI0000)...");
                request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
                return;
            }

            if (td.validarRepetido(cod)) {

                t = new Tesis(noPagina, unidades, cod, titulo, autor, pais, ciudad, universidad, fecha, idioma, ubicacion);
                td.registrarTesis(t);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Tesis registrada con exito...");
                request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);

            } else {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Tesis que estas tratando de registrar ya existe...");
                request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void editarTesis(HttpServletRequest request, HttpServletResponse response) {

        try {
            cId = request.getParameter("CodTs").toUpperCase();
            Tesis ts = td.consultarPorId(cId);
            request.setAttribute("ts", ts);
            request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void actualizarTesis(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String ciudad = request.getParameter("txtCiudad").toUpperCase();
            String universidad = request.getParameter("txtUniversidad").toUpperCase();
            int noPagina = Integer.parseInt(request.getParameter("txtPagina"));
            String fecha = request.getParameter("txtFecha").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            t = td.consultarPorId(cod);

            if (!cod.matches("TSI\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Tesis debe de ser de la siguiente forma (TSI0000)...");
                request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
                return;
            }
            
            if (t == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Tesis que estas tratando de modificar no existe...");
                request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
                return;
            }

            t = new Tesis(noPagina, unidades, cId, titulo, autor, pais, ciudad, universidad, fecha, idioma, ubicacion);
            td.actualizarTesis(t);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Tesis modificada con exito...");
            request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void eliminarTesis(HttpServletRequest request, HttpServletResponse response) {

        try {

            cId = request.getParameter("CodTs").toUpperCase();
            td.eliminarTesis(cId);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Tesis eliminada con exito...");
            request.getRequestDispatcher("TesisControlador?menu=Tesis&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

}

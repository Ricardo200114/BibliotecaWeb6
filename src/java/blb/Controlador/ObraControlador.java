package blb.Controlador;

import blb.Modelo.Obras;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.ObraDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ObraControlador", urlPatterns = {"/ObraControlador"})
public class ObraControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios us;
    ObraDao od = new ObraDao();
    Obras o = new Obras();
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

        if (menu.equals("Obra")) {

            switch (accion) {
                case "Listar":

                    listarObra(request);

                    break;
                case "Registrar":

                    registrarObra(request, response);

                    break;
                case "Editar":

                    editarObra(request, response);

                    break;
                case "Actualizar":

                    actualizarObra(request, response);

                    break;
                case "Eliminar":

                    eliminarObra(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/RegistroAdmin/RegistroObras.jsp").forward(request, response);
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

    private void listarObra(HttpServletRequest request) {

        try {
            List lista = od.listarObra();
            request.setAttribute("lista", lista);
            request.setAttribute("car",carnet);
        } catch (Exception e) {
        }

    }

    private void registrarObra(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            int pagina = Integer.parseInt(request.getParameter("txtPagina"));
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String anio = request.getParameter("txtAnio").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String genero = request.getParameter("txtGenero").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));

            if (!cod.matches("OBR\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Obra debe de ser de la siguiente forma (OBR0000)...");
                request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
                return;
            }

            if (od.validarRepetido(cod)) {

                o = new Obras(pagina, unidades, cod, titulo, autor, editorial, pais, isbn, anio, idioma, genero, ubicacion);
                od.registrarObra(o);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Obra registrada con exito...");
                request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);

            } else {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Obra que estas tratando de ingresar ya existe...");
                request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void editarObra(HttpServletRequest request, HttpServletResponse response) {

        try {
            cId = request.getParameter("CodOb").toUpperCase();
            Obras obr = od.consultarPorId(cId);
            request.setAttribute("ob", obr);
            request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void actualizarObra(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            int pagina = Integer.parseInt(request.getParameter("txtPagina"));
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String anio = request.getParameter("txtAnio").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String genero = request.getParameter("txtGenero").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            o = od.consultarPorId(cod);

            if (!cod.matches("OBR\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código de la Obra debe de ser de la siguiente forma (OBR0000)...");
                request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
                return;
            }
            
            if (o == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La Obra que estas tratando de modificar no existe...");
                request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
                return;
            }

            o = new Obras(pagina, unidades, cId, titulo, autor, editorial, pais, isbn, anio, idioma, genero, ubicacion);
            od.actualizarObra(o);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Obra modificada con exito...");
            request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void eliminarObra(HttpServletRequest request, HttpServletResponse response) {

        try {

            cId = request.getParameter("CodOb").toUpperCase();
            od.eliminarObra(cId);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Obra eliminada con exito...");
            request.getRequestDispatcher("ObraControlador?menu=Obra&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

}

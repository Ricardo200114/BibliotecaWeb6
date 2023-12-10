package blb.Controlador;

import blb.Modelo.Libros;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.LibroDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroControlador", urlPatterns = {"/LibroControlador"})
public class LibroControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios us;
    LibroDao ld = new LibroDao();
    Libros l = new Libros();
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

        if (menu.equals("Libro")) {

            switch (accion) {
                case "Listar":

                    listarLibro(request);

                    break;
                case "Registrar":

                    registrarLibro(request, response);

                    break;
                case "Editar":

                    editarLibro(request, response);

                    break;
                case "Actualizar":

                    actualizarLibro(request, response);

                    break;
                case "Eliminar":

                    eliminarLibro(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/RegistroAdmin/RegistroLibros.jsp").forward(request, response);

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

    private void listarLibro(HttpServletRequest request) {

        try {

            List lista = ld.listarLibro();
            request.setAttribute("lista", lista);
            request.setAttribute("car",carnet);
        } catch (Exception e) {
        }
    }

    private void registrarLibro(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            int noPagina = Integer.parseInt(request.getParameter("txtPagina"));
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String anio = request.getParameter("txtAnio").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));

            if (!cod.matches("LIB\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código del Libro debe de ser de la siguiente forma (LIB0000)...");
                request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
                return;
            }

            if (ld.validarRepetido(cod)) {

                l = new Libros(noPagina, unidades, cod, titulo, autor, editorial, pais, isbn, anio, idioma, ubicacion);
                ld.registrarLibro(l);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Libro registrado con exito...");
                request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);

            } else {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "El Libro que estas tratando de ingresar ya existe...");
                request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void editarLibro(HttpServletRequest request, HttpServletResponse response) {

        try {
            cId = request.getParameter("CodLi").toUpperCase();
            Libros li = ld.consultarPorId(cId);
            request.setAttribute("li", li);
            request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void actualizarLibro(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            int noPagina = Integer.parseInt(request.getParameter("txtPagina"));
            String editorial = request.getParameter("txtEditorial").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String isbn = request.getParameter("txtIsbn");
            String anio = request.getParameter("txtAnio").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            l = ld.consultarPorId(cod);

            if (!cod.matches("LIB\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código del Libro debe de ser de la siguiente forma (LIB0000)...");
                request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
                return;
            }
            
            if (l == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "El Libro que estas tratando de modificar no existe...");
                request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
                return;
            }
            
            l = new Libros(noPagina, unidades, cId, titulo, autor, editorial, pais, isbn, anio, idioma, ubicacion);
            ld.actualizarLibro(l);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Libro modificado con exito...");
            request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void eliminarLibro(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            cId = request.getParameter("CodLi").toUpperCase();
            ld.eliminarLibro(cId);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Libro eliminado con exito...");
            request.getRequestDispatcher("LibroControlador?menu=Libro&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

}

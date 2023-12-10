package blb.Controlador;
import blb.Modelo.Administracion;
import blb.Modelo.CDs;
import blb.Modelo.Libros;
import blb.Modelo.Obras;
import blb.Modelo.Prestamos;
import blb.Modelo.Revistas;
import blb.Modelo.Tesis;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.AdministracionDao;
import blb.ModeloDAO.CdDao;
import blb.ModeloDAO.LibroDao;
import blb.ModeloDAO.ObraDao;
import blb.ModeloDAO.PrestamoDao;
import blb.ModeloDAO.RevistaDao;
import blb.ModeloDAO.TesisDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultarUsuarios", urlPatterns = {"/ConsultarUsuarios"})
public class ConsultarUsuarios extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    LibroDao ld = new LibroDao();
    ObraDao od = new ObraDao();
    RevistaDao rd = new RevistaDao();
    CdDao cd = new CdDao();
    TesisDao td = new TesisDao();
    PrestamoDao pd = new PrestamoDao();
    AdministracionDao ad = new AdministracionDao();

    Usuarios us;
    Libros li;
    Obras ob;
    Revistas re;
    CDs cds;
    Tesis ts;
    Administracion a;
    Prestamos p;

    String carnet;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Menu")) {
            request.getRequestDispatcher("MenuConsultar.jsp").forward(request, response);
        } else if (menu.equals("ConsultarLib")) {

            switch (accion) {
                case "Listar":

                    listarLibro(request);
                    request.getRequestDispatcher("/ConsultarUsuario/ConsultarLibros.jsp").forward(request, response);

                    break;
                case "Buscar":

                    consultarLibro(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

        } else if (menu.equals("ConsultarObr")) {

            switch (accion) {
                case "Listar":

                    listarObra(request);
                    request.getRequestDispatcher("/ConsultarUsuario/ConsultarObras.jsp").forward(request, response);

                    break;
                case "Buscar":

                    consultarObra(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

        } else if (menu.equals("ConsultarRev")) {

            switch (accion) {
                case "Listar":

                    listarRevista(request);
                    request.getRequestDispatcher("/ConsultarUsuario/ConsultarRevistas.jsp").forward(request, response);

                    break;
                case "Buscar":

                    consultarRevista(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

        } else if (menu.equals("ConsultarCds")) {

            switch (accion) {
                case "Listar":

                    listarCd(request);
                    request.getRequestDispatcher("/ConsultarUsuario/ConsultarCds.jsp").forward(request, response);

                    break;
                case "Buscar":

                    consultarCd(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

        } else if (menu.equals("ConsultarTsi")) {

            switch (accion) {
                case "Listar":

                    listarTesis(request);
                    request.getRequestDispatcher("/ConsultarUsuario/ConsultarTesis.jsp").forward(request, response);

                    break;
                case "Buscar":

                    consultarTesis(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

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
        } catch (Exception e) {
        }
    }

    private void consultarLibro(HttpServletRequest request, HttpServletResponse response) {
        try {

            String texto = request.getParameter("texto").toUpperCase();

            List lista = ld.buscarLibro(texto);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/ConsultarUsuario/ConsultarLibros.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
        }
    }

    private void listarObra(HttpServletRequest request) {
        try {
            List lista = od.listarObra();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void consultarObra(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String texto = request.getParameter("texto").toUpperCase();

            List lista = od.buscarObra(texto);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/ConsultarUsuario/ConsultarObras.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void listarRevista(HttpServletRequest request) {
        try {
            List lista = rd.listarRevista();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void consultarRevista(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String texto = request.getParameter("texto").toUpperCase();

            List lista = rd.buscarRevista(texto);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/ConsultarUsuario/ConsultarRevistas.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void listarCd(HttpServletRequest request) {
        try {
            List lista = cd.listarCds();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void consultarCd(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String texto = request.getParameter("texto").toUpperCase();

            List lista = cd.buscarCds(texto);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/ConsultarUsuario/ConsultarCds.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

    private void listarTesis(HttpServletRequest request) {
        try {
            List lista = td.listarTesis();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void consultarTesis(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String texto = request.getParameter("texto").toUpperCase();

            List lista = td.buscarTesis(texto);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/ConsultarUsuario/ConsultarTesis.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }

}

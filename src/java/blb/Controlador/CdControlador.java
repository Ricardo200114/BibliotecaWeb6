package blb.Controlador;

import blb.Modelo.CDs;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.CdDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CdControlador", urlPatterns = {"/CdControlador"})
public class CdControlador extends HttpServlet {

    UsuarioDao ud = new UsuarioDao();
    Usuarios us;
    CdDao cd = new CdDao();
    CDs c = new CDs();
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

        if (menu.equals("CD")) {

            switch (accion) {
                case "Listar":

                    listarCd(request);

                    break;
                case "Registrar":

                    registrarCd(request, response);

                    break;
                case "Editar":
                    
                    editarCd(request, response);

                    break;
                case "Actualizar":
                    
                    actualizarCd(request, response);

                    break;
                case "Eliminar":
                    
                    eliminarCd(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/RegistroAdmin/RegistroCds.jsp").forward(request, response);

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

    private void listarCd(HttpServletRequest request) {

        try {

            List lista = cd.listarCds();
            request.setAttribute("lista", lista);
            request.setAttribute("car",carnet);
        } catch (Exception e) {
        }

    }

    private void registrarCd(HttpServletRequest request, HttpServletResponse response) {

        try {

            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String anio = request.getParameter("txtAnio").toUpperCase();
            String volumen = request.getParameter("txtVolumen").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String genero = request.getParameter("txtGenero").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            if (!cod.matches("CDA\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código del CD debe de ser de la siguiente forma (CDA0000)...");
                request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
                return;
            }

            if (cd.validarRepetido(cod)) {
                
                c = new CDs(unidades,cod,titulo,autor,pais,anio,volumen,idioma,genero,ubicacion);
                cd.registrarCds(c);

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "CD registrado con exito...");
                request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);

            } else {

                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "El CD que estas tratando de registrar ya existe...");
                request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
        }

    }

    private void editarCd(HttpServletRequest request, HttpServletResponse response) {

        try {
            
            cId = request.getParameter("CodCd").toUpperCase();
            CDs cds = cd.consultarPorId(cId);
            request.setAttribute("cds", cds);
            request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
        } catch (Exception e) {
        }
    }
    
    private void actualizarCd(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            String cod = request.getParameter("txtCod").toUpperCase();
            String titulo = request.getParameter("txtTitulo").toUpperCase();
            String autor = request.getParameter("txtAutor").toUpperCase();
            String pais = request.getParameter("txtPais").toUpperCase();
            String anio = request.getParameter("txtAnio").toUpperCase();
            String volumen = request.getParameter("txtVolumen").toUpperCase();
            String idioma = request.getParameter("txtIdioma").toUpperCase();
            String genero = request.getParameter("txtGenero").toUpperCase();
            String ubicacion = request.getParameter("txtUbicacion").toUpperCase();
            int unidades = Integer.parseInt(request.getParameter("txtUnidad"));
            
            c = cd.consultarPorId(cod);
            
            if (!cod.matches("CDA\\d{4}")) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código del CD debe de ser de la siguiente forma (CDA0000)...");
                request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
                return;
            }
            
            if (c == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "El CD que estas tratando de modificar no existe...");
                request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
                return;
            }
            
            c = new CDs(unidades,cId,titulo,autor,pais,anio,volumen,idioma,genero,ubicacion);
            cd.actualizarCd(c);
            
            request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "CD modificado con exito...");
            request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }
    
    private void eliminarCd(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            cId = request.getParameter("CodCd").toUpperCase();
            cd.eliminarCd(cId);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "CD eliminado con exito...");
            request.getRequestDispatcher("CdControlador?menu=CD&accion=Listar").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }
}

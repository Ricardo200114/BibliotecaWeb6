package blb.Controlador;

import blb.Modelo.Administracion;
import blb.Modelo.Usuarios;
import blb.ModeloDAO.AdministracionDao;
import blb.ModeloDAO.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdministracionControlador", urlPatterns = {"/AdministracionControlador"})
public class AdministracionControlador extends HttpServlet {
    
    UsuarioDao ud = new UsuarioDao();
    Usuarios us = new Usuarios();
    AdministracionDao ad = new AdministracionDao();
    Administracion a;
    
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

        if (menu.equals("Actualizar")) {

            switch (accion) {

                case "Actualizar":
                    
                    cargarDatos(request, response);

                    break;
                case "Actualizar Estudiante":
                    
                    actualizarEstudiante(request, response);

                    break;
                case "Actualizar Profesor":
                    
                    actualizarProfesor(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("/Usuario/ActualizarAdministracion.jsp").forward(request, response);
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

    private void cargarDatos(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            a = ad.consultarAdmin();
            request.setAttribute("admin", a);
            request.getRequestDispatcher("/Usuario/ActualizarAdministracion.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
        }
    }
    
    private void actualizarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nCar = request.getParameter("noCarnet");
            int diaEstudiante = Integer.parseInt(request.getParameter("txtDia"));
            int materialEstudiante = Integer.parseInt(request.getParameter("txtMaterial"));
            double moraEstudiante = Double.parseDouble(request.getParameter("txtMora"));
            
            a.setDiaEstudiante(diaEstudiante);
            a.setMaterialEstudiante(materialEstudiante);
            a.setMoraEstudiante(moraEstudiante);
            ad.actualizarAdministracionEstudiante(a);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "La informacion ha sido actualizada con exito...");
            request.getRequestDispatcher("AdministracionControlador?accion=Actualizar&noCarnet=" + nCar).forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

    private void actualizarProfesor(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nCar = request.getParameter("noCarnet");
            int diaProfesor = Integer.parseInt(request.getParameter("txtDia"));
            int materialProfesor = Integer.parseInt(request.getParameter("txtMaterial"));
            double moraProfesor = Double.parseDouble(request.getParameter("txtMora"));
            
            a.setDiaProfesor(diaProfesor);
            a.setMaterialProfesor(materialProfesor);
            a.setMoraProfesor(moraProfesor);
            ad.actualizarAdministracionProfesor(a);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "La informacion ha sido actualizada con exito...");
            request.getRequestDispatcher("AdministracionControlador?accion=Actualizar&noCarnet=" + nCar).forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
        }
    }

}

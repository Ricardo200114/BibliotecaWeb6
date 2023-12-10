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
import blb.Validaciones.Validaciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PrestarUsuarios", urlPatterns = {"/PrestarUsuarios"})
public class PrestarUsuarios extends HttpServlet {
    
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
        
        //EL CARNET SE OBTIENE DEL LOGIN AL MOMENTO DE LOGEARSE...
        carnet = request.getParameter("noCarnet");
        us = ud.consultarPorId(carnet);
        //SE MANDA EL OBJETO USUARIO AL MENU PARA MOSTRAR LOS DATOS DEL USUARIO EN LA BARRA DE NAVEGACION...
        request.setAttribute("us", us);
        
        
        if (menu.equals("Menu")) {
            
            request.getRequestDispatcher("Menu.jsp").forward(request, response);
        } 
        
        else if (menu.equals("PrestarLib")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);

            switch (accion) {
                case "Listar":
                    
                    listarLibro(request);

                    break;
                case "Prestar":
                    
                    prestarLibro(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/PrestarUsuario/PrestarLibros.jsp").forward(request, response);

        } 
        
        else if (menu.equals("PrestarObr")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);

            switch (accion) {
                case "Listar":

                    listarObra(request);

                    break;
                case "Prestar":

                    prestarObra(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/PrestarUsuario/PrestarObras.jsp").forward(request, response);

        } 
        
        else if (menu.equals("PrestarRev")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);

            switch (accion) {
                case "Listar":
                    
                    listarRevista(request);

                    break;
                case "Prestar":
                    
                    prestarRevista(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/PrestarUsuario/PrestarRevistas.jsp").forward(request, response);

        } 
        
        else if (menu.equals("PrestarCds")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);

            switch (accion) {
                case "Listar":
                    
                    listarCd(request);
                    
                    break;
                case "Prestar":
                    
                    prestarCd(request, response);
                    
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/PrestarUsuario/PrestarCds.jsp").forward(request, response);

        } else if (menu.equals("PrestarTsi")) {
            
            String noCarnet = request.getParameter("noCarnet");
            request.setAttribute("c", noCarnet);

            switch (accion) {
                case "Listar":
                    
                    listarTesis(request);
                    
                    break;
                case "Prestar":
                    
                    prestarTesis(request, response);
                    
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/PrestarUsuario/PrestarTesis.jsp").forward(request, response);

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

    private void prestarLibro(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            
            String codLib = request.getParameter("txtCod").toUpperCase();
            String nCarnet = request.getParameter("txtCarnet");  
            
            us = ud.consultarPorId(nCarnet);
            li = ld.consultarPorId(codLib);
            a = ad.consultarAdmin();
            
            if (li == null) {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro Libro con código " + codLib);
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            if (li.getUnidades() < 1) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El Libro que intentas prestar no esta disponible...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            Prestamos pActual = pd.prestamoActualLibro(us, li);
            
            if (pActual != null) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Ya prestaste este Libro, debes de prestar uno diferente...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            if (us.getOficio().equals("ESTUDIANTE") && pd.cantidadPrestamos(us) >= a.getMaterialEstudiante()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialEstudiante() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("PROFESOR") && pd.cantidadPrestamos(us) >= a.getMaterialProfesor()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialProfesor() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getRecargoMora() != 0) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento tienes un recargo por $" + us.getRecargoMora() + ", debes cancelar el recargo para poder volver a prestar...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            int idUser = us.getId();
            int idLib = li.getId();
            
            String nombre = us.getNombre() + " " + us.getApellido();
            String cod = li.getCodLib();
            String material = li.getTitulo();
            java.sql.Date fecha = Validaciones.fecha();
            p = new Prestamos(idUser, idLib, 0, 0, 0, 0, nCarnet, nombre, cod, material, fecha);
            pd.registrarPrestamoLibro(p);
            
            li.setUnidades(li.getUnidades() - 1);
            ld.actualizarLibro(li);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Libro prestado con exito");
            request.getRequestDispatcher("PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
        
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

    private void prestarObra(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String codObr = request.getParameter("txtCod").toUpperCase();
            String nCarnet = request.getParameter("txtCarnet");  
            
            us = ud.consultarPorId(nCarnet);
            ob = od.consultarPorId(codObr);
            a = ad.consultarAdmin();
            
            if (ob == null) {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro Obra con código " + codObr);
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            if (ob.getUnidades() < 1) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "La Obra que intentas prestar no esta disponible...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            Prestamos pActual = pd.prestamoActualObra(us, ob);
            
            if (pActual != null) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Ya prestaste esta Obra, debes de prestar uno diferente...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            if (us.getOficio().equals("ESTUDIANTE") && pd.cantidadPrestamos(us) >= a.getMaterialEstudiante()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialEstudiante() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("PROFESOR") && pd.cantidadPrestamos(us) >= a.getMaterialProfesor()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialProfesor() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getRecargoMora() != 0) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento tienes un recargo por $" + us.getRecargoMora() + ", debes cancelar el recargo para poder volver a prestar...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            int idUser = us.getId();
            int idObr = ob.getId();
            
            String nombre = us.getNombre() + " " + us.getApellido();
            String cod = ob.getCodOb();
            String material = ob.getTitulo();
            java.sql.Date fecha = Validaciones.fecha();
            p = new Prestamos(idUser, 0, 0, idObr, 0, 0, nCarnet, nombre, cod, material, fecha);
            pd.registrarPrestamoObra(p);

            ob.setUnidades(ob.getUnidades() - 1);
            od.actualizarObra(ob);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Obra prestada con exito");
            request.getRequestDispatcher("PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
            
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

    private void prestarRevista(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nCarnet = request.getParameter("txtCarnet").toUpperCase();
            String codRev = request.getParameter("txtCod").toUpperCase();
            
            us = ud.consultarPorId(nCarnet);
            re = rd.consultarPorId(codRev);
            a = ad.consultarAdmin();
            
            if (re == null) {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro Revista con código " + codRev);
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (re.getUnidades() < 1) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "La Revista que intentas prestar no esta disponible...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            Prestamos pActual = pd.prestamoActualRevista(us, re);
            
            if (pActual != null) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Ya prestaste esta Revista, debes de prestar uno diferente...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("ESTUDIANTE") && pd.cantidadPrestamos(us) >= a.getMaterialEstudiante()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialEstudiante() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("PROFESOR") && pd.cantidadPrestamos(us) >= a.getMaterialProfesor()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialProfesor() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getRecargoMora() != 0) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento tienes un recargo por $" + us.getRecargoMora() + ", debes cancelar el recargo para poder volver a prestar...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            int idUser = us.getId();
            int idRev = re.getId();
            
            String nombre = us.getNombre() + " " + us.getApellido();
            String cod = re.getCodRe();
            String material = re.getTitulo();
            java.sql.Date fecha = Validaciones.fecha();
            p = new Prestamos(idUser, 0, 0, 0, idRev, 0, nCarnet, nombre, cod, material, fecha);
            pd.registrarPrestamoRevista(p);

            re.setUnidades(re.getUnidades() - 1);
            rd.actualizarRevista(re);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Revista prestada con exito");
            request.getRequestDispatcher("PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
            
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

    private void prestarCd(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nCarnet = request.getParameter("txtCarnet").toUpperCase();
            String codCds = request.getParameter("txtCod").toUpperCase();
            
            us = ud.consultarPorId(nCarnet);
            cds = cd.consultarPorId(codCds);
            a = ad.consultarAdmin();
            
            if (cds == null) {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro CD con código " + codCds);
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (cds.getUnidades() < 1) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El CD que intentas prestar no esta disponible...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            Prestamos pActual = pd.prestamoActualCd(us, cds);
            
            if (pActual != null) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Ya prestaste este CD, debes de prestar uno diferente...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("ESTUDIANTE") && pd.cantidadPrestamos(us) >= a.getMaterialEstudiante()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialEstudiante() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("PROFESOR") && pd.cantidadPrestamos(us) >= a.getMaterialProfesor()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialProfesor() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getRecargoMora() != 0) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento tienes un recargo por $" + us.getRecargoMora() + ", debes cancelar el recargo para poder volver a prestar...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            int idUser = us.getId();
            int idCds = cds.getId();
            
            String nombre = us.getNombre() + " " + us.getApellido();
            String cod = cds.getCodCd();
            String material = cds.getTitulo();
            java.sql.Date fecha = Validaciones.fecha();
            p = new Prestamos(idUser,0,idCds,0,0,0,nCarnet,nombre,cod,material,fecha);
            pd.registrarPrestamoCd(p);

            cds.setUnidades(cds.getUnidades() - 1);
            cd.actualizarCd(cds);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "CD prestado con exito");
            request.getRequestDispatcher("PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
            
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

    private void prestarTesis(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nCarnet = request.getParameter("txtCarnet").toUpperCase();
            String codTsi = request.getParameter("txtCod").toUpperCase();
            
            us = ud.consultarPorId(nCarnet);
            ts = td.consultarPorId(codTsi);
            a = ad.consultarAdmin();
            
            if (ts == null) {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontro Tesis con código " + codTsi);
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (ts.getUnidades() < 1) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "La Tesis que intentas prestar no esta disponible...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            Prestamos pActual = pd.prestamoActualTesis(us, ts);
            
            if (pActual != null) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Ya prestaste esta Tesis, debes de prestar uno diferente...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("ESTUDIANTE") && pd.cantidadPrestamos(us) >= a.getMaterialEstudiante()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialEstudiante() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getOficio().equals("PROFESOR") && pd.cantidadPrestamos(us) >= a.getMaterialProfesor()) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento solo tienes permitido prestar " + a.getMaterialProfesor() + " materiales maximos...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }

            if (us.getRecargoMora() != 0) {
                
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "Lo siento tienes un recargo por $" + us.getRecargoMora() + ", debes cancelar el recargo para poder volver a prestar...");
                request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
                return;
            }
            
            int idUser = us.getId();
            int idTsi = ts.getId();
            
            String nombre = us.getNombre() + " " + us.getApellido();
            String cod = ts.getCodTs();
            String material = ts.getTitulo();
            java.sql.Date fecha = Validaciones.fecha();
            p = new Prestamos(idUser,0,0,0,0,idTsi,nCarnet,nombre,cod,material,fecha);
            pd.registrarPrestamoTesis(p);

            ts.setUnidades(ts.getUnidades() - 1);
            td.actualizarTesis(ts);
            
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Tesis prestada con exito");
            request.getRequestDispatcher("PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet="+ us.getNoCarnet()).forward(request, response);
            
        } catch (IOException | ServletException e) {
        }
    }

}

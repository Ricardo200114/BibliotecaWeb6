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
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DevolverControlador", urlPatterns = {"/DevolverControlador"})
public class DevolverControlador extends HttpServlet {

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

        if (menu.equals("Devolver")) {

            switch (accion) {
                case "Listar":

                    listarMaterial(request);

                    break;
                case "Devolver":

                    devolverMaterial(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/DevolverAdmin/DevolverMaterial.jsp").forward(request, response);

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

    private void listarMaterial(HttpServletRequest request) {
        try {
            List lista = pd.listarPrestamo();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
        }
    }

    private void devolverMaterial(HttpServletRequest request, HttpServletResponse response) {
        
        String nCar = request.getParameter("noCarnet").toUpperCase();
        String noCarnet = request.getParameter("txtCarnet").toUpperCase();
        String codMaterial = request.getParameter("txtCod").toUpperCase();

        us = ud.consultarPorId(noCarnet);
        a = ad.consultarAdmin();
        
        try {

    //---SE EVALUA PRIMERO SI EL USUARIO EXISTE EN LA BASE DE DATOS----        
            if (us == null) {
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "No se encontró el usuario con No Carnet " + noCarnet);
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar&noCarnet=" + nCar).forward(request, response);
                return;
            }

            
    //---ESTA PARTE EVALUA SI EL MATERIAL A DEVOLVER ES UN LIBRO----
            if (codMaterial.matches("LIB\\d{4}")) {
                
                li = ld.consultarPorId(codMaterial);

                if (li == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el libro con código " + codMaterial);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }

                p = pd.prestamoActualLibro(us, li);

                if (p == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el préstamo que estas tratando de devolver...");
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p.setF_devolucion(Validaciones.fecha());
                pd.modificarDevolucionLibro(p);
                
                li.setUnidades(li.getUnidades() + 1);
                ld.actualizarLibro(li);
                
                int dias = Validaciones.calcularDias(p.getF_prestamo(), Validaciones.fecha());
               
                if (us.getOficio().equals("ESTUDIANTE") && dias > a.getDiaEstudiante()) {
                    
                    int dia_retraso = dias - a.getDiaEstudiante();
                    double recargo = dia_retraso * a.getMoraEstudiante();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                if (us.getOficio().equals("PROFESOR") && dias > a.getDiaProfesor()) {
                    
                    int dia_retraso = dias - a.getDiaProfesor();
                    double recargo = dia_retraso * a.getMoraProfesor();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }

                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Material devuelto con exito...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);              

            }
            
            
    //---ESTA PARTE EVALUA SI EL MATERIAL A DEVOLVER ES UNA OBRA----        
            else if (codMaterial.matches("OBR\\d{4}")){
                
                ob = od.consultarPorId(codMaterial);

                if (ob == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el obra con código " + ob.getCodOb());
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p = pd.prestamoActualObra(us, ob);
                
                if (p == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el préstamo que estas tratando de devolver...");
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p.setF_devolucion(Validaciones.fecha());
                pd.modificarDevolucionObra(p);
                
                ob.setUnidades(ob.getUnidades() + 1);
                od.actualizarObra(ob);
                
                int dias = Validaciones.calcularDias(p.getF_prestamo(), Validaciones.fecha());
               
                if (us.getOficio().equals("ESTUDIANTE") && dias > a.getDiaEstudiante()) {
                    
                    int dia_retraso = dias - a.getDiaEstudiante();
                    double recargo = dia_retraso * a.getMoraEstudiante();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                if (us.getOficio().equals("PROFESOR") && dias > a.getDiaProfesor()) {
                    
                    int dia_retraso = dias - a.getDiaProfesor();
                    double recargo = dia_retraso * a.getMoraProfesor();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Material devuelto con exito...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);                
                
            }
      
            
    //---ESTA PARTE EVALUA SI EL MATERIAL A DEVOLVER ES UN CD----        
            else if (codMaterial.matches("CDA\\d{4}")){
                
                cds = cd.consultarPorId(codMaterial);

                if (cds == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el CD con código " + cds.getCodCd());
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p = pd.prestamoActualCd(us, cds);
                
                if (p == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el préstamo que estas tratando de devolver...");
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p.setF_devolucion(Validaciones.fecha());
                pd.modificarDevolucionCd(p);
                
                cds.setUnidades(cds.getUnidades() + 1);
                cd.actualizarCd(cds);
                
                int dias = Validaciones.calcularDias(p.getF_prestamo(), Validaciones.fecha());
               
                if (us.getOficio().equals("ESTUDIANTE") && dias > a.getDiaEstudiante()) {
                    
                    int dia_retraso = dias - a.getDiaEstudiante();
                    double recargo = dia_retraso * a.getMoraEstudiante();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                if (us.getOficio().equals("PROFESOR") && dias > a.getDiaProfesor()) {
                    
                    int dia_retraso = dias - a.getDiaProfesor();
                    double recargo = dia_retraso * a.getMoraProfesor();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Material devuelto con exito...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);                
                
            }
                 
             
    //---ESTA PARTE EVALUA SI EL MATERIAL A DEVOLVER ES UNA REVISTA----        
            else if (codMaterial.matches("REV\\d{4}")) {
                
                re = rd.consultarPorId(codMaterial);

                if (re == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el Revista con código " + re.getCodRe());
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p = pd.prestamoActualRevista(us, re);
                
                if (p == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el préstamo que estas tratando de devolver...");
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p.setF_devolucion(Validaciones.fecha());
                pd.modificarDevolucionRevista(p);
                
                re.setUnidades(re.getUnidades() + 1);
                rd.actualizarRevista(re);
                
                int dias = Validaciones.calcularDias(p.getF_prestamo(), Validaciones.fecha());
               
                if (us.getOficio().equals("ESTUDIANTE") && dias > a.getDiaEstudiante()) {
                    
                    int dia_retraso = dias - a.getDiaEstudiante();
                    double recargo = dia_retraso * a.getMoraEstudiante();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                if (us.getOficio().equals("PROFESOR") && dias > a.getDiaProfesor()) {
                    
                    int dia_retraso = dias - a.getDiaProfesor();
                    double recargo = dia_retraso * a.getMoraProfesor();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Material devuelto con exito...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);                           
                
            }
            
            
    //---ESTA PARTE EVALUA SI EL MATERIAL A DEVOLVER ES UNA TESIS----                
            else if (codMaterial.matches("TSI\\d{4}")) {
                
                ts = td.consultarPorId(codMaterial);
                
                if (ts == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el Tesis con código " + ts.getCodTs());
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p = pd.prestamoActualTesis(us, ts);
                
                if (p == null) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "No se encontro el préstamo que estas tratando de devolver...");
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                    return;
                }
                
                p.setF_devolucion(Validaciones.fecha());
                pd.modificarDevolucionTesis(p);
                
                ts.setUnidades(ts.getUnidades() + 1);
                td.actualizarTesis(ts);
                
                int dias = Validaciones.calcularDias(p.getF_prestamo(), Validaciones.fecha());
               
                if (us.getOficio().equals("ESTUDIANTE") && dias > a.getDiaEstudiante()) {
                    
                    int dia_retraso = dias - a.getDiaEstudiante();
                    double recargo = dia_retraso * a.getMoraEstudiante();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warining");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                if (us.getOficio().equals("PROFESOR") && dias > a.getDiaProfesor()) {
                    
                    int dia_retraso = dias - a.getDiaProfesor();
                    double recargo = dia_retraso * a.getMoraProfesor();
                    
                    us.setRecargoMora(us.getRecargoMora() + recargo);
                    ud.sancionar(us);
                    request.setAttribute("config", "alert alert-warining");
                    request.setAttribute("mensaje", "Material devuelto con exito, se ha aplicado recargo por devolución tardía el total a pagar es: $" + recargo);
                    request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);
                }
                
                request.setAttribute("config", "alert alert-success");
                request.setAttribute("mensaje", "Material devuelto con exito...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);                                    
                
            }
    
            
    //---SI EL CODIGO DEL MATERIAL A DEVOLVER NO COINCIDE CON NINGUNA DE LAS OPCIONES ENTONCES MENSAJE DE ERROR APARCE----        
            else {
                request.setAttribute("config", "alert alert-warning");
                request.setAttribute("mensaje", "El código del material a devolver es incorrecto...");
                request.getRequestDispatcher("DevolverControlador?menu=Devolver&accion=Listar").forward(request, response);

            }

        } catch (IOException | ParseException | ServletException e) {
        }
    }

}

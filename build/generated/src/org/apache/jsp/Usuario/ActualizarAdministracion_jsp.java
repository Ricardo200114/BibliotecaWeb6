package org.apache.jsp.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ActualizarAdministracion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Resources/style.css\">\n");
      out.write("        <script src=\"Resources/script.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Biblioteca UDB</title>\n");
      out.write("        <script>\n");
      out.write("            setTimeout(function () {\n");
      out.write("                document.getElementById(\"msj\").style.display = \"none\";\n");
      out.write("            }, 4000);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-info\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"PrestarControlador?menu=Menu&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">BibliotecaUDB</a>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                            Prestar Material\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarControlador?menu=PrestarLib&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Libros</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarControlador?menu=PrestarObr&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Obras</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarControlador?menu=PrestarRev&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Revistas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarControlador?menu=PrestarCds&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">CDs</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarControlador?menu=PrestarTsi&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Tesis</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"DevolverControlador?menu=Devolver&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Devolver Material</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"AdministracionControlador?menu=Actualizar&accion=Actualizar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Actualizar Préstamos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"UsuarioControlador?menu=PagarMora&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Pagar Recargo</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"UsuarioControlador?menu=Usuario&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Registrar Usuario</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                            Registrar Material\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"LibroControlador?menu=Libro&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Libros</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ObraControlador?menu=Obra&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Obras</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"RevistaControlador?menu=Revista&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Revistas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"CdControlador?menu=CD&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">CDs</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"TesisControlador?menu=Tesis&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Tesis</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <button style=\"border: none\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNombre().toUpperCase()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getApellido().toUpperCase()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </button>\n");
      out.write("                <div class=\"dropdown-menu text-center\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                        <img src=\"Resources/images/user1.png\" alt=\"60\" width=\"60\"/>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getUsername().toUpperCase()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet().toUpperCase()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <form action=\"LoginControlador\" method=\"POST\">\n");
      out.write("                        <button name=\"accion\" value=\"Salir\" class=\"dropdown-item\">Salir</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <h3 class=\"text-center m-4\">Formulario de Administración</h3>\n");
      out.write("\n");
      out.write("        <div id=\"msj\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${config}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container d-flex parametros\">\n");
      out.write("\n");
      out.write("            <div class=\"card col-sm-6 custom-margin\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"AdministracionControlador?menu=Actualizar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Día límite de estudiantes:</label>\n");
      out.write("                            <input type=\"number\" name=\"txtDia\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getDiaEstudiante()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cantidad de materiales estudiantes:</label>\n");
      out.write("                            <input type=\"number\" name=\"txtMaterial\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getMaterialEstudiante()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cantidad de recargo mora estudiantes:</label>\n");
      out.write("                            <input type=\"number\" step=\"0.01\" name=\"txtMora\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getMoraEstudiante()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" name=\"accion\" value=\"Actualizar Estudiante\" class=\"btn btn-info\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card col-sm-6\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"AdministracionControlador?menu=Actualizar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Día límite de profesores:</label>\n");
      out.write("                            <input type=\"number\" name=\"txtDia\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getDiaProfesor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cantidad de materiales profesores:</label>\n");
      out.write("                            <input type=\"number\" name=\"txtMaterial\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getMaterialProfesor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cantidad de recargo mora profesores:</label>\n");
      out.write("                            <input type=\"number\" step=\"0.01\" name=\"txtMora\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.getMoraProfesor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" name=\"accion\" value=\"Actualizar Profesor\" class=\"btn btn-info\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

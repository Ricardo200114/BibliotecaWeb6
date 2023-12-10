package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Resources/style2.css\">\n");
      out.write("        <script src=\"Resources/script.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Biblioteca UDB</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"menu\">\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-info\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"PrestarUsuarios?menu=Menu&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">BibliotecaUDB</a>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light dropdown-toggle\" href=\"\" role=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                            Prestar Material\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Libros</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Obras</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Revistas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">CDs</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Tesis</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"DevolverUsuarios?menu=Devolver&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Devolver Material</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"UsuarioControlador?menu=PagarUsuarioMora&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Pagar Recargo</a>\n");
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
      out.write("                </div>           \n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"shadow\">\n");
      out.write("            <div class=\"container py-5\">\n");
      out.write("                <div class=\"abc\"><h3 class=\"text-center mb-5 text-white\" style=\" font-weight: bold;\">Prestar Materiales:</h3></div>\n");
      out.write("                <div class=\"row text-center abc\">\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/libros.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"PrestarUsuarios?menu=PrestarLib&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    LIBROS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/obras.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"PrestarUsuarios?menu=PrestarObr&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    OBRAS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/revistas.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"PrestarUsuarios?menu=PrestarRev&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    REVISTAS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/cds.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"PrestarUsuarios?menu=PrestarCds&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    CDS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/tesis.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"PrestarUsuarios?menu=PrestarTsi&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    TESIS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>               \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"titulo\"><h3 class=\"text-center mb-5 text-white\" style=\" font-weight: bold;\">Otros:</h3></div>\n");
      out.write("                <div class=\"row text-center\">\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/regresar.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"DevolverUsuarios?menu=Devolver&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    DEVOLVER MATERIAL\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/pagar.jpg\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"UsuarioControlador?menu=PagarUsuarioMora&accion=Listar&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    PAGAR RECARGO\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
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

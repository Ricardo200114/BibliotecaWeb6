package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuConsultar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("      <img src=\"Resources/images/udb.png\" alt=\"\" width=\"40\" height=\"34\">\n");
      out.write("    </a>\n");
      out.write("            <a class=\"navbar-brand\" href=\"ConsultarUsuarios?menu=Menu\">BIENVENIDO A TU BIBLIOTECA UDB</a>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light dropdown-toggle\" href=\"\" role=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                            Consultar Material\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ConsultarUsuarios?menu=ConsultarLib&accion=Listar\">Libros</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ConsultarUsuarios?menu=ConsultarObr&accion=Listar\">Obras</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ConsultarUsuarios?menu=ConsultarRev&accion=Listar\">Revistas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ConsultarUsuarios?menu=ConsultarCds&accion=Listar\">CD's</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ConsultarUsuarios?menu=ConsultarTsi&accion=Listar\">Tesis</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <li class=\"nav-item active\" style=\"list-style: none ;\">\n");
      out.write("                    <a style=\"margin-left: 10px; border: none;\" class=\"btn btn-outline-light\" href=\"login.jsp\">Iniciar Sesión</a>\n");
      out.write("                </li>       \n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"shadow\">\n");
      out.write("\n");
      out.write("            <div class=\"container py-5\">\n");
      out.write("                <div class=\"abc\"><h2 class=\"text-center mb-3 text-white\" style=\" font-weight: bold;\">Bienvenido al menú de Consultas</h2></div>\n");
      out.write("                <div class=\"abc\"><h5 class=\"text-center mb-5 text-white\" style=\" font-weight: bold;\">Selecciona el material que deseas consultar:</h5></div>\n");
      out.write("                <div class=\"row text-center abc\">\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/pila-de-libros.png\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"ConsultarUsuarios?menu=ConsultarLib&accion=Listar\">\n");
      out.write("                                    LIBROS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/libro.png\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"ConsultarUsuarios?menu=ConsultarObr&accion=Listar\">\n");
      out.write("                                    OBRAS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/revista.png\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"ConsultarUsuarios?menu=ConsultarRev&accion=Listar\">\n");
      out.write("                                    REVISTAS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/disco-de-vinilo.png\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"ConsultarUsuarios?menu=ConsultarCds&accion=Listar\">\n");
      out.write("                                    CDS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <figure>\n");
      out.write("                                <img class=\"imagen\" src=\"Resources/images/tesisgra.png\">\n");
      out.write("                            </figure>\n");
      out.write("                            <div class=\"contenido d-grid\">\n");
      out.write("                                <a href=\"ConsultarUsuarios?menu=ConsultarTsi&accion=Listar\">\n");
      out.write("                                    TESIS\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>               \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <footer class=\"bg-dark text-light text-center p-3\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <p>&copy; 2023 BIBLIOTECA UDB. \n");
      out.write("          <br>\n");
      out.write("          Todos los derechos reservados.</p>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-yGBVx2Jd8hRyi6LOaxwn4I6TXm2DOHPh6aOW9uL9H6EGgoDZvR8GBCYzSHcceNXP\" crossorigin=\"anonymous\"></script>\n");
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

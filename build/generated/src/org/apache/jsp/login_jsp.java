package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Resources/style.css\">\n");
      out.write("        <script src=\"Resources/script.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Inicio de sesión</title>\n");
      out.write("        <script>\n");
      out.write("            setTimeout(function () {\n");
      out.write("                document.getElementById(\"msj\").style.display = \"none\";\n");
      out.write("            }, 4000);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"msj\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${config}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"container main\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6 side-image\">\n");
      out.write("                        <div class=\"d-flex flex-column justify-content-center align-items-center h-100\">\n");
      out.write("                            <div class=\"text text-center\">\n");
      out.write("                                <p>\"Viviendo la experiencia<br>virtual\"</p> \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 right\">\n");
      out.write("                         <div class=\"input-box\">\n");
      out.write("                             <header><h2 class=\"fw-bold\">Bienvenido a tu biblioteca web</h2></header>\n");
      out.write("                            <form class=\"form-sing\" action=\"/BibliotecaWeb6/LoginControlador\" method=\"post\">\n");
      out.write("                                <div class=\"form-group text-center\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Username:</label>\n");
      out.write("                                    <input type=\"text\" name=\"txtuser\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Contraseña:</label>\n");
      out.write("                                    <input type=\"password\" name=\"txtpass\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Ingresar\" class=\"btn btn-dark btn-block\">\n");
      out.write("                            </form>\n");
      out.write("                            <div class=\"signin\">\n");
      out.write("                                <label>¿Haz olvidado tu contraseña?</label>\n");
      out.write("                                <br>\n");
      out.write("                                <a class=\"btn btn-dark\" href=\"RestablecerContraseña.jsp\" role=\"button\">Restablecer Contraseña</a>\n");
      out.write("                               <br> \n");
      out.write("                                <label>¿No esta registrado?</label>\n");
      out.write("                                <br>\n");
      out.write("                                <a class=\"btn btn-dark\" href=\"MenuConsultar.jsp\" role=\"button\">Consulta Materiales</a>\n");
      out.write("                            </div>\n");
      out.write("                         </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
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

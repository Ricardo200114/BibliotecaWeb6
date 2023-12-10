package org.apache.jsp.RegistroAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistroTesis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Resources/style.css\">\n");
      out.write("        <script src=\"Resources/script.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Biblioteca UDB</title>\n");
      out.write("        <script>\n");
      out.write("            setTimeout(function () {\n");
      out.write("                document.getElementById(\"msj\").style.display = \"none\";\n");
      out.write("            }, 4000);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"PrestarControlador?menu=Menu&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">BIBLIOTECA UDB</a>\n");
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
      out.write("                    \n");
      out.write("        <div id=\"msj\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${config}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("                                    \n");
      out.write("        <h3 class=\"text-center m-4\" style=\" font-weight: bold;\">Registro de Tesis</h3>\n");
      out.write("\n");
      out.write("        <div class=\"d-flex\">\n");
      out.write("            <div class=\"col-12\">\n");
      out.write("                <div class=\"card bg-light\">\n");
      out.write("                    <form action=\"TesisControlador?menu=Tesis&noCarnet=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${us.getNoCarnet()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"POST\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtCod\" placeholder=\"Código tesis\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getCodTs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtTitulo\" placeholder=\"Titulo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getTitulo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtAutor\" placeholder=\"Autor\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getAutor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtPais\" placeholder=\"País\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getPais()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtCiudad\" placeholder=\"Ciudad\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getCiudad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtUniversidad\" placeholder=\"Universidad\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getUniversidad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"number\" name=\"txtPagina\" placeholder=\"No Páginas\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getNoPagina()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtFecha\" placeholder=\"Fecha publicación\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getFecha()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtIdioma\" placeholder=\"Idioma\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getIdioma()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"text\" name=\"txtUbicacion\" placeholder=\"Ubicación\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getUbicacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <input type=\"number\" name=\"txtUnidad\" placeholder=\"Unidades\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ts.getUnidades()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" required=\"true\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-1\">\n");
      out.write("                                    <input type=\"submit\" name=\"accion\" value=\"Registrar\" class=\"btn btn-dark\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-1\">\n");
      out.write("                                    <input type=\"submit\" name=\"accion\" value=\"Actualizar\" class=\"btn btn-danger\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("<br>\n");
      out.write("            <div class=\"container-sm table-responsive block2\" >\n");
      out.write("                <div class=\"col-sm-12 text-center\">\n");
      out.write("                    <table class=\"table table-hover table-striped\" style=\"background-color: lightgray;\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Código</th>\n");
      out.write("                                <th>Titulo</th>\n");
      out.write("                                <th>Autor</th>\n");
      out.write("                                <th>Pais</th>\n");
      out.write("                                <th>Ciudad</th>\n");
      out.write("                                <th>Universidad</th>\n");
      out.write("                                <th>No Páginas</th>\n");
      out.write("                                <th>Fecha de Publicación</th>\n");
      out.write("                                <th>Idioma</th>\n");
      out.write("                                <th>Ubicacion</th>\n");
      out.write("                                <th>Unidades</th>\n");
      out.write("                                <th></th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                                \n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("  <footer class=\"bg-dark text-light text-center p-3\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <p>&copy; 2023 BIBLIOTECA UDB.\n");
      out.write("          <br>Todos los derechos reservados.</p>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-yGBVx2Jd8hRyi6LOaxwn4I6TXm2DOHPh6aOW9uL9H6EGgoDZvR8GBCYzSHcceNXP\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write(" \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("tsi");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getCodTs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getTitulo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getAutor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getPais()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getCiudad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getUniversidad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getNoPagina()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getFecha()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getIdioma()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getUbicacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getUnidades()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <a class=\"btn btn-warning\" href=\"TesisControlador?menu=Tesis&accion=Editar&CodTs=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getCodTs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&noCarnet=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Editar</a>\n");
          out.write("                                        <a class=\"btn btn-danger\" href=\"TesisControlador?menu=Tesis&accion=Eliminar&CodTs=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tsi.getCodTs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&noCarnet=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Eliminar</a>\n");
          out.write("                                    </td>\n");
          out.write("                                </tr>  \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}

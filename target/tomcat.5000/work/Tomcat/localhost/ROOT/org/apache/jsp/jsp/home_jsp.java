/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2016-11-17 01:40:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.2.1.RELEASE.jar", Long.valueOf(1477333436000L));
    _jspx_dependants.put("jar:file:/home/apprentice/Documents/project-repos/vending-machine/target/tomcat.5000/webapps/expanded/WEB-INF/lib/spring-webmvc-4.2.1.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1441087544000L));
    _jspx_dependants.put("jar:file:/home/apprentice/Documents/project-repos/vending-machine/target/tomcat.5000/webapps/expanded/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153399482000L));
    _jspx_dependants.put("jar:file:/home/apprentice/Documents/project-repos/vending-machine/target/tomcat.5000/webapps/expanded/WEB-INF/lib/spring-webmvc-4.2.1.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1441087544000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1476984242000L));
    _jspx_dependants.put("jar:file:/home/apprentice/Documents/project-repos/vending-machine/target/tomcat.5000/webapps/expanded/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153399482000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Vending Machine App</title>\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/angular.min.js\"></script>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/layout.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/ui-bootstrap-tpls-2.2.0.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/adminApp.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/adminCtrl.js\"></script>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/xeditable.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/xeditable.js\"></script>\n");
      out.write("        <!-- SWC Icon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/icon.png\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div ng-app=\"adminApp\" ng-controller=\"adminController\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-offset-2 col-md-6\">\n");
      out.write("                        <div class=\"row item-search\">\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <a class=\"btn btn-default\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/machine\"><span class=\"glyphicon glyphicon-arrow-left\" aria-hidden=\"true\"></span> Vending Machine</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <input type=\"text\" class=\"pull-right form-control\" placeholder=\"Search...\" ng-model=\"searchItems\">\n");
      out.write("                                    <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-search\"></span></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <table class=\"table table-hover item-table\">\n");
      out.write("                            <thead>\n");
      out.write("                            <th> \n");
      out.write("                                <a width=\"40%\" ng-click=\"orderByMe('name')\">\n");
      out.write("                                    Name \n");
      out.write("                                    <span ng-show=\"myOrderBy == 'name' && !sortReverse\" class=\"glyphicon glyphicon-triangle-bottom\"></span>\n");
      out.write("                                    <span ng-show=\"myOrderBy == 'name' && sortReverse\" class=\"glyphicon glyphicon-triangle-top\"></span>\n");
      out.write("                                </a>\n");
      out.write("                            </th>\n");
      out.write("                            <th>\n");
      out.write("                                <a width=\"20%\" ng-click=\"orderByMe('cost')\">\n");
      out.write("                                    Cost\n");
      out.write("                                    <span ng-show=\"myOrderBy == 'cost' && !sortReverse\" class=\"glyphicon glyphicon-triangle-bottom\"></span>\n");
      out.write("                                    <span ng-show=\"myOrderBy == 'cost' && sortReverse\" class=\"glyphicon glyphicon-triangle-top\"></span>\n");
      out.write("                                </a>\n");
      out.write("                            </th>\n");
      out.write("                            <th>\n");
      out.write("                                <a width=\"20%\" ng-click=\"orderByMe('quantity')\">\n");
      out.write("                                    Quantity\n");
      out.write("                                    <span ng-show=\"myOrderBy == 'quantity' && !sortReverse\" class=\"glyphicon glyphicon-triangle-bottom\"></span>\n");
      out.write("                                    <span ng-show=\"myOrderBy == 'quantity' && sortReverse\" class=\"glyphicon glyphicon-triangle-top\"></span>\n");
      out.write("                                </a>\n");
      out.write("                            </th>\n");
      out.write("                            <th width=\"20%\"></th>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody\n");
      out.write("                                <tr ng-repeat=\"item in items| filter:searchItems | orderBy:myOrderBy:sortReverse\">\n");
      out.write("                                    <td>\n");
      out.write("                                        <span editable-text=\"item.name\" e-name=\"name\" e-form=\"rowform\" \n");
      out.write("                                              onbeforesave=\"checkName($data)\">\n");
      out.write("                                            {{ item.name || 'Empty' }}\n");
      out.write("                                        </span>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <span editable-number=\"item.cost\" e-step=\".05\" e-name=\"cost\" \n");
      out.write("                                              e-form=\"rowform\" onbeforesave=\"checkCost($data)\">\n");
      out.write("                                            {{ item.cost | currency }}\n");
      out.write("                                        </span>\n");
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <span editable-number=\"item.quantity\" e-step=\"1\" e-name=\"quantity\" \n");
      out.write("                                              e-form=\"rowform\" onbeforesave=\"checkQuantity($data)\">\n");
      out.write("                                            {{ item.quantity || 'Empty' }}\n");
      out.write("                                        </span>\n");
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td style=\"white-space: nowrap\">\n");
      out.write("                                        <!-- form -->\n");
      out.write("                                        <form editable-form name=\"rowform\" onbeforesave=\"updateItem($data, item.id)\" ng-show=\"rowform.$visible\" class=\"form-buttons form-inline\" shown=\"inserted == item\">\n");
      out.write("                                            <button type=\"submit\" ng-disabled=\"rowform.$waiting\" class=\"btn btn-primary\">\n");
      out.write("                                                save\n");
      out.write("                                            </button>\n");
      out.write("                                            <button type=\"button\" ng-disabled=\"rowform.$waiting\" ng-click=\"rowform.$cancel()\" class=\"btn btn-default\">\n");
      out.write("                                                cancel\n");
      out.write("                                            </button>\n");
      out.write("                                        </form>\n");
      out.write("                                        <div class=\"buttons\" ng-show=\"!rowform.$visible\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-primary\" ng-click=\"rowform.$show()\">edit</button>\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" ng-click=\"deleteItem(item.id)\">del</button>\n");
      out.write("                                        </div>  \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default\" ng-click=\"addItem()\"><span class=\"glyphicon glyphicon-plus\"></span>Add item</button>\n");
      out.write("\n");
      out.write("                        <div class=\"alert alert-danger\" ng-hide=\"errorDiv\">\n");
      out.write("                            <div ng-repeat=\"error in validationErrors\">\n");
      out.write("                                <p> {{ error.message}} </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>         \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery-2.2.4.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

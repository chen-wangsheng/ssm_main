/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-26 09:48:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write("\r\n");
      out.write("<footer class=\"footer\">\r\n");
      out.write("    <div class=\"footer-container\">\r\n");
      out.write("        <div class=\"footer-link\">\r\n");
      out.write("            <div class=\"footer-link__item\">\r\n");
      out.write("                <h4 class=\"footer-title\">关于我们</h4>\r\n");
      out.write("                <ul class=\"footer-list\">\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">关于我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">帮助中心</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">加入我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">联系我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">标签集</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">商务合作</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">免责声明</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-link__item\">\r\n");
      out.write("                <h4 class=\"footer-title\">手机应用</h4>\r\n");
      out.write("                <ul class=\"footer-list\">\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">关于我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">帮助中心</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">加入我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-link__item\">\r\n");
      out.write("                <div class=\"footer-orcode\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/app_qrcode.png\" alt=\"#\"></div>\r\n");
      out.write("                <div class=\"orcode-text\">\r\n");
      out.write("                    <p>扫描二维码</p>\r\n");
      out.write("                    <p>下载手机客户端</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-link__item\">\r\n");
      out.write("                <h4 class=\"footer-title\">关注我们</h4>\r\n");
      out.write("                <ul class=\"footer-list\">\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">关于我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">帮助中心</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-link__item\">\r\n");
      out.write("                <h4 class=\"footer-title\">友情链接</h4>\r\n");
      out.write("                <ul class=\"footer-list\">\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">关于我们</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">帮助中心</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">联系详情</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"item\">\r\n");
      out.write("                        <a href=\"#\">服务中心</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"fopter-copyright\">\r\n");
      out.write("            <p>©2019 网上商城版权所有。</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2019-10-17 06:20:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1571234356479L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1571234306816L));
  }

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--文件头开始-->\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("\t\t");
      out.write('\r');
      out.write('\n');

	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

      out.write("    \r\n");
      out.write("<head>\r\n");
      out.write("\t<base href=\"");
      out.print(basePath );
      out.write("\" />\r\n");
      out.write("\t<meta http-equiv=\"Content-Language\" content=\"zh-cn\">\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\r\n");
      out.write("\t<meta name=\"description\" content=\"杰普电子商务门户\">\r\n");
      out.write("\t<title>杰普电子商务门户</title>\r\n");
      out.write("\t<LINK href=\"css/main.css\" rel=stylesheet>\r\n");
      out.write("\t<script language = \"JavaScript\" src = \"js/main.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"165\" height=\"60\"></td>\r\n");
      out.write("\t    <td width=\"62%\" background=\"images/top_bg.gif\">　</td>\r\n");
      out.write("\t    <td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\">\r\n");
      out.write("\t\t<img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">\r\n");
      out.write("\t      <table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td width=\"5%\">　</td>\r\n");
      out.write("\t          <td width=\"10%\"><a href=\"index.jsp\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image1','','images/index_on.gif',1)\">\r\n");
      out.write("\t\t\t\t<img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>\r\n");
      out.write("\t          <td width=\"10%\"><a href=\"user/userinfo.jsp\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image2','','images/reg_on.gif',1)\">\r\n");
      out.write("\t\t\t\t<img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>\r\n");
      out.write("\t          <td width=\"10%\"><a href=\"user/shopcart.jsp\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image4','','images/carts_on.gif',1)\">\r\n");
      out.write("\t\t\t\t<img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>\r\n");
      out.write("\t          <td width=\"10%\"><a href=\"user/orderFindAll\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image5','','images/order_on.gif',1)\">\r\n");
      out.write("\t\t\t\t<img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>\r\n");
      out.write("\t          <td width=\"10%\"><a href=\"logout\" onMouseOut=\"MM_swapImgRestore()\" onMouseOver=\"MM_swapImage('Image6','','images/exit_on.gif',1)\">\r\n");
      out.write("\t\t\t\t<img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t      </table>\r\n");
      out.write("\t    </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td width=\"65%\"><BR>\r\n");
      out.write("\t>> 欢迎访问 <b>杰普电子商务门户</b> </td>\r\n");
      out.write("\t<td width=\"35%\" align=\"right\">\r\n");
      out.write("\t</td></tr></table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--文件体开始-->\r\n");
      out.write("\r\n");
      out.write("\t\t<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td height=25 valign=middle>\r\n");
      out.write("                  <img src=\"images/Forum_nav.gif\" align=\"middle\">\r\n");
      out.write("                  <a href=index.jsp>杰普电子商务门户</a> →\r\n");
      out.write("\t\t\t\t\t<img border=\"0\" src=\"images/dog.gif\" width=\"19\" height=\"18\">\r\n");
      out.write("\t\t\t\t\t欢迎<font color=\"red\"></font>光临！\r\n");
      out.write("                </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("              <br>\r\n");
      out.write("\r\n");
      out.write("\t\t<table cellpadding=3 cellspacing=1 align=center class=tableborder1>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=middle align=center height=25 background=\"images/bg2.gif\" width=\"\"><font color=\"#ffffff\"><b>序号</b></font></td>\r\n");
      out.write("\t\t\t<td valign=middle align=center height=25 background=\"images/bg2.gif\" width=\"\"><font color=\"#ffffff\"><b>产品名称</b></font></td>\r\n");
      out.write("\t\t\t<td valign=middle align=center height=25 background=\"images/bg2.gif\" width=\"\"><font color=\"#ffffff\"><b>价格</b></font></td>\r\n");
      out.write("\t\t\t<td valign=middle align=center height=25 background=\"images/bg2.gif\" width=\"\"><font color=\"#ffffff\"><b>操作</b></font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("        \r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td class=tablebody2 valign=middle align=center width=\"\">1</td>\r\n");
      out.write("\t\t\t<td class=tablebody1 valign=middle width=\"\">&nbsp;&nbsp;<a href=\"productDetail.html\">精通Hibernate：Java对象持久化技术详解</a></td>\r\n");
      out.write("\t\t\t<td class=tablebody2 valign=middle align=center width=\"\">59</td>\r\n");
      out.write("\t\t\t<td class=tablebody1 valign=middle align=center width=\"\"><a href=\"shoppingCart.html\">\r\n");
      out.write("\t\t\t<img border=\"0\" src=\"images/car_new.gif\" width=\"97\" height=\"18\"></a> </td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("                \r\n");
      out.write("\t\t</table>\r\n");
      out.write("<!--文件尾开始-->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"17\" background=\"images/bot_bg.gif\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">\r\n");
      out.write("\t<p align=\"center\">Copyright &copy;2010 - 2019 <a href=\"http://www.briup.com\"><b><font face=\"Verdana,\">briup</font></b><font color=#CC0000>.com</font></b><br>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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

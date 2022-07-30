package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Rate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/UserHeader.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Rate & Comment Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        .rate {\r\n");
      out.write("            float: left;\r\n");
      out.write("            height: 46px;\r\n");
      out.write("            padding: 0 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .rate:not(:checked) > input {\r\n");
      out.write("            position:absolute;\r\n");
      out.write("            top:-9999px;\r\n");
      out.write("        }\r\n");
      out.write("        .rate:not(:checked) > label {\r\n");
      out.write("            float:right;\r\n");
      out.write("            width:1em;\r\n");
      out.write("            overflow:hidden;\r\n");
      out.write("            white-space:nowrap;\r\n");
      out.write("            cursor:pointer;\r\n");
      out.write("            font-size:60px;\r\n");
      out.write("            color:#ccc;\r\n");
      out.write("        }\r\n");
      out.write("        .rate:not(:checked) > label:before {\r\n");
      out.write("            content: '★ ';\r\n");
      out.write("        }\r\n");
      out.write("        .rate > input:checked ~ label {\r\n");
      out.write("            color: #ffc700;    \r\n");
      out.write("        }\r\n");
      out.write("        .rate:not(:checked) > label:hover,\r\n");
      out.write("        .rate:not(:checked) > label:hover ~ label {\r\n");
      out.write("            color: #deb217;  \r\n");
      out.write("        }\r\n");
      out.write("        .rate > input:checked + label:hover,\r\n");
      out.write("        .rate > input:checked + label:hover ~ label,\r\n");
      out.write("        .rate > input:checked ~ label:hover,\r\n");
      out.write("        .rate > input:checked ~ label:hover ~ label,\r\n");
      out.write("        .rate > label:hover ~ input:checked ~ label {\r\n");
      out.write("            color: #c59b08;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"body\">\r\n");
      out.write("            <header>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("                <link href=\"Stylesheet.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("                <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"container-fluid header \">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <a class=\"logo \"href=\"UserHomePage.jsp\"><img    src=\"image/cafe2.png\" /></a>\r\n");
      out.write("                </div>                \r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"UserHomePage.jsp\" >Home</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"MainController?action=ProfileOfMentor\" >Mentor</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"ViewSkill.jsp\" >Skill</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"MainController?action=ListRequestByMentee\" >Request</a>\r\n");
      out.write("                <div class=\"col-md-1 d-flex\">\r\n");
      out.write("                    <a  href=\"\"><img style=\"background-color: white\" class=\"avatar\" src=\"image/avatar.png\" /></a>\r\n");
      out.write("                    <div class=\"dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn  dropdownbutton\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"MenteeProfile.jsp\">Profile</a></li>\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"ChangePasswordByMentee.jsp\">Change Password</a></li>\r\n");
      out.write("\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"MainController?action=LogOut\">Log out</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div> \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("            </header>\r\n");
      out.write("            ");
 String mentorName = request.getParameter("mentorName");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <form action=\"MainController\" class=\" d-flex flex-column align-items-center\">\r\n");
      out.write("                <p style=\"text-align: center;font-size: 30px; margin-top:40px;\">  Ratings </p> \r\n");
      out.write("                \r\n");
      out.write("                <div class=\"rate\">\r\n");
      out.write("    <input type=\"radio\" id=\"star5\" name=\"radio\" value=\"5\" />\r\n");
      out.write("    <label for=\"star5\" title=\"text\">5 stars</label>\r\n");
      out.write("    <input type=\"radio\" id=\"star4\" name=\"radio\" value=\"4\" />\r\n");
      out.write("    <label for=\"star4\" title=\"text\">4 stars</label>\r\n");
      out.write("    <input type=\"radio\" id=\"star3\" name=\"radio\" value=\"3\" />\r\n");
      out.write("    <label for=\"star3\" title=\"text\">3 stars</label>\r\n");
      out.write("    <input type=\"radio\" id=\"star2\" name=\"radio\" value=\"2\" />\r\n");
      out.write("    <label for=\"star2\" title=\"text\">2 stars</label>\r\n");
      out.write("    <input type=\"radio\" id=\"star1\" name=\"radio\" value=\"1\" />\r\n");
      out.write("    <label for=\"star1\" title=\"text\">1 star</label>\r\n");
      out.write("  </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <p style=\"text-align: center;font-size: 30px; padding-top:50px;\">  Comment </p>   <textarea style=\"width:600px; height:220px;\" type=\"text\" name=\"comment\"></textarea>           \r\n");
      out.write("                <input type=\"hidden\" name=\"mentorName\" value=\"");
      out.print( mentorName);
      out.write("\"/>\r\n");
      out.write("                \r\n");
      out.write("                <input style=\"width:200px\" type=\"submit\" name=\"action\" value=\"Rate\" class=\"btn btn-primary btn-lg px-4 py-2 m-4\" />\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("<!--        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <link href=\"Stylesheet.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"footer navbar \">\r\n");
      out.write("            <p>©Copyright by Team 4</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

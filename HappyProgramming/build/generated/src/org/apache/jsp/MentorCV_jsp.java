package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DTO.Rating;
import DAO.MentorDAO;
import DTO.Mentor;
import java.util.ArrayList;
import DAO.RateDAO;

public final class MentorCV_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Mentor CV</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link href=\"Stylesheet.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            var starWidth = 40;\r\n");
      out.write("            \r\n");
      out.write("            $.fn.stars = function () {\r\n");
      out.write("                return $(this).each(function () {\r\n");
      out.write("                    $(this).html($('<span />').width(Math.max(0, (Math.min(5, parseFloat($(this).html())))) * starWidth));\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $('span.stars').stars();\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("            $(document).on('click', 'div a', function () {\r\n");
      out.write("                $(this).addClass('active').siblings().removeClass('active')\r\n");
      out.write("                \r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("\r\n");
      out.write("            table, table tr{\r\n");
      out.write("\r\n");
      out.write("                width:99%;\r\n");
      out.write("                margin: auto;\r\n");
      out.write("                margin-right: 100px;  \r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            table th,td{\r\n");
      out.write("                width: 30%;\r\n");
      out.write("                margin-right: 30px;\r\n");
      out.write("                margin-left: 80px;\r\n");
      out.write("            }\r\n");
      out.write("            span.stars, span.stars span {\r\n");
      out.write("                display: block;\r\n");
      out.write("                background: url(image/emptystar.svg) 0 0 repeat-x ;\r\n");
      out.write("                width: 200px; /* width of a star multiplied by 5 */\r\n");
      out.write("                height: 40px; /* the height of the star */\r\n");
      out.write("                background-size: 40px 40px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            span.stars span {\r\n");
      out.write("                background-position: 0 0;\r\n");
      out.write("                background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/747/star.svg) ;\r\n");
      out.write("            }\r\n");
      out.write("            .stars{\r\n");
      out.write("                margin-left: 120px;\r\n");
      out.write("                margin-top: 50px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("        <style>\r\n");
      out.write("            .avatarCv{\r\n");
      out.write("                width:150px;\r\n");
      out.write("                height:auto;\r\n");
      out.write("                border-radius: 50%;\r\n");
      out.write("                margin-left: 150px;\r\n");
      out.write("                margin-top: 50px;\r\n");
      out.write("            }\r\n");
      out.write("            h1{\r\n");
      out.write("                margin-left: 85px;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");
 String signin = (String) session.getAttribute("signin");
        if (signin==null) {
                session.setAttribute("role", "Unregistered");
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.role}Header.jsp", java.lang.String.class, (PageContext)_jspx_page_context, null), out, false);
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("            ");
 MentorDAO mentordao = new MentorDAO();
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
Mentor list2 = mentordao.getMentorByID(Integer.parseInt(request.getParameter("id")));
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr><img style=\"background-color: white\" class=\"avatarCv\" src=\"");
      out.print(list2.getAvatar());
      out.write("\"></tr>\r\n");
      out.write("            <h5>Introduction</h5>\r\n");
      out.write("            <tr>");
      out.print(list2.getIntroduction());
      out.write("<tr>\r\n");
      out.write("            <tr><h1>");
      out.print(list2.getFullname());
      out.write("</h1></tr>\r\n");
      out.write("\r\n");
      out.write("    </table> \r\n");
      out.write("    <h5>Profession</h5><br>\r\n");
      out.write("<tr style=\"padding-left: 100px;\">");
      out.print(list2.getProfession());
      out.write("</tr><br><br>\r\n");
      out.write("<tr style=\"padding-left: 100px;\">");
      out.print(list2.getJob());
      out.write("</tr>\r\n");
      out.write("<h5>Service</h5><br>\r\n");
      out.write("<tr style=\"padding-left: 100px;\">");
      out.print(list2.getServiceDesc());
      out.write("</tr>\r\n");
      out.write("<h5>Achievement</h5><br>\r\n");
      out.write("<tr style=\"padding-left: 100px;\">");
      out.print(list2.getAchievementDesc());
      out.write("</tr>\r\n");
      out.write("<h5>Rating</h5><br>\r\n");
      out.write("<tr style=\"padding-left: 100px;\"><span class=\"stars\">");
      out.print(RateDAO.getRateStar(list2.getId()));
      out.write("</span></tr>\r\n");
      out.write("<footer>\r\n");
      out.write("    ");
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
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

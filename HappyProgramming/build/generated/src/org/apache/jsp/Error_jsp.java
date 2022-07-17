package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DTO.Skill;
import DAO.SkillDAO;
import java.util.ArrayList;

public final class Error_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Javascript Example</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("         <h2>Lấy giá trị của checkbox bằng Javascript</h2>\r\n");
      out.write("        <p>Hãy viết chương trình khi click vào button thì in ra danh sách sở thích mà người dùng đã chọn.</p>\r\n");
      out.write("         \r\n");
      out.write("        ");

            ArrayList<Skill> skilllist = SkillDAO.getAllSkill();
            for (Skill skill : skilllist) {
                if ("active".equals(skill.getStatus())) {
      out.write("\r\n");
      out.write("        <input type=\"checkbox\" class=\"form-check-input \" name=\"hobby\" value=\"");
      out.print(skill.getId());
      out.write("\"><label class=\"form-check-label\">");
      out.print(skill.getName());
      out.write("</label></br>\r\n");
      out.write("        ");
}
                    }
      out.write("\r\n");
      out.write("        <br/> <br/>\r\n");
      out.write("         \r\n");
      out.write("        <input type=\"button\" id=\"btn\" value=\"Xem kết quả\"/>\r\n");
      out.write("         \r\n");
      out.write("        <script language=\"javascript\">\r\n");
      out.write("            document.getElementById('btn').onclick = function()\r\n");
      out.write("            {\r\n");
      out.write("                // Khai báo tham số\r\n");
      out.write("                var checkbox = document.getElementsByName('hobby');\r\n");
      out.write("                var result = \"\";                 \r\n");
      out.write("                // Lặp qua từng checkbox để lấy giá trị\r\n");
      out.write("                for (var i = 0; i < checkbox.length; i++){\r\n");
      out.write("                    if (checkbox[i].checked === true){\r\n");
      out.write("                        result += checkbox[i].value + ', ';\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                 \r\n");
      out.write("                // In ra kết quả\r\n");
      out.write("                alert(\"Sở thích là: \" + result);\r\n");
      out.write("                document.getElementByName('skillChoose').value = result;\r\n");
      out.write("            };          \r\n");
      out.write("        </script>\r\n");
      out.write("        <input type=\"text\" name=\"skillChoose\">\r\n");
      out.write("</body>\r\n");
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

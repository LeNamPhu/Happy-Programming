package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import DTO.Request;
import java.util.ArrayList;

public final class ListRequestByMentee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>List Request By Mentee Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            ");
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
      out.write("                </div>                <a class=\"col-md-1\" href=\"UserHomePage.jsp\" >Home</a>\r\n");
      out.write("                <a class=\"col-md-1\" href=\"ViewMentor.jsp\" >Mentor</a>\r\n");
      out.write("                <a class=\"col-md-1\" href=\"ViewSkill.jsp\" >Skill</a>\r\n");
      out.write("                <a class=\"col-md-1\" href=\"MainController?action=ListRequestByMentee\" >Request</a>\r\n");
      out.write("                <div class=\"col-md-1 d-flex\">\r\n");
      out.write("                    <a  href=\"\"><img style=\"background-color: white\" class=\"avatar\" src=\"image/avatar.png\" /></a>\r\n");
      out.write("                    <div class=\"dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn  dropdownbutton\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"#\">Profile</a></li>\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"#\">Change Password</a></li>\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"#\">Log out</a></li>\r\n");
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
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"body\" style=\"font-size:30px\">\r\n");
      out.write("            <!--        <form action=\"MainController\">\r\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"ListRequestByMentee\"/>\r\n");
      out.write("                    </form>-->\r\n");
      out.write("\r\n");
      out.write("            <!--        <h2>Your Requests </h2>-->\r\n");
      out.write("            ");

                ArrayList<String> listSkill = (ArrayList) session.getAttribute("LIST_SKILL");
                Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");
                ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_REQUEST_BY_MENTEE");
                int flag = 0;
                if (list != null) {

                    if (list.size() == 0) {
                        flag = 1;
                    }
            
      out.write("\r\n");
      out.write("            <div style=\"width:70%;margin:auto;\" class=\"py-5\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");

                    for (Request req : list) {
                        String a = (String) skillReq.get(req);
                        String x = "X";
                        String y = "X";
                        String z = "X";
                        String[] skills = a.split(" ");
                        if (skills.length == 1) {
                            x = skills[0];
                        } else if (skills.length == 2) {
                            x = skills[0];
                            y = skills[1];
                        } else {
                            x = skills[0];
                            y = skills[1];
                            z = skills[2];
                        }
                
      out.write("           \r\n");
      out.write("                <div class=\"d-flex border border-secondary justify-content-around \">\r\n");
      out.write("                    <div class=\"d-flex flex-column \" style=\"width:608px;height:200px;\">\r\n");
      out.write("                        <div class=\" d-flex justify-content-between m-2\" style=\"width:600px;height:50px;\" >\r\n");
      out.write("                            <div class=\"m-2 \"><span>");
      out.print( req.getTitle());
      out.write("</span> </div>                   \r\n");
      out.write("                            <div class=\"m-2\"><span>");
      out.print( req.getDeadlineHour());
      out.write("h</span>\r\n");
      out.write("                                <span class=\"px-1\"></span>\r\n");
      out.write("                                <span>");
      out.print( req.getDeadlineDate());
      out.write("</span></div>\r\n");
      out.write("                        </div >\r\n");
      out.write("                        <div class=\" d-flex\" style=\"width:608px;height:150px;\">\r\n");
      out.write("                            <span class=\" d-flex border border-secondary mt-2 me-2 \"style=\"width:508px;height:auto;\">");
      out.print( req.getContent());
      out.write("</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"d-flex align-items-center border border-secondary justify-content-center mt-2\"style=\"width:100px;height:auto;\">");
      out.print( req.getStatus());
      out.write("</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"d-flex align-items-center m-2 flex-column border border-secondary justify-content-around\" style=\"width:150px; height:200px;\">\r\n");
      out.write("                        <p class=\"m-2\">");
      out.print( x);
      out.write("</p>\r\n");
      out.write("                        <p class=\"m-2\">");
      out.print( y);
      out.write("</p>\r\n");
      out.write("                        <p class=\"m-2\">");
      out.print( z);
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"d-flex flex-column justify-content-center\">\r\n");
      out.write("                        <div >\r\n");
      out.write("                            <div class=\"d-flex flex-row m-2\">\r\n");
      out.write("                                <div class=\"me-1\">\r\n");
      out.write("                                <form action=\"MainController\">\r\n");
      out.write("\r\n");
      out.write("                                    <input class=\"rounded\" type=\"submit\" name=\"action\" value=\"DeleteRequest\" style=\"background-color:#0076ff; color:white;;border:none;padding:10px 10px;font-size: 25px;\"/>\r\n");
      out.write("                                    <input type=\"hidden\" name=\"reqID\" value=\"");
      out.print( req.getId());
      out.write("\"/>                      \r\n");
      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                    <div class=\"ms-1\">\r\n");
      out.write("                                <form action=\"UpdateRequest.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    <input class=\"rounded\" type=\"submit\" value=\"UpdateRequest\" style=\"background-color:#0076ff; color:white;;border:none;padding:10px 10px;font-size: 25px;\"/>\r\n");
      out.write("                                    <input type=\"hidden\" name=\"reqID\" value=\"");
      out.print( req.getId());
      out.write("\"/>                                              \r\n");
      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                                    <div class=\"m-2\">\r\n");
      out.write("                        <form action=\"#\">\r\n");
      out.write("\r\n");
      out.write("                            <input class=\"rounded\" style=\"width:100% ;background-color:#0076ff;border:none; color:white; font-size: 25px; padding:10px 10px;\" type=\"submit\" value=\"ShowMentorSuggestion\"/>\r\n");
      out.write("                            <input type=\"hidden\" name=\"reqID\" value=\"");
      out.print( req.getId());
      out.write("\"/>                                              \r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    }
                    if (flag == 1) {
                
      out.write("\r\n");
      out.write("                <h3>You do not have any request</h3>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("            </div>\r\n");
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
      out.write("    </body>\r\n");
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

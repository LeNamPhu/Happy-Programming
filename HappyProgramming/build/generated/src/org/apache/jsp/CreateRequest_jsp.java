package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import DTO.Skill;
import DAO.SkillDAO;
import DAO.SkillDAO;

public final class CreateRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Unauthorised.jsp");
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
if (session.getAttribute("role") != "User") {
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>no</h1>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
 } else {
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Create Request</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"Stylesheet.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"body\">\r\n");
      out.write("\r\n");
      out.write("            <h1 style=\"text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px\">Create Request</h1>\r\n");
      out.write("            <form action=\"MainController\" method=\"post\">\r\n");
      out.write("                <table style=\";font-size: 25px\" class=\"d-flex justify-content-center\" id=\"createrequesttable\">\r\n");
      out.write("                    <tr><td id=\"createrequestpass\">Title</td><td><input type=\"text\" name=\"title\" style=\"width: 400px\"></td></tr>\r\n");
      out.write("                    <tr><td id=\"createrequestpass\">Deadline date</td><td><input type=\"date\" name=\"deadlineDate\" style=\"width: 400px\" id=\"createrequestform\"/></td></tr>\r\n");
      out.write("                    <tr><td id=\"createrequestpass\">Deadline hour</td><td><input type=\"text\" name=\"deadlineHour\" style=\"width: 400px\" id=\"createrequestform\"/></td></tr>\r\n");
      out.write("                    <tr><td id=\"createrequestpass\">Content</td><td><input type=\"text\" name=\"content\" style=\"width: 400px; height: 150px\" id=\"createrequestform\"/></td></tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td id=\"first\">Skill</td><td id=\"input\">\r\n");
      out.write("                            ");

                                ArrayList<Skill> listSkill = SkillDAO.getAllSkill();
                                String x = "";
                                String y = "";
                                String z = "";
                            
      out.write("\r\n");
      out.write("                            <select name=\"skill1\">\r\n");
      out.write("                                <option value=\"");
      out.print( x);
      out.write('"');
      out.write('>');
      out.print( x);
      out.write("</option>\r\n");
      out.write("                                ");

                                    for (Skill skill : listSkill) {
                                
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print( skill.getName() );
      out.write('"');
      out.write('>');
      out.print( skill.getName() );
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("                                <option value=\"X\">X</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("\r\n");
      out.write("                            <select name=\"skill2\">\r\n");
      out.write("                                <option value=\"");
      out.print( y);
      out.write('"');
      out.write('>');
      out.print( y);
      out.write("</option>\r\n");
      out.write("                                ");

                                    for (Skill skill : listSkill) {
                                
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print( skill.getName());
      out.write('"');
      out.write('>');
      out.print( skill.getName());
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("                                <option value=\"X\">X</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("\r\n");
      out.write("                            <select name=\"skill3\">\r\n");
      out.write("                                <option value=\"");
      out.print( z);
      out.write('"');
      out.write('>');
      out.print( z);
      out.write("</option>\r\n");
      out.write("                                ");

                                    for (Skill skill : listSkill) {
                                
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print( skill.getName());
      out.write('"');
      out.write('>');
      out.print( skill.getName());
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("                                <option value=\"X\">X</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td> \r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("                <div>\r\n");
      out.write("                    <!--                    <input type=\"submit\" class=\"createrequest\" value=\"Enter\" style=\"font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none\" >-->\r\n");
      out.write("                    <input type=\"submit\" class=\"createrequest\" value=\"Cancel\" style=\"font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)\" >\r\n");
      out.write("                    <input type=\"submit\" name=\"action\" value=\"Add\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html> \r\n");
 }
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

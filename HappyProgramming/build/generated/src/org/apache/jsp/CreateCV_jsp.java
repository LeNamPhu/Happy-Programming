package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DTO.Account;
import DAO.MentorDAO;
import DTO.Skill;
import java.util.ArrayList;
import DAO.SkillDAO;

public final class CreateCV_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/MentorHeader.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"virtual-select.min.css\">\r\n");
      out.write("        <script src=\"virtual-select.min.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css\">\r\n");
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
      out.write("      \r\n");
      out.write("<nav class=\"container-fluid header \">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("                    \r\n");
      out.write("                    <a class=\"logo \"href=\"MentorHomePage.jsp\"><img    src=\"image/cafe2.png\" /></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"MentorHomePage.jsp\" >Home</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"MainController?action=ProfileOfMentor\" >Mentor</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"ViewSkill.jsp\" >Skill</a>\r\n");
      out.write("                <a class=\"col-md-1 nav-link\" href=\"MainController?action=ListRequestByMentor\" >Request</a>\r\n");
      out.write("                <div class=\"col-md-1 d-flex\">\r\n");
      out.write("                    <a  href=\"\"><img style=\"background-color: white\" class=\"avatar\" src=\"image/avatar_male.png\" /></a>\r\n");
      out.write("                    <div class=\"dropdown\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn  dropdownbutton\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                            \r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"CreateCV.jsp\">CV</a></li>\r\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"ChangePasswordByMentor.jsp\">Change Password</a></li>\r\n");
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
      out.write("       \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("        <div class=\"body\"style=\"font-size:  30px;\">\r\n");
      out.write("            ");
 MentorDAO mentordao = new MentorDAO();
                // Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
                int mentorID = 6;//user.getId();
                if (mentordao.getMentorProfession(mentorID)) {
                    response.sendRedirect("UpdateCV.jsp");
                }
      out.write("\r\n");
      out.write("            <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("                <div class=\" py-5 my-5\"style=\"width: 60%; margin:auto; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;\">\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 \" style=\"text-align:center\">\r\n");
      out.write("                            <div class=\"p-4\">\r\n");
      out.write("                                <div style=\"height:162px; width:162px;position:relative;margin:auto\">\r\n");
      out.write("                                    <img id=\"avt\" class=\"rounded-circle border\"  src=\"image/avatar.png\" style=\"height:100%;width:100%\">\r\n");
      out.write("\r\n");
      out.write("                                    <div style=\" position:absolute; right:5px; bottom:5px; height:30px; width:30px; border-radius: 50%; background-color: white\">\r\n");
      out.write("                                        <i class=\"fa-solid fa-camera\" style=\"height:100%; position:absolute; right:5px; bottom:5px;\"></i>\r\n");
      out.write("                                        <input type=\"file\" name=\"avatar\" accept=\"image/*\"\r\n");
      out.write("                                               onchange=\"document.getElementById('avt').src = window.URL.createObjectURL(this.files[0])\" style=\"width: 100%; height:100%; opacity: 0;\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!--                            <input style=\"margin: auto; height:50px; width:300px; text-align: center\" type=\"text\" placeholder=\"Account Name\" class=\"form-control\" name=\"accName\"> -->\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <!--                            <input  type=\"text\" placeholder=\"Full Name\" class=\"form-control m-2 cvform\" name=\"fullName\"> -->\r\n");
      out.write("\r\n");
      out.write("                            <input  type=\"text\" placeholder=\"Job\" class=\"form-control m-2 cvform \" name=\"job\"> \r\n");
      out.write("\r\n");
      out.write("                            <textarea style=\" height:auto \" type=\"text\" placeholder=\"Introduction\" rows=\"5\" class=\"form-control m-2 cvform\" name=\"introducton\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                                            <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                                                <div class=\"cvlabel p-2\">\r\n");
      out.write("                                                    <label> Email </label>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                                                <input style=\" \" type=\"text\"  class=\"form-control m-2 cvform\" name=\"email\"> \r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>-->\r\n");
      out.write("                    <!--                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                                            <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                                                <div class=\"cvlabel p-2\">\r\n");
      out.write("                                                    <label> Date of Birth </label>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                                                <input style=\" \" type=\"text\"  class=\"form-control m-2 cvform\" name=\"dob\"> \r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>-->\r\n");
      out.write("                    <!--                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                                            <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                                                <div class=\"cvlabel p-2\">\r\n");
      out.write("                                                    <label>Gender </label>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-8 pt-2\" >\r\n");
      out.write("                                                <select class=\"form-select m-2 cvform\" name=\"gender\" style=\"width:200px;\" ><option>Male</option>\r\n");
      out.write("                                                    <option>Female</option>\r\n");
      out.write("                                                    <option>Other</option></select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>-->\r\n");
      out.write("                    <!--                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                                            <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                                                <div class=\"cvlabel p-2\">\r\n");
      out.write("                                                    <label> Address </label>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                                                <input style=\" \" type=\"text\"  class=\"form-control m-2 cvform\" name=\"address\"> \r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>-->\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Profession </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <input style=\" \" type=\"text\"  class=\"form-control m-2 cvform\" name=\"profession\"> \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Profession Intro </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <textarea style=\" height:auto \" type=\"text\" placeholder=\"\" rows=\"5\" class=\"form-control m-2 cvform\" name=\"professionIntro\"></textarea>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Framework </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <input style=\"height:auto\" type=\"text\"  class=\"form-control m-2 cvform\" name=\"framework\"> \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Service </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <input style=\"height:auto\" type=\"text\"  class=\"form-control m-2 cvform\" name=\"service\"> \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Service Description </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <textarea style=\" height:auto \" type=\"text\" placeholder=\"\" rows=\"5\" class=\"form-control m-2 cvform\" name=\"serviceDesc\"></textarea>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Achievement</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <textarea style=\" height:auto \" type=\"text\" placeholder=\"\" rows=\"5\" class=\"form-control m-2 cvform\" name=\"achievement\"></textarea>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row \" style=\"margin:0!important\">\r\n");
      out.write("                        <div class=\"col-md-4 pt-3 \">\r\n");
      out.write("                            <div class=\"cvlabel p-2\">\r\n");
      out.write("                                <label> Skill</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8 pt-2\">\r\n");
      out.write("                            <div class=\"overflow-auto form-control m-2 cvform \" style=\"height:150px;\">\r\n");
      out.write("                                ");

                                    ArrayList<Skill> skilllist = SkillDAO.getAllSkill();
                                    for (Skill skill : skilllist) {
                                        if ("active".equals(skill.getStatus())) {
      out.write("\r\n");
      out.write("                                <input type=\"checkbox\" class=\"form-check-input \" name=\"hobby\" value=\"");
      out.print(skill.getId());
      out.write("\"><label class=\"form-check-label\">");
      out.print(skill.getName());
      out.write("</label></br>\r\n");
      out.write("                                ");
}
                                    }
      out.write("\r\n");
      out.write("                                <br/> <br/>                              \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input type=\"submit\" id=\"btn\" class=\"btn btn-primary btn-lg m-3\"name=\"action\" value=\"CreateCV\">\r\n");
      out.write("                    <input type=\"hidden\" id=\"abc\" name=\"skill\">\r\n");
      out.write("                    <script language=\"javascript\">\r\n");
      out.write("                        document.getElementById('btn').onclick = function ()\r\n");
      out.write("                        {\r\n");
      out.write("                            // Khai báo tham số\r\n");
      out.write("                            var checkbox = document.getElementsByName('hobby');\r\n");
      out.write("                            var result = \"\";\r\n");
      out.write("\r\n");
      out.write("                            // Lặp qua từng checkbox để lấy giá trị\r\n");
      out.write("                            for (var i = 0; i < checkbox.length; i++) {\r\n");
      out.write("                                if (checkbox[i].checked === true) {\r\n");
      out.write("                                    result += checkbox[i].value + ', ';\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            document.getElementById('abc').value = result;\r\n");
      out.write("                        };\r\n");
      out.write("                    </script>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
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

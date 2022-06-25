package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import DTO.Request;
import java.util.ArrayList;

public final class ListInviteRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>List Invite Request</title>\n");
      out.write("    </head>\n");
      out.write("    <body>       \n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Invite Request\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");

            ArrayList<Request> listInviteRequest = (ArrayList) session.getAttribute("LIST_INVITE");
            Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");
            if (listInviteRequest != null) {               
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Title</th>\n");
      out.write("                    <th>Content</th>\n");
      out.write("                    <th>Deadline Date</th>\n");
      out.write("                    <th>Deadline Hour</th>\n");
      out.write("                    <th>Skill 1</th>\n");
      out.write("                    <th>Skill 2</th>\n");
      out.write("                    <th>Skill 3</th>                                              \n");
      out.write("                    <th>Accept</th>                          \n");
      out.write("                    <th>Reject</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("\n");
      out.write("                ");
                   
                    for (Request req : listInviteRequest) {
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
                
      out.write("          \n");
      out.write("            <form action=\"MainController\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>");
      out.print(req.getTitle() );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print(req.getContent() );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print(req.getDeadlineDate() );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print(req.getDeadlineHour() );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print( x );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print( y );
      out.write("</th>\n");
      out.write("                    <th>");
      out.print( z );
      out.write("</th>                                                              \n");
      out.write("                    <th> <input type=\"submit\" name=\"action\" value=\"Accept Request\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"reqID\" value=\"");
      out.print( req.getId() );
      out.write("\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"status\" value=\"Closed\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"inviteStatus\" value=\"closed\"/>\n");
      out.write("                    \n");
      out.write("                    </th>                          \n");
      out.write("                    <th><input type=\"submit\" name=\"action\" value=\"Reject Request\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"reqID\" value=\"");
      out.print( req.getId() );
      out.write("\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"status\" value=\"Processing\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"inviteStatus\" value=\"closed\"/>\n");
      out.write("                    </th>                    \n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");
               
            }
        
      out.write("\n");
      out.write("</body>\n");
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
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class StatisticByMentee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Statistic of Requests</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("         <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Statistic by Mentee\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

        ArrayList<String> listMentor = (ArrayList) request.getAttribute("LIST_MENTOR");
        ArrayList<String> listTitle = (ArrayList) request.getAttribute("LIST_TITLE");      
        String totalHour = (String)request.getAttribute("TOTAL_HOUR");
        String totalRequest = (String)request.getAttribute("TOTAL_REQUEST");
        
      out.write("\n");
      out.write("        <h4>Total Request</h4> ");
      out.print(totalRequest);
      out.write("\n");
      out.write("        <h4>Total Hour</h4> ");
      out.print(totalHour);
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>No</th>\n");
      out.write("                        <th>List Title</th>                       \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>                    \n");
      out.write("                     ");

                        int count = 1;
                        for (String title : listTitle) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th>");
      out.print( count++ );
      out.write("</th>\n");
      out.write("                        <th>");
      out.print( title );
      out.write("</th>\n");
      out.write("                        \n");
      out.write("                    </tr>                   \n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("        </table>\n");
      out.write("                \n");
      out.write("                <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>No</th>\n");
      out.write("                        <th>List Mentor</th>                       \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>                    \n");
      out.write("                     ");

                        int a = 1;
                        for (String mentor : listMentor) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th>");
      out.print( a++ );
      out.write("</th>\n");
      out.write("                        <th>");
      out.print( mentor );
      out.write("</th>\n");
      out.write("                        \n");
      out.write("                    </tr>                   \n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
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
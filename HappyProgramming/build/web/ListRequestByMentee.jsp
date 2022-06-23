<%-- 
    Document   : ListRequestByMentee
    Created on : Jun 18, 2022, 5:01:01 PM
    Author     : ThienNho
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="DTO.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Request By Mentee Page</title>
    </head>
    <body>
        <header>
             <%@include file = "UserHeader.jsp" %>
        
        </header>
             <div class="body">
        <form action="MainController">
            <input type="submit" name="action" value="ListRequestByMentee"/>
        </form>
        
        <h2>Your Requests </h2>
        <%
            ArrayList<String> listSkill = (ArrayList) session.getAttribute("LIST_SKILL");
            Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");          
            ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_REQUEST_BY_MENTEE");
            int flag = 0;
            if (list != null) {               
                
                if (list.size() == 0) {
                    flag = 1;
                }
        %>
        <table border="1">
            
            <tbody>
                <%
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
                %>           
                <tr>
                    <td><%= req.getTitle()%></td>
                    <td><%= req.getStatus()%></td>
                    <td><%= req.getDeadlineDate()%></td>
                    <td><%= req.getDeadlineHour()%></td>
                    <td><%= req.getContent() %></td>
                    <td><%= x%></td>
                    <td><%= y%></td>
                    <td><%= z%></td>
                <form action="MainController">
                    <td>              
                        <input type="submit" name="action" value="DeleteRequest"/>
                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                      
                    </td>
                </form>
                <form action="UpdateRequest.jsp">
                    <td>
                        <input type="submit" value="UpdateRequest"/>
                        <input type="hidden" name="reqID" value="<%= req.getId() %>"/>                                              
                    </td>
                </form>

                </tr>
                <%
                }
                %>
                </tbody>
        </table>
        <%               
            }
            if (flag == 1) {
        %>
        <h3>You do not have any request</h3>
        <%
            }
        %>
             </div>
             <footer>
                 <%@include file = "Footer.jsp" %>
             </footer>
    </body>
</html>

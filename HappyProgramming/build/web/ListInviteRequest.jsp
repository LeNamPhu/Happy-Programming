<%-- 
    Document   : ListInviteRequest
    Created on : Jun 25, 2022, 10:38:10 PM
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
        <title>List Invite Request</title>
    </head>
    <body>       
        <form action="MainController">
            <input type="submit" name="action" value="Invite Request"/>
        </form>
        
        <%
            ArrayList<Request> listInviteRequest = (ArrayList) session.getAttribute("LIST_INVITE");
            Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_INVITE_REQUEST");
            if (listInviteRequest != null) {               
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Deadline Date</th>
                    <th>Deadline Hour</th>
                    <th>Skill 1</th>
                    <th>Skill 2</th>
                    <th>Skill 3</th>                                              
                    <th>Accept</th>                          
                    <th>Reject</th>
                </tr>
            </thead>
            <tbody>

                <%                   
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
                %>          
            <form action="MainController">
                <tr>
                    <th><%=req.getTitle() %></th>
                    <th><%=req.getContent() %></th>
                    <th><%=req.getDeadlineDate() %></th>
                    <th><%=req.getDeadlineHour() %></th>
                    <th><%= x %></th>
                    <th><%= y %></th>
                    <th><%= z %></th>                                                              
                    <th> <input type="submit" name="action" value="Accept Request"/>
                        <input type="hidden" name="reqID" value="<%= req.getId() %>"/>
                        <input type="hidden" name="status" value="Closed"/>
                        <input type="hidden" name="inviteStatus" value="closed"/>
                    
                    </th>                          
                    <th><input type="submit" name="action" value="Reject Request"/>
                        <input type="hidden" name="reqID" value="<%= req.getId() %>"/>
                        <input type="hidden" name="status" value="Processing"/>
                        <input type="hidden" name="inviteStatus" value="closed"/>
                    </th>                    
                </tr>
            </form>

            <%
                }
            %>
        </tbody>
        </table>
        <%               
            }
        %>
</body>
</html>

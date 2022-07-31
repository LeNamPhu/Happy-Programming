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
 <%if (session.getAttribute("role")!="Mentor") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Invite Request</title>
    </head>
    <body>     
        <header>

            <%@include file = "MentorHeader.jsp" %>

        </header> 
        <div class="body">
            <div style="width: 60%; margin: auto;">
               

                <%
                    ArrayList<Request> listInviteRequest = (ArrayList) session.getAttribute("LIST_INVITE");
                    Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_INVITE_REQUEST");
                    System.out.println(listInviteRequest);
                    if (listInviteRequest != null)
                    {
                %>
                

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
                        <div class="w-100 mt-5 p-3 border border-dark border-2">
                            <table class="w-100" style="height:100px;">   
                                <tr>
                                <td style="width: 20%"><%=req.getTitle()%></td>   
                                <td rowspan="3" style="width: 35%; border:solid 1px lightgrey;"><%=req.getContent()%></td>
                                <td style="width: 10%; text-align: center;"><%=x%></td>
                                <td rowspan="3" style=" width: 10%;"><%=req.getStatus()%></td>
                                <td rowspan="3" style="width: 25%;text-align: center;">
                                    <span> <input class="btn btn-primary"   type="submit" name="action" value="Accept Request"/>
                                    <input type="hidden" name="reqID" value="<%= req.getId()%>"/>
                                    <input type="hidden" name="status" value="Closed"/>
                                    <input type="hidden" name="inviteStatus" value="Closed"/>
                                    
                                </span>                          
                                    <span><input class="btn btn-primary" type="submit" name="action" value="Reject Request"/>
                                    <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                       
                                </span> 
                                </td>
                                </tr>
                                <tr>
                                    <td rowspan="2">
                                        <span><%=req.getDeadlineHour()%></span>h
                                    <span><%=req.getDeadlineDate()%></span>
                                    
                                    </td>
                                
                                
                                    <td style="text-align: center;"><%= y%></td>
                                                                                             
                                </tr>
                                <tr>
                                    <td style="text-align: center;"><%= z%></td> 
                                </tr>
                                </table>
                                </div>
                    </form>
                
                <%
                    }
                %>
                <a href="MainController?action=ListRequestByMentor" class="btn btn-lg btn-primary w-25 my-5 mx-auto d-flex justify-content-center">Back</a>

                <%
                    }else{%>
                    <h1>you have no inviting request!</h1>
<%}
                %>
            </div>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
<% } %>
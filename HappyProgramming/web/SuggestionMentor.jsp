<%-- 
    Document   : SuggestionMentor
    Created on : Jul 8, 2022, 8:11:56 PM
    Author     : ThienNho
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="DTO.Mentor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%if (session.getAttribute("role")!="User") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suggestion Mentor Page</title>
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>
        </header>
        <div class="body">
            <div style="width: 60%; margin: auto">
        <%
            ArrayList<String> accName = (ArrayList) session.getAttribute("LIST_ACCOUNTNAME");
            Map<String, Mentor> mapMentor = (Map) session.getAttribute("Map_Mentor");
            Map<String, Integer> mapInviteReq = (Map) session.getAttribute("Map_Invite");
            Map<String, Integer> mapAcceptedReq = (Map) session.getAttribute("Map_Accepted");
            String reqID = (String) request.getAttribute("REQ_ID");
            if (accName != null) {
                if (!accName.isEmpty()) {
        %>
        <h1 class="m-4">Mentor Suggestion:</h1>
        <%
            for (String acc : accName) {
        %>
        
        <form action="MainController" class="w-100">
            <div class="w-100 border border-2 border-dark mb-4 p-3">
            <table  class="w-100  "style="text-align: center; font-size: 20px;">


                <tr>
                    <td style="width: 15%;" class="ratio ratio-1x1"> <img class="border border-dark rounded-circle" src="image/<%= mapMentor.get(acc).getAvatar()%> "></td>
                    <td  style="width:25%; vertical-align: middle">Inviting Requests: <%=  mapInviteReq.get(acc)%> <br>
                        Accepted Requests: <%= mapAcceptedReq.get(acc)%></td>
                    <td rowspan="3" style="border: 1px solid lightgray;text-align: left;vertical-align:top;padding:15px; "> <%= mapMentor.get(acc).getServiceDesc()%></td>
                    
                </tr>
               
                <tr>
                    <td> <%= acc%> </td>
                    <td rowspan="2"  >
                        
                        <input class=" btn-lg btn btn-primary w-75" type="submit" name="action" value="Invite"/>
                        <input type="hidden" name="mentorID" value="<%= mapMentor.get(acc).getId()%>"/>
                        <input type="hidden" name="reqID" value="<%= reqID%>"/>
                    </td> 
                </tr>
                <tr>
                    
                    <td> <%= mapMentor.get(acc).getFullname()%> </td>
                    
                    
                    
                    
                    
                </tr>    
            </table>    
            </div>
        </form>
        <%
            }
        %>                       
        <div class="btn btn-lg btn-primary d-flex w-25 justify-content-center m-auto">
            <a style="color:white" href="MainController?action=ListRequestByMentee"> Return</a>
        </div>
        <%
        } else {
        %>
        <h3> THERE ARE NO MENTOR AVAILABLE FOR THIS REQUEST</h3>
        <%
                }
            }
        %>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>
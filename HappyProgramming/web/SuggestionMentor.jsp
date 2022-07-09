<%-- 
    Document   : SuggestionMentor
    Created on : Jul 8, 2022, 8:11:56 PM
    Author     : ThienNho
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="DTO.Mentor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%
        ArrayList<String> accName = (ArrayList) session.getAttribute("LIST_ACCOUNTNAME");
        Map<String, Mentor> mapMentor = (Map) session.getAttribute("Map_Mentor");
        Map<String, Integer> mapInviteReq = (Map) session.getAttribute("Map_Invite");
        Map<String, Integer> mapAcceptedReq = (Map) session.getAttribute("Map_Accepted");
         String reqID = (String) request.getAttribute("REQ_ID");
        if(accName != null){
            if(!accName.isEmpty()){
                %>
                <table border="1">
                    <thead>
                    <tr>                        
                        <th>Account Name</th>
                        <th>Full Name</th>
                        <th>Avatar</th>
                        <th>Service Description</th>
                        <th>Invite Request</th>
                        <th>Accept Request</th>                        
                    </tr>
                    </thead>
                    <tbody>
                        <%
                        for (String acc : accName) {
                        %>
                    <form action="MainController">
                        <tr>
                            <th> <%= acc %> </th>
                            <th> <%= mapMentor.get(acc).getFullname() %> </th>
                            <th> <%= mapMentor.get(acc).getAvatar() %> </th>
                            <th> <%= mapMentor.get(acc).getServiceDesc() %> </th>
                            <th> <%= mapInviteReq.get(acc) %> </th>
                            <th> <%= mapAcceptedReq.get(acc) %> </th>   
                            <th>
                                <input type="submit" name="action" value="Invite"/>
                                <input type="hidden" name="mentorID" value="<%= mapMentor.get(acc).getId() %>"/>
                                <input type="hidden" name="reqID" value="<%= reqID %>"/>
                             </th>
                        </tr>    
                        </form>
                        <%
                            }
                        %>                       
                    </tbody>                    
                </table>       
                <%
            }else{
        %>
        <h3> THERE ARE HAVE NOT SUGGESTION FOR THIS REQUEST</h3>
        <%
            }
        }
        %>
    </body>
</html>

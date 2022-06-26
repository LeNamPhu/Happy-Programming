<%-- 
    Document   : StatisticByMentee
    Created on : Jun 26, 2022, 1:42:23 PM
    Author     : ThienNho
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic of Requests</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <form action="MainController">
            <input type="submit" name="action" value="Statistic by Mentee"/>
        </form>
        <%
        ArrayList<String> listMentor = (ArrayList) request.getAttribute("LIST_MENTOR");
        ArrayList<String> listTitle = (ArrayList) request.getAttribute("LIST_TITLE");      
        String totalHour = (String)request.getAttribute("TOTAL_HOUR");
        String totalRequest = (String)request.getAttribute("TOTAL_REQUEST");
        if(listTitle != null){
        %>
        <h4>Total Request</h4> <%=totalRequest%>
        <h4>Total Hour</h4> <%=totalHour%>
        
        <table border="1">
            <thead>
                    <tr>
                        <th>No</th>
                        <th>List Title</th>                       
                    </tr>
                </thead>
                <tbody>                    
                     <%
                        int count = 1;
                        for (String title : listTitle) {
                    %>
                    <tr>
                        <th><%= count++ %></th>
                        <th><%= title %></th>
                        
                    </tr>                   
                    <%
                    }
                    %>
                </tbody>
        </table>
                
                <table border="1">
            <thead>
                    <tr>
                        <th>No</th>
                        <th>List Mentor</th>                       
                    </tr>
                </thead>
                <tbody>                    
                     <%
                        int a = 1;
                        for (String mentor : listMentor) {
                    %>
                    <tr>
                        <th><%= a++ %></th>
                        <th><%= mentor %></th>
                        
                    </tr>                   
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

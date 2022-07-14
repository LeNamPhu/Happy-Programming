<%-- 
    Document   : StatisticByMentee
    Created on : Jun 26, 2022, 1:42:23 PM
    Author     : ThienNho
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%if (session.getAttribute("role")!="User") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic of Requests</title>
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>

        </header>
            <div class="body"> 
                <div style="width: 70%" class="m-auto ">
        <%
            ArrayList<String> listMentor = (ArrayList) request.getAttribute("LIST_MENTOR");
            ArrayList<String> listTitle = (ArrayList) request.getAttribute("LIST_TITLE");
            String totalHour = (String) request.getAttribute("TOTAL_HOUR");
            String totalRequest = (String) request.getAttribute("TOTAL_REQUEST");
            if (listTitle != null) {
        %>
        <div class=" w-75 m-auto mt-5 p-4" style="box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
        <div class="d-flex justify-content-between m-3" style="font-size: 30px; vertical-align: middle">
           
            <div><span>Total Request</span> <%=totalRequest%></div>
        <div> <span>Total Hour</span> <%=totalHour%></div>
        <div> <span> Total Mentor</span> <%=listMentor.size()%></div>
        </div>
        <table  class="w-75 m-auto table ">
            
            <thead>
                <tr>
                    <th>#</th>
                    <th>Request Title</th>                       
                </tr>
            </thead>
            <tbody>                    
                <%
                    int count = 1;
                    for (String title : listTitle) {
                %>
                <tr>
                    <th><%= count++%></th>
                    <th><%= title%></th>
                    <th></th>

                </tr>                   
                <%
                    }
                %>
            </tbody>
        </table>

        <%
            }
        %>
        </div>
        <div class="" style="text-align: center">
        <a class="btn btn-lg btn-primary my-5" href="MainController?action=ListRequestByMentee" style=""> Go Back</a>
        </div>
                </div>
       
            </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>
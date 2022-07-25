<%-- 
    Document   : StatisticByMentee
    Created on : Jun 26, 2022, 1:42:23 PM
    Author     : ThienNho
--%>

<%@page import="DTO.Request"%>
<%@page import="java.util.Map"%>
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
            String totalMentor = (String) request.getAttribute("TOTAL_MENTOR");
            Map map = (Map) request.getAttribute("MAP");
            ArrayList<Request> listRequest = (ArrayList) request.getAttribute("LIST_REQUEST");
            if (listRequest != null) {
                int totalRequest = 0;
                int totalHour = 0;
                for (Request elem : listRequest) {
                        totalRequest++;
                        totalHour += elem.getDeadlineHour();
                    }
        %>
        <p>   Total of requests: <%= totalRequest %>     Total of hours: <%= totalHour %>       Total of Mentors: <%= totalMentor %></p>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Mentor</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (Request elem : listRequest) {
                            count++;
                            String mentor = "";
                            if(map.get(elem) != null){                          
                                mentor = (String) map.get(elem);
                            }
                            %>
                            <tr>
            <td><%= count %></td>
            <td><%= elem.getTitle() %></td>
            <td><%= elem.getStatus() %></td>
            <td><%= mentor %></td>
                <%
                        }
                %>
                            </tr>
            </tbody>
            
        </table>
        
        
        
        
        
        
        
        
        
        
        
<%--        <div class=" w-75 m-auto mt-5 p-4" style="box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
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
--%>
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
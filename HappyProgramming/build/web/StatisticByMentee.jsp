<%-- 
    Document   : StatisticByMentee
    Created on : Jun 26, 2022, 1:42:23 PM
    Author     : ThienNho
--%>

<%@page import="DTO.Account"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DTO.Request"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("role") != "User") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
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
                    Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
                    int menteeID = user.getId();
                    String totalMentor = (String) request.getAttribute("TOTAL_MENTOR");
                    Map map = (Map) request.getAttribute("MAP");
                    ArrayList<Request> listRequest = (ArrayList) request.getAttribute("LIST_REQUEST");
                    if (listRequest != null) {
                        int totalRequest = 0;
                        int totalHour = RequestDAO.getHoursOfRequestByMenteeID(menteeID);
                        for (Request elem : listRequest) {
                            totalRequest++;
                        }
                %>
                <div class="d-flex justify-content-around my-3 p-2 border-dark border-2 border" style="font-size: 26px;">
                    <span>   
                        Total of requests: <%= totalRequest%>        
                    </span>
                    <span>
                        Total of hours: <%= totalHour%> 
                    </span>
                    <span> 
                        Total of Mentors: <%= totalMentor%>
                    </span>
                </div>
                <table class="table ">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Title</th>
                            <th>Status</th>
                            <th>Mentor</th>
                            <th>Rate Mentor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 0;
                            for (Request elem : listRequest) {
                                count++;
                                String mentor = "";
                                if (map.get(elem) != null) {
                                    mentor = (String) map.get(elem);
                                }
                        %>
                        <tr>
                            <td><%= count%></td>
                            <td><%= elem.getTitle()%></td>
                            <td><%= elem.getStatus()%></td>
                            <td><%= mentor%></td>
                            <td>
                                <%
                                    if (!mentor.isEmpty()) {
                                %>

                                <form action="Rate.jsp">
                                    <input class="btn-primary btn" type="submit" value="Rate Mentor">
                                    <input type="hidden" name="mentorName" value="<%=mentor%>">
                                </form>

                                <%
                                }%>
                            </td>
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
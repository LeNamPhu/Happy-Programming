<%-- 
    Document   : AdminViewMentee
    Created on : Jul 6, 2022, 2:38:40 PM
    Author     : DELL
--%>

<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Mentee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("role") != "Admin") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

        <style>
            table, table tr{
                border: 1px solid;
                width:99%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 10%;
                border: 1px solid;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>

        <div class="body">
            <%ArrayList<Mentee> list = MenteeDAO.getAllMentees(); %>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Account Name</th>
                    <th>Total hours of all requests</th>
                    <th>Total skills of requests</th>
                </tr>
                <% if (list != null && !list.isEmpty()) {
                        for (Mentee mt : list) { %>
                        <tr>
                            <td><%=mt.getFullname()%></td>
                            <td><%=MenteeDAO.getAccountNameByMenteeID(mt.getId())%></td>
                            <td><%=RequestDAO.getHoursOfRequestByMenteeID(mt.getId())%></td>
                            <td><%=SkillDAO.totalSkillsofRequests(mt.getId())%></td>
                        </tr>
                <%}
                    }
                %>
            </table><br>
            <b style="margin-left: 1%">Number of mentee(s): <%=list.size()%></b>

        </div>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>

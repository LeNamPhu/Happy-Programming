<%-- 
    Document   : AdminViewStatMentee
    Created on : Jul 3, 2022, 12:15:38 PM
    Author     : DELL
--%>

<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Mentee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <style>
            table, table tr{
                border: 1px solid;
                width:80%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 15%;
                border: 1px solid;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>

        <div class="body">
            <% ArrayList<Mentee> list = MenteeDAO.getAllMentees();
            %>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Account name</th>
                    <th>Total hours of all requests</th>
                    <th>Total skills of requests</th>
                </tr>
                <%for (Mentee mt : list) {%>
                <tr>
                    <td><%=mt.getFullname()%></td>
                    <td><%=MenteeDAO.getMenteeAccountNameById(mt.getId())%></td>
                    <td><%=RequestDAO.getHoursOfRequestByMenteeID(mt.getId())%></td>
                    <td><%=SkillDAO.getTotalSkillsByMenteeID(mt.getId())%></td>
                </tr>  
                <% }
                %>
            </table><br>
            <b style="margin-left: 10%">Number of mentee: <%=list.size()%></b>
        </div>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>

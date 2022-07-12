<%-- 
    Document   : AdminViewRequestDetail
    Created on : Jul 6, 2022, 3:27:40 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Request"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DAO.MenteeDAO"%>
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
        <style>
            table, table tr{
               
                width:99%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 10%;
               
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>

        <div class="body">
            <%
                int count = 1;
                int ID = Integer.parseInt(request.getParameter("ID"));
                Request req = RequestDAO.getARequestDetail(ID);
                ArrayList<String> list = RequestDAO.getAllSkillsNameByRequestID(ID);
            %>

            
            <table class="table">

                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Account name</th>
                    <th>Title</th>
                    <th>Skill</th>
                    <th>Status</th>
                    <th>Content</th>
                    <th>Deadline Datetime</th>
                    <th>Created Date</th>
                </tr>

                <tr><td><%=count++%></td>
                    <td><%=req.getId()%></td>
                    <td><%=MenteeDAO.getAccountNameByMenteeID(req.getMenteeID())%></td>
                    <td><%=req.getTitle()%></td>
                    <td><%for (int i = 0; i < list.size(); i++) {
                            if (i != list.size() - 1) {%>
                        <%=list.get(i)%>,
                        <%} else {%>
                        <%=list.get(i)%>
                        <%}
                            }
                        %></td>
                    <td><%=req.getStatus()%></td>
                    <td><%=req.getContent()%></td>
                    <td><%=req.getDeadlineHour()%>h <%=req.getDeadlineDate()%></td>
                    <td><%=RequestDAO.getCreatedDateByRequestID(req.getId())%></td>
                </tr>

            </table><br>
            <a href="AdminViewRequest.jsp?page=1"><button class="btn btn-light btn-outline-dark" style="margin-left: 40%;width: 10%" >Back</button></a>
        </div>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>

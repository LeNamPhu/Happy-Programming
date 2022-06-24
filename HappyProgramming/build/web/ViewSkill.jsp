<%-- 
    Document   : ViewSkill
    Created on : Jun 13, 2022, 3:37:48 PM
    Author     : admin
--%>

<%@page import="DAO.SkillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Skill"%>
<%@page import="DTO.Skill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skill</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            table, table tr{
                border: 1px solid;
                width:50%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 15%;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>

        <div class="body">
            <%ArrayList<Skill> list = SkillDAO.getAllSkill();
                int count = 1;%>
            <%if (list != null && !list.isEmpty()) {
            %>
            <table >
                <tr><th >STT</th>
                    <td></td>
                    <th >Skill name</th>                  
                        <%    for (Skill sk : list) {
                                if (sk.getStatus().equals("active")) {
                        %>               
                <tr><td ><%=count++%></td>
                    <td><img src="<%=sk.getImage()%>"style="width:150px; height:120px;"></td>
                    <td><%=sk.getName()%></td></tr>
                    <% }
                        }%>
            </table>   
            <%    }%>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

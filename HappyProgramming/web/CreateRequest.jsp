<%-- 
    Document   : CreateRequest
    Created on : Jun 29, 2022, 9:53:40 PM
    Author     : trida
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Skill"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.SkillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("role") != "User") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Request</title>
<!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->
    </head>
    <body>
        <header>

            <%@include file = "UserHeader.jsp" %>

        </header>


        <div class="body">

            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Create Request</h1>
            <form action="MainController" method="post">
                <table style=";font-size: 25px" class="d-flex justify-content-center" id="createrequesttable">
                    <tr><td id="createrequestpass">Title</td><td><input type="text" name="title" style="width: 400px"></td></tr>
                    <tr><td id="createrequestpass">Deadline date</td><td><input type="date" name="deadlineDate" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Deadline hour</td><td><input type="text" name="deadlineHour" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Content</td><td><input type="text" name="content" style="width: 400px; height: 150px" id="createrequestform"/></td></tr>
                    <tr>
                        <td id="first">Skill</td><td id="input">
                            <%
                                ArrayList<Skill> listSkill = SkillDAO.getAllSkill();
                                
                            %>
                            <select name="skill1">
                                <option value="<%= 0%>"><%= ""%></option>
                                <%
                                    for (Skill skill : listSkill) {
                                        if (!"inactive".equals(skill.getStatus())) {
                                %>
                                <option value="<%= skill.getId()%>"><%= skill.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>

                            <select name="skill2">
                                <option value="<%= 0%>"><%= ""%></option>
                                <%
                                    for (Skill skill : listSkill) {
                                        if (!"inactive".equals(skill.getStatus())) {
                                %>
                                <option value="<%= skill.getId()%>"><%= skill.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>

                            <select name="skill3">
                                <option value="<%= 0%>"><%=""%></option>
                                <%
                                    for (Skill skill : listSkill) {
                                        if (!"inactive".equals(skill.getStatus())) {
                                %>
                                <option value="<%= skill.getId()%>"><%= skill.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td> 
                    </tr>

                </table>

                <div>
                    <!--                    <input type="submit" class="createrequest" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >-->
                    <input type="submit" name="action" value="Add" class="btn btn-primary btn-lg createrequest"style="font-size: 25px;width:400px;height: 60px;" />

                    <input type="submit" name="action" class="createrequest btn btn-light btn-outline-dark" value="Cancel" style="font-size: 25px;width:400px;height: 60px;" >
                </div>
            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html> 
<% }%>
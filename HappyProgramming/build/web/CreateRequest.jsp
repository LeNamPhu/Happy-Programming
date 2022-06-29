<%-- 
    Document   : CreateRequest
    Created on : Jun 28, 2022, 2:58:54 PM
    Author     : Admin
--%>

<%@page import="DTO.Skill"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.SkillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Request</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>

            <%@include file = "MentorHeader.jsp" %>

        </header>

        <%
            String id = request.getParameter("id");
            Skill sk = SkillDAO.getASkill(id);
        %>

        <div class="body">
            
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Create Request</h1>
            <form action="MainController" method="POST">
                <table style=";font-size: 25px" class="d-flex justify-content-center" id="createrequesttable">
                    <tr><td id="createrequestpass">Title</td><td><input type="text" name="txttitle" style="width: 400px" id="createrequestform"></td></tr>
                    <tr><td id="createrequestpass">Deadline date</td><td><input type="text" name="textDeadlineDate" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Deadline hour</td><td><input type="text" name="textDeadlineHour" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Content</td><td><input type="text" name="textDeadlineHour" style="width: 400px; height: 150px" id="createrequestform"/></td></tr>
                    <tr>
                        <td id="createrequestpass">Skill</td>
                        <td>
                            <div>
                                <input type="checkbox" id="skill1" name="skill1" value="Java">
                                <label for="skill1"> Java</label><br>
                                <input type="checkbox" id="skill2" name="skill2" value="Mockito">
                                <label for="skill2"> Mockito</label><br>
                                <input type="checkbox" id="skill3" name="skill3" value="SQLServer">
                                <label for="skill3"> SQLServer</label><br><br>
                            </div>
                        </td></tr>

                </table>

                <div style="text-align: center">
                    <input type="submit" class="createrequest" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >
                    <input type="submit" class="createrequest" value="Cancel" style="font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)" >
                </div>
            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html>

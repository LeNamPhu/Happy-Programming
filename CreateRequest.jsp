<%-- 
    Document   : CreateRequest
    Created on : Jun 29, 2022, 9:53:40 PM
    Author     : trida
--%>

<%@page import="DTO.RequestError"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Skill"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.SkillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%if (session.getAttribute("role")!="User") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
                
                
            <%RequestError requestError = (RequestError) request.getAttribute("REQUEST_ERROR");  //cai nay
            if(requestError == null){
                requestError = new RequestError();
            }%>       
                
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

            <%@include file = "UserHeader.jsp" %>

        </header>


        <div class="body">

            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Create Request</h1>
            <form action="MainController" method="post">
                <table style=";font-size: 25px" class="d-flex justify-content-center" id="createrequesttable">
                    <tr><td id="createrequestpass">Title</td><td><input type="text" name="title" style="width: 400px">
                        </td></tr>
                    <tr><td id="createrequestpass">Deadline date</td><td><input type="date" name="deadlineDate" min="<%=LocalDate.now().plusDays(1)%>" max="<%=LocalDate.now().plusDays(14)%>" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Deadline hour</td><td><input type="text" name="deadlineHour" style="width: 400px" id="createrequestform"/>
                        <p style="color : red; font-size:20px"><%=requestError.getHourError()%></p></td></tr> //cai nay
                    <tr><td id="createrequestpass">Content</td><td><input type="text" name="content" style="width: 400px; height: 150px" id="createrequestform"/>
                        <p style="color : red; font-size:20px"><%=requestError.getContentError()%></p></td></tr>  //cai nay
                    <tr>
                        <td id="createrequestpass">Skill</td>
                        <td>
                            <%--
                                // String id = request.getParameter("id");
                                ArrayList<Skill> list = SkillDAO.getAllSkill();
                                int count = 1;
                                if (list != null && !list.isEmpty()) {
                                    for (Skill sk : list) {
                                        if (sk.getStatus().equals("active")) {
                            %>   
                            <div>
                                <input type="checkbox" id="<%=sk.getId()%>" name="skillCheckBox<%=count++%>" value=" <%=sk.getName()%>">
                                <label for="<%=sk.getId()%>"> <%=sk.getName()%></label><br>
                            </div>
                            <%}
                                    }
                                }
                            --%>
                        </td></tr>

                </table>

                <div>
<!--                    <input type="submit" class="createrequest" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >-->
                    <input type="submit" class="createrequest" value="Cancel" style="font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)" >
                    <input type="submit" name="action" value="Add"/>
                </div>
            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html> 
<% } %>

<%-- 
    Document   : ChangePassword
    Created on : Jun 14, 2022, 2:47:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%if (session.getAttribute("role")!="User") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
<!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>
        </header>
        <% String placeholder;
            if (request.getParameter("txtuser") != null) {
                placeholder = request.getParameter("txtuser");
            } else {
                placeholder = "";
            }

        %>
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%; font-size: 40px; font-weight: normal">Please enter your email and password</h1>
            <form action="MainController">
                <table style=";font-size: 25px" class="d-flex justify-content-center" id="resettable">
                    <%if (request.getAttribute("ERROR_MESSAGE") != null) {
                    %>


                    <tr>
                        <td>
                            <div class="alert alert-danger p-2" style="font-size: 20px;">
                                <p><%=request.getAttribute("ERROR_MESSAGE")%></p>
                            </div>
                        </td>
                    </tr>

                    <%}%>       
                    <tr><td id="resetpass">Account Name</td><td><input type ="text" id="resetform" name="txtuser" value="<%=placeholder%>">  </td> </tr>
                    <tr><td id="resetpass">Old Password</td><td><input type ="password" id="resetform" name="txtpass"></td></tr>
                    <tr><td id="resetpass">New Password</td><td><input type ="password" id="resetform" name="txtnewpass"></td></tr>
                    <tr><td id="resetpass">Confirm Password</td><td><input type ="password" id="resetform" name="txtconfirmpass"></td></tr>
                </table>

                <div class="m-5 d-flex justify-content-around">
                    <input class="btn btn-primary btn-lg" type="submit" name="action" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" />   
                    <form action="UserHomePage.jsp">
                        <input class="btn btn-primary btn-lg" type="submit"value="Cancel" style="font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)" />
                    </form>
                </div>   
                   
            </form>
        </div>

        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>
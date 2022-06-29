<%-- 
    Document   : ChangePassword
    Created on : Jun 14, 2022, 2:47:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>
        </header>
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%; font-size: 40px; font-weight: normal">Please enter your email and password</h1>

            <table style=";font-size: 25px" class="d-flex justify-content-center" id="resettable">
                <tr><td id="resetpass">Account Name</td><td><input type ="text" id="resetform" name="">  </td> </tr>
                <tr><td id="resetpass">Old Password</td><td><input type ="password" id="resetform" name=""></td></tr>
                <tr><td id="resetpass">New Password</td><td><input type ="password" id="resetform" name=""></td></tr>
                <tr><td id="resetpass">Confirm Password</td><td><input type ="password" id="resetform" name=""></td></tr>
            </table>

            <div >
                <input type="submit" class="reset" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >
                <input type="submit" class="reset" value="Cancel" style="font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)" >
            </div>
        </div>

        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

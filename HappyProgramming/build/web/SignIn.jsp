<%-- 
    Document   : SignIn
    Created on : Jun 13, 2022, 3:39:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>
            
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%">Sign in</h1>
            <table style="margin-left: 35%;font-size: 25px">
                <tr><td>Email</td></tr>
                <tr><td><input type="text" name="txtemail" style="width: 400px"></td></tr>
                <tr><td>Password</td></tr>
                <tr><td><input type="password" name="txtpass" style="width: 400px"></td></tr>
                <tr><td style="padding: 8px 0px 20px 200px"><a href="ChangePassword.jsp" style="color: #439DBB">Forgot Password?</a></td></tr>
                <tr><td><input type="submit" value="Sign in" style="width:400px;height: 60px;background-color: blue;color: white " ></td></tr>
            </table>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp"%>
        </header>           
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Sign In</h1>
            <form action="MainController">
                <table style=";font-size: 25px" class="d-flex justify-content-center">
                    <tr><td>Account Name</td></tr>
                    <tr><td><input type="text" name="txtemail" style="width: 400px"></td></tr>
                    <tr><td>Password</td></tr>
                    <tr><td><input type="password" name="txtpass" style="width: 400px"></td></tr>
                    <tr><td style="padding: 10px 0px 10px 200px"><a href="ForgotPassword.jsp" style="color: #439dbb">Forgot Password?</a></td></tr>
                    <tr><td><input type="submit" name="action" value="Sign in" style="width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" ></td></tr>
                </table>
            </form>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

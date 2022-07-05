<%-- 
    Document   : ForgotPassword
    Created on : Jun 14, 2022, 4:21:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>

        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>


        <div class="body">
            <div style="height: 700px; width:850px ; margin:auto; margin-top:50px;" class="d-flex justfy-content-center text-align-center flex-column border border-secondary mb-5">
                <div style="padding:20px;">
                <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Forgot Password</h1>
                <p style="text-align: center;font-size: 35px"class="text-aign-center">No Problem! Enter your email and account name below and we will send you an email with instruction to reset your password</p>
                <table style=";font-size:30px" class="d-flex justify-content-center">
                <tr><td>Email</td></tr>
                <tr><td><input type="text" name="txtemail" style="width: 550px"></td></tr>
                
                <tr><td>Account Name</td></tr>
                <tr><td><input type="password" name="txtpass" style="width: 550px"></td></tr>

               
                <tr><td> <div class="d-grid"><input class="btn btn-primary btn-lg mt-4 " type="submit" value="Send Reset Link" style="font-size: 25px;" >  </div></td></tr>
               
                <tr><td><div class="d-grid"><a class="btn btn-light btn-lg mt-4" style="font-size: 25px;" href="SignIn.jsp">Back to Login</a></div><td><tr>
            </table>
                </div>
            </div>
            </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>

    </body>
</html>

<%-- 
    Document   : Unauthorised
    Created on : Jul 2, 2022, 7:23:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unauthorized</title>
<!--                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->

    </head>
    <body>
        <header>
            <%@include file = 'UnregisteredHeader.jsp' %>
        </header>
        <div class=" body w-100 d-flex flex-column justify-content-center" style="height:87vh">
        <div class="   mx-auto my-5 h-50 d-flex flex-column justify-content-center " style="box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; text-align: center; vertical-align: middle; width:60%   ">
            
            
            <h1 style="color:red;" >YOU ARE NOT AUTHORIZED TO ACCESS THIS PAGE!!!</h1>
            <br>
            <p style="font-size: 25px;">Please go back to home page</p>
            <br>
            <div>
        <a class="btn btn-lg btn-primary m-3 p-3" href="HomePage.jsp">Return to Home Page </a>
        </div>
           
        </div>
        </div>
        <footer>
             <%@include file = 'Footer.jsp' %>
        </footer>
    </body>
</html>

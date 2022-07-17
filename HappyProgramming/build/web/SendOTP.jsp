<%-- 
    Document   : SendOTP
    Created on : Jun 16, 2022, 11:23:47 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Sent!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>

        <div class="body d-flex justify-content-center align-content-center flex-column" style=" height:86.69vh;" >
            <div style="vertical-align: middle;height: 500px; width:850px ; margin:auto;" class="d-flex justify-content-center text-align-center flex-column border border-secondary">
                <div style="padding:20px;">           
                    <p style="text-align: center;font-size: 35px; color: green"class="text-align-center">You account has been successfully created!</p>
                    <p style="text-align: center;font-size: 35px; color: black"class="text-align-center">Please check your email to confirm the information of your account.</p>
                    <br>
                    <div  style="text-align: center"><a style="height: 60px;
                                 
                                 font-size: 27px;"type="button" class="btn btn-primary" href="HomePage.jsp" >Back to Home Page</a></div>
                </div>
            </div>
        </div>

        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

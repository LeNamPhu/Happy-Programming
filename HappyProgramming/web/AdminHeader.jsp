<%-- 
    Document   : AdminHeader
    Created on : Jun 17, 2022, 10:13:14 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->

    </head>
    <body>
        <nav class="container-fluid header ">
            <div class="row">
                <a class="col-md-8" href="HomePage.jsp"><img  class="logo" src="image/cafe2.png" /></a>
                <a class="col-md-1" href="HomePage.jsp" >Home</a>
                <a class="col-md-1" href="ViewMentor.jsp" >Mentor</a>
                <a class="col-md-1" href="ViewMentee.jsp" >Mentee</a>

                <div class="col-md-1 d-flex">
                    <a  href=""><img style="background-color: white" class="avatar" src="image/avatar.png" /></a>
                    <div class="dropdown">
                        <button type="button" class="btn  dropdownbutton" data-bs-toggle="dropdown">
                            
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Skill</a></li>
                            <li><a class="dropdown-item" href="#">Request</a></li>
                            <li><a class="dropdown-item" href="#">Log out</a></li>
                        </ul>
                    </div> 
                </div>
            </div>


        </nav>

    </body>
</html>
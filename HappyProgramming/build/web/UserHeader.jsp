<%-- 
    Document   : UserHeader
    Created on : Jun 15, 2022, 10:56:06 PM
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
        <nav class="container-fluid header ">
            <div class="row">
                <div class="col-md-7">

                    <a class="logo "href="UserHomePage.jsp"><img    src="image/cafe2.png" /></a>
                </div>                <a class="col-md-1" href="UserHomePage.jsp" >Home</a>
                <a class="col-md-1" href="ViewMentor.jsp" >Mentor</a>
                <a class="col-md-1" href="ViewSkill.jsp" >Skill</a>
                <a class="col-md-1" href="ListRequestByMentee.jsp" >Request</a>
                <div class="col-md-1 d-flex">
                    <a  href=""><img style="background-color: white" class="avatar" src="image/avatar.png" /></a>
                    <div class="dropdown">
                        <button type="button" class="btn  dropdownbutton" data-bs-toggle="dropdown">

                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Profile</a></li>
                            <li><a class="dropdown-item" href="#">Change Password</a></li>
                            <li><a class="dropdown-item" href="#">Log out</a></li>
                        </ul>
                    </div> 
                </div>
            </div>


        </nav>

    </body>
</html>

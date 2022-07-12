<%-- 
    Document   : MenteeProfile
    Created on : Jul 9, 2022, 3:09:00 PM
    Author     : ADMIN
--%>

<%@page import="DTO.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        label{
            display:inline-block;
            width:200px;
            margin-right:30px;
            text-align:left;
            margin-bottom: 10px;

        }

        input{

        }


    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentee Profile</title>
    </head>

    <header>
        <jsp:include page='${sessionScope.role}Header.jsp' />
    </header>
    <form action="MainController" method="POST">
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Update Profile</h1>
            <table style=";font-size: 25px" class="d-flex justify-content-center" id="updateform">
                <tr><td id="updatename">Account Name</td><td><input type ="text", id="updateform", name="accountname", size="30"></td></tr>
                <tr><td id="updatename">Email</td><td><input type ="text", id="updateform", name="email", size="30"></td></tr>
                <tr><td id="updatename">Full Name</td><td><input type ="text", id="updateform", name="fullName", size="30"></td></tr>                 
                <tr><td id="updatename">Date of Birth</td><td><input type ="date", id="updateform", name="dob", size="30"></td></tr>
                <tr><td id="updatename">Sex</td><td>
                        <select name="sex">
                            <option value="M">Male</option>
                            <option value="F">Female</option>
                            <option value="O">Other</option>
                        </select></td></tr>
                <tr><td id="updatename">Address</td><td><input type ="", id="signupform", name="address", size="30"></td></tr>

            </table>
            <br>
            <div style="text-align: center" class="d-grid w-25 m-auto" >
                <input type="submit" name ="action" value="Update" class="btn btn-lg btn-primary" >
            </div>
        </div>
    </form>

    <footer>
        <%@include file = "Footer.jsp" %>
    </footer>

</html>

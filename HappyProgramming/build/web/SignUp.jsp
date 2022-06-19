<%-- 
    Document   : SignUp
    Created on : Jun 11, 2022, 10:08:23 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>
            
       
            <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Sign up</h1>
            <table style=";font-size: 25px" class="d-flex justify-content-center" id="signuptable">
                <tr><td id="signupname">Account Name</td><td><input type ="text", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Email</td><td><input type ="text", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Password</td><td><input type ="password", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Confirm Password</td><td><input type ="text", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Full Name</td><td><input type ="text", id="signupform", name=""></td></tr>            
                <tr><td id="signupname">Phone Number</td><td><input type ="", id="signupform", name=""></td></tr>            
                <tr><td id="signupname">Date of Birth</td><td><input type ="date", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Sex</td><td><select><option>Male</option>
                            <option>Female</option>
                            <option>Other</option></select></td></tr>
                <tr><td id="signupname">Address</td><td><input type ="", id="signupform", name=""></td></tr>
                <tr><td id="signupname">Role</td><td class=><div id="role">
                            <label class="contain">Mentee
                                <input type="radio" checked="checked" name="radio">
                                <span class="checkmark"></span>
                            </label>
                            <label class="contain">Mentor
                                <input type="radio" name="radio">
                                <span class="checkmark"></span>
                            </label></div></td></tr>
            </table>
            <div >
                <input type="submit" class="signup" value="Sign up" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >
            </div>
        </div> 
        
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

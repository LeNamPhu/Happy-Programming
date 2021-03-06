

<%-- 
    Document   : SignUp
    Created on : Jun 11, 2022, 10:08:23 AM
    Author     : admin
--%>
<%@page import="DTO.UserError"%>
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
            <%UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if(userError == null){      //code java
                userError = new UserError();
            }%>
        
        <form action="MainController" method="POST">
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Sign up</h1>
            <table style=";font-size: 25px" class="d-flex justify-content-center" id="signuptable">
                <tr><td id="signupname">Account Name</td><td><input type ="text", id="signupform", name="accountName">
                     <p style="color : red; font-size:20px"><%=userError.getAccError()%></p></td></tr>
                <tr><td id="signupname">Email</td><td><input type ="text", id="signupform", name="email">
 <p style="color : red; font-size:20px"><%=userError.getEmailError()%></p>
                        <!--                    <a href = "mailto: abc@example.com"></a> --></td></tr>
                <tr><td id="signupname">Password</td><td><input type ="password", id="signupform", name="password"><p></p></td></tr>
                <tr><td id="signupname">Confirm Password</td><td><input type ="password", id="signupform", name="confirm">
                     <p style="color : red; font-size:20px"><%=userError.getPassError()%></p></td></tr>
                <tr><td id="signupname">Full Name</td><td><input type ="text", id="signupform", name="fullName"><p></p></td></tr>            
                <tr><td id="signupname">Phone Number</td><td><input type ="", id="signupform", name="phone">
                    <p style="color : red; font-size:20px"><%=userError.getPhoneError()%></p></td></tr>            
                
                <tr><td id="signupname">Date of Birth</td><td><input type ="date", id="signupform", name="dob"></td></tr>
                 <tr><td id="signupname">Sex</td><td>
                         <select name="sex">
                             <option value="M">Male</option>
                             <option value="F">Female</option>
                             <option value="O">Other</option>
                         </select></td></tr>
                <tr><td id="signupname">Address</td><td><input type ="", id="signupform", name="address"></td></tr>
                <tr><td id="signupname">Role</td><td class=><div id="role">
                            <label class="contain">Mentee
<!--                                <input type="radio" checked="checked" name="radio">-->
                                <input type="radio" checked="checked" value=1 name="roleId">
                                <span class="checkmark"></span>
                            </label>
                            <label class="contain">Mentor
<!--                                <input type="radio" name="radio">-->
                                <input type="radio" value=2 name="roleId">
                                <span class="checkmark"></span>
                            </label></div></td></tr>

            </table>
                <br>
                <div style="text-align: center" class="d-grid w-25 m-auto mb-4" >
                    <input type="submit" name ="action" value="Create" class="btn btn-lg btn-primary" >
            </div>
        </div>
        </form>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
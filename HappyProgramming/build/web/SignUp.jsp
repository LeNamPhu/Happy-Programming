lines (67 sloc)  3.75 KB

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
                    <%=userError.getAccError()%></td></tr>
                <tr><td id="signupname">Email</td><td><input type ="text", id="signupform", name="email">
<!--                    <a href = "mailto: abc@example.com"></a> --></td></tr>
                <tr><td id="signupname">Password</td><td><input type ="password", id="signupform", name="password"></td></tr>
                <tr><td id="signupname">Confirm Password</td><td><input type ="text", id="signupform", name="confirm">
                    <%=userError.getPassError()%></td></tr>
                <tr><td id="signupname">Full Name</td><td><input type ="text", id="signupform", name="fullName"></td></tr>            
                <tr><td id="signupname">Phone Number</td><td><input type ="", id="signupform", name="phone"></td></tr>            
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
            <div >
                <input type="submit" name ="action" value="Create" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >
            </div>
        </div>
        </form>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
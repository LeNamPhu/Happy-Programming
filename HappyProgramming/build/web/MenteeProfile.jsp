<%-- 
    Document   : MenteeProfile
    Created on : Jul 9, 2022, 3:09:00 PM
    Author     : ADMIN
--%>

<%@page import="DTO.Mentee"%>
<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("role") != "User") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
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
        <link rel="stylesheet" href="virtual-select.min.css">
        <script src="virtual-select.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    </head>

    <header>
        <jsp:include page='UserHeader.jsp' />
    </header>
    <%
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int menteeID = user.getId(); 
            Mentee mt = MenteeDAO.getAccountByMenteeID(menteeID);%>
    <form action="MainController" method="POST">
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Update Profile</h1>
            <div class="row " style="margin:0!important">
                <div class="col-md-5 d-flex justify-content-end" style="text-align:center">
                    <div class="p-4">
                        <div style="height:162px; width:162px;position:relative;margin:auto">
                            <img id="avt" class="rounded-circle border"  src="image/<%=MenteeDAO.getAMenteeAvatar(menteeID)%>" style="height:100%;width:100%">

                            <div style=" position:absolute; right:5px; bottom:5px; height:30px; width:30px; border-radius: 50%; background-color: white">
                                <i class="fa-solid fa-camera" style="font-size:30px;height:100%; position:absolute; right:5px; bottom:5px;"></i>

                                <input  type="file" name="avatar" accept="image/*"

                                        onchange="document.getElementById('avt').src = window.URL.createObjectURL(this.files[0])" style="width: 100%; height:100%; opacity: 0;">
                            </div>
                        </div>
                    </div>
                 <%--   <input  readonly style="margin: auto; height:50px; width:300px; text-align: center" type="text" placeholder="" class="form-control" name="accName" value="<%=user.getAccountName()%>"> --%>
                </div>
                <div class="col-md-5 pt-2">
                    <table style=";font-size: 25px" class="d-flex  " id="updateform">
                        <input type="hidden" name="ID" value="<%=mt.getId()%>">
                        <tr><td id="updatename">Account Name</td><td><input value="<%=MenteeDAO.getAccountNameByMenteeID(menteeID)%>" readonly="" type ="text", id="updateform", name="accountname", size="30"></td></tr>
                        <tr><td id="updatename">Email</td><td><input value="<%=mt.getEmail()%>" type ="text", id="updateform", name="email", size="30"></td></tr>
                        <tr><td id="updatename">Full Name</td><td><input value="<%=mt.getFullname()%>" type ="text", id="updateform", name="fullName", size="30"></td></tr>                 
                        <tr><td id="updatename">Date of Birth</td><td><input value="<%=mt.getDob()%>" type ="date", id="updateform", name="dob", size="30"></td></tr>
                        <tr><td id="updatename">Sex</td><td>
                                <select name="sex">
                                    <option value="M" <%if(mt.getSex().equals("M")){%>selected<%}%>>Male</option>
                                    <option value="F" <%if(mt.getSex().equals("F")){%>selected<%}%>>Female</option>
                                    <option value="O" <%if(mt.getSex().equals("O")){%>selected<%}%>>Other</option>
                                </select></td></tr>
                        <tr><td id="updatename">Address</td><td><input value="<%=mt.getAddress()%>" type ="text", id="signupform", name="address", size="30"></td></tr>

                    </table>
                </div>

            </div>

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
<%}%>
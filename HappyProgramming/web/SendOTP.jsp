<%-- 
    Document   : SendOTP
    Created on : Jun 16, 2022, 11:23:47 PM
    Author     : admin
--%>

<%@page import="DAO.AccountDAO"%>
<%@page import="Utils.RandomNumberUtil"%>
<%@page import="Utils.EmailUtils"%>
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
        <%  String accountName = request.getAttribute("accountName").toString();
            int roleId = Integer.parseInt(request.getAttribute("roleId").toString());
            String email = request.getAttribute("email").toString();
            String otp = RandomNumberUtil.RandomNumber();
            EmailUtils.sendMail(email, otp);
        %>
        <div class="body d-flex justify-content-center align-content-center flex-column" style=" height:86.69vh;" >
            <div style="vertical-align: middle;height: 500px; width:850px ; margin:auto;" class="d-flex justify-content-center text-align-center flex-column border border-secondary">
                <div style="padding:20px;">           
                    <p id="green"style="text-align: center;font-size: 38px; color: green"class="text-align-center">You account has been successfully created!</p>
                    <p style="text-align: center;font-size: 35px; color: black"class="text-align-center">Please type the OTP code sent to your email in order to activate your account.</p>
                    <input id="otp" type="text" style="width:250px; font-size: 35px;display: flex;margin:auto;text-align: center">
                    <br>
                    <div  style="text-align: center">
                        <button id="submit" style="height: 60px;width:250px!important;font-size: 27px;"type="button" class="btn btn-primary btn-lg m-2" >Submit</button>
                        
                       <!-- <button id="resend" style="height: 60px;width:250px!important;font-size: 27px;"type="button" class="btn btn-outline-dark btn-light btn-lg m-2">Resend OTP </button>-->
                        
                    </div>

                </div>
            </div>
        </div>
                        <script>
                            document.getElementById("submit").addEventListener("click", check1);
                            document.getElementById("resend").addEventListener("click", resend);
                            function check1() {
                                alert("help");
                                document.getElementById("green").innerHTML = "aaaa;";
                                var otp = document.getElementById("otp").value;
                                if (otp == <%=otp%>) {
                            <%AccountDAO.changeStatus(roleId, accountName);
                            %>
                                    window.location.replace("http://localhost:8080/HappyProgramming/SignIn.jsp");
                                }
                            
                            else{
                                alert("OTP is incorrect");
                            }
                            }
                            
                            function resend() {
                                <%   
            
             otp = RandomNumberUtil.RandomNumber();
            EmailUtils.sendMail(email, otp);
                    %>
                            }

                        </script>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

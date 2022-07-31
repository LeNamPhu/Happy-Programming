<%-- 
    Document   : MentorCV
    Created on : Jul 10, 2022, 12:31:50 AM
    Author     : ADMIN
--%>


<%@page import="DTO.Rating"%>
<%@page import="DAO.MentorDAO"%>
<%@page import="DTO.Mentor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.RateDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor CV</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script>
            var starWidth = 40;

            $.fn.stars = function () {
                return $(this).each(function () {
                    $(this).html($('<span />').width(Math.max(0, (Math.min(5, parseFloat($(this).html())))) * starWidth));
                });
            }
            $(document).ready(function () {
                $('span.stars').stars();
            });

            $(document).on('click', 'div a', function () {
                $(this).addClass('active').siblings().removeClass('active')

            })
        </script>

        <style>

            table, table tr{

                width:99%;
                margin: auto;
                margin-right: 100px;  
                text-align: center;
            }
            table th,td{
                width: 30%;
                margin-right: 30px;
                margin-left: 80px;
            }
            span.stars, span.stars span {
                display: block;
                background: url(image/emptystar.svg) 0 0 repeat-x ;
                width: 200px; /* width of a star multiplied by 5 */
                height: 40px; /* the height of the star */
                background-size: 40px 40px;
            }

            span.stars span {
                background-position: 0 0;
                background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/747/star.svg) ;
            }
            .stars{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom: 10px;
            }

        </style>
        <style>
            .avatarCv{
                width:150px;
                height:auto;
                border-radius: 50%;
                margin-left: 150px;
                margin-top: 50px;
            }
            h1{
                margin-left: 85px;
            }
        </style>

    </head>
    <body>

        <% String signin = (String) session.getAttribute("signin");
            if (signin == null) {
                session.setAttribute("role", "Unregistered");
            }
        %>

        <header>
            <jsp:include page='${sessionScope.role}Header.jsp' />
        </header>


        <% MentorDAO mentordao = new MentorDAO();%>


        <%Mentor list2 = mentordao.getMentorInfoByID(Integer.parseInt(request.getParameter("id")));%>
        <%--        // <div class="body d-flex flex-column align-items-center" style="text-align: center;width:70% " >
                    <table>
                        <tr><h1><%=list2.getFullname()%></h1></tr>
                        <tr><img style="background-color: white" class="avatarCv" src="<%=list2.getAvatar()%>"></tr>
                        <h5>Introduction</h5>
                        <tr><%=list2.getIntroduction()%><tr>


            </table> 
            <h5>Profession</h5>
            <tr style="padding-left: 100px;"><%=list2.getProfession()%></tr><br><br>
            <h5>Job</h5>
            <tr style="padding-left: 100px;"><%=list2.getJob()%></tr>
            <h5>Service</h5><br>
            <tr style="padding-left: 100px;"><%=list2.getServiceDesc()%></tr>
            <h5>Achievement</h5><br>
            <tr style="padding-left: 100px;"><%=list2.getAchievementDesc()%></tr>
            <h5>Rating</h5><br>
            <tr style="padding-left: 100px;"><span class="stars"><%=RateDAO.getRateStar(list2.getId())%></span></tr>
        </div>--%>


        <div class="body " style="font-size: 120%" >
            <div class=" py-5 my-5"style="width: 30%; margin:auto; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
                <div class="row " style="margin:0!important">
                    <div class="col-md-4 " style="text-align:center">
                        <div class="p-4">
                            <div style="height:75%; width:75%;position:relative;margin:auto">
                                <img class="rounded-circle border" src="image/<%=list2.getAvatar()%>" style="height:100%;width:100%">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 pt-2 ">
                        <div class="p-4">
                            <span class="m-2 cvform" style="font-size:140%; font-weight: bold"><%=list2.getFullname()%></span><br>
                            <span class="m-2 cvform" style="font-size:85%"><%=list2.getJob()%></span><br><br>
                            <span class="m-2 cvform" style="height:auto;word-wrap: break-word"><%=list2.getIntroduction()%></span>
                        </div>
                    </div>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Profession</span><br>
                    <span ><%=list2.getProfession()%></span>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Profession Description</span><br>
                    <span ><%=list2.getProfessionIntro()%></span>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Service</span><br>
                    <span ><%=list2.getService()%></span><br>
                    <span  style="font-weight: bold">Service Description</span><br>
                    <span><%=list2.getServiceDesc()%></span>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Achievement</span><br>
                    <span ><%=list2.getAchievementDesc()%></span>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Rating</span><br>
                    <span style="width: 50%">
                        <span class="stars" style=""><%=RateDAO.getRateStar(list2.getId())%></span>
                    </span>
                </div>
                <div class="row " style="padding-left:2%; margin:0!important">
                    <span style="font-weight: bold">Comment</span><br>
                    <ul style="padding-left: 4%">
                        <li><%=RateDAO.getRateComment(list2.getId())%></li>
                    </ul>
                    
                        
                </div>
            </div>
        </div>

        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>
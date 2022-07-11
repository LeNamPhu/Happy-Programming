<%-- 
    Document   : ViewMentor
    Created on : Jun 13, 2022, 3:37:26 PM
    Author     : admin
--%>

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

                
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                
                margin-right: 30px;

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
                margin: auto;
            }

        </style>
        <style>
            .avatarCv{
                width:200px;
                height:200px;
                border-radius: 50%;

            }
            button {
                display: inline-block;
                height: 134px;
                padding: 0;
                margin: 0;
                vertical-align: top;
                width: 104px;
            }
        </style>

    </head>
    <body>
        
       <% String signin = (String) session.getAttribute("signin");
        if (signin==null) {
                session.setAttribute("role", "Unregistered");
            }
        %>

        <header>
            <jsp:include page='${sessionScope.role}Header.jsp' />
        </header>
        <div class="body"> 
            <div class=" mx-auto my-3" style="width:70%;"> 
                <table class="table w-100 border-secondary" style="vertical-align: middle">
                
                    <thead>
                        <tr>
                    <th>Avatar</th>
                    <th>Full Name</th>
                    <th>Ratings</th>
                    <th>Introduction</th>
                        </tr>
                </thead>
        <%ArrayList<Mentor> list = (ArrayList) session.getAttribute("LIST_OF_MENTOR");
            for (Mentor mentor : list) {%>
           
            <tr>
                
                    <td style="width:20%;"><a class="w-100"  href="MentorCV.jsp?id=<%=mentor.getId()%>"><img style="background-color: white; " class="avatarCv " src="<%=mentor.getAvatar()%>"></a></td>
                    <td style="width:20%;"><%=mentor.getFullname()%></td>
                    <td style="width:20%;"><span class="stars"><%=RateDAO.getRateStar(mentor.getId())%></span></td>
                    <td style="text-align: left;" class=" m-2"><div style="border: 1px lightgray solid;height:190px; " class=""><%= mentor.getIntroduction()%></div></td>
            </tr>
            
        <%}
        %>
        </table>
            </div>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 30%;
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
                margin-left: 120px;
                margin-top: 50px;
            }

        </style>
        <style>
            .avatarCv{
                width:150px;
                height:auto;
                border-radius: 50%;
                margin-left: 150px;
            }
        </style>

    </head>
    <body>

        <% String signin = (String) session.getAttribute("signin");
            if (signin == null) {
                session.setAttribute("header", "UnregisteredHeader.jsp");
            }
        %>

        <header>
            <jsp:include page='${sessionScope.header}' />
        </header>
        <%ArrayList<Mentor> list = (ArrayList) session.getAttribute("LIST_OF_MENTOR");
            for (Mentor mentor : list) {%>
        <table>
            <td><img style="background-color: white" class="avatarCv" src="<%=mentor.getAvatar()%>"/></a></td>
            <td><span class="stars"><%=RateDAO.getRateStar(mentor.getId())%></span></td>
            <td><%= mentor.getIntroduction()%></td>
        </table>

        <%}
        %>

        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

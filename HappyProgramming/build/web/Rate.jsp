<%-- 
    Document   : Rate
    Created on : Jul 8, 2022, 5:43:19 PM
    Author     : ThienNho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rate & Comment Page</title>
    </head>
    <style>

        .rate {
            float: left;
            height: 46px;
            padding: 0 10px;
        }
        .rate:not(:checked) > input {
            position:absolute;
            top:-9999px;
        }
        .rate:not(:checked) > label {
            float:right;
            width:1em;
            overflow:hidden;
            white-space:nowrap;
            cursor:pointer;
            font-size:60px;
            color:#ccc;
        }
        .rate:not(:checked) > label:before {
            content: '★ ';
        }
        .rate > input:checked ~ label {
            color: #ffc700;    
        }
        .rate:not(:checked) > label:hover,
        .rate:not(:checked) > label:hover ~ label {
            color: #deb217;  
        }
        .rate > input:checked + label:hover,
        .rate > input:checked + label:hover ~ label,
        .rate > input:checked ~ label:hover,
        .rate > input:checked ~ label:hover ~ label,
        .rate > label:hover ~ input:checked ~ label {
            color: #c59b08;
        }
    </style>
    <script>

    </script>
    <body>
        <div class="body">
            <header>
                <%@include file='UserHeader.jsp' %>
            </header>
            <% String mentorName = request.getParameter("mentorName");%>

            <form action="MainController" class=" d-flex flex-column align-items-center">
                <p style="text-align: center;font-size: 30px; margin-top:40px;">  Ratings </p> 
                
                <div class="rate">
    <input type="radio" id="star5" name="radio" value="5" />
    <label for="star5" title="text">5 stars</label>
    <input type="radio" id="star4" name="radio" value="4" />
    <label for="star4" title="text">4 stars</label>
    <input type="radio" id="star3" name="radio" value="3" />
    <label for="star3" title="text">3 stars</label>
    <input type="radio" id="star2" name="radio" value="2" />
    <label for="star2" title="text">2 stars</label>
    <input type="radio" id="star1" name="radio" value="1" />
    <label for="star1" title="text">1 star</label>
  </div>
                <br>
                <p style="text-align: center;font-size: 30px; padding-top:50px;">  Comment </p>   <textarea style="width:600px; height:220px;" type="text" name="comment"></textarea>           
                <input type="hidden" name="mentorName" value="<%= mentorName%>"/>
                
                <input style="width:200px" type="submit" name="action" value="Rate" class="btn btn-primary btn-lg px-4 py-2 m-4" />
            </form>
        </div>
        <footer>
            <%@include file='Footer.jsp' %>
        </footer>

    </body>

</html>

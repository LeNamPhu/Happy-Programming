<%-- 
    Document   : FollowingRequest
    Created on : Jun 28, 2022, 1:44:27 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <Style>
        table, table tr{
            border: 1px solid;
            width:80%;
            margin: auto;
            text-align: center;
            margin-top: 5%;

        }
        table th,td{
            width: 15%;
            border: 1px solid;

        }
        table {
            border-collapse: collapse;
        }

        table tr {
            border-bottom: 1px solid black;
        }

        table tr:last-child {
            border: 0;
        }

        .button {
            display: flex;
            justify-content: center;
            padding: 200px;
            column-gap: 150px; 
            border-radius: 10px;
            border-radius: 50%;

        }
        button{
            background-color: blue;
            color: white;
            border: none;
            margin-top: 15px;
            margin-bottom: 15px;
            margin-right: 15px;
            margin-left: 15px;
        }
        h1 {text-align: center;}
        .container {
            height: 200px;
            position: relative;
            border: 3px solid green;
        }

        .vertical-center {
            margin: 0;
            position: absolute;
            top: 50%;
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
        }
    </Style>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor Request</title>
    <header>

        <%@include file = "MentorHeader.jsp" %>

    </header>
</head>
<body>
    <%ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_FOLLOWING_REQUEST");%>
    <%if (list.isEmpty()) {%>
    <h1>You Have No Request!</h1>
    <% } else {
    %>
    <%int i = 1;%>
    <table> 
        <tr>
            <th>STT</th>
            <th>Title</th>
            <th>Content</th>
            <th>Deadline Date</th>
            <th>Deadline Hour</th>
        </tr>
        <%for (Request request1 : list) {%>
        <tr>
            <th><%= i%></th>
            <th><%= request1.getTitle()%></th>
            <th><%= request1.getContent()%></th>
            <th><%= request1.getDeadlineDate()%></th>
            <th><%= request1.getDeadlineHour()%>:00</th>
                <%i++;%>
        </tr>

        <%}%>
    </table>
    <%}%>
    <a href="MentorRequest.jsp" class="button">Back</a>

</body>
<footer>
    <%@include file = "Footer.jsp" %>
</footer>
</html>

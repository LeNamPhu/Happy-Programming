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
    <body>
        <% String mentorName =  request.getParameter("mentorName"); %>

        <form action="MainController">
        Rate    <input type="text" name="rate"/></br>
        Comment    <input type="text" name="comment"/>           
            <input type="hidden" name="mentorName" value=<%= mentorName %>/>
            <input type="submit" name="action" value="Rate"/>
        </form>
    </body>
</html>

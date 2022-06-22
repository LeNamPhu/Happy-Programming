<%-- 
    Document   : Error
    Created on : Jun 19, 2022, 7:34:07 PM
    Author     : ThienNho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String abc = (String) request.getAttribute("ERROR_MESSAGE");
        %>
        <%=abc%>
        </br>
        <a href="HomePage.jsp" style="font-style: oblique; font-size: 42px; color:red">Back to HomePage</a>
    </body>
</html>

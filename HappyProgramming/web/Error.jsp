<%-- 
    Document   : Error
    Created on : Jun 19, 2022, 7:34:07 PM
    Author     : ThienNho
--%>

<%@page import="DTO.Skill"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>ERROR PAGE</title>
    </head>
    <body>
<%
String error =(String) session.getAttribute("MESSAGE_ERROR");
%>
<%= error %>
       
    </body>
</html>

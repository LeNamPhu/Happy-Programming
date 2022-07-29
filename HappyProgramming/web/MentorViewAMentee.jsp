<%-- 
    Document   : MentorViewAMentee
    Created on : Jul 29, 2022, 9:12:10 PM
    Author     : DELL
--%>

<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Mentee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Mentee mt = MenteeDAO.getAccountByMenteeID(ID);
%>

<table class="table table-borderless">
    <tr>
        <th>ID</th>
        <td><%=mt.getId()%></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><%=mt.getEmail()%></td>
    </tr>
    <tr>
        <th>Full name</th>
         <td><%=mt.getFullname()%></td>
    </tr>
    <tr>
        <th>Address</th>
        <td><%=mt.getAddress()%></td>
    </tr>
    <tr>
        <th>Phone</th>
        <td><%=mt.getPhone()%></td>
    </tr>
    <tr>
        <th>Date of birth</th>
        <td><%=mt.getDob()%></td>
    </tr>
    <tr>
        <th>Sex</th>
        <td><%=mt.getSex()%></td>
    </tr>

</table>

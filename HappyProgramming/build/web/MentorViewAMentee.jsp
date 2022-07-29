<%-- 
    Document   : MentorViewAMentee
    Created on : Jul 29, 2022, 9:12:10 PM
    Author     : DELL
--%>

<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Mentee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <style>
            table, table tr{
                
                width:99%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 10%;
            }
        </style>     
        
        <%
                int ID = Integer.parseInt(request.getParameter("ID"));
                Mentee mt = MenteeDAO.getAccountByMenteeID(ID);
            %>
        
        <table class="table">
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Full name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Date of birth</th>
        <th>Sex</th>
    </tr>
    <tr>
        <td><%=mt.getId()%></td>
        <td><%=mt.getEmail()%></td>
        <td><%=mt.getFullname()%></td>
        <td><%=mt.getAddress()%></td>
        <td><%=mt.getPhone()%></td>
        <td><%=mt.getDob()%></td>
        <td><%=mt.getSex()%></td>
    </tr>
</table>

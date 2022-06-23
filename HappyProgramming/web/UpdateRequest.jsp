<%-- 
    Document   : UpdateRequest
    Created on : Jun 22, 2022, 3:29:26 PM
    Author     : ThienNho
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="DTO.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Request</title>
    </head>
    <body>
        <%
            ArrayList<String> listSkill = (ArrayList) session.getAttribute("LIST_SKILL");
            Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");
            ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_REQUEST_BY_MENTEE");
            int reqID = Integer.parseInt((String) request.getParameter("reqID"));

            for (Request req : list) {
                if (reqID == req.getId()) {
                    String a = (String) skillReq.get(req);
                    String x = "X";
                    String y = "X";
                    String z = "X";
                    String[] skills = a.split(" ");
                    if (skills.length == 1) {
                        x = skills[0];
                    } else if (skills.length == 2) {
                        x = skills[0];
                        y = skills[1];
                    } else {
                        x = skills[0];
                        y = skills[1];
                        z = skills[2];
                    }
        %>
        <form action="MainController">
            <td><input type="text" name="title" value="<%= req.getTitle()%>"> </td>
            <td><%= req.getStatus() %> </td>
            <td><input type="text" name="deadlineDate" value="<%= req.getDeadlineDate()%>"> </td>
            <td><input type="text" name="deadlineHour" value="<%= req.getDeadlineHour()%>"> </td>
            <td><input type="text" name="content" value="<%= req.getContent()%>"> </td>                                                                                            
            <td>
                <select name="skill1">
                    <option value="<%= x%>"><%= x%></option>
                    <%
                        for (String name : listSkill) {
                    %>
                    <option value="<%= name%>"><%= name%></option>
                    <%
                        }
                    %>
                    <option value="X">X</option>
                </select>
            </td>                                                                                            
            <td>
                <select name="skill2">
                    <option value="<%= y%>"><%= y%></option>
                    <%
                        for (String name : listSkill) {
                    %>
                    <option value="<%= name%>"><%= name%></option>
                    <%
                        }
                    %>
                    <option value="X">X</option>
                </select>
            </td>                                                                                            
            <td>
                <select name="skill3">
                    <option value="<%= z%>"><%= z%></option>
                    <%
                        for (String name : listSkill) {
                    %>
                    <option value="<%= name%>"><%= name%></option>
                    <%
                        }
                    %>
                    <option value="X">X</option>
                </select>
            </td>  
            <td>
                <input type="submit" name="action" value="UpdateRequest"/>
                <input type="hidden" name="reqIDForUpdate" value="<%= req.getId()%>"/>                      
            </td>
        </form>
        <%
                }
            }

        %>

    </body>
</html>

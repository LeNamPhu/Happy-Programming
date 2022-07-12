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
        <style>
            #first{
                width:40%
                    
            }
            #second{
                width:60%;
                padding:5px;
            }
            #input{
                width:100%;
                height:60px;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>

        </header>
            <div class="body">
                <div style="width: 75%;font-size: 30px;" class="mx-auto my-5">
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
            <table style="" class="m-auto w-75">
            <tr>
                <td id="first">Title</td><td id="second"><input id="input" type="text" name="title" value="<%= req.getTitle()%>"> </td>
            </tr>
            
            <tr>
            <td  id="first">Deadline Date</td><td id="second"><input id="input" type="text" name="deadlineDate" value="<%= req.getDeadlineDate()%>"> </td>
            </tr>
            <tr>
            <td id="first">Deadline Hour</td><td id="second"><input id="input" type="text" name="deadlineHour" value="<%= req.getDeadlineHour()%>"> </td>
            </tr>
            <tr>
                <td id="first">Content</td><td id="second"><textarea id="input" type="textarea" name="content" style="height:100px;"><%= req.getContent()%></textarea> </td>                                                                                            
            </tr>
            <tr>
            <td id="first">Skill</td><td id="input">
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
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; height:150px;">
                    <input class="btn btn-primary btn-lg"type="submit" name="action" value="UpdateRequest"/>
                <input type="hidden" name="reqIDForUpdate" value="<%= req.getId()%>"/>                      
            </td>
            </tr>
            </table>
        </form>
        <%
                }
            }

        %>
                </div>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>

    </body>
</html>

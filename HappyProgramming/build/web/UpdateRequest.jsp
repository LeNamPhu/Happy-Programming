<%@page import="DTO.RequestError"%>
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
                    RequestError reqError = (RequestError) request.getAttribute("REQUEST_ERROR");
                    if (reqError == null) {      
                        reqError = new RequestError();
                    }
                    ArrayList<String> listSkill = (ArrayList) session.getAttribute("LIST_SKILL");
                    Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");
                    ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_REQUEST_BY_MENTEE");
                    String requestID = (String) request.getParameter("reqID");
                    int reqID = 0;
                    if(requestID == null){
                        String a = (String) request.getAttribute("REQ_ID");
                        reqID = Integer.parseInt(a);
                    }else{
                        reqID = Integer.parseInt(requestID);
                    }

                    for (Request req : list) {
                        if (reqID == req.getId()) {
                            String a = (String) skillReq.get(req);
                            String x = " ";
                            String y = " ";
                            String z = " ";
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
                            <td id="first">Title</td><td id="second"><input id="input" type="text" name="title" value="<%= req.getTitle()%>"> <p style="color : red; font-size:20px"> <%= reqError.getTitleError()%> </p></td>
                        </tr>
                        <tr>
                            <td  id="first">Deadline Date</td><td id="second"><input id="input" type="date" name="deadlineDate" value="<%= req.getDeadlineDate()%>"> 
                            <p style="color : red; font-size:20px"> <%= reqError.getDateError()%> </p></td>
                        </tr>

                        <tr>
                            <td id="first">Deadline Hour</td><td id="second"><input id="input" type="text" name="deadlineHour" value="<%= req.getDeadlineHour()%>"> 
                            <p style="color : red; font-size:20px"><%= reqError.getHourError()%></p></td>
                        </tr>


                        <tr>
                            <td id="first">Content</td><td id="second"><input id="input" type="text" name="content" value="<%= req.getContent()%>" style="height:100px;">  
                            <p style="color : red; font-size:20px"> <%= reqError.getContentError()%> </p></td>
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
                                    <option value=""> </option>
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
                                    <option value=""> </option>
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
                                    <option value=""> </option>
                                </select>
                            <p style="color : red; font-size:20px"><%= reqError.getSkillError()%></p></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center; height:150px;">
                                <input class="btn btn-primary btn-lg"type="submit" name="action" value="UpdateRequest" style="font-size: 25px;width:400px;height: 60px;"/>
                                 <input type="submit" name="action" class="createrequest btn btn-light btn-outline-dark" value="Cancel" style="font-size: 25px;width:400px;height: 60px;" >
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

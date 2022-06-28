<%-- 
    Document   : ListRequestByMentee
    Created on : Jun 18, 2022, 5:01:01 PM
    Author     : ThienNho
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="DTO.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Request By Mentee Page</title>
    </head>
    <body>
        <header>
            <%@include file = "UserHeader.jsp" %>

        </header>
        <div class="body" style="font-size:30px">
            <!--        <form action="MainController">
                        <input type="submit" name="action" value="ListRequestByMentee"/>
                    </form>-->

            <!--        <h2>Your Requests </h2>-->
            <%
                ArrayList<String> listSkill = (ArrayList) session.getAttribute("LIST_SKILL");
                Map<Request, String> skillReq = (Map) session.getAttribute("SKILL_REQUEST");
                ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_REQUEST_BY_MENTEE");
                int flag = 0;
                if (list != null) {

                    if (list.size() == 0) {
                        flag = 1;
                    }
            %>
            <div style="width:70%;margin:auto;" class="py-5">




                <%
                    for (Request req : list) {
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
                <div class="d-flex border border-secondary justify-content-around ">
                    <div class="d-flex flex-column " style="width:608px;height:200px;">
                        <div class=" d-flex justify-content-between m-2" style="width:600px;height:50px;" >
                            <div class="m-2 "><span><%= req.getTitle()%></span> </div>                   
                            <div class="m-2"><span><%= req.getDeadlineHour()%>h</span>
                                <span class="px-1"></span>
                                <span><%= req.getDeadlineDate()%></span></div>
                        </div >
                        <div class=" d-flex" style="width:608px;height:150px;">
                            <span class=" d-flex border border-secondary mt-2 me-2 "style="width:508px;height:auto;"><%= req.getContent()%></span>

                            <span class="d-flex align-items-center border border-secondary justify-content-center mt-2"style="width:100px;height:auto;"><%= req.getStatus()%></span>
                        </div>
                    </div>
                    <div class="d-flex align-items-center m-2 flex-column border border-secondary justify-content-around" style="width:150px; height:200px;">
                        <p class="m-2"><%= x%></p>
                        <p class="m-2"><%= y%></p>
                        <p class="m-2"><%= z%></p>
                    </div>
                    <div class="d-flex flex-column justify-content-center">
                        <div >
                            <div class="d-flex flex-row m-2">
                                <div class="me-1">
                                    <form action="MainController">

                                        <input class="rounded" type="submit" name="action" value="DeleteRequest" style="background-color:#0076ff; color:white;;border:none;padding:10px 10px;font-size: 25px;"/>
                                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                      

                                    </form>
                                </div>
                                <div class="ms-1">
                                    <form action="UpdateRequest.jsp">

                                        <input class="rounded" type="submit" value="UpdateRequest" style="background-color:#0076ff; color:white;;border:none;padding:10px 10px;font-size: 25px;"/>
                                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                                              

                                    </form>
                                </div>
                            </div>
                        </div>              
                        <div class="m-2">
                            <form action="#">

                                <input class="rounded" style="width:100% ;background-color:#0076ff;border:none; color:white; font-size: 25px; padding:10px 10px;" type="submit" value="ShowMentorSuggestion"/>
                                <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                                              

                            </form>
                        </div>
                        <div class="m-3">
                            <form action="CreateRequest.jsp">

                                <input class="rounded" style="width:100% ;background-color:#0076ff;border:none; color:white; font-size: 25px; padding:10px 10px;" type="submit" value="CreateRequest"/>
                                <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                                              
                        </div>
                        </form>
                    </div>

                    <%
                        }
                    %>



                </div>
                <%
                    }
                    if (flag == 1) {
                %>
                <h3>You do not have any request</h3>
                <%
                    }
                %>
            </div>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

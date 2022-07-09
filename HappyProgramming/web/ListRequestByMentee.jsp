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
<%if (session.getAttribute("role") != "User") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
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
                <div class=" border border-dark border-2 pe-2 ps-2">
                    <table class="w-100 table table-borderless ">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2" class=""style="width:35%" ><%= req.getTitle()%></td>                   

                            <td colspan="2" class="" style="text-align: center ; width: 30%"> <%=req.getDeadlineHour()%>h <%= req.getDeadlineDate()%></td>
                            <td class="w-15 border border-secondary" style="width:10%; text-align: center;"><%= x%></td>
                            <td rowspan="3" class="" style="width:25%;vertical-align: middle"> 
                                <div class="d-flex mb-2 justify-content-between " style="">

                                    <form action="MainController" class="w-50 me-2">
                                        <input class="btn btn-primary w-100 "  type="submit" name="action" value="DeleteRequest" style="height:40px"/>
                                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                      
                                    </form>


                                    <form action="UpdateRequest.jsp" class="w-50 ms-2">

                                        <input class="btn btn-primary w-100 " type="submit" value="UpdateRequest" name="action" style="height:40px"/>
                                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                                              

                                    </form>

                                </div>

                                <div>
                                    <form action="#" class="d-grid">

                                        <input class="btn btn-primary" style="" type="submit" name="action" value="ShowMentorSuggestion"/>
                                        <input type="hidden" name="reqID" value="<%= req.getId()%>"/>                                              

                                    </form>
                                </div>

                            </td>

                        </tr>
                        <tr>
                            <td colspan="3" rowspan="2"  class=" "style="width:65%;height:auto;border: 1px lightgray solid"><%= req.getContent()%></td>

                            <td  colspan="1" rowspan="2" class=""style="width:10%;height:auto;vertical-align: middle; text-align: center;"><%= req.getStatus()%></td>
                            <td class="border border-secondary" style="text-align: center"><%= y%></td>
                        </tr>
                        <tr>
                            <td class="border border-secondary" style="text-align: center"><%= z%></td>
                        </tr>

                    </table>       
                    <%
                        }
                    %>



                </div>
                <div class="m-5 d-flex justify-content-around">
                    <form action="CreateRequest.jsp" >
                        <input class="btn btn-primary btn-lg"  style=" " type="submit" value="CreateRequest"/>                               
                    </form>
                    
                    <form action="MainController">
                        <input  class="btn btn-primary btn-lg" type="submit" name="action" value="Statistic by Mentee"/>
                    </form>
                </div>

                <%
                    }
                    if (flag == 1) {
                %>
                <h3 style="text-align: center;">You do not have any request</h3>
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
<% }%>
<%-- 
    Document   : AdminViewRequestDetail
    Created on : Jul 6, 2022, 3:27:40 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Request"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DAO.MenteeDAO"%>
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
                Request req = RequestDAO.getARequestDetail(ID);
                ArrayList<String> list = RequestDAO.getAllSkillsNameByRequestID(ID);
            %>
            <table>

                <tr>
                    <th>ID</th>
                    <th>Account name</th>
                    <th>Title</th>
                    <th>Skill</th>
                    <th>Status</th>
                    <th>Content</th>
                    <th>Deadline Datetime</th>
                    <th>Created Date</th>
                </tr>

                <tr>
                    <td><%=req.getId()%></td>
                    <td><%=MenteeDAO.getAccountNameByMenteeID(req.getMenteeID())%></td>
                    <td><%=req.getTitle()%></td>
                    <td><%for (int i = 0; i < list.size(); i++) {
                            if (i != list.size() - 1) {%>
                        <%=list.get(i)%>,
                        <%} else {%>
                        <%=list.get(i)%>
                        <%}
                            }
                        %></td>
                    <td><%=req.getStatus()%></td>
                    <td><%=req.getContent()%></td>
                    <td><%=req.getDeadlineHour()%>h <%=req.getDeadlineDate()%></td>
                    <td><%=RequestDAO.getCreatedDateByRequestID(req.getId())%></td>
                </tr>

            </table><br>
            
        

        
    

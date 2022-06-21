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
        <form action="MainController">
            <input type="submit" name="action" value="ListRequestByMentee"/>
        </form>
        
        <h2>Your Requests </h2>
        <%
            Map<Request, String> skillReq = new HashMap<>();
            skillReq = (Map) request.getAttribute("SKILL_REQUEST");
            ArrayList<Request> list = (ArrayList) request.getAttribute("LIST_REQUEST_BY_MENTEE");        
            int flag = 0;
            if (list != null) {
            ArrayList<String> listSkill =(ArrayList) request.getAttribute("LIST_SKILL");          
            if(list.size() == 0){
                flag = 1;
            }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Deadline Date</th>
                    <th>Deadline Hour</th>
                    <th>Description</th>
                    <th>Skill 1</th>
                    <th>Skill 2</th>
                    <th>Skill 3</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                 for (Request req : list) {
                    String a = (String) skillReq.get(req);
                    String x = "X";
                    String y = "X";
                    String z = "X";
                    String[] skills = a.split(" "); 
                    if(skills.length == 1){
                         x = skills[0];                       
                    }else if(skills.length == 2){
                         x = skills[0];
                         y = skills[1];
                    }else{
                         x = skills[0];
                         y = skills[1];
                         z = skills[2];
                    }
                %>
            <form action="MainController">
                <tr>
                    <td><input type="text" name="title" value="<%= req.getTitle()%>"> </td>
                    <td><select name="status">
                            <option value="<%= req.getStatus() %>"><%= req.getStatus() %></option>
                            <option value="Open">Open</option>
                            <option value="Processing">Processing</option>                           
                            <option value="Closed">Closed</option>                                                                                      
                        </select> </td>
                    <td><input type="text" name="deadlineDate" value="<%= req.getDeadlineDate() %>"> </td>
                    <td><input type="text" name="deadlineHour" value="<%= req.getDeadlineHour() %>"> </td>
                    <td><input type="text" name="content" value="<%= req.getContent() %>"> </td>                                                                                            
                    <td>
                        <select name="skill1">
                            <option value="<%= x %>"><%= x %></option>
                                <%
                                for (String name : listSkill) {
                                    %>
                                        <option value="<%= name %>"><%= name %></option>
                                    <%
                                    }                                    
                                %>
                                <option value="X">X</option>
                        </select>
                    </td>                                                                                            
                    <td>
                        <select name="skill2">
                            <option value="<%= y %>"><%= y %></option>
                                <%
                                for (String name : listSkill) {
                                    %>
                                        <option value="<%= name %>"><%= name %></option>
                                    <%
                                    }
                                %>
                                <option value="X">X</option>
                        </select>
                    </td>                                                                                            
                    <td>
                        <select name="skill3">
                            <option value="<%= z %>"><%= z %></option>
                                <%
                                for (String name : listSkill) {
                                    %>
                                        <option value="<%= name %>"><%= name %></option>
                                    <%
                                    }
                                %>
                                <option value="X">X</option>
                        </select>
                    </td>                                                     
                    <td>
                        <input type="submit" name="action" value="DeleteRequest"/>
                        <input type="hidden" name="reqID" value="<%= req.getId() %>"/>                      
                    </td>
                    <td>
                        <input type="submit" name="action" value="UpdateRequest"/>
                        <input type="hidden" name="reqID" value="<%= req.getId() %>"/>                      
                    </td>
                </tr>
                </form>
            </tbody>
        </table>

        <%
            }
        }
        if(flag == 1){
        %>
        <h3>You do not have any request</h3>
        <%

}
        %>
        
    </body>
</html>

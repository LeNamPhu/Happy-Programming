<%-- 
    Document   : ViewSkill
    Created on : Jun 13, 2022, 3:37:48 PM
    Author     : admin
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.stream.*"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Skill"%>
<%@page import="DTO.Skill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skill</title>
<!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->
        <style>
            table{
                
                margin-right: auto;
                margin-left: auto;
                margin-top: 4%;
                text-align: center;
                font-size: 30px;
                
            }
            
        </style>
    </head>
    <body>
        
        <% String signin = (String) session.getAttribute("signin");
        if (signin==null) {
                session.setAttribute("role", "Unregistered");
            }
        %>

        <header>
            <jsp:include page='${sessionScope.role}Header.jsp' />
        </header>

        <div class="body">
            <div class="row m-auto" style="width:65%">
            <%ArrayList<Skill> list = SkillDAO.getAllSkill();
            
Collections.sort(list, new Comparator<Skill>(){

  public int compare(Skill o1, Skill o2)
  {
     return o1.getName().compareTo(o2.getName());
  }
});  
                int count = 1;%>
            <%if (list != null && !list.isEmpty()) {
            %>
            
                                
                        <%    for (Skill sk : list) {
                                if (sk.getStatus().equals("active")) {
                        %>   
                        
                            <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;width:25.5%;" class="m-5 row p-3">
                            <table class=" " >
                                <tr><%--<td style=""><%=count++%></td>--%>
                            <td><img src="image/<%=sk.getImage()%>"style="width:150px; height:150px; border-radius: 50%; object-fit: scale-down" class="border border-secondary m-2"></td></tr>
                        <tr> <td style="text-align: center; width:100%;"><%=sk.getName()%></td></tr>
                        </table>   
                        </div>
                        
                    <% }
                        }%>
            
            <%    }%>
        </div>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

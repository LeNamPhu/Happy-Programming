<%-- 
    Document   : AdminViewSkill
    Created on : Jun 21, 2022, 2:12:05 PM
    Author     : DELL
--%>

<%@page import="DAO.SkillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Skill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Skill</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script>
            $(document).on('click', 'div a', function () {
                $(this).addClass('active').siblings().removeClass('active')

            })
        </script>
        <style>
            table, table tr{
                border: 1px solid;
                width:80%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 15%;
                border: 1px solid;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>

        <div class="body">
            <%ArrayList<Skill> list = SkillDAO.getAllSkill();
                int count = 1;%>
            <%if (list != null && !list.isEmpty()) {%>
            <table class="skillad">
                <tr><th >STT</th>
                    <th>ID</th>
                    <th></th>
                    <th>Skill name</th>
                    <th>Status</th>
                    <th>Option</th></tr>
                        <%    for (Skill sk : list) {
                        %>               
                <tr><td><%=count++%></td>
                    <td><%=sk.getId()%></td>
                    <td><img src="<%=sk.getImage()%>"style="width:150px; height:120px;"></td>
                    <td><%=sk.getName()%></td>


                    <td><div class="btn-group ">
                            <a onclick="location.href = 'MainController?action=changeStatus&id=<%=sk.getId()%>&status=active'" class="btn <%=sk.getId()%> act"  data-bs-toggle="button" style="border: 1px solid">Active </a>
                            <a onclick="location.href = 'MainController?action=changeStatus&id=<%=sk.getId()%>&status=inactive'" class="btn <%=sk.getId()%> inact"  data-bs-toggle="button" style="border: 1px solid">Inactive</a>
                        </div>
                        <%if (sk.getStatus().equalsIgnoreCase("active")) {%>
                        <script>
                            $('a.btn.<%=sk.getId()%>.act').addClass('active');
                        </script>

                        <% } else {%>
                        <script>

                            $('a.btn.<%=sk.getId()%>.inact').addClass('active');
                        </script>
                        <% }%>

                    </td>
                    <td><a href="UpdateSkill.jsp?id=<%=sk.getId()%>" class="btn" style="color:white;background-color: blue;border: 1px solid;width: 60%">Update</a></td></tr>
                    <%  }%>
            </table> 
            <%    }%>
            <a href="AddSkill.jsp"><img src="image/plus.png" style="margin: 3% 5%; width: 15%; "></a>
        </div>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>

    </body> 
</html>

<%-- 
    Document   : AddSkill
    Created on : Jun 24, 2022, 2:43:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <style>
            table{
                border: 1px solid;
                width:40%;
                margin: 7% auto;     
            }
            tr {
                width: 10%;
                
            }
            td{
                width: 10%;
                padding-top: 2%;
                padding-left: 10%;
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>
        <div class="body">
            <form action="mainController" method="post">
        <table>
            <tr>
                <td>Skill name</td>
                <td><input type="text" name="txtname" required></td>
            </tr>
            <tr>
                <td>Status</td>
                <td><select name="newstatus">
                        <option value="active">Active</option>
                        <option value="inactive">Inactive</option>
                    </select></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="text" name="newimage" required></td>
            </tr>
            <tr>
                <td><button type="submit" name="action" value="addSkill" class="btn" style="color:white;background-color: blue;border: 1px solid;width: 80%;margin: 10% 45% 10%">OK</button></td>
                <td><a href="AdminViewSkill.jsp" class="btn" style="color:black  ;background-color: white;border: 1px solid;width: 38%;margin-left: 30%;">Cancel</a></td>
            </tr>
        </table>
            </form>
        </div>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>

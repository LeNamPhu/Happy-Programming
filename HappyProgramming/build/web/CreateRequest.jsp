<%-- 
    Document   : CreateRequest
    Created on : Jun 27, 2022, 1:55:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Create Request</title>
        <link rel="stylesheet" href="virtual-select.min.css">
        <script src="virtual-select.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    </head>
    <body>
        <header>

            <%@include file = "MentorHeader.jsp" %>

        </header>

        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Create Request</h1>
            <form action="MainController">
                <table style=";font-size: 25px" class="d-flex justify-content-center" id="createrequesttable">
                    <tr><td id="createrequestpass">Title</td><td><input type="text" name="txttitle" style="width: 400px" id="createrequestform"></td></tr>
                    <tr><td id="createrequestpass">Deadline date</td><td><input type="text" name="textDeadlineDate" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Deadline hour</td><td><input type="text" name="textDeadlineHour" style="width: 400px" id="createrequestform"/></td></tr>
                    <tr><td id="createrequestpass">Content</td><td><input type="text" name="textDeadlineHour" style="width: 400px; height: 150px" id="createrequestform"/></td></tr>
                    <tr>
                        <td id="createrequestpass">Skill</td>
                        <td>
                            <div>
                                <input type="checkbox" id="skill1" name="skill1" value="Java">
                                <label for="skill1"> Java</label><br>
                                <input type="checkbox" id="skill2" name="skill2" value="Mockito">
                                <label for="skill2"> Mockito</label><br>
                                <input type="checkbox" id="skill3" name="skill3" value="SQLServer">
                                <label for="skill3"> SQLServer</label><br><br>
                            </div>
                        </td></tr>

                </table>

                <div>
                    <input type="submit" class="reset" value="Enter" style="font-size: 25px;width:400px;height: 60px;background-color: #0076ff ;color: white; border:none" >
                    <input type="submit" class="reset" value="Cancel" style="font-size: 25px;width:400px;height: 60px;background-color: #ffffff ;color: black; border:1px solid rgba(80,80,80,0.8)" >
                </div>
            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html>

<%-- 
    Document   : MentorRequest.jsp
    Created on : Jun 26, 2022, 3:03:25 PM
    Author     : ADMIN
--%>

<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%if (session.getAttribute("role")!="Mentor") {%>
             <%@include file = "Unauthorised.jsp" %>
            <% }else
                {%>
<html>
    <style>
        
    </style>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
<!--        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor Request</title>
        <script>
            var myModal = document.getElementById('exampleModal')
            var myInput = document.getElementById('myInput')
            myModal.addEventListener('shown.bs.modal', function () {
                myInput.focus()
            })
</script>
</head>
<body>
    <header>

        <%@include file = "MentorHeader.jsp" %>

    </header>
        <div class="body">
            <div class="w-75 m-auto">
    <%ArrayList<Request> list = (ArrayList) session.getAttribute("LIST_FOLLOWING_REQUEST");%>
    <%if (list.isEmpty()) {%>
    <h1>You Have No Request!</h1>
    <% } else {
    %>
    <%int i = 1;%>
   
        
        <%for (Request request1 : list) {%>
        <a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal<%=request1.getMenteeID()%>">
        <div class="border border-dark border-2 p-2 w-75 ms-auto me-auto mt-4 mb-4"> 
        <table class=" w-100  "> 
            <tr style="height: 40px " >
            
            <td style="width:25%" class="p-2"> <%= request1.getTitle()%></td>
            <td style="width:45%; border:solid 1px lightgray" class="p-2 " rowspan="2"><%= request1.getContent()%></td>
            <td  style="width:15%; text-align: center;" class="p-2"rowspan="2"span="2"> Closed</td>
               
        </tr>
        <tr style="height: 60px">
            
            <td  style="width:20%"  class="p-2"><%= request1.getDeadlineHour()%>:00 
            <%= request1.getDeadlineDate()%></td>
        </tr>
        </table>
        </div></a>
        <div class="modal  fade" id="exampleModal<%=request1.getMenteeID()%>" tabindex="-1"  aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-xl">
                        <div class="modal-content" id="loadModalBody">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel" style="font-size: 22px;">Request's mentee information</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <jsp:include page="MentorViewAMentee.jsp">
                                    <jsp:param name="ID" value="<%=request1.getMenteeID()%>"/>
                                </jsp:include>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger btn-lg" data-bs-dismiss="modal">Close</button>
                                
                            </div>
                        </div>
                    </div>
                </div>
         <%i++;%>

        <%}%>
        
    <form action="MainController">
        <div class="w-75 d-flex align-content-center justify-content-around m-auto">
            <tr><td><button class="btn btn-primary btn-lg" type="submit" name="action" value="ListRequestByMentor" >Back</button></td>
                
            </tr>
        </div>
    </form>
             
    <%}%>
       
        </div>
        </div>
    <footer>
        <%@include file = "Footer.jsp" %>
    </footer>
</body>
</html>
<% }%>
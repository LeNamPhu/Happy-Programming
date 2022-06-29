<%-- 
    Document   : ViewMentor
    Created on : Jun 13, 2022, 3:37:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor</title>
<!--                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>-->

    </head>
    <body>
        
        <% String signin = (String) session.getAttribute("signin");
        if (signin==null) {
                session.setAttribute("header", "UnregisteredHeader.jsp");
            }
        %>

        <header>
            <jsp:include page='${sessionScope.header}' />
        </header>
            
        <div class="body">
            
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

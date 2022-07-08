
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>
            <%@include file = "UnregisteredHeader.jsp"%>
        </header>           
            <% String placeholder;
                if (request.getParameter("txtuser")!=null) {
              placeholder   = request.getParameter("txtuser");
                }
                else{
                    placeholder="";
                }
            
            %>
        <div class="body">
            <h1 style="text-align: center; padding-top: 3%; padding-bottom:1%;font-size: 50px">Sign In</h1>
            <form action="MainController">
                <table style="font-size: 25px" class="d-flex justify-content-center">
                    <%if (request.getAttribute("ERROR_MESSAGE") != null) {
                    %>
   

                    <tr>
                        <td>
                            <div class="alert alert-danger p-2" style="font-size: 20px;">
                                <p><%=request.getAttribute("ERROR_MESSAGE")%></p>
                            </div>
                        </td>
                    </tr>
                    
                    <%}%>       
                    <tr><td>Account Name</td></tr>
                    <tr><td><input type="text" name="txtuser" value="<%=placeholder%>"  style="width: 400px"></td></tr>
                    <tr><td>Password</td></tr>
                    <tr><td><input type="password" name="txtpass"  style="width: 400px"></td></tr>
                    <tr><td style="padding: 10px 0px 10px 200px"><a href="ForgotPassword.jsp" style="" class="link-info">Forgot Password?</a></td></tr>
                    <tr><td><div class="d-grid"><input type="submit" name="action" value="Sign in" class="btn btn-primary btn-lg" ></div></td></tr>
                </table>
            </form>
        </div>
        <footer>
            <%@include file = "Footer.jsp" %>
        </footer>
    </body>
</html>

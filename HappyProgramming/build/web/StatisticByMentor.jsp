<%-- 
    Document   : StatisticByMentor
    Created on : Jul 9, 2022, 12:52:45 PM
    Author     : ThienNho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic Request By Mentor Page</title>
    </head>
    <body>
       Number of Accepted Request  <% String accReq = (String) request.getAttribute("ACCEPTED_REQ"); %> <%= accReq %></br>
       Number of Rejected Request  <% String rejReq = (String) request.getAttribute("REJECTED_REQ"); %> <%= rejReq %></br>
       Number of Inviting Request  <% String invReq = (String) request.getAttribute("INVITING_REQ"); %> <%= invReq %></br>
       Percent of Accepted Request <% String perAcc = (String) request.getAttribute("PERCENT_ACC"); %> <%= perAcc + "%" %></br>
       Percent of Rejected Request <% String perRej = (String) request.getAttribute("PERCENT_REJ"); %> <%= perRej + "%"%></br>
       Star <% String star = (String) request.getAttribute("STAR"); %> <%= star %>
    </body>
</html>

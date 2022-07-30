
<%@page import="DAO.RateDAO"%>
<%@page import="DAO.InviteDAO"%>
<%@page import="DTO.Account"%>
<%
            Account user1 = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int userId = user1.getId();
            InviteDAO dao = new InviteDAO();
            int accReq = dao.getCountReq(userId, "Accepted");
            int rejReq = dao.getCountReq(userId, "Rejected");
            int invReq = dao.getCountReq(userId, "Pending");
            int sum = accReq + rejReq + invReq;
            double perAcc = accReq * 100 / sum ;
            double perRej = rejReq * 100 / sum;
            RateDAO rateDAO = new RateDAO();
            double star = rateDAO.getStar(userId);
            String a = String.valueOf(accReq);
            String b = String.valueOf(rejReq);
            String c = String.valueOf(invReq);
            String d = String.valueOf(perAcc);
            String e = String.valueOf(perRej);
            String f = String.valueOf(star);
    %>
    <table class="table table-borderless" style="font-size: 20px;">
        <tr style="height:60px"><td>Number of Accepted Request:</td> <td style="text-align: right"> <%=a%></td> </tr>
   <tr style="height:60px"><td> Number of Rejected Request:</td><td style="text-align: right">  <%=b%></td> </tr>
  <tr style="height:60px"><td>  Number of Inviting Request: </td><td style="text-align: right"> <%=c%></td> </tr>
  <tr style="height:60px"><td>  Percent of Accepted Request:</td><td style="text-align: right"> <%=d%>%</td></tr>
 <tr style="height:60px"> <td>  Percent of Rejected Request: </td><td style="text-align: right"><%=e%>%</td> </tr>
  <tr style="height:60px"><td>  Average Rating:</td><td style="text-align: right"> <%=f%></td></tr>
    </table>


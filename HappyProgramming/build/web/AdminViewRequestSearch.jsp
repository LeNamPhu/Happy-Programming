<%-- 
    Document   : AdminViewRequestSearch
    Created on : Jul 6, 2022, 3:24:47 PM
    Author     : DELL
--%>

<%@page import="DAO.RequestDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.MenteeDAO"%>
<%@page import="DTO.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("role") != "Admin") {%>
<%@include file = "Unauthorised.jsp" %>
<% } else {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script>
            var myModal = document.getElementById('exampleModal')
            var myInput = document.getElementById('myInput')
            myModal.addEventListener('shown.bs.modal', function () {
                myInput.focus()
            })
</script>
        <style>
            table, table tr{
               
                width:99%;
                margin: auto;
                margin-top: 5%;
                text-align: center;
            }
            table th,td{
                width: 10%;
                
            }
        </style>
    </head>
    <body>
        <header>
            <%@include file="AdminHeader.jsp" %>
        </header>
        
        <div class="body">
            <%  String spageid = request.getParameter("page");
                int pageid = Integer.parseInt(spageid);
                int total = 3;
                pageid = pageid - 1;
                pageid = pageid * total;
                String keyword = request.getParameter("txtsearch");
                ArrayList<Request> list = RequestDAO.searchRequestByAccountNamePagination(keyword, pageid, total);
                ArrayList<Request> allRequest = RequestDAO.searchRequestByAccountName(keyword);
                int count = 1;
                int pages = 0;
                if (allRequest.size() % total == 0) {
                    pages = allRequest.size() / total;
                } else if (allRequest.size() > total) {
                    pages = allRequest.size() / total + 1;
                } else {
                    pages = 1;
                }
            %>
            <form action="MainController" method="post">
                <div class="input-group " style="margin-top: 2%;margin-left: 2%">
                    <button type="submit" name="action" value="searchRequest" class="btn btn-light btn-outline-dark">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                    </button>
                    <input style="width:25%" type="text" name="txtsearch" value="${param.txtsearch}"  placeholder="Search account name" aria-label="Search account name" aria-describedby="basic-addon1">
                    <span style="margin-left: 2%">
                        <select name="status" style="height:40px ">
                            <option selected disabled>Status</option>
                            <option value="Open" >Open</option>
                            <option value="Processing" >Processing</option>
                            <option value="Canceled" >Canceled</option>
                            <option value="Closed" >Closed</option>
                        </select>
                    </span>
                    <span style="margin-left: 2%">
                        From <input type="date" name="from" style="height:40px "> to <input type="date" name="to"  style="height:40px ">
                    </span>
                    <button class="btn btn-primary" type="submit" name="action" value="filterRequest" style="margin-left: 2%;width: 10%">Filter</button>
                </div>
            </form>

                    <table class="table">
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Account name</th>
                    <th>Title</th>
                    <th>Status</th>
                </tr>
                <%for (Request req : list) {%>
                <tr><td><%=pageid+count++%></td>
                    <td><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal<%=req.getId()%>"><%=req.getId()%></a>
                    <div class="modal fade" id="exampleModal<%=req.getId()%>" tabindex="-1"  aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content" id="loadModalBody">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel" style="font-size: 22px;">Request Statistic</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <jsp:include page="AdminViewRequestDetail.jsp">
                                    <jsp:param name="ID" value="<%=req.getId()%>"/>
                                </jsp:include>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger btn-lg" data-bs-dismiss="modal">Close</button>
                                
                            </div>
                        </div>
                    </div>
                </div></td>
                    <td><%=MenteeDAO.getAccountNameByMenteeID(req.getMenteeID())%></td>
                    <td><%=req.getTitle()%></td>
                    <td><%=req.getStatus()%></td>
                </tr>

                <%  }
                %>
            </table>

            <nav aria-label="Page navigation example" style="margin-top:100px;margin-left: 450px ">
                <ul class="pagination">

                    <li class="page-item <%if (Integer.parseInt(request.getParameter("page")) == 1) {%>disabled<%}%>">
                        <a class="page-link" href="AdminViewRequestSearch.jsp?page=<%=Integer.parseInt(request.getParameter("page")) - 1%>&txtsearch=<%=request.getParameter("txtsearch")%>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <%for (int i = 1; i <= pages; i++) {%>
                    <li class="page-item"><a class="page-link" href="AdminViewRequestSearch.jsp?page=<%=i%>&txtsearch=<%=request.getParameter("txtsearch")%>"><%=i%></a></li>
                        <%  }
                        %>

                    <li class="page-item <%if (Integer.parseInt(request.getParameter("page")) == pages) {%>disabled<%}%>">
                        <a class="page-link" href="AdminViewRequestSearch.jsp?page=<%=Integer.parseInt(request.getParameter("page")) + 1%>&txtsearch=<%=request.getParameter("txtsearch")%>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>

                </ul>
            </nav>
        </div>
        
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
<%}%>
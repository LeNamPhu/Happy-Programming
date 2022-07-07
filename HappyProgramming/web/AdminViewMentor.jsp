<%-- 
    Document   : AdminViewMentor
    Created on : Jun 27, 2022, 2:51:42 PM
    Author     : DELL
--%>

<%@page import="DAO.RateDAO"%>
<%@page import="DAO.RequestDAO"%>
<%@page import="DAO.AccountDAO"%>
<%@page import="DAO.MentorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Mentor"%>
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
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script>
            var starWidth = 40;

            $.fn.stars = function () {
                return $(this).each(function () {
                    $(this).html($('<span />').width(Math.max(0, (Math.min(5, parseFloat($(this).html())))) * starWidth));
                });
            }
            $(document).ready(function () {
                $('span.stars').stars();
            });

            $(document).on('click', 'div a', function () {
                $(this).addClass('active').siblings().removeClass('active')

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
            span.stars, span.stars span {
                display: block;
                background: url(image/emptystar.svg) 0 0 repeat-x ;
                width: 200px; /* width of a star multiplied by 5 */
                height: 40px; /* the height of the star */
                background-size: 40px 40px;
            }

            span.stars span {
                background-position: 0 0;
                background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/747/star.svg) ;
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
                ArrayList<Mentor> list = MentorDAO.mentorPagination(pageid, total);
                ArrayList<Mentor> allMentor = MentorDAO.viewAllMentor();
                int count = 1;
                int pages = 0;
                if (allMentor.size() % total == 0) {
                    pages = allMentor.size() / total;
                } else if (allMentor.size() > total) {
                    pages = allMentor.size() / total + 1;
                } else {
                    pages = 1;
                }
            %>
            <br>
            <form action="MainController" method="post">
                <div class="input-group w-25">
                    <button type="submit" name="action" value="searchMentor" class="btn btn-light btn-outline-dark">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                    </button>
                    <input type="text" name="txtsearch" value="${param.txtsearch}" class="form-control" placeholder="Search account name" aria-label="Search account name" aria-describedby="basic-addon1">
                </div>
                <table class="table">
                    <tr><th>STT</th><th>ID</th><th>Fullname</th><th>Account name</th><th>Image</th><th>Profession</th><th>Number of accepted request</th><th>Percentage completed</th><th>Rate star</th><th>Status</th></tr>
                            <%for (Mentor mtr : list) {%>
                            <%int totalRequest = RequestDAO.countRequestOfMentor(mtr.getId(), "Accepted") + RequestDAO.countRequestOfMentor(mtr.getId(), "Rejected");%>
                    <tr><td><%=count++%></td>
                        <td><%=mtr.getId()%></td>
                        <td><%=mtr.getFullname()%></td>
                        <td><%=MentorDAO.getMentorAccountNameById(mtr.getId())%></td>
                        <td><%=mtr.getAvatar()%></td>
                        <td><%=mtr.getProfession()%></td>
                        <td><%=RequestDAO.countRequestOfMentor(mtr.getId(), "Accepted")%></td>
                        <td><%=totalRequest == 0 ? 0 : RequestDAO.countRequestOfMentor(mtr.getId(), "Accepted") * 100 / totalRequest%>%</td>
                        <td><span class="stars"><%=RateDAO.getRateStar(mtr.getId())%></span></td>
                        <td><div class="btn-group ">
                                <a onclick="location.href = 'MainController?action=changeMentorStatus&id=<%=mtr.getId()%>&roleID=2'" class="btn <%=mtr.getId()%> act"  data-bs-toggle="button" style="border: 1px solid">Active </a>
                                <a onclick="location.href = 'MainController?action=changeMentorStatus&id=<%=mtr.getId()%>&roleID=4'" class="btn <%=mtr.getId()%> inact"  data-bs-toggle="button" style="border: 1px solid">Inactive</a>
                            </div>
                            <%if (MentorDAO.getMentorRoleID(mtr.getId()) != 4) {%>
                            <script>
                                $('a.btn.<%=mtr.getId()%>.act').addClass('active');
                            </script>

                            <% } else {%>
                            <script>

                                $('a.btn.<%=mtr.getId()%>.inact').addClass('active');
                            </script>
                            <% }%></td></tr>

                    <%    }
                    %>
                </table>
            </form>
            <nav aria-label="Page navigation example" style="margin-top:100px;margin-left: 450px ">
                <ul class="pagination">

                    <li class="page-item <%if (Integer.parseInt(request.getParameter("page")) == 1) {%>disabled<%}%>">
                        <a class="page-link" href="AdminViewMentor.jsp?page=<%=Integer.parseInt(request.getParameter("page")) - 1%>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <%for (int i = 1; i <= pages; i++) {%>
                    <li class="page-item"><a class="page-link" href="AdminViewMentor.jsp?page=<%=i%>"><%=i%></a></li>
                        <%  }
                        %>

                    <li class="page-item <%if (Integer.parseInt(request.getParameter("page")) == pages) {%>disabled<%}%>">
                        <a class="page-link" href="AdminViewMentor.jsp?page=<%=Integer.parseInt(request.getParameter("page")) + 1%>" aria-label="Next">
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
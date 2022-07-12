<%-- 
    Document   : CreateCV
    Created on : Jun 19, 2022, 8:39:04 AM
    Author     : admin
--%>

<%@page import="DTO.Account"%>
<%@page import="DAO.MentorDAO"%>
<%@page import="DTO.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.SkillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>
        <link rel="stylesheet" href="virtual-select.min.css">
        <script src="virtual-select.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    </head>
    <body>
        <header>

            <%@include file = "MentorHeader.jsp" %>

        </header>
        <div class="body"style="font-size:  30px;">
            <% MentorDAO mentordao = new MentorDAO();
                Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int mentorID = user.getId();
                if(mentordao.getMentorProfession(mentorID)){
                    response.sendRedirect("UpdateCV.jsp");
                }%>
            <form action="MainController" method="POST">
                <div class=" py-5 my-5"style="width: 60%; margin:auto; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 " style="text-align:center">
                            <div class="p-4">
                                <div style="height:162px; width:162px;position:relative;margin:auto">
                                    <img id="avt" class="rounded-circle border"  src="image/avatar.png" style="height:100%;width:100%">

                                    <div style=" position:absolute; right:5px; bottom:5px; height:30px; width:30px; border-radius: 50%; background-color: white">
                                        <i class="fa-solid fa-camera" style="height:100%; position:absolute; right:5px; bottom:5px;"></i>
                                        <input type="file" name="avatar" accept="image/*"
                                              onchange="document.getElementById('avt').src = window.URL.createObjectURL(this.files[0])" style="width: 100%; height:100%; opacity: 0;">
                                    </div>
                                </div>
                            </div>
<!--                            <input style="margin: auto; height:50px; width:300px; text-align: center" type="text" placeholder="Account Name" class="form-control" name="accName"> -->
                        </div>
                        <div class="col-md-8 pt-2">
<!--                            <input  type="text" placeholder="Full Name" class="form-control m-2 cvform" name="fullName"> -->

                            <input  type="text" placeholder="Job" class="form-control m-2 cvform " name="job"> 

                            <textarea style=" height:auto " type="text" placeholder="Introduction" rows="5" class="form-control m-2 cvform" name="introducton"></textarea>
                        </div>

                    </div>
<!--                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Email </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 
                        </div>
                    </div>-->
<!--                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Date of Birth </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="dob"> 
                        </div>
                    </div>-->
<!--                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label>Gender </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2" >
                            <select class="form-select m-2 cvform" name="gender" style="width:200px;" ><option>Male</option>
                                <option>Female</option>
                                <option>Other</option></select>
                        </div>
                    </div>-->
<!--                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Address </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="address"> 
                        </div>
                    </div>-->
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="profession"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession Intro </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="professionIntro"></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Framework </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style="height:auto" type="text"  class="form-control m-2 cvform" name="framework"> 

                        </div>
                    </div>

                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style="height:auto" type="text"  class="form-control m-2 cvform" name="service"> 

                        </div>
                    </div>

                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service Description </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="serviceDesc"></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Achievement</label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="achievement"></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Skill</label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <div class="overflow-auto form-control m-2 cvform " style="height:150px;">
                                <%ArrayList<Skill> skilllist = SkillDAO.getAllSkill();
                                for (Skill skill : skilllist) {%>

                                <div>
                                <input type="checkbox" class="form-check-input " value="<%=skill.getId()%>">
                                <label class="form-check-label"><%=skill.getName()%></label
                                </div> 
                                <%}%>
                            </div>
                        </div>
                    </div>
                        
                </div>
                            <input type="submit" class="btn btn-primary btn-lg m-3"name="action" value="CreateCV">
            
            </div>
                            </form>
        </div>
    
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html>
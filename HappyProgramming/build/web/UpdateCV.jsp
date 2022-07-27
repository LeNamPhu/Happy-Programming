<%-- 
    Document   : CreateCV
    Created on : Jun 19, 2022, 8:39:04 AM
    Author     : admin
--%>

<%@page import="java.nio.file.Files"%>
<%@page import="java.io.File"%>
<%@page import="javax.swing.JFileChooser"%>
<%@page import="DTO.Skill"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="DAO.SkillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Mentor"%>
<%@page import="DAO.MentorDAO"%>
<%@page import="DTO.Account"%>
<%@page import="DTO.Account"%>
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
        <%
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int mentorID = user.getId();
            MentorDAO mentordao = new MentorDAO();
            Mentor mentor = mentordao.getMentorInfoByID(mentorID);

        %>
        <div class="body"style="font-size:  30px;">
            <form action="MainController" method="POST">
                <div class=" py-5 my-5"style="width: 60%; margin:auto; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 " style="text-align:center">
                            <div class="p-4">
                                <div style="height:162px; width:162px;position:relative;margin:auto">
                                    <img id="avt" class="rounded-circle border"  src="image/avatar.png" style="height:100%;width:100%">

                                    <div style=" position:absolute; right:5px; bottom:5px; height:30px; width:30px; border-radius: 50%; background-color: white">
                                        <i class="fa-solid fa-camera" style="height:100%; position:absolute; right:5px; bottom:5px;"></i>

                                        <input  type="file" name="avatar" accept="image/*"

                                               onchange="document.getElementById('avt').src = window.URL.createObjectURL(this.files[0])" style="width: 100%; height:100%; opacity: 0;">
                                    </div>
                                </div>
                            </div>
                            <input  readonly style="margin: auto; height:50px; width:300px; text-align: center" type="text" placeholder="" class="form-control" name="accName" value="<%=user.getAccountName()%>"> 
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required  type="text" placeholder="Full Name" class="form-control m-2 cvform" name="fullName" value="<%=mentor.getFullname()%>"> 

                            <input  required type="text" placeholder="Job" class="form-control m-2 cvform " name="job" value="<%=mentor.getJob()%>"> 

                            <textarea required style=" height:auto " type="text" placeholder="Introduction" rows="5" class="form-control m-2 cvform" name="introducton" ><%=mentor.getIntroduction()%></textarea>
                        </div>

                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Email </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required  value="<%=mentor.getEmail()%>"style=" " type="text"  class="form-control m-2 cvform" name="email"> 
                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Date of Birth </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required  value="<%=mentor.getDob()%>"style=" " type="date"  class="form-control m-2 cvform" name="dob"> 
                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label>Gender </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2" >
                            <select required class="form-select m-2 cvform" name="gender" style="width:200px;" ><option>Male</option>
                                <option>Female</option>
                                <option>Other</option></select>
                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Address </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required value="<%=mentor.getAddress()%> " type="text"  class="form-control m-2 cvform" name="address"> 
                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required value="<%=mentor.getProfession()%>" type="text"  class="form-control m-2 cvform" name="profession"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession Intro </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea  required style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="professionIntro"><%=mentor.getProfessionIntro()%></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Framework </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input  required style="height:auto" type="text"  class="form-control m-2 cvform" name="framework" value="<%=mentor.getFramework()%>"> 

                        </div>
                    </div>

                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input required style="height:auto" type="text"  class="form-control m-2 cvform" name="service" value="<%=mentor.getService()%>"> 

                        </div>
                    </div>

                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service Description </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea required style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="serviceDesc"><%=mentor.getServiceDesc()%></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Achievement</label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea required style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="achievement"><%=mentor.getAchievementDesc()%></textarea>

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
                                <%

                                    boolean check =false;
                                    ArrayList<Skill> skilllist= SkillDAO.getAllSkill();
                                    ArrayList<String> skillListMentor = mentordao.getmentorSKill(mentorID);
                                    
                                            
                                    for (Skill skill : skilllist) {
                                        check=false;
                                       if ("active".equals(skill.getStatus())) {
                                    for (String s : skillListMentor) {
                                        
                                        if (s.equals(skill.getName())) {
                                              check = true;  
                                            }
      
                                    
                                                  
                                    }
                                       
                                if(check){%>
                                <input  checked type="checkbox" class="form-check-input " name="hobby" value="<%=skill.getId()%>"><label class="form-check-label"><%=skill.getName()%></label></br>
                                <%}else{%>
                                <input  type="checkbox" class="form-check-input " name="hobby" value="<%=skill.getId()%>"><label class="form-check-label"><%=skill.getName()%></label></br>
 
                                        <%}%>
                                <%  
                                    }

                                    }%>
                                
                            </div>
                        </div>        
                    </div>
<div class="mt-3" style="text-align: center">
                                    <input type="submit" id="btn" name="action" value="UpdateCV" class="btn btn-primary btn-lg " style="text-align: center">
                                </div>
                    
                    <input type="hidden" id="abc" name="skill">
                    <script language="javascript">
                        document.getElementById('btn').onclick = function ()
                        {
                            // Khai báo tham số
                            var checkbox = document.getElementsByName('hobby');
                            var result = "";

                            // Lặp qua từng checkbox để lấy giá trị
                            for (var i = 0; i < checkbox.length; i++) {
                                if (checkbox[i].checked === true) {
                                    result += checkbox[i].value + ', ';
                                }
                            }

                            document.getElementById('abc').value = result;
                        };
                    </script>
                    
                                
                </div>
            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html>
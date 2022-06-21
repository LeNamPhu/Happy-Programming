<%-- 
    Document   : CreateCV
    Created on : Jun 19, 2022, 8:39:04 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>

        <script type="text/javascript" src="virtual-select.min.js"></script>
        <link href="virtual-select.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <header>

            <%@include file = "MentorHeader.jsp" %>

        </header>
        <div class="body"style="font-size:  30px;">
            <form>
                <div style="width: 60%; margin:auto">
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 " style="text-align:center">
                            <div class="p-4">
                                <img class="rounded-circle border" src="image/avatar.png">
                            </div>
                            <input style="margin: auto; height:50px; width:300px; text-align: center" type="text" placeholder="Account Name" class="form-control" name="accName"> 
                        </div>
                        <div class="col-md-8 pt-2">
                            <input  type="text" placeholder="Full Name" class="form-control m-2 cvform" name="fullName"> 
                            <input  type="text" placeholder="Job" class="form-control m-2 cvform " name="job"> 
                            <textarea style=" height:auto " type="text" placeholder="Introduction" rows="5" class="form-control m-2 cvform" name="description"></textarea>
                        </div>

                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Email </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Date of Birth </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label>Gender </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2" >
                            <select class="form-select m-2 cvform" style="width:200px;" ><option>Male</option>
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
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 

                        </div>
                    </div>
                    <div class="row" style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Profession Intro </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="profession"></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <input style=" " type="text"  class="form-control m-2 cvform" name="email"> 

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Service Introduction </label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="profession"></textarea>

                        </div>
                    </div>
                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label> Achievement</label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2">
                            <textarea style=" height:auto " type="text" placeholder="" rows="5" class="form-control m-2 cvform" name="profession"></textarea>

                        </div>
                    </div>

                    <div class="row " style="margin:0!important">
                        <div class="col-md-4 pt-3 ">
                            <div class="cvlabel p-2">
                                <label>Skill</label>
                            </div>
                        </div>
                        <div class="col-md-8 pt-2  ">
                            <div id="sample-select" style="width:600px;" class="m-2 "></div>
                            <script type="text/javascript" src="SkillDropdownJS.js"></script>
                        </div>

                    </div>

                </div>



            </form>
        </div>
        <footer>

            <%@include file = "Footer.jsp" %>

        </footer>
    </body>
</html>

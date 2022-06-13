<%-- 
    Document   : HomePage
    Created on : Jun 9, 2022, 8:28:21 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $("#demo").carousel({
                    interval: false
                });
            });
        </script>
    </head>
    <body>
       
        <header>
            <%@include file = "UnregisteredHeader.jsp" %>
        </header>
        <section>
 <div class="">
            <!-- Carousel -->
            <div id="demo" class="carousel slide" data-bs-ride="carousel" >

                <!-- Indicators/dots -->
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                </div>

                <!-- The slideshow/carousel -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="image/img1.jpg" alt="Los Angeles" class="d-block" style="width:100%">
                    </div>
                    <div class="carousel-item">
                        <img src="image/img2.jpg" alt="Chicago" class="d-block" style="width:100%">
                    </div>
                    <div class="carousel-item">
                        <img src="image/img3.jpg" alt="New York" class="d-block" style="width:100%">
                    </div>
                </div>

                <!-- Left and right controls/icons -->
                <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>

            </div>
        </section>
       
        
        </div>
    </body>
</body>
</html>

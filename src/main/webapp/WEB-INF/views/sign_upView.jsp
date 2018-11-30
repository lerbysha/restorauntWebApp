<%--
  Created by IntelliJ IDEA.
  User: Artur
  Date: 28.11.2018
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="site-section bg-light" id="section-contact">
    <div class="container">
        <div class="row">

            <div class="col-md-12 text-center mb-5 site-animate">
                <h2 class="display-4">Get In Touch</h2>
                <div class="row justify-content-center">
                    <div class="col-md-7">
                        <p class="lead">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-7 mb-5 site-animate">
                <form action="" method="post">
                    <div class="form-group">
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" name="username" class="form-control" id="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="email" class="sr-only">Email</label>
                        <input type="text" name="email" class="form-control" id="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="password" class="sr-only">Message</label>
                        <input type="password" name="password" id="password"  class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary btn-lg" value="Send Message">
                    </div>
                </form>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-4 site-animate">
                <p><img src="images/about_img_1.jpg" alt="" class="img-fluid"></p>
                <p class="text-black">
                    Address: <br> 121 Street, Melbourne Victoria <br> 3000 Australia <br> <br>
                    Phone: <br> 90 987 65 44 <br> <br>
                    Email: <br> <a href="mailto:info@yoursite.com">info@yoursite.com</a>
                </p>

            </div>

        </div>
    </div>
</section>
<div id="map"></div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Artur
  Date: 28.11.2018
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="site-section" id="section-about">
    <div class="container">
        <div class="row">
            <div class="col-md-5 site-animate mb-5">
                <h4 class="site-sub-title">Our Story</h4>
                <h2 class="site-primary-title display-4">Welcome</h2>
            </div>
            <p>${user.username  }</p>
            <div class="col-md-1"></div>
            <div class="col-md-6 site-animate img" data-animate-effect="fadeInRight">
                <img src="images/about_img_1.jpg" alt="Free Template by colorlib.com" class="img-fluid">
            </div>
        </div>
    </div>
</section>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>EatWell</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700|Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">



    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body data-spy="scroll" data-target="#site-navbar" data-offset="200">
<nav class="navbar navbar-expand-lg navbar-dark site_navbar bg-dark site-navbar-light" id="site-navbar">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/"/>">EatWell</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#site-nav" aria-controls="site-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="site-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="<c:url value="/"/>" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="<c:url value="/signIn"/> " class="nav-link">Sing In</a></li>
                <li class="nav-item"><a href="<c:url value="/signUp"/>" class="nav-link">Register</a></li>
                <li class="nav-item"><a href="<c:url value="/menu"/>" class="nav-link">Menu</a></li>
                <li class="nav-item"><a href="<c:url value="/profile"/>" class="nav-link">Profile</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="site-section" id="section-about">
    <div class="container">
        <div class="row">
            <div class="col-md-5 site-animate mb-5">
                <h4 class="site-sub-title">Welcome</h4>
                <h2 class="site-primary-title display-4">Please, SIGN IN</h2>
                <c:if test="${not empty error}">
                    ${error}
                </c:if>

                <form action="" method="post">
                    <div class="form-group">
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" name="username" class="form-control" id="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="password" class="sr-only">Message</label>
                        <input type="password" name="password" id="password"  class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary btn-lg" value="Sing IN">
                    </div>
                <p><a href="#" class="btn btn-secondary btn-lg">Learn More About Us</a></p>
                </form>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-6 site-animate img" data-animate-effect="fadeInRight">
                <img src="images/about_img_1.jpg" alt="Free Template by colorlib.com" class="img-fluid">
            </div>
        </div>
    </div>
</section>
<footer class="site-footer site-bg-dark site-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-4 site-animate">
                        <h2 class="site-heading-2">About Us</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cumque, similique, delectus blanditiis odit expedita amet. Sed labore ipsum vel dolore, quis, culpa et magni autem sequi facere eos tenetur, ex?</p>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-3 site-animate">
                        <div class="site-footer-widget mb-4">
                            <h2 class="site-heading-2">The Restaurant</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">About Us</a></li>
                                <li><a href="#" class="py-2 d-block">Events</a></li>
                                <li><a href="#" class="py-2 d-block">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2 site-animate">
                        <div class="site-footer-widget mb-4">
                            <h2 class="site-heading-2">Useful links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Foods</a></li>
                                <li><a href="#" class="py-2 d-block">Drinks</a></li>
                                <li><a href="#" class="py-2 d-block">Breakfast</a></li>
                                <li><a href="#" class="py-2 d-block">Brunch</a></li>
                                <li><a href="#" class="py-2 d-block">Dinner</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2 site-animate">
                        <div class="site-footer-widget mb-4">
                            <h2 class="site-heading-2">Useful links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Foods</a></li>
                                <li><a href="#" class="py-2 d-block">Drinks</a></li>
                                <li><a href="#" class="py-2 d-block">Breakfast</a></li>
                                <li><a href="#" class="py-2 d-block">Brunch</a></li>
                                <li><a href="#" class="py-2 d-block">Dinner</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="row site-animate">
            <div class="col-md-12 text-center">
                <div class="site-footer-widget mb-4">
                    <ul class="site-footer-social list-unstyled ">
                        <li class="site-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="site-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="site-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-12 text-center">
                <p>&copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Artur Gaisin</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
        </div>
    </div>
</footer>




<!-- Modal -->
<div class="modal fade" id="reservationModal" tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="bg-image" style="background-image: url('/images/reservation_1.jpg');"></div>
                    </div>
                    <div class="col-lg-12 p-5">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <small>CLOSE </small><span aria-hidden="true">&times;</span>
                        </button>
                        <h1 class="mb-4">Reserve A Table</h1>
                        <form action="#" method="post">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="m_fname">First Name</label>
                                    <input type="text" class="form-control" id="m_fname">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="m_lname">Last Name</label>
                                    <input type="text" class="form-control" id="m_lname">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <label for="m_email">Email</label>
                                    <input type="email" class="form-control" id="m_email">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="m_people">How Many People</label>
                                    <select name="" id="m_people" class="form-control">
                                        <option value="1">1 People</option>
                                        <option value="2">2 People</option>
                                        <option value="3">3 People</option>
                                        <option value="4+">4+ People</option>
                                    </select>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="m_phone">Phone</label>
                                    <input type="text" class="form-control" id="m_phone">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="m_date">Date</label>
                                    <input type="text" class="form-control" id="m_date">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="m_time">Time</label>
                                    <input type="text" class="form-control" id="m_time">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <label for="m_message">Message</label>
                                    <textarea class="form-control" id="m_message" cols="30" rows="7"></textarea>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Reserve Now">
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- END Modal -->

<!-- loader -->
<div id="site-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>

<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.timepicker.min.js"></script>

<script src="js/jquery.animateNumber.min.js"></script>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>

<script src="js/main.js"></script>

</body>
</html>

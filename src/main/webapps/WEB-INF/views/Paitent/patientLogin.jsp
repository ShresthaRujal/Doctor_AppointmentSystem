<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 6/5/2017
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en-US"><!--<![endif]-->


<head>
    <!-- META TAGS -->
    <meta charset="UTF-8">

    <!-- Title -->
    <title>E-Health</title>


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="SKYPE_TOOLBAR" content ="SKYPE_TOOLBAR_PARSER_COMPATIBLE"/>

    <!-- favicon -->
    <link rel="shortcut icon" href="/resources/local/images/favicon-new.png">

    <!-- Google Web Font -->
    <link href="http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,800,900,300,200" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- bootstrap Style Sheet (caution ! - Do not edit this stylesheet) -->
    <link rel="stylesheet" href="/resources/local/css/bootstrap.css" type="text/css" media="all">
    <!-- Flexslider stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/flexslider.css" type="text/css" media="all">
    <!-- Animations stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/animations.css" type="text/css" media="all">
    <!-- Awesome Font stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/font-awesome.css" type="text/css" media="all">
    <!-- Datepciker stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/datepicker.css" type="text/css" media="all">
    <!-- Swipebox stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/swipebox.css" type="text/css" media="all">
    <!-- meanmenu stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/meanmenu.css" type="text/css" media="all">
    <!-- Include the site main stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/main.css" type="text/css" media="all">
    <!-- Include the site responsive  stylesheet -->
    <link rel="stylesheet" href="/resources/local/css/custom-responsive.css" type="text/css" media="all">

<style type="text/css">
    .error{
        color: red;
    }
</style>
<script type="text/javascript">
    ${notice}
</script>

</head>
<body>


<div class="header-top clearfix">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ">
                <p>Welcome to E-health Management System</p>
            </div>
            <!--opening hours-->
            <div class="col-md-7 text-right">
                <p>
                    Opening Hours : <span>24/7</span>
                    <br class="visible-xs">Contact : <span>014420454</span>
                </p>
            </div>

        </div>
    </div>
</div>


<header id="header">
    <div class="container">

        <!-- Website Logo -->
        <div class="logo clearfix">
            <a href="home.html">
                <%--<img width="180" height="80" src="${pageContext.request.contextPath}/resources/image/${user.image}" alt=""/>--%>
                <img src="/resources/local/images/temp-images/logo-two.png" height="80" width="180" alt="">${user.name}
            </a>
        </div>

        <!-- Main Navigation -->
        <nav class="main-menu">
            <ul class="header-nav clearfix" id="menu-main-menu">
                <li>
                    <a href="#">Home</a>
                    <ul>
                        <li><a href="#">HomeBlog</a></li>
                        <li><a href="#">HospitalBlog</a></li>

                    </ul>
                </li>
                <li>
                    <a href="#">Doctors</a>
                    <ul>
                        <li>
                            <a href="#">Permanenet</a>
                        </li>
                        <li>
                            <a href="#">Trainee</a>
                        </li>
                        <li>
                            <a href="#">Visiting</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#">Services</a>

                </li>
                <li>
                    <a href="#">Gallery</a>
                    <ul>
                        <li>
                            <a href="#">Doctors Galle|</a>
                        </li>
                        <li>
                            <a href="#">Patients Gallery</a>
                        </li>
                        <li>
                            <a href="#">Staff Gallery</a>
                        </li>
                    </ul>
                </li>

                <li class="current-menu-item page_item">
                    <a href="${pageContext.request.contextPath}/patients/login">Login</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </nav>
        <div id="responsive-menu-container"></div>
    </div>
</header>
<div class="container">
    <script>${passmessage}</script>
    <h3 class="error"><u>${message}</u></h3>
</div>
<section class="login-register sec-padding">  
    <div class="container">
         
        <div class="col-md-6" style="border: 1px solid dimgrey">
                <div class="sec-title">
                    <h2>Login</h2>
                </div>              
                <form:form method="post" action="/patients/login" id="contact-form login" modelAttribute="patientLoginDto">

                    <div class="row" >
                    <label class="col-sm-2">Email :</label>
                    <div class="col-sm-6">
                        <form:input path="email" id="test" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="email" cssClass="error" placeholder="john@gmail.com"/> </div>
                </div>
                <div class="row">
                    <label class="col-sm-2">Password :</label>
                    <div class="col-sm-6">
                        <form:password path="password" id="test" class="form-control"/>
                    </div>
                    <div class="col-sm-4"><form:errors path="password" cssClass="error"/> </div>
                </div>
                <div class="row" style="margin-left: 5px; margin-bottom: 5px    ">
                    <input type="submit" class="thm-btn" value="Login now">
                    <a href="/password/forgot" style="margin-left: 125px;"><i>Forgot Password!</i></a>

                </div>

                    
                </form:form>
            </div>
        <div class="col-md-6">
            <div class="row" style="margin-left: 250px;font-size: 33px;color: darkred;font-family: Verdana">Don't have ID? </div>
            <div class="row">
            <img src="${pageContext.request.contextPath}/resources/dist/img/new.png" style="margin-left: 55px;">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/patients/regPatient" style="font-weight: 600;font-size: 33px;">Register!</a><br/>
            </div>

        </div>
    </div>

</section>
<br/>
<footer id="main-footer" class="site-footer clearfix">
    <div class="container">
        <div class="row">


            <!--about widget-->
            <div class="col-md-3 col-sm-6">
                <section  class="widget animated fadeInLeft">
                    <h3 class="title">About MedicalPress</h3>
                    <div class="textwidget">
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod
                            tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis
                            nisl ut aliquip ex ea commodo consequat.</p>
                    </div>
                </section>
            </div>


            <!--general services-->
            <div class="col-md-3 col-sm-6  ">
                <section class="widget animated fadeInLeft ae-animation-fadeInLeft">
                    <h3 class="title">General Services</h3>
                    <ul>
                        <li>
                            <a href="#">Immunization</a>
                        </li>
                        <li>
                            <a href="#">Medical Services</a>
                        </li>
                        <li>
                            <a href="#">Surgical</a>
                        </li>
                        <li>
                            <a href="#">Diagnostic Services</a>
                        </li>
                        <li>
                            <a href="#">Pharmacy</a>
                        </li>
                    </ul>
                </section>
            </div>

            <div class="clearfix visible-sm"></div>

            <!--recent posts-->
            <div class="col-md-3 col-sm-6  ">
                <section  class="widget animated fadeInLeft">
                    <h3 class="title">Latest Tweets</h3>                     <ul id="twitter_update_list">                         <li>No Tweet Loaded !</li>                     </ul>
                </section>
            </div>
            <!--subscription form-->

        </div>
        <div class="footer-bottom animated fadeInDown clearfix">
            <div class="row">

                <!--footer social icons-->
                <div class="col-sm-5 clearfix">
                    <ul class="footer-social-nav">
                        <li><a target="_blank" href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-instagram"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-youtube"></i></a></li>
                        <li><a target="_blank" href="skype:skypeusername?add"><i class="fa fa-skype"></i></a></li>
                        <li><a target="_blank" href="#"><i class="fa fa-rss"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>

<a href="#top" id="scroll-top"></a>

<script type='text/javascript' id='quick-js'></script>
<script type='text/javascript' src='/resources/local/js/jquery-2.2.3.min.js'></script>
<script type='text/javascript' src='/resources/local/js/bootstrap.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.flexslider-min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.swipebox.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.isotope.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.appear.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.ui.core.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.ui.datepicker.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.validate.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.form.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.autosize.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.meanmenu.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery.velocity.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery-twitterFetcher.js'></script>
<script type='text/javascript' src='/resources/local/js/respond.min.js'></script>
<script type='text/javascript' src='/resources/local/js/jquery-migrate-1.2.1.min.js'></script>
<script type='text/javascript' src='/resources/local/js/custom.js'></script>

</body>

<!-- Mirrored from inspirythemes.biz/html-templates/medicalpress/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 26 Apr 2017 07:44:18 GMT -->
</html>

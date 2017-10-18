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


     

</head>
<body>
<%String token= (String) request.getAttribute("tokan");
    session.setAttribute("token",token);%>
 
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
                <img src="/resources/local/images/temp-images/logo-two.png" height="80" width="180" alt="">
                    <%--${user.name}--%>
            </a>
        </div>

        <!-- Main Navigation -->
        <nav class="main-menu">
            <ul class="header-nav clearfix" id="menu-main-menu">
                <li class="current-menu-item page_item">
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
                    <a href="#">services</a>
                     
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
                 <li>
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
<!--slider-->
<div class="home-slider clearfix">
    <div class="flexslider">
        <ul class="slides">
            <!--slide start-->
            <li class="flex-active-slide">
                <img src="/resources/local/images/temp-images/slide-one.jpg" alt="Medical Services That You Can Trust" draggable="false">
                <div class="content-wrapper clearfix">
                    <div class="container">
                        <div class="slide-content clearfix">
                            <h1>Medical Services <span>That You Can Trust</span></h1>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit sed diam nonummy nibh euismod.</p>
                            <a class="slider-button" href="doctors-three-columns.html">Read More</a>
                        </div>
                    </div>
                </div>
            </li>
            <!--slide end-->

            <!--slide start-->
            <li>
                <img src="/resources/local/images/temp-images/slide-two.jpg" alt="We Care for You" draggable="false">
                <div class="content-wrapper clearfix">
                    <div class="container">
                        <div class="slide-content clearfix ">
                            <h1>We <span>Care</span> for <span>You</span></h1>
                            <p>Monthly checking will help to avoid future problems.</p>
                            <a class="slider-button" href="doctors-three-columns.html">Read More</a>
                        </div>
                    </div>
                </div>
            </li>
            <!--slide end-->
        </ul>
        <!--directional nav-->
        <ul class="flex-direction-nav">
            <li><a class="flex-prev" href="#">Previous</a></li>
            <li><a class="flex-next" href="#">Next</a></li></ul>
    </div>
    <!--appointment form-->
 
 
 
 

<!--blog posts section-->
<div class="home-blog text-center clearfix">
    <div class="container">
        <div class="slogan-section animated fadeInUp clearfix">
            <h2>Latest News from <span>Health and Medical</span></h2>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
        </div>
        <div class="row">
            <div class="col-md-4">
                <article class="common-blog-post animated fadeInRight clearfix">
                    <figure>
                        <a href="image-post-format.html" title="Image Post Format">
                            <img src="/resources/local/images/temp-images/news-2-732x447.jpg" alt="news-2" />
                        </a>
                    </figure>
                    <div class="text-content clearfix">
                        <h5><a href="image-post-format.html">Image Post Format</a></h5>
                        <div class="entry-meta">
                            <span>10 May, 2014</span>, by <a href="#" title="Posts by John Doe">John Doe</a>
                        </div>
                        <div class="for-border"></div>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat&hellip; </p>
                    </div>
                </article>
                <a class="read-more" href="image-post-format.html">Read More</a>
            </div>
            <div class="col-md-4">
                <article class="common-blog-post animated fadeInRight clearfix">
                    <div class="gallery gallery-slider clearfix loading">
                        <ul class="slides">
                            <li>
                                <a href="/resources/local/images/temp-images/gallery-1.jpg" title="" >
                                    <img src="/resources/local/images/temp-images/gallery-1.jpg" alt="gallery-1" />
                                </a>
                            </li>
                            <li class="flex-active-slide">
                                <a href="/resources/local/images/temp-images/gallery-2.jpg" title="" >
                                    <img src="/resources/local/images/temp-images/gallery-2.jpg" alt="gallery-2" />
                                </a>
                            </li>
                            <li>
                                <a href="/resources/local/images/temp-images/gallery-3.jpg" title="" >
                                    <img src="/resources/local/images/temp-images/gallery-3.jpg" alt="gallery-3" />
                                </a>
                            </li>
                            <li>
                                <a href="/resources/local/images/temp-images/gallery-2.jpg" title="" >
                                    <img src="/resources/local/images/temp-images/gallery-2.jpg" alt="gallery-4" />
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="text-content clearfix">
                        <h5><a href="gallery-post-format.html">Gallery Post Format</a></h5>
                        <div class="entry-meta">
                            <span>10 May, 2014</span>, by <a href="#" title="Posts by John Doe">John Doe</a>
                        </div>
                        <div class="for-border"></div>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat&hellip; </p>
                    </div>
                </article>

                <a class="read-more" href="gallery-post-format.html">Read More</a>
            </div>

            <div class="col-md-4">
                <article class="common-blog-post animated fadeInRight clearfix">
                    <div class="video clearfix">
                        <div class="video-wrapper clearfix">
                            <iframe src="http://player.vimeo.com/video/75594702?title=0&amp;byline=0&amp;portrait=0" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
                        </div>
                    </div>
                    <div class="text-content clearfix">
                        <h5><a href="video-post-format.html">The Hero In All Of Us</a></h5>
                        <div class="entry-meta">
                            <span>10 May, 2014</span>, by <a href="#" title="Posts by John Doe">John Doe</a>
                        </div>
                        <div class="for-border"></div>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat&hellip; </p>
                    </div>
                </article>
                <a class="read-more" href="video-post-format.html">Read More</a>
            </div>
        </div>
    </div>
</div>
<!--blog posts section end-->

<!--testimonials section-->
<div class="home-testimonial  clearfix">
    <div class="container">
        <div class="text-center">
            <div class="slogan-section animated fadeInUp clearfix">
                <h2>What patients say <span>About E-Health System</span></h2>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10 text-center">
                <div class="flexslider-three animated fadeInUp">
                    <ul class="slides">
                        <li>
                            <img class="img-circle" src="/resources/local/images/temp-images/author-22-130x130.jpg" alt="author-22" />
                            <blockquote>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam quis nostrud exerci tation.</p>
                            </blockquote>

                            <div class="testimonial-footer clearfix">
                                <h3>Marina Forrest</h3>
                                <div class="for-border"></div>
                                <p><a target="_blank" href="#">Oh Yeah</a></p>
                            </div>
                        </li>
                        <li>
                            <img class="img-circle" src="/resources/local/images/temp-images/author-11-130x130.jpg" alt="author-11" />
                            <blockquote>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                            </blockquote>

                            <div class="testimonial-footer clearfix">
                                <h3>Jaden Wayne</h3>
                                <div class="for-border"></div>
                                <p><a target="_blank" href="#">Beautypie</a></p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-1"></div>
        </div>
    </div>
</div>
<!--testimonials section end-->



<!--page footer-->
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
</div>
</body>

<!-- Mirrored from inspirythemes.biz/html-templates/medicalpress/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 26 Apr 2017 07:44:18 GMT -->
</html>

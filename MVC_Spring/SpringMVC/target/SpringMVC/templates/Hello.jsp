<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
 
     <!-- Site Metas -->
    <title>Dominic - Responsive HTML5 OnePage Template</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="./static/images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="./static/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./static/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="./static/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="./static/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="./static/css/custom.css">
	<script src="./static/js/modernizr.js"></script> <!-- Modernizr -->

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body id="page-top" class="politics_version">

    <!-- LOADER -->
    <div id="preloader">
        <div id="main-ld">
			<div id="loader"></div>  
		</div>
    </div><!-- end loader -->
    <!-- END LOADER -->
	
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">
			<img class="img-fluid" src="./static/images/logo.png" alt="" />
		</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav text-uppercase ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger active" href="#home">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">About Us</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">Portfolio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#testimonials">Testimonials</a>
            </li>
			<li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#blog">Blog</a>
            </li>
			<li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Contect Us</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
	<section id="home" class="main-banner parallaxie" style="background: url('./static/uploads/banner-01.jpg')">
		<div class="heading">
			<h1>${greeting}</h1>
			<p>"***"</p>
		</div>
	</section>

	<svg id="clouds" class="hidden-xs" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 85 100" preserveAspectRatio="none">
        <path d="M-5 100 Q 0 20 5 100 Z
            M0 100 Q 5 0 10 100
            M5 100 Q 10 30 15 100
            M10 100 Q 15 10 20 100
            M15 100 Q 20 30 25 100
            M20 100 Q 25 -10 30 100
            M25 100 Q 30 10 35 100
            M30 100 Q 35 30 40 100
            M35 100 Q 40 10 45 100
            M40 100 Q 45 0 50 100
            M45 100 Q 50 20 55 100
            M50 100 Q 55 -10 60 100
            M55 100 Q 60 10 65 100
            M60 100 Q 65 10 70 100
            M65 100 Q 70 0 75 100
            M70 100 Q 75 10 80 100
            M75 100 Q 80 30 85 100
            M80 100 Q 85 20 90 100
            M85 100 Q 90 10 95 100
            M90 100 Q 95 0 100 100
            M95 100 Q 100 15 105 100 Z">
        </path>
    </svg>


    <div class="copyrights">
        <div class="container">
            <div class="footer-distributed">
                <div class="footer-left">
                    <p class="footer-links">
                        <a href="#">Home</a>
                        <a href="#">Blog</a>
                        <a href="#">Pricing</a>
                        <a href="#">About</a>
                        <a href="#">Faq</a>
                        <a href="#">Contact</a>
                    </p>
                    <p class="footer-company-name">All Rights Reserved. &copy; 2018 <a href="#">Dominic</a> Design By : 
					<a href="https://html.design/">html design</a></p>
                </div>
            </div>
        </div><!-- end container -->
    </div><!-- end copyrights -->

    <a href="#" id="scroll-to-top" class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>

    <!-- ALL JS FILES -->
    <script src="./static/js/all.js"></script>
	<!-- Camera Slider -->
	<script src="./static/js/jquery.mobile.customized.min.js"></script>
	<script src="./static/js/jquery.easing.1.3.js"></script> 
	<script src="./static/js/parallaxie.js"></script>
	<script src="./static/js/headline.js"></script>
	<!-- Contact form JavaScript -->
    <script src="./static/js/jqBootstrapValidation.js"></script>
    <script src="./static/js/contact_me.js"></script>
    <!-- ALL PLUGINS -->
    <script src="./static/js/custom.js"></script>
    <script src="./static/js/jquery.vide.js"></script>

</body>
</html>
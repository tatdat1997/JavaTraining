<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V16</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="./static/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="./static/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="./static/css/util.css">
<link rel="stylesheet" type="text/css" href="./static/css/main.css">
<link rel="stylesheet" href="./static/style.css">
<!--===============================================================================================-->
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"> <img
				class="img-fluid" src="./static/images/logo.png" alt="" />
			</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/hello">Home</a></li>
					<li class="nav-item"><a
						class="nav-link js-scroll-trigger active" href="/login">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('./static/images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41"> Account Login </span>
				<form class="login100-form validate-form p-b-33 p-t-5">

					<div class="wrap-input100 validate-input"
						data-validate="Enter username">
						<input class="input100" type="text" name="username"
							placeholder="User name"> <span class="focus-input100"
							data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="pass"
							placeholder="Password"> <span class="focus-input100"
							data-placeholder="&#xe80f;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="pass_cfm"
							placeholder="Confirm Password"> <span class="focus-input100"
							data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">Register</button>
						<a class="login100-form-btn m-l-10" href="/login">Login</a>
					</div>

				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="./static/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="./static/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="./static/vendor/bootstrap/js/popper.js"></script>
	<script src="./static/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="./static/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="./static/vendor/daterangepicker/moment.min.js"></script>
	<script src="./static/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="./static/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<!-- 	<script src="./static/js/main.js"></script> -->

</body>
</html>
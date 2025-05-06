<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rental Booking</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<!-- CSS link -->
<link rel="stylesheet" href="/Rental_Booking_System/URLRESOURCE/css/style.css">
<style>
.selector-for-some-widget {
	box-sizing: content-box;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	text-align: center;
	height: 5%;
	font-size: 14px;
}
</style>
</head>
<body>
<nav class="navbar fixed-top navbar-dark" style="height: 50px;background-color: black;">
		<div class="container-fluid">
			<img src="/Rental_Booking_System/URLRESOURCE/img/parkimg.png" class="w3-bar w3-border" width="85"
				height="40">
			<div class="navbar-left" class="w3-bar w3-border" style="margin-top: -5px;">
				<a href="index.jsp" class="btn btn-sm"
					style="background-color: turquoise;color:black">Home</a>
			</div>
		</div>
	</nav>
<div class="container">
		<div class="row justify-content-center mt-5" >
			<div class="col-lg-4 col-md-8 col-sm-8" style="margin-top:-5%;">
				<div class="card shadow " >
					<div class="card-title text-center border-bottom" style="background-color: turquoise;">
						<h3 class="p-2" style="color: black;">Admin Login</h3>
					</div>
					<div class="card-body">
						<form action="adminLogin" method="post" onsubmit="return validateform()" name="myform">
						<span id="form" style="color:red;">${error2}</span><span style=color:red;>${error}</span>
							<div class="mb-4 shadow"> 
								<input type="text" class="form-control" id="email" name="email" placeholder="Email address"/>
								<span id="email1" style="color:red;"></span>
							</div>
							<div class="mb-4 shadow">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
								<span id="password1" style="color:red;"></span>
							</div>
							<div class="d-grid shadow" style="margin-left: 10%;margin-right: 10%;">
							<button type="submit" class="btn w-60" style="background-color: turquoise;text-align: center;"><b>Login</b></button>
							</div>
						<div class="mb-3"></div>
						<div class="mb-3" style="text-align: center;">
						<small><a href="index.jsp" id="fpassword" style="a{text-decoration: none;}a:hover {text-decoration: underline;}">Forgot password?</a></small>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<div class="footer">
		<small style="color:white;"style="color:white;">&copy; Created by: Priyanka B S,</small><small style="color:white;">&ensp;bspriya9912@gmail.com</small>
	</div>
</body>
</html>
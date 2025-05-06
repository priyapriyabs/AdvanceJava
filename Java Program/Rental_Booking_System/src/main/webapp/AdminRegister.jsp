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
<script type="text/javascript" src="/Rental_Booking_System/URLRESOURCE/js/myscript.js"></script>
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
<script type="text/javascript">
function validateform() {
    var name=document.myform.name.value;
	var email = document.myform.email.value;
	var password = document.myform.password.value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/;
	var status = false;

	if (email == "" && password=="" && name=="") {
		document.getElementById('form').innerHTML = "*Please enter the credential";
		document.getElementById('name1').innerHTML = "";
		document.getElementById('email1').innerHTML = "";
		document.getElementById('password1').innerHTML = "";
		status = false;
	} else {
		document.getElementById('form').innerHTML = "";
		}
		if (name == "") {
			document.getElementById('name1').innerHTML = "*Please enter Your name";
			status = false;
		} 
		else if (email == "") {
			document.getElementById('email1').innerHTML = "*Please enter email-id";
			status = false;
		} else if (!filter.test(email)) {
			document.getElementById('email1').innerHTML = "*Please enter valid email-id";
			status = false;
		} else {
			document.getElementById('name1').innerHTML ="";
			document.getElementById('email1').innerHTML = "";
			status = true;
		}
		if (password=="") {
			document.getElementById('password1').innerHTML = "*Please enter Password";
			status = false;
		} else if (password.length < 6 && password.length>15) {
			document.getElementById('password1').innerHTML = "*PMin 6 to 15 characters";
			status = false;
		} else {
			document.getElementById('password1').innerHTML = "";
		}
	
	return status;
}

</script>
<script type="text/javascript">
function emailValidation() {
	var email1 = document.myform.email.value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/;
	var status = false;

	if (email1 == "") {
		document.getElementById('emailError').innerHTML = "*Please enter the email-id";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else if (!filter.test(email1)) {
		document.getElementById('emailError').innerHTML = "*Please enter the valid email-id";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else {
		document.getElementById('emailError').innerHTML = "";
		document.getElementById('form').innerHTML = "";
		status = true;
	}
	return status;
}
</script>
<script type="text/javascript">
function validatePassword() {
	var password = document.myform.password.value;
	var status = false;

	if (password.length < 1) {
		document.getElementById('password').innerHTML = "*Please enter the Password";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else if (password.length < 6 ) {
		document.getElementById('password1').innerHTML = "*Min length must be 6 characters";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else {
		document.getElementById('password1').innerHTML = "";
		document.getElementById('form').innerHTML = "";
	}
	return status;
}

</script>
</head>
<body>
<nav class="navbar fixed-top navbar-dark" style="height: 50px;background-color: black;">
		<div class="container-fluid">
			<img src="/Rental_Booking_System/URLRESOURCE/img/Parking Space.jpeg" class="w3-bar w3-border" width="85"
				height="40">
				<div class="navbar-left" class="w3-bar w3-border" style="margin-top: -5px;">
				<a href="AdminLogin.jsp" class="btn btn-sm"
					style="background-color: turquoise;color:black">Login</a>
			</div>
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
						<h3 class="p-2" style="color: black;">Admin Register</h3>
					</div>
					<div class="card-body">
						<form action="adminRegister" modelAttribue="admin" method="post" onsubmit= "return validateform()" name="myform">
						<span id="form" style="color:red;"></span><span style=color:red;>${notregister}</span>
						
						<div class="mb-4 shadow"> 
								<input type="text" class="form-control" id="name" name="name" placeholder="Enter name"/>
								<span id="name1" style="color:red;"></span>
							</div>
							<div class="mb-4 shadow"> 
								<input type="email" class="form-control" id="email" onchange="return emailValidation()" name="adminEmail" placeholder="Email address"/>
								<span id="email1" style="color:red;"></span>
								<span id="emailError" style="color:red;"></span>
							</div>
							<div class="mb-4 shadow">
								<input type="password" class="form-control" id="password" onchange="return validatePassword()" name="password" placeholder="Password"/>
								<span id="password1" style="color:red;"></span>
								<span id="passworderror" style="color:red;"></span>
							</div>
							<div class="d-grid shadow" style="margin-left: 10%;margin-right: 10%;">
							<button type="submit" class="btn w-60" style="background-color: turquoise;text-align: center;"><b>Register</b></button>
							</div>
						<div class="mb-3"></div>
						<div class="mb-3" style="text-align: center;">
						
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
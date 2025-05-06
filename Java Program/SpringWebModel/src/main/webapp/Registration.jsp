<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="/springModel/URLToResource/css/mystyle.css"> -->
<style type="text/css">
body{
	background-color: aqua;
	
}
.reg_form{
	position: relative;
	left: 30%;
	
}
 .head{
 /* border:  2px solid red; */ 
position:absolute;
background-color: silver;
border-radius: 2px;
width: 100%;
top: 0%;
left: 0%;
}

h1{
text-align: center;
}

.icons{
margin-left: 94%;
 text-decoration: none;
}

.regPage {
position:relative;
top:22px;
    left: 1150px;
    text-decoration: none;
}

.formData{
text-align: center;
position: relative;
top:110px;
}

label{
position:relative;
left: -40%;
}

.home{
position: relative;
top: 20px;
}

footer{
position: fixed;
bottom: 0%;
}
.footcolor{
color: blue;
}
</style>
<script>
	function validateFields() {
		var username = document.getElementById("username").value;
		var contact_number = document.getElementById("contact_number").value;
		var email = document.getElementById("email").value;
		var address = document.getElementById("address").value;
		var password = document.getElementById("password").value;
		
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/;
		
		if (username == "" || username == null && contact_number == ""
				|| contact_number == null && address == ""
				|| address == null && password == ""
				|| password == null && email=="" || email==null) {
			document.getElementById('validate').innerHTML = "*Please fill the form";
			return false;
		} else if (username == "" || contact_number == "" || address == ""
				|| password == "" || email=="") {
			document.getElementById('validate').innerHTML = "*Please fill the missing field/s";
			return false;
		} else if (!filter.test(email)) {
			
			document.getElementById('email').innerHTML = "*Please enter valid email-id";
			return false;
		} 
		else if (contact_number.length <10) {
			document.getElementById('contact_number1').innerHTML = "*Phone number must 10 digits";
			return false;
		}
		else {
			document.getElementById('validate').innerHTML = "";
			document.getElementById('email').innerHTML ="";
			document.getElementById('contact_number').innerHTML="";
			return true;
		}
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
function validateUserName() {
	var username = document.myform.username.value;
	var status = false;

	if (username.length < 1) {
		document.getElementById('username').innerHTML = "*Please enter the Name";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else if (username.length < 5 ) {
		document.getElementById('username1').innerHTML = "*Min length must be 5 characters";
		document.getElementById('form').innerHTML = "";
		status = false;
	} else {
		document.getElementById('username1').innerHTML = "";
		document.getElementById('form').innerHTML = "";
	}
	return status;
}

</script>
</head>
<body>
<header>
<nav class="head">
<h1 >Welcome Spring Web Application</h1>

<a  href="home" class="home" ><button>Home</button></a>
<a  href="login" class="icons" ><button>SignIn</button></a>
</nav>
</header>
<h2 class="formData">User Registration</h2>

<form class="col-md-4 reg_form formData" action="newRegister" method="post"  onsubmit="return validateFields()"  name="myform">
<span class="text-danger formData">
<c:forEach items="${errors}" var="objectError">${objectError.defaultMessage}</c:forEach>
</span>
<span id="form" style="color:red;"></span>
<span style="color: red;" id="validate"></span>
<span class="text-danger fs-4 fw-bold">${signupMsg}</span>

 <input type="number" hidden="hidden" class="form-control" name="id" id="id" aria-describedby="emailHelp" >
  <div class="form-group">
    <label for="exampleInputEmail1">User Name</label>
    <input type="text" class="form-control" name="username" id="username" value="${dto.username}" onchange="return validateUserName()" aria-describedby="emailHelp" placeholder="Enter username">
    <span id="username" style="color: red;"></span>
    <span id="username1" style="color:red;"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Phone</label>
    <input type="number" class="form-control"name="contact_number" id="contact_number" value="${dto.contact_number}" placeholder="Contact Number">
  <span id="contact_number" style="color: red;"></span>
   <span id="contact_number1" style="color: red;"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" class="form-control"  id="email" name="email" value="${dto.email}" onchange="return emailValidation()" placeholder="email">
    <a style="color: red;"> ${error }</a>
 <span id="email" style="color: red;"></span>
 <span id="emailError" style="color:red;"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control"name="address" id="address" value="${dto.address}" placeholder="address">
 <span id="address" style="color: red;"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="password"  placeholder="Enter password">
  <span id="password" style="color: red;"></span>
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<nav  >
 <footer class="text-center text-lg-start bg-body-tertiary text-muted" class="navbar navbar-dark bg-primary"   style="position: fixed; width: 100%;">
      <div class="text-center p-4 " style="background-color: rgba(0, 0, 0, 0.05);">
    © 2024 Copyright:
    <a class="text-reset fw-bold footcolor " href="https://mdbootstrap.com/">bspriya9912@gmail.com</a>
  </div>
  <!-- Copyright -->
</footer>

</nav>
</body>
</html>
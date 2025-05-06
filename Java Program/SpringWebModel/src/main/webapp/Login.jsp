<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
margin-left: 93%;
 text-decoration: none;
}

.regPage {
position:relative;
top:27px;
    left: 1130px;
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

h5{
position: relative;
top: 120px;
}
</style>
<script>
	function validateFields() {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{2,4})+$/;
		
		if (password == "" || password == null && email=="" || email==null) {
			alert("*Please fill the form")
			/* document.getElementById('validate').innerHTML = "*Please fill the form"; */
			return false;
		} else if (password == "" || email=="") {
			alert("*Please fill the missing field/s")
			/* document.getElementById('validate').innerHTML = "*Please fill the missing field/s"; */
			return false;
		} else if (!filter.test(email)) {
			alert("*Please enter valid email-id")
			/* document.getElementById('email').innerHTML = "*Please enter valid email-id"; */
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
</head>
<body>
<header>
<nav class="head">
<h1 >Welcome Spring Web Application</h1>

<a  href="home" class="home" ><button>Home</button></a>
<a  href="reg"  class="regPage" ><button>SignUp</button></a>
<a  href="login" class="icons" ><button>SignIn</button></a>
</nav>
</header>
<h5 style="color: white;">Welcome, ${userName.username }</h5>
<h2 class="formData">User Login</h2>

<form class="col-md-4 reg_form formData" action="userlogin" method="post" onsubmit="return validateFields()">
<p style="color: red;"> ${emailError }</p>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" id="email" value="${userName.email }" aria-describedby="emailHelp" placeholder="Enter email">
 <span id="email" style="color: red;"></span>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control"name="password" id="password" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-primary">Login</button>
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
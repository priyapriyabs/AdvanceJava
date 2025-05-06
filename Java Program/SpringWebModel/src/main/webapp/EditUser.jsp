<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<header>
<nav class="head">
<h1 >Welcome Spring Web Application</h1>
<a  href="home" class="home" >Home</a>
<a  href="view"  class="regPage" >ViewUser</a>
<a  href="login" class="icons" >SignIn</a>
</nav>
</header>
<h2 class="formData">Update User</h2>
<form class="col-md-4 reg_form formData" action="updateUser" method="post" modelAttribute="userUpdate">
 <input type="number" hidden="hidden" class="form-control" name="id" id="id" value="${editAllUser.id }" aria-describedby="emailHelp" >
  <div class="form-group">
    <label for="exampleInputEmail1">User Name</label>
    <input type="text" class="form-control" name="username" id="username" value="${editAllUser.username }" aria-describedby="emailHelp" placeholder="Enter username">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Phone</label>
    <input type="text" class="form-control"name="contact_number" id="contact_number" value="${editAllUser.contact_number }" placeholder="Contact Number">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" class="form-control"name="email" id="email" value="${editAllUser.email }" placeholder="email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control"name="address" id="address" value="${editAllUser.address }" placeholder="address">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="password" value="${editAllUser.password }" placeholder="Enter password">
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
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
</style>
</head>
<body>
<h1>User Registration</h1>
<form class="col-md-4 reg_form " action="newRegister" method="post" modelAttribute="user">
 <input type="number" hidden="hidden" class="form-control" name="id" id="id" aria-describedby="emailHelp" >
  <div class="form-group">
    <label for="exampleInputEmail1">User Name</label>
    <input type="text" class="form-control" name="username" id="username" aria-describedby="emailHelp" placeholder="Enter username">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Phone</label>
    <input type="number" class="form-control"name="contact_number" id="contact_number" placeholder="Contact Number">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" class="form-control"name="email" id="email" placeholder="email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control"name="address" id="address" placeholder="address">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
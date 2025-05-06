<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style >
.reg_form{
	position: relative;
	left: 30%;	
}
h1{
text-align: center;
}

footer {
position: relative;

bottom: -400px;

}

.pass{
color: red;
text-decoration: underline;
position: relative;
left:45%;
}
.butt{
position: relative;
left: 35%;
top: 20px;
}

.top{
top: 80px;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h1>Sign In</h1>
<form action="signin" method="post" modelAttribute="signinall" class="col-lg-4 reg_form top ">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 <p style="color: red;"> ${errorsall }</p>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">

  </div>
 
  <button type="submit" class="btn btn-primary butt">Submit</button>
  <a href="getpass" class="pass">Forget Password?</a>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
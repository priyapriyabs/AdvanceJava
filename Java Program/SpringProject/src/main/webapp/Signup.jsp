<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style >
.reg_form{
	position: relative;
	left: 25%;
	
}
body {
	background-color: aqua;
}
h1{
text-align: center;
}

.butt{
position: relative;
left: 40%;
top: 2px;
}
.top{
top: 55px;
}
</style>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h1>Sign Up</h1>
<form action="signup" method="post"  modelAttribute="signupall" class="col-lg-6 reg_form top" >
<span class="text-danger">
<c:forEach items="${errors}" var="objectError">
${objectError.defaultMessage}<br>
</c:forEach>
</span>
<div class="form-group">
    <label for="exampleInputEmail1">User Name</label>
    <input type="text"  class="form-control" value="${dto.username }" name="username" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
    
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" value="${dto.email }" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 <p style="color: red;"> ${emailerrors }</p>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" value="${dto.password }" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
 <div class="form-group">
    <label for="exampleInputPassword1">Mobile</label>
    <input type="number" class="form-control" value="${dto.mobile }" name="mobile" id="exampleInputPassword1" placeholder="Enter phone number">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Address</label>
    <input type="text" value="${dto.address }" class="form-control" name="address" id="exampleInputPassword1" placeholder="address">
  </div>
  <div>
   <input type="hidden" class="form-control" readonly="readonly" name="otp" id="exampleInputPassword1" placeholder="address">
  </div>
  <button type="submit" class="btn btn-primary butt">Submit</button>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.butt{
position: relative;
left: 35%;
top: 20px;
}

.top{
top: 130px;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="changepass" method="post" modelAttribute="updatepass" class="col-lg-4 reg_form top ">
 <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" autocomplete="name"  id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
   

  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">New Password</label>
   
    <input type="password" class="form-control"  name="newpassword" id="exampleInputPassword1" placeholder="Password">

  </div>
 <div class="form-group">
    <label for="exampleInputPassword1">Conform Password</label>
    <input type="password" class="form-control" name="conformpassword"  id="exampleInputPassword1" placeholder="Password">
<h6  style="color: red; font-size: 14px;"> ${reseterror }</h6>
  </div>
 
  <button type="submit" class="btn btn-primary butt">Submit</button>
  </form>
  <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
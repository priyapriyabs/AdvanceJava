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
h3{
text-align: center;
}

.reg_form{
	position: relative;
	left: 30%;	
}

.butt{
position: relative;
left: 35%;
top: 10px;
}

footer {
position: relative;

bottom: -300px;

}

.top{
top: 120px;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<h3>Forget Password? fill this form</h3>
<form action="sendotp" method="post" modelAttribute="sendall" class="col-lg-4 reg_form  top">

  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Enter email">

  </div>
 
   <div>
  
    <input type="number" class="form-control"  name="otp"  id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter otp">
    <p style="color: red; font-size: 13px;"> ${otperror }</p>
     </div>
       <div>
   <button type="submit" class="btn btn-primary butt">Submit</button>
  </div>
 
   </form>
  <jsp:include page="Footer.jsp"></jsp:include> 
</body>
</html>
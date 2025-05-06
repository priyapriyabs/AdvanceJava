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
<style type="text/css">
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
position:relative;
top:-6px;
margin-left: 93%;
 text-decoration: none;
}

.regPage {
position:relative;
top:22px;
    left: 1110px;
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
<a  href="home" class="home" ><button>Home</button></a>
<a  href="reg"  class="regPage" ><button>SignUp</button></a>
<a  href="login" class="icons" ><button>SignIn</button></a>
</nav>
</header>
<table class="table table-dark formData">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Phone</th>
      <th scope="col">Email</th>
       <th scope="col">Address</th>
       <th colspan="2">Action</th>
       
    </tr>
  </thead>
  <c:forEach var="user" items="${users }">
  <tbody>
    <tr>
      <td> ${user.id }</td>
       <td> ${user.username }</td>
       <td> ${user.contact_number }</td>
        <td> ${user.email }</td>
         <td> ${user.address }</td>
         <td><a href="deleteUser?id=${user.id }" style="color: red;">Delete</a></td>
         <td><a href="editUser?id=${user.id }">Edit</a></td>
    </tr> 
  </tbody>
  </c:forEach>
</table>
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
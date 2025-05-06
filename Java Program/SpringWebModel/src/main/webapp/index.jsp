<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N">
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
margin-left: 93%;
 text-decoration: none;
}

.regPage {
position:relative;
top:17px;
    left: 1200px;
    text-decoration: none;
}

footer{
position: fixed;
bottom: 0%;
}
.footcolor{
color: blue;
}

.nameDisp{
position: relative;
left: 40%;
}
 </style>
 </head>
<body>
<header>
<nav class="head">
<h1 >Welcome Spring Web Application</h1>
<a  href="reg"  class="regPage" ><button>SignUp</button></a>
<a  href="login" class="icons" ><button>SignIn</button></a>
</nav>
</header>
<nav  >
 <footer class="text-center text-lg-start bg-body-tertiary text-muted" class="navbar navbar-dark bg-primary"   style="position: fixed; width: 100%;">
      <div class="text-center p-4 nameDisp" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2024 Copyright:
    <a class="text-reset fw-bold footcolor " href="https://mdbootstrap.com/">bspriya9912@gmail.com</a>
  </div>
  <!-- Copyright -->
</footer>

</nav>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
 crossorigin="anonymous">
 <style type="text/css">
 h1{
 text-align: center;
 color: blue;
 }
 
.imgreduce{
display:inline-block;
width: 15%;
} 

.marge{
margin-left: 150px;
margin-top: 100px;
}

.head{
/* border:  2px solid red; */
position:absolute;
background-color: silver;
border-radius: 2px;
width: 100%;
}
a{
margin-left: 45%;
}

.possition{
margin-left:20%;
color: black;

}

.htmlBook{
margin-left: 30%;
margin-top: -20px;
}

.pythonBook{
margin-left: 60%;
margin-top: -20px;
}
 </style>
</head>

<body>
<header>
<nav class="head">
<h1 >Book Details</h1>
<a  href="#" >LogIn</a>
<a  href="logout">LogOut</a>
</nav>
</header>

<img alt="" src="/BookDetails/URLRESOURCE/img/java book.jpg" class="imgreduce marge">
<img alt="" src="/BookDetails/URLRESOURCE/img/html book.jpg" class="imgreduce marge">
<img alt="" src="/BookDetails/URLRESOURCE/img/python.jpg" class="imgreduce marge">
<div>
<a href="javaBookDisplay" class="possition">save</a>
</div>
<div>
<a href="viewBooks" class="possition">Read</a>
</div>
<div class="htmlBook">
<div>
<a href="#" class="possition">Buy</a>
</div>
<div>
<a href="htmlBookDisplay" class="possition">Read</a>
</div>
</div>
<div class="pythonBook">
<div>
<a href="#" class="possition">Buy</a>
</div>
<div>
<a href="pythonBookDisplay" class="possition">Read</a>
</div>
</div>
</body>
</html>
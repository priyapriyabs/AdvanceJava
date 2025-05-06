<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/StudentShop/URLRESOURCE/css/header.css">
</head>
<body>
 <nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="home">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

 <a class="navbar-brand" href="reg">Register</a>
 
  
  <a class="navbar-brand" href="log">Login</a>
 
  <a class="navbar-brand" href="viewstd">Student info</a>
 
    <form class="form-inline my-2 my-lg-0">
      <input id="inp" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" id="butt" type="submit">Search</button>
    </form>
 
</nav>
</body>
</html>

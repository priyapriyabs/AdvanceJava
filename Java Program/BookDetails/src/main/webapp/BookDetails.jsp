<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add book</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
<style type="text/css">
 .reg_form{
	position: relative;
	left: 30%;	
	top: 10px;
}

.buttn{
position: relative;
left: 30%;
}

.head{
/* border:  2px solid red; */
position:absolute;
background-color: silver;
border-radius: 2px;
width: 100%;

}

.possition{
margin-left: 95%;
}
</style>
</head>
<body>
<header>
<nav class="head">
<h1 >Book Details</h1>

<a  href="home" class="possition">Home</a>
</nav>
</header>
<h1>Add Books</h1>
<form action="bookSave" method="post" ModelAttribute="saveBooks" class="col-lg-3 reg_form" >
 <div class="form-group">
 
  
    <input type="number" name="id" hidden="hidden" class="form-control required" id="exampleInputUsername1" aria-describedby="emailHelp" placeholder="Enter username">

  </div>
 <span class="form-group">
    <label for="exampleInputEmail1">Book Name</label>
    <input type="text"  name="name"   class="form-control required" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
   </span>
   <div class="form-group top">
    <label for="exampleInputEmail1">Price</label>
    <input type="number"  name="price"    class="form-control required" id="exampleInputMobile1" aria-describedby="emailHelp" placeholder="Enter email">

  </div>
   <div class="form-group top left">
    <label for="exampleInputEmail1">Contact Number</label>
    <input type="number"  name="contactNumber"   class="form-control required" id="exampleInputAdhar1" aria-describedby="emailHelp" placeholder="Enter email">
   
  </div>
   <div class="form-group top one_val">
    <label for="exampleInputEmail1">Email</label>
    <input type="email"  name="email"   class="form-control required" id="exampleInputDriving1" aria-describedby="emailHelp" placeholder="Enter email">
    <a style="color: red;"> ${error }</a>

  </div>
       <div class="form-group top one_val">
    <label for="exampleInputEmail1">Password</label>
    <input type="password"  name="password"   class="form-control required" id="exampleInputDriving1" aria-describedby="emailHelp" placeholder="Enter email">
    

  </div>
      
<button type="submit"  class="btn btn-primary top buttn">Submit</button>
 


</form>
</body>
</html>
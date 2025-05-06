<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration Form</title>
        <base href="http://localhost:8080/MuncipalityTicketRaise/">
<style>


  .card {
                     max-width: 450px;
                     word-wrap: break-word;
                 }
    </style>
 <!-- <script src="/MuncipalityTicketRaise/js/usersignup.js"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-muted">
<nav class="navbar navbar-expand-lg navbar-light bg-dark py-0 sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://www.x-workz.in/Logo.png" width="70" height="50" alt="Xworkz Logo">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active text-light fs-5" aria-current="page" href="index.jsp">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

        <form action="departmentSignup" method="post" modelAttribute="departmentsData">
   
     <div class="container mt-5 mb-5 d-flex justify-content-center">
           <div class="card px-5 py-4 bg-light shadow p-3 mb-5 bg-white rounded">
               <div class="card-body">
<span   class="text-success fs-4 fw-bold"> ${actCreate }</span>
 <span  class="text-danger"> ${depMessage }</span>


                 <div class="mb-3">
                     <label for="departmentName" class="form-label text-dark">Department Name</label>
                    <select class="form-select" id="departmentName" name="departmentName">
                    <option value="0" }>Choose...</option>
                    <option value="Drainage Department" >Drainage Department</option>
                    <option value="Electric Department">Electric Department</option>
                    <option value="Plumber Department" >Plumber Department</option>
                    <option value="Wastage Department" >Wastage Department</option>
                    <option value="Water Department" >Water Department</option>
                </select>
                     <span id="fnameError" class="text-danger"></span>
                 </div>

    <div class="mb-3">
                           <label for="departmentType" class="form-label text-dark">Deparment Type</label>
                            <select class="form-select" id="departmentType" name="departmentType">
                           <option value="0" }>Choose...</option>
                    <option value="Rural Type" >Rural Type</option>
                    <option value="Urben Type">Urben Type</option>
                    <option value="Local Type" >Local Type</option>
                    </select>
                           <span id="lnameError" class="text-danger"></span>
                       </div>
                    <div class="mb-3" >
                                       <label for="area" class="form-label text-dark" >Area</label>
                                       <select class="form-select" id="area" name="area">
                           <option value="0" }>Choose...</option>
                    <option value="Rajaji Nagara" >Rajaji Nagara</option>
                    <option value="Electronic City">Electronic City</option>
                    <option value="White Field" >White Field</option>
                    </select>
                                   </div>

          <div class=" mt-3">
                <div class="container">
             <div class="d-flex justify-content-between">
                                <input type="submit" value="Register" class="btn btn-primary" >
                                <input class="btn btn-primary" type="reset" value="Reset">
                            </div>
                            
    </div>

</form>
<div class="fixed-bottom">
<footer class="d-flex flex-wrap justify-content-center align-items-center mb-0 py-3 my-4 border-top bg-dark ">
    <div class="d-flex align-items-center">
        <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
            <svg class="bi" width="30" height="24">
                <use xlink:href="#bootstrap"></use>
            </svg>
        </a>
        <span class="text-light">Copyright &#169; 2024, All Right Reserved</span>
    </div>
</footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>

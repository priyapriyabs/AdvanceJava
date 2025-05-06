<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Page</title>
     <base href="http://localhost:8080/MuncipalityTicketRaise/">
<style>
 .card {
                    max-width: 400px;
                    word-wrap: break-word;
                }
</style>
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
                      <a class="nav-link active text-light fs-5 " aria-current="page" href="departmentAdmin/departmentAdminLogout">Logout</a>
                   </li>
                           <li class="nav-item">
                           <a class="nav-link active text-light fs-5 " aria-current="page" href="#"> ${departmentAdmin.name} </a>
           </li>

                       </ul>

        </div>
    </div>
</nav>
 <div class="container mt-5 mb-5 d-flex justify-content-center">
            <div class="card px-5 py-4 bg-light w-100 shadow-lg p-3 mb-1 bg-white rounded" style="max-width: 600px;">
                <div class="mb-1 mt-3">
                    <a class="dropdown-item fs-2" href="departmentAdmin/addEmployee">Add Employees</a>
                </div>
            </div>
        </div>
<div class="container mt-5 mb-5 d-flex justify-content-center">
            <div class="card px-5 py-4 bg-light w-100 shadow-lg p-3 mb-1 bg-white rounded" style="max-width: 600px;">
                <div class="mb-1 mt-3">
                    <a class="dropdown-item fs-2" href="departmentAdmin/departmentAdminViewComplaints">View Complaints</a>
                </div>
            </div>
        </div>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student Info</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../../Header.jsp"></jsp:include>
<h3>Student Information </h3>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">User Name</th>
      <th scope="col">Address</th>
        <th scope="col">City</th>
          <th scope="col">State</th>
            <th scope="col">Zip</th>
             <th scope="col" colspan="2">Action</th>
    </tr>
  </thead>
   <c:forEach var="stdtab" items="${stdobj}">
  <tbody>
 
    <tr>
      <td>${stdtab.email }</td>
     <td>${stdtab.password }</td>
      <td>${stdtab.username }</td>
      <td>${stdtab.address }</td>
      <td>${stdtab.city }</td>
      <td>${stdtab.state }</td>
      <td>${stdtab.zip }</td>
       <td><a href="deletestud?id=${stdtab.email }">Delete</a></td>
        <td><a href="editstud?id=${stdtab.email }">Edit</a></td>
    </tr>
  </tbody>
  </c:forEach>
</table>
</body>
</html>
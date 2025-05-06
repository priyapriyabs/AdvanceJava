<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
 crossorigin="anonymous">
</head>
<body>
<h1>Java Book Details</h1>
<table class="table">
  <thead>
   <tr>
   
    <th>BOOK NAME</th>
     <th>PRICE</th>
      <th>CONTACT</th>
      <th>EMAIL</th>
      <th colspan="2">ACTION</th>
   </tr>
  </thead>
  <c:forEach var="java" items="${allbooks }">
  <tbody>
    <tr class="table-active">
   
   <td> ${java.name}</td>
   <td>${java.price }</td>
   <td> ${java.contactNumber }</td>
   <td> ${java.email }</td>
   <td><a href="deleteadmin?contactNumber=${java.contactNumber}" style="color: black;">Delete</a></td>
<td><a href="editadmin?contactNumber=${java.contactNumber}" style="color: white;">Edit</a></td>
    </tr>
  </tbody>
  </c:forEach>
</table>

</body>
</html>
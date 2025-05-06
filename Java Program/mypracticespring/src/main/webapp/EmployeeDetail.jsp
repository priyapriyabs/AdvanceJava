<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Employee Table</h1>
 
<table border="1"  >
<tr>
<th>Emp_id</th>
<th>Emp_name</th>
<th>Password</th>
<th>Email</th>
<th>Phone</th>
<th>City</th>
<th>Action</th>
</tr>
<c:forEach var="empl" items="${emplobj}">
<tr>
<td>${empl.emp_id }</td>
<td>${empl.emp_name }</td>
<td>${empl.password }</td>
<td>${empl.email }</td>
<td>${empl.phone }</td>
<td>${emptable.city }</td>
<td><a href="deleteemp?id=${empl.emp_id}">Delete</a></td>
</tr>
</c:forEach>


</table>


</body>
</html>
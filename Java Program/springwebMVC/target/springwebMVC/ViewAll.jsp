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
<h1>Student list: </h1>
<table border="2">
<tr>
<th>Name</th>
<th>Password</th>
<th>Mobile</th>
<th>Email</th>
<th>Company</th>
<th>Action</th>
</tr>
<c:forEach var="user" items="${userobj}">
<tr>
<td> ${user.userName}</td>
<td> ${user.password}</td>
<td> ${user.mobile}</td>
<td> ${user.email}</td>
<td> ${user.cname}</td>
<td><a href="deleteuser?id=${user.mobile}">Delete</a></td>
<td><a href="edituser?mobile=${user.mobile}">Edit</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>
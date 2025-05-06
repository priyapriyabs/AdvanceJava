<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MyShoppingJpaMySql/URLToResource/css/mystyle.css/">
</head>
<body>
<jsp:include page="../../Header.jsp"></jsp:include>
<h1>View all User </h1>
<table border="2" class="navbar navbar-dark bg-dark" style="width: 40%">
<tr style="color: red;" >
<th>ID</th>
<th>Name</th>
<!-- <th>Password</th> -->
<th>Phone</th>
<th>Email</th>

<th colspan="2">Action</th>
</tr>
<c:forEach var="user" items="${userobj}" >
<tr style="color: white;" >
<td> ${user.id}</td>
<td> ${user.name}</td>
<%-- <td> ${user.password}</td> --%>
<td> ${user.phoneno}</td>
<td> ${user.email}</td>
<td><a href="deleteuser?id=${user.id}">Delete</a></td>
<td><a href="edituser?id=${user.id}">Edit</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>
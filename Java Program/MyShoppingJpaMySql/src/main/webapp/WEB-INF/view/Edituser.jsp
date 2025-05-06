<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../../Header.jsp"></jsp:include>
<h1>Update User</h1>
<form action="Update" method="post" modelAttribute="user">
<div>
<label>ID</label>
<input type="text" name="id" value="${editUser.id}">
</div>
<div>
<label>Username</label>
<input type="text" name="name" value="${editUser.name}">
</div>
<div>
<label>Password</label>
<input type="text" name="password"  value="${editUser.password }">
</div>
<div>
<label>Phone</label>
<input type="text" readonly="readonly" name="phoneno"  value="${editUser.phoneno }">
</div>
<div>
<label>Email</label>
<input type="text" name="email"  value="${editUser.email }">
</div>

<div><input type="submit" value="Update"></div>
</form>
</body>
</html>
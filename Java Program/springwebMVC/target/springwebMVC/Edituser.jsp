<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit</h1>
<form action="Update" method="post" modelAttribute="user">
<div>
<label>Username</label>
<input type="text" name="userName" value="${editUser.userName }">
</div>
<div>
<label>Password</label>
<input type="text" name="password"  value="${editUser.password }">
</div>
<div>
<label>Mobile</label>
<input type="text" name="mobile"  value="${editUser.mobile }">
</div>
<div>
<label>Email</label>
<input type="text" name="email"  value="${editUser.email }">
</div>
<input type="hidden" value="${editUser.cname }" name="cname">
<div><input type="submit" value="Update"></div>
</form>
</body>
</html>
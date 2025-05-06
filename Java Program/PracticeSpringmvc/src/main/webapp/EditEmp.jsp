<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Update User</h1>

<form action="udtate" method="post" modelAttribute="empl">
<div>
<label>ID</label>
<input type="text" placeholder="Enter your email" name="emp_id" value="${empledit.emp_id}">
</div>
<div>
<label>User Name</label>
<input type="text" placeholder="Enter your email" name="emp_name" value="${empledit.emp_name}">
</div>
<div>
<label>Password</label>
<input type="password" placeholder="Enter your password" name="password" value="${empledit.password}">
</div>
<label>Email</label>
<input type="email" placeholder="Enter your password" name="email" value="${empledit.email}">
</div>
<div>
<label>Phone</label>
<input type="number" placeholder="Enter your password" name="phone" value="${empledit.phone}">
</div>
<input type="text" name="city" value="${empledit.city}" >
<input type="submit" value="Update">
</form>

</body>
</html>
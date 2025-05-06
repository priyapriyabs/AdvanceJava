<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Register Page</h1>
<a href="viewall">View emp</a>
<form action="newreg" method="post" modelAttribute="empl">
<div>
<label>ID</label>
<input type="text" placeholder="Enter your email" name="emp_id">
</div>
<div>
<label>User Name</label>
<input type="text" placeholder="Enter your email" name="emp_name">
</div>
<div>
<label>Password</label>
<input type="password" placeholder="Enter your password" name="password">
</div>
<label>Email</label>
<input type="email" placeholder="Enter your password" name="email">
</div>
<div>
<label>Phone</label>
<input type="number" placeholder="Enter your password" name="phone">
</div>

<input type="submit" value="Register">
</form>

</body>
</html>
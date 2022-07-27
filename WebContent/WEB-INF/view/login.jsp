<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login Form</h1>
	<form action="/SampleORM_IT17102/login" method="POST">
		<p>Username: <input name="username"/></p>
		<p>Password: <input name="password"/></p>
		<input type="submit" value="Sign In"/>
	</form>
	<i style="color:red">${sessionScope.error}</i>
</body>
</html>
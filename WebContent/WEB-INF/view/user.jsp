<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
</head>
<body>
	<h4>Hello, ${sessionScope.username}</h4>
	<h1>Danh sách sản phẩm</h1>
	<c:forEach items="${products}" var="product">
		<p> ${product.name} - ${product.price} VND </p>
	</c:forEach>
</body>
</html>
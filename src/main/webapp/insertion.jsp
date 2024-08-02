<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body>
	<form action="insertion" method="post" >
	<input type="text" placeholder="Enter name" name="name" class="form-control" name="name">
	<input type="email" placeholder="Enter email" name="email" class="form-control" name="email">
	<input type="text" placeholder="Enter branch" name="branch" class="form-control" name="branch">
	<input type="number" placeholder="Enter phonenum" name="phonenum" class="form-control" name="phonenum">
	<button class="btn btn-primary">Register</button>
	</form>
</body>
</html>
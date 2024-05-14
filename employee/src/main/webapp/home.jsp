<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Back to registration page</title>
<style>
body {
	background-image: url('img/registration.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
h1 {
	margin: 0px auto;
	margin-top: 50px;
	margin-bottom: 20PX;
	color: black;
	background-color: white;
	max-width: 500px;
	padding: 20px;
	border-radius: 10px;
	border-color: gray;
	box-shadow: 0 0 10px rgb(0, 0, 0);
}
button {
	background-color: rgb(240, 230, 249);
	max-width: 300px;
	padding: 20px;
	font-size: 20px;
	margin-top: 50px;
	margin-bottom: 20PX;
	border-radius: 8px;
	box-shadow: 0 0 10px rgb(0, 0, 0);
	margin-left: 800px;
	cursor: pointer;
}
</style>
</head>
<body>
	<form action="registration.jsp">
		<%	
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		out.println("<h1 align = 'center'>" + firstname + " " + lastname + ", your registration has been sucessfully..</h1>");	
		%>
		<button onclick="document.location='registration.jsp'"	class="btn-back">Back to registration page</button>
	</form>
</body>
</html>
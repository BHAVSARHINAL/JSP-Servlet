<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Employee Form</title>
<link rel="stylesheet" href="style.css">
<style>
body {
	background-image: url('img/registration.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
.control, fieldset {
	margin: 6px 0;
}
.required {
	color: red;
}
.error {
	color: red;
}
.reset {
	background-color: rgb(0, 0, 0);
	color: rgb(255, 255, 255);
	border: none;
	border-radius: 5px;
	border-color: black;
	padding: 10px 20px;
	cursor: pointer;
	font-size: 16px;
}
</style>
</head>
<body>
	<h1 align="center">REGISTRATION FORM</h1>
	<form name="registrationForm" action="<%=request.getContextPath()%>/register" method="post">
		<table>
			<tr>
				<td>
					<span class="required">*</span>First Name<br>
					<input	type="text" name="firstname" placeholder="Enter your first name" value="${param.firstname}"> 
					<span class="error">${errors.firstname}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="required">*</span>Last Name<br> 
					<input type="text" name="lastname" placeholder="Enter your last name"value="${param.lastname}"> 
					<span class="error">${errors.lastname}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="required">*</span>User Name<br> 
					<input type="text" name="username" placeholder="Enter your username" value="${param.username}"> 
					<span class="error">${errors.username}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="required">*</span>Password<br> 
					<input type="password" name="password" id="myInput" placeholder="Enter your password" value="${param.password}">
					<input type="checkbox" onclick="myFunction()">Show Password<br>
					<span class="error">${errors.password}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="required">*</span>Address <br> 
					<input	type="text" name="address" placeholder="Enter your address"	id="address" value="${param.address}">
					<span class="error">${errors.address}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="required">*</span>Contact No <br>
					<input type="text" name="contact" placeholder="Enter your contact number" maxlength="10" value="${param.contact}"> 
					<span class="error">${errors.contact}</span>
				</td>
			</tr>
			<tr>
				<td>
					<input style="margin-left: 100px; margin-top: 10px"  type="submit" value="Save" name="submit"> 
					<a href="registration.jsp" class="reset">Reset</a>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>
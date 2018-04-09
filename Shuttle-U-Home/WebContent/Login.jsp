<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<script type="text/javascript" src="js/FormValidation.js"></script>
</head>
<body class="body">
<form name='login' method="post" action="StudentController">
<div class="division" align="center">
<fieldset class="fieldset">
<legend align="top"> <font color="blue">Login</font></legend>
<table align="center">
<tr>
<td class="fonts">Identity:</td>
<td><input type="radio" value="Student" id="Student" name="identity" class="text">Student
<input type="radio" value="Employee" id="Employee" name="identity" class="text">Employee</td></tr>
<tr>
<tr>
<td class="fonts">Email Id:</td>
<td class="fonts"><input type="text" name="seid" id="seid" class="text"></input></td></tr>
<tr>
<tr>
<td class="fonts">Password:</td>
<td class="fonts"><input type="password" name="spwd" id="spwd" class="text"></input></td></tr>
<tr>
<tr>
<td><input type="hidden" value="login" name="action"></td>
<td><input type="Submit" value="Submit" onclick="return Validate()"></input></td>
<td><input type="reset" value="Reset"/></td>
<td><a href="Registration.jsp">Register</a>
</tr>
</table>
</fieldset>
</div>
</form>
</body>
</html>
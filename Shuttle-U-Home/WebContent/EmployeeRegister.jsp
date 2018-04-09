<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Register</title>
</head>
<body class="body">
<form name='Empregistration' method="post" action="StudentController">
<div class="division" align="center">
<fieldset class="fieldset">
<legend align="top"> <font color="blue">Register Employee</font></legend>

<table align="center">
<tr>
<td class="fonts">Name:</td>
<td class="fonts"><input type="text" name="empName" id="empName" class="text"></input></td></tr>
<tr>
<td class="fonts">Email id:</td>
<td><input type="text" name="eid" id="eid" class="text"></input></td></tr>
<tr>
<td class="fonts">Password:</td>
<td><input type="password" name="pwd" id="pwd" class="text"></input></td></tr>
<tr>
<td class="fonts">Confirm Password:</td>
<td><input type="password" name="cpwd" id="cpwd" class="text"></input></td></tr>
<tr>
<td class="fonts">Phone No.:</td>
<td><input type="text" name="phone" id="phone" class="text"></input></td></tr>
<tr>
<td>&nbsp;<input type="hidden" value="addEmployee" name="action"></td>
<td><input type="Submit" value="Submit"></input></td>
<td><input type="reset" value="Reset"/></td>
</tr>
</table>

</fieldset>
</div>
</form>
</body>
</html>
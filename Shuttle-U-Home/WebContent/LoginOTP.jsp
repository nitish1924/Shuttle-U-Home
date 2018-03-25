<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTP</title>
</head>
<body class="body">
<form name='otp' method="post" action="StudentController">
<div class="division" align="center">
<fieldset class="fieldset">
<legend align="top"> <font color="blue">Login OTP</font></legend>

<table align="center">
<tr>
<td class="fonts">OTP:</td>
<td class="fonts"><input type="text" name="otp" id="otp" class="text"></input></td></tr>
<tr>
<tr>
<td>&nbsp;<input type="hidden" value="loginotp" name="action"></td>
<td><input type="Submit" value="Submit"></input></td>
<td><input type="reset" value="Reset"/></td>

</tr>
</table>
</fieldset>
</div>
</form>
</body>
</html>
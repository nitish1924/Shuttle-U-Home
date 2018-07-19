<!--/////////////////////////////////////////////////////////////////////////////
//  forgotpwd.jsp-Retrieve password for student                                //
//  version 2.0  (Date - 03/20/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                             //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   Retrieve password when student forgets his password
 *   
 */-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/FormValidation.js"></script>
</head>
<body class="body">
<div id="topBanner" class="regbanner">
			<h1 align="center" style="color: white">Syracuse University</h1>
			<h2 align="center" style="color: white">Shuttle-U-Home Online</h2>
			<h4 align="right" style="color: white; padding-right: 20px">
				Welcome
			</h4>
		</div>
<form name='forgotpwd' method="post" action="StudentController">
<div class="division" align="center">
<br>
<br>
<table align="center" class="forgotpwd">
<caption class="tabletitle">Retrieve Password</caption>
<tr>
<td class="fonts">Email id:</td>
<td><input type="text" name="eid" id="eid" class="text"></input></td></tr>
<tr>
<td><input class="form-button" type="Submit" value="Submit" onclick="return emailValidate()"/></td>
<td><a href="Login.jsp">Login</a>&nbsp;&nbsp;&nbsp;<a href="Registration.jsp">Register</a></td></tr>
<tr><td><input type="hidden" value="forgotpwd" name="action"></td></tr>
</table>
</div>
</form>
</body>
</html>
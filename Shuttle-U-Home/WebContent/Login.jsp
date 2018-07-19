<!--/////////////////////////////////////////////////////////////////////////////
// 	Login.jsp - Login form for student/admin and driver                        //
//  version 2.0  (Date - 03/20/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Shweta shukla, Syracuse University                            //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   Login Form for student/admin and driver 
 *   
 */-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/FormValidation.js"></script>
</head>
<body class="body">
<div id="topBanner" class="container-full">
        <img id="logo-main" class="img-responsive" src="images/logo.png" height="90" alt="Syracuse University">
            <h1 align="center" style="color: white">Welcome to Shuttle-U-Home Online</h1>   
</div>
<form name='login' method="post" action="StudentController">
<div class="division" align="center">
<table align="center" class="register">
<br>
<br>
<caption class="tabletitle">LOGIN/SIGNUP</caption>
<tr>
<td class="fonts" style="font-weight:600">Identity:</td></tr>
<tr><td><input type="radio" value="Student" id="Student" name="identity" class="text" onclick="displayLink()">Student
<input type="radio" value="Employee" id="Employee" name="identity" class="text" onclick="displayLink()">Employee</td></tr>
<tr>
<tr>
<td class="fonts" style="font-weight:600">Email Id:</td></tr>
<tr>
<td class="fonts"><input type="text" name="seid" id="seid" class="element"></input></td></tr>
<tr>
<tr>
<td class="fonts" style="font-weight: 600">Password:</td></tr>
<tr>
<td class="fonts"><input type="password" name="spwd" id="spwd" class="element"></input></td></tr>
<tr>
<tr>
<td><input type="hidden" value="login" name="action"></td></tr>
<tr>
<td><input class="form-button" type="Submit" value="Submit" onclick="return Validate()"/>
<input class="form-button" type="reset" value="Reset"/>
<a href="Registration.jsp" id="reg" style="display:none">Register</a>
<a href="forgotpwd.jsp">Forgot Password?</a>
</tr>
</table>
</div>
</form>
</body>
</html>
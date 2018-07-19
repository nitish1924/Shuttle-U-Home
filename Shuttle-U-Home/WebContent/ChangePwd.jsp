<!--/////////////////////////////////////////////////////////////////////////////
//  ChangePwd.jsp- Layout of Chnage password page for student                  //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Shweta Shukla, Syracuse University                            //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This JSP Layout of Change password page for student
 *   
 */-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/FormValidation.js"></script>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Change Password</title>
</head>
<body>
<form name='changepwd' method="post" action="StudentController" style="padding-top: 50px">
<%
			session.removeAttribute("b");
			String sname = (String) session.getAttribute("name");
			if (null == sname) { // checking if session is false currently
				request.setAttribute("Error", "Session has ended.  Please login.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// if session is false redirect to login page
				rd.forward(request, response);
			}
		%>
<div class="division" align="center">
<table class="register">
<caption class="tabletitle">Change Password</caption>
<tr>
<td class="label">Password:</td>
<td><input type="password" name="pwd" id="pwd" class="text" required></input></td></tr>
<tr>
<td class="label">Confirm Password:</td>
<td><input type="password" name="cpwd" id="cpwd" class="text" required></input></td></tr>
<tr>
<td>&nbsp;<input type="hidden" value="changepwd" name="action"></td>
<td><input class="form-button" type="Submit" value="Submit" onclick="return pwdValidations()"></input>
<input class="form-button" type="reset" value="Reset"/></td>
</tr>
</table>
</div>
</form>
</body>
</html>
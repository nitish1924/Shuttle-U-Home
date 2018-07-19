<!--/////////////////////////////////////////////////////////////////////////////
// Logout.jsp-Logout page for admin/student/driver                             //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Shweta Shukla, Syracuse University                            //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   To logout from admin, student or driver module
 *   This page will make all the session assigned as null to maintain the state of a user
 *   
 */-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogOut</title>
</head>
<body class='body' bgcolor="#ffb997">
<div class="division" align="center">
<img id="logo-main" class="img-responsive" src="images/logo.png" height="150" alt="Syracuse University"><br><br>
<fieldset class="fieldset">
<%session.invalidate(); // to make all session variables as null%>
<h1 align="center">You are successfully logged out.</h1>
</fieldset>
<h2> Please click here to log in again</h2><a href="Login.jsp" style="font-size: 24px">Login</a>
</div>
</body>
</html>
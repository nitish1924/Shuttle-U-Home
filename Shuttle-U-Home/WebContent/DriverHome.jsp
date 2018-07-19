<!--/////////////////////////////////////////////////////////////////////////////
//  DriverHome.jsp- Layout of Driver Home page for Drivers                     //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                             //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This JSP Layout of Driver Home page for Drivers 
 *   
 */-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form name='driver' method="post" action="StudentController"
		>
		<%
			session.removeAttribute("b");
			String sname = (String) session.getAttribute("name");
			if (null == sname) { // checking if session is null
				request.setAttribute("Error", "Session has ended.  Please login.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); // if session is null redirect to login page
				rd.forward(request, response);
			}
		%>
		<div id="topBanner" class="regbanner">
			<h1 align="center" style="color: white">Syracuse University</h1>
			<h2 align="center" style="color: white">Shuttle-U-Home Online</h2>
			<h4 style="color: white; padding-left: 20px">
				Welcome
				<%
				out.print(sname.toUpperCase() + "! ");
			%><a href="Logout.jsp" style="float:right;padding-right:5px;color:white;text-decoration:none">Log Out</a></h4>

			
			
		</div>
		<br> 
		<div align="center">
		<h4>Click to start your trip</h4>
		<input type="Submit" value="Start Trip" >
		<input type="hidden" name="action" value="createlist"></div>
	


	</form>
</body>
</html>
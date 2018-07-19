<!--/////////////////////////////////////////////////////////////////////////////
//  AdminHome.jsp- Layout of admin home page display                           //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Shweta Shukla, Syracuse University                            //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This JSP file has Layout of admin home page display
 *   
 */-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String sname = (String) session.getAttribute("name");  
			if (null == sname) {                                 // checking if session is false currently
				request.setAttribute("Error", "Session has ended.  Please login.");// if session is false redirect to login page
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); 
				rd.forward(request, response);
			}%>
			<div id="topBanner" class="regbanner">
			<h1 align="center" style="color: white">Syracuse University</h1>
			<h2 align="center" style="color: white">Shuttle-U-Home Online</h2>
			<a href="Logout.jsp" style="float: right;padding-right: 5px;color: white;
			text-decoration: none">Log Out</a>	
		</div><br>
<form name='viewBookings' method="post" action="StudentController" target="adm_frame">
<div align="center">
<a href="EmployeeRegister.jsp" class="adm" target="adm_frame">Register Driver</a>
<input type="Submit" value="View Bookings" class="adm">
<input type="hidden" value="adminview" name="action">
</div>
<div align="center">
<iframe frameborder="0" height="500px" width="80%" name="adm_frame"></iframe>
</div>

</form>
</body>
</html>
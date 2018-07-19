<!--/////////////////////////////////////////////////////////////////////////////
//  AdminHome.jsp- Layout of admin booking view page display                   //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                            //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This JSP file has Layout of admin booking view page display 
 *   All the current booking for shuttle can be viewed here in admin page
 *   
 */-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All bookings </title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Booking> allbookings = new ArrayList<Booking>();
allbookings =(ArrayList<Booking>) request.getAttribute("newbook");

%>
<%String sname = (String) session.getAttribute("name");  
			if (null == sname) { // checking if session is false currently
				request.setAttribute("Error", "Session has ended.  Please login.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); // if session is false redirect to login page
				rd.forward(request, response);
			}%>
<div class="division" align="center">
<table class="register">
<caption class="tabletitle">Today's Booking details</caption>
<tr class="tabletitle">
<td class='fonts'>Name</td>
<td class='fonts'> Address</td>
<td class='fonts'> emailId</td>
<td class='fonts'>Status</td>
<td class='fonts'> Date</td>
<td class='fonts'> Driver</td>

</tr>

		        <% for(Booking bo:allbookings){ // booking details are fetched from booking array list and disaplyed here%>
<tr class="tablebook">
<td class='fonts'><%=bo.getName() %></td>
<td class='fonts'><%=bo.getAddress() %></td>
<td class='fonts'><%=bo.getEmail() %></td>
<td class='fonts'><%=bo.getStatus()%></td>
<td class='fonts'><%=bo.getDate() %></td>
<td class='fonts'><%=bo.getDriver() %></td>

</tr>	
<%} %>
	        	
		        
	        
		        
</table>

</div>
</body>
</html>
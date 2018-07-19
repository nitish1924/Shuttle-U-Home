<!--/////////////////////////////////////////////////////////////////////////////
//  Viewbooklist.jsp-student booking details are displyed                      //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                             //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   student booking details are displayed 
 *   
 */-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>View bookings</title>
</head>
<body>
<body class="body">
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>
<form name='viewbooklist' method="post" action="StudentController">
<%
String sname = (String) session.getAttribute("name");
if (null == sname) { // check if session is null
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); // if session is null redirect to login page
   rd.forward(request, response);
}
%>

<div class="division" align="center">
<table class="register">
<caption caption class="tabletitle">Last five booking details</caption>
<tr class="tabletitle">
<th class='fonts'>Date</th>
<th class='fonts'>Drop Address</th>
<th class='fonts'>Status</th>
<th class='fonts'>Modify</th>
</tr>
<%ArrayList<Booking> b=new ArrayList<Booking>();%>
<%b=(ArrayList<Booking>) request.getAttribute("bl");%>
		        <% for(Booking bo:b){//fetch last five booking details%>
<tr class="tablebook">
<td class='fonts'><%=bo.getDate() %></td>
<td class='fonts'><%=bo.getAddress() %></td>
<td class='fonts'><%=bo.getStatus()%></td>
<%if(bo.getStatus().equals("booked")){ %>
<td class='fonts'><input class="form-button" type="Submit" value="Cancel Booking"></td>
<%}
else{%>
	<td class='fonts' align="center">N/A</td>
<% }


%>
</tr>		        	
		        <%} %>
	        
		        
</table>
<input type="hidden" name="action" value="cancel">
</div>
</form>
</body>
</body>
</html>
<!--/////////////////////////////////////////////////////////////////////////////
//  DriverTripList.jsp-Driver trip list(with drop addresses are displayed here)//
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                             //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   Driver trip list (with drop addresses are displayed here)
 *   
 */-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip List</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body class="body">
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>

<form name='triplist' method="post" action="Road.jsp">
<%
String sname = (String) session.getAttribute("name");
if (null == sname) { // check if session is null
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); // if session is null login is page is loaded
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

<%ArrayList<Booking> b=new ArrayList<Booking>();// trip list with drop addresses are fetched and displayed here%> 
<%b=(ArrayList<Booking>) session.getAttribute("b");%>
		        <% 
		        if(b.isEmpty()){%>
		        <h2 align="center"> No Bookings Available at the moment.</h2>
		        	
		       <%}
		        else
		        	{%>
		        	<div class="division" align="center">

<table class="register">
<caption class="tabletitle">TRIP LIST</caption>
<tr class="tabletitle">
<td class='fonts'>Booking id</td>
<td class='fonts'>Email id</td>
<td class='fonts'>Drop Address</td>
</tr>
<%for(Booking bo:b){%>
<tr class="tablebook">
<td class='fonts'><%=bo.getName() %></td>
<td class='fonts'><%=bo.getEmail() %></td>
<td class='fonts'><%=bo.getAddress()%></td>
</tr>	

	        	
		        <%}%>
		        <tr>
<td><input class="form-button" type="Submit" value="start map"></input></td>
</tr>		        
		        
</table>


</div><%} %>
		        
</form>
</body>
</html>
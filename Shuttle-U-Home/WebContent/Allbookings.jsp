<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All bookings </title>
</head>
<body>
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Booking> allbookings = new ArrayList<Booking>();
allbookings =(ArrayList<Booking>) request.getAttribute("newbook");

%>
<div class="division" align="center">
<fieldset class="fieldset">
<table border="1">
<tr>
<td class='fonts'>Name/td>
<td class='fonts'> Address</td>
<td class='fonts'> emailId</td>
<td class='fonts'>Status</td>
<td class='fonts'> Date</td>
<td class='fonts'> Driver</td>

</tr>

		        <% for(Booking bo:allbookings){%>
<tr>
<td class='fonts'><%=bo.getName() %></td>
<td class='fonts'><%=bo.getAddress() %></td>
<td class='fonts'><%=bo.getEmail() %></td>
<td class='fonts'><%=bo.getStatus()%></td>
<td class='fonts'><%=bo.getDate() %></td>
<td class='fonts'><%=bo.getDriver() %></td>

</tr>	
<%} %>
	        	
		        
	        
		        
</table>
</fieldset>
</div>
</body>
</html>
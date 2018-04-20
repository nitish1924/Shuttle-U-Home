<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip List</title>
</head>
<body class="body">
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>
<form name='triplist' method="post" action="Road.jsp">
<%
String sname = (String) session.getAttribute("name");
if (null == sname) {
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
   rd.forward(request, response);
}
%>

<%ArrayList<Booking> b=new ArrayList<Booking>();%>
<%b=(ArrayList<Booking>) session.getAttribute("b");%>
		        <% 
		        if(b.isEmpty()){%>
		        <h2 align="center"> No Bookings Available at the moment.</h2>
		        	
		       <%}
		        else
		        	{for(Booking bo:b){%>
		        	<div class="division" align="center">

<table>
<tr>
<td class='fonts'>Booking id</td>
<td class='fonts'>Email id</td>
<td class='fonts'>Drop Address</td>
</tr>
<tr>
<td class='fonts'><%=bo.getName() %></td>
<td class='fonts'><%=bo.getEmail() %></td>
<td class='fonts'><%=bo.getAddress()%></td>
</tr>	

	        	
		        <%}%>
		        <tr>
<td><input type="Submit" value="start map"></input></td>
</tr>		        
		        
</table>


</div><%} %>
		        
</form>
</body>
</html>
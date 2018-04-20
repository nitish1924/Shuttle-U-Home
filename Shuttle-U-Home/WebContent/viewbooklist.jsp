<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body class="body">
<%@ page import="bean.Booking" %>
<%@ page import="java.util.ArrayList"%>
<form name='viewbooklist' method="post" action="StudentController">
<%
String sname = (String) session.getAttribute("name");
if (null == sname) {
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
   rd.forward(request, response);
}
%>

<div class="division" align="center">
<fieldset class="fieldset">
<table border="1">
<tr>Last five booking details</tr>
<tr>
<td class='fonts'>Date</td>
<td class='fonts'>Drop Address</td>
<td class='fonts'>Status</td>
</tr>
<%ArrayList<Booking> b=new ArrayList<Booking>();%>
<%b=(ArrayList<Booking>) request.getAttribute("bl");%>
		        <% for(Booking bo:b){%>
<tr>
<td class='fonts'><%=bo.getDate() %></td>
<td class='fonts'><%=bo.getAddress() %></td>
<td class='fonts'><%=bo.getStatus()%></td>
<%if(bo.getStatus().equals("booked")){ %>
<td class='fonts'><input type="Submit" value="Cancel Booking"></td>
<%} %>
</tr>		        	
		        <%} %>
	        
		        
</table>
</fieldset>
<input type="hidden" name="action" value="cancel">
</div>
</form>
</body>
</body>
</html>
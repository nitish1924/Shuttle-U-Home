<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<form name='view booking' method="post" action="StudentController">
<%
String sname = (String) session.getAttribute("name");
if (null == sname) {
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
   rd.forward(request, response);
}
%>
Welcome!Login successful! <%out.print(sname); %>
<a href="Homepage.jsp">Home</a>
<a href="Book.jsp">Book Shuttle</a> 
<a href="Logout.jsp">Log Out</a>
<input type="Submit" value="View Bookings">
<input type="hidden" value="viewbooking" name="action">
</body>
</html>
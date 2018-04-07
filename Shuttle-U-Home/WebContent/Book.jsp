<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Room</title>
</head>
<body>
<%
java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
String sysdate= df.format(new java.util.Date());


String sname = (String) session.getAttribute("name");
if (null == sname) {
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
   rd.forward(request, response);
   }
%>
<form name="book" action="StudentController" method=post>
<div class="division" align="center">
<fieldset class="fieldset">
<legend align="top" size="20"> <font color="blue">Book Shuttle</font></legend>
	<table align="center">
	<tr><td class="fonts">Name</td>
	<td><input type='text' name='name' id='name' value="<%= session.getAttribute("name")%>" readonly></td>
	</tr>
	<tr><td class="fonts">Email</td>
	<td><input type='text' name='email' id='email' value="<%= session.getAttribute("email")%>" readonly></td>
	</tr>
	<tr><td class="fonts">Date</td>
	<td><input type='text' name='date' id='date' value="<%= sysdate%>" readonly></td>
	</tr>
	<tr><td class="fonts">Drop Address</td>
	<td><input type='text' name='address' id='address' value="<%= session.getAttribute("address")%>" ></td>
	</tr>
	<tr>
	<td><input type="Submit" value="Continue" ></td>
	<td><input type="hidden" name="action" value="book"></td>
	</tr>
	</table>
	</fieldset>
</div>
</form>

</body>
</html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Room</title>
<script type="text/javascript" src="js/FormValidation.js"></script>
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


int time=Integer.parseInt((String)session.getAttribute("waitTime"));
String Timestamp=(String)session.getAttribute("timestamp");
long diff;
java.text.DateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
String sysdate1= df1.format(new java.util.Date());
Date d1=df1.parse(sysdate1);
Date d2=df1.parse(Timestamp);
diff=Math.abs(d1.getTime()-d2.getTime());
if(diff<0){
	diff=0;
}
int minute=(int)(diff/60000);
%>
<form name="book" action="StudentController" method=post>
<a href="Homepage.jsp">Home</a>
<a href="Book.jsp">Book Shuttle</a> 
<a href="Logout.jsp">Log Out</a>
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
	<tr><td class="fonts">Date</td>
	<td><input type='text' name='time' id='time' value="<%= minute%>" readonly></td>
	</tr>
	<tr><td class="fonts">Drop Address</td>
	<td><input type='text' name='address' id='address' value="<%= session.getAttribute("address")%>" ></td>
	</tr>
	<tr>
	<td><input type="Submit" value="Continue" onclick="return bookValidate()"></td>
	<td><input type="hidden" name="action" value="book"></td>
	</tr>
	</table>
	</fieldset>
</div>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
<form name='driver' method="post" action="StudentController">
<%
session.removeAttribute("b");
String sname = (String) session.getAttribute("name");
if (null == sname) {
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
   rd.forward(request, response);
}
%>
Welcome!Login successful! <%out.print(sname);%>
<a href="DriverHome.jsp">Home</a>
<a href="Logout.jsp">Log Out</a>
<input type="Submit" value="Start Trip" >
<input type="hidden" name="action" value="createlist"></div>

</form>
</body>
</html>
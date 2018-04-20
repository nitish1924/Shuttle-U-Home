<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<form name='driver' method="post" action="StudentController"
		target="iframe_a">
		<%
			session.removeAttribute("b");
			String sname = (String) session.getAttribute("name");
			if (null == sname) {
				request.setAttribute("Error", "Session has ended.  Please login.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
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
			%><a href="Logout.jsp">Log Out</a></h4>

			
			
		</div>
		<br> 
		<div align="center">
		<h4>Click to start your trip</h4>
		<input type="Submit" value="Start Trip" onclick="onStartClick()">
		<input type="hidden" name="action" value="createlist"></div>
		<div style="padding-top: 10px">
			<iframe height="400px" width="90%" name="iframe_a" frameborder="0">
			</iframe>
		</div>


	</form>
</body>
</html>
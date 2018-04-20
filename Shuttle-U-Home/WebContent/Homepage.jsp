<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script>
		$(document).ready(function() {
			$(".btn").click(function(){
				$("#bot").show();
				$("#button1").hide();
			});
		});
	</script>
</head>
<body>

	<form name='view booking' method="post" action="StudentController" target="iframe_a">
		<%
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
			<h4 align="right" style="color: white; padding-right: 20px">
				Welcome
				<%
				out.print(sname.toUpperCase() + "!");
			%>
			</h4>
		</div>
		<br>
		<div class="navbar">
			<a href="HomeContent.jsp" target="iframe_a">Home</a> <a
				href="Book.jsp" target="iframe_a">Book Shuttle</a> <input
				class="navbar" type="Submit" value="View Bookings" > <input
				type="hidden" value="viewbooking" name="action">
				<div align="right">
					<a href="Logout.jsp">Log Out</a></div>
		</div>
		<div style="padding-top: 10px">
			<iframe height="300px" src="HomeContent.jsp" width="100%"
				name="iframe_a" frameborder="0"></iframe>
		</div>
		</form>
		<div id = "myButton">
		<button class = "btn" id = "button1"> Chat with us! </button>
	</div>

	<iframe id = "bot" align = "bottom" frameborder="10px" scrolling = "yes" 
	    width="350"
	    height="500"
	    src="https://console.dialogflow.com/api-client/demo/embedded/5f3e8ba4-3fe2-4d42-abca-d376d45113c1">
	</iframe>

	
</body>
</html>
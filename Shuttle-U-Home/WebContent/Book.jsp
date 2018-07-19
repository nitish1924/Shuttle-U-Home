<!--/////////////////////////////////////////////////////////////////////////////
//  Book.jsp- Layout of shuttle booking page display                           //
//  version 2.0  (Date - 03/26/2018)                                           //
//  Language:    HTML5,Java                                                    //
//  Platform:    Windows 10 Pro                                                //
//  Application: Shuttle U Home CSE686 - Internet Programming                  //
//  Author:      Nitish Kumar, Syracuse University                             //
/////////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This JSP file has Layout of shuttle booking page display
 *   waiting time for each student is also calculated here and dispalyed to student
 *   
 */-->
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Room</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/FormValidation.js"></script>
</head>
<body>
<%
java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
String sysdate= df.format(new java.util.Date());


String sname = (String) session.getAttribute("name");
if (null == sname) { // checking if session is false currently
   request.setAttribute("Error", "Session has ended.  Please login.");
   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// if session is false redirect to login page
   rd.forward(request, response);
   }


int waitTime=0;
try{
	
	//wait time is calculated based on the number of booking for shuttle and then the value is returned to user.
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
if (minute<0){
	minute=0;
}


int count=Integer.parseInt((String)session.getAttribute("count"));
int count1=count/9;
count1++;

waitTime=(time*count1)-minute;
if(minute>=(time*count1)){
	waitTime=time*count1;
	
}

System.out.println("count1:"+count1);
System.out.println("min:"+minute);
System.out.println("wait in db:"+time);
}
catch(Exception e){
	System.out.println(e);
}

%>
<form name="book" action="StudentController" method=post>
<div class="division" align="center">
	<table align="center" class="register">
	<caption class="tabletitle">Book your Shuttle.</caption>
	<tr><td class="label">Name</td>
	<td><input type='text' name='name' id='name' value="<%= session.getAttribute("name")%>" readonly></td>
	</tr>
	<tr><td class="label">Email</td>
	<td><input type='text' name='email' id='email' value="<%= session.getAttribute("email")%>" readonly></td>
	</tr>
	<tr><td class="label">Date</td>
	<td><input type='text' name='date' id='date' value="<%= sysdate%>" readonly></td>
	</tr>
	<tr><td class="label">Waiting time(in minutes)</td>
	<td><input type='text' name='time' id='time' value="<%= waitTime%>" readonly></td>
	</tr>
	<tr><td class="label">Drop Address</td>
	<td><input type='text' name='address' id='address' value="<%= session.getAttribute("address")%>" ></td>
	</tr>
	<tr>
	<td><input class="form-button" type="Submit" value="Continue" onclick="return bookValidate()" align="right"></td>
	<td><input class="form-button" type="hidden" name="action" value="book"></td>
	</tr>
	</table>
</div>
</form>

</body>
</html>
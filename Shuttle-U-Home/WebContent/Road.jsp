<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver Module</title>

   <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        float: left;
        width: 70%;
        height: 100%;
      }
      #right-panel {
        margin: 20px;
        border-width: 2px;
        width: 20%;
        height: 400px;
        float: left;
        text-align: left;
        padding-top: 0;
      }
      .directions-panel {
        margin-top: 10px;
        background-color: #FFEE77;
        overflow: scroll;
        padding: 10px;
        height: 38%;
        width: 100%;
      }

      .btn {
        margin-top: 10px;
        margin-left: 2px;
        text-align: center;
        width: 30%;
      }
    </style>
    <script>
    	var address = [];
    </script>
    </head>
    <body>
    
    
    <%@ page import="java.util.ArrayList"%>
<%ArrayList<String> b=new ArrayList<String>();
b=(ArrayList<String>)session.getAttribute("addresses");%>

<%for(String a:b){%>
	
	<input type="hidden" value="<%=a%>" class="add"/>
	
<%}
%>
 <!-- Firebase Script -->
  <script src="https://www.gstatic.com/firebasejs/4.12.0/firebase.js"></script>

 <!-- jQuery Script -->
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

 <!-- Rishabh's Code -->
  <script type="text/javascript" src="js/Road.js"></script>

 <!-- Salim's Code-->
  <script type="text/javascript" src="js/Road3.js"></script>

  <!-- Loading Map synchronously code execuating -->
	<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJMprrXTtmUqciVaVgskmHxskLkVjrE6A&callback=initMap">
	</script>


    <div id="map"></div>
    <div id="right-panel">
    <div id="order" class="directions-panel"></div>
    <div id="route" class="directions-panel"></div>
    <div id="general" class="directions-panel"></div>
    <div>
    <input type="submit" id="start" class="btn" value="Start" onclick="start()">
    
    <input type="submit" id="drop" class="btn" value="Drop"  onclick="drop()">
    <form name='trip' method="post" action="DriverHome.jsp">
    <input type="submit" id="end" class="btn" value="End" onclick="end()">
    </form>
    </div>
    
    <script type="text/javascript" src="js/main.js"></script>
    
</body>
</html>
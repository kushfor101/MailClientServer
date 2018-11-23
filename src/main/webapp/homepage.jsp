<%@ page import="java.util.ArrayList" %>
<%@ page import="com.user.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome to your mailbox  <%= session.getAttribute("currentuser") %>

<br> <br> <br>

<form action = "logout">
	<div align="right">
	<input type="submit" value="LOGOUT">
	</div>
</form>

<form action = "composepage.jsp">
	<input type="submit" value="COMPOSE"  >
</form>
<br>
<form action = "viewmails">
	<input type="submit" value="VIEW MAILS" >
</form>

<% if(request.getAttribute("notification") != null) { %>
		<h4>Notification Received</h4>
		
	<%	ArrayList<String> received = (ArrayList<String>)request.getAttribute("notification");
		for(String id : received) { %>
			<br> <%= id %> has received your mail <br>
	<% 	}
} %>

</body>
</html>
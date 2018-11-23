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

<br>
Compose a new mail
 <br> <br>

<form action="compose" method="post" >
	<h3>To</h3>
	
	<input type="text" name="toId">
	<br> <br> <br>
	<h3>Subject</h3>
	<input type="text" name="subject">
	
	<h3>Body</h3>
	<textarea rows="7" cols="100" name="body" form="compose"></textarea>
	<br> 
	<input type="submit" value="SEND" >

</form>


</body>
</html>
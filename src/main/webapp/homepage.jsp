<%@page import="com.user.model.MessageQueue"%>
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

Welcome to your mailbox  <%= request.getAttribute("currentuser") %>

<br> <br> <br>

<form action = "logout">
	<div align="right">
	<input type="submit" value="LOGOUT">
	</div>
</form>

<form action = "composepage.jsp">
	<input type="submit" value="COMPOSE"  >
	<input type="hidden" name="currentuser" value= <%=request.getAttribute("currentuser") %> >
</form>
<br>
<form action = "viewmails">
	<input type="submit" value="VIEW MAILS" >
	<input type="hidden" name="currentuser" value= <%=request.getAttribute("currentuser") %> >
</form>

<%
	if(session.getAttribute("messagequeue")!=null) {
	System.out.println("got message queue");
	ArrayList<String> received = new ArrayList<String>();
	ArrayList<MessageQueue> mqs = (ArrayList<MessageQueue>)session.getAttribute("messagequeue");
	ArrayList<MessageQueue> newmqs = new ArrayList<MessageQueue>();
	for(MessageQueue mq : mqs) {
		if(mq.getFromId().equals(request.getAttribute("currentuser")) && mq.isReceived()) {
			received.add(mq.getToId());
		}
		else
			newmqs.add(mq);
	}
	session.setAttribute("messagequeue", newmqs);
	if(!received.isEmpty()) {
		System.out.println("sending notification");   %>
		<h4>Notification Received</h4>
		
	<%
		for(String id : received) { %>
			<br> <%= id %> has received your mail <br>
	<% 	}
	}
} %>

</body>
</html>
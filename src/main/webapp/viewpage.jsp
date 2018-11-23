<%@page import="javax.mail.Message"%>
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

<h2> Messages :  </h2>
<br> <br>

<form action="viewmail.jsp">
<table>
<tr>
<td> From </td>
<td>Subject</td>
<td>Select</td>
</tr>

<% Message[] messages = (Message[])request.getAttribute("messages");
   int size = (Integer)request.getAttribute("size");
   int c=0;
   for(Message ms : messages) { %>
   <br>
   <tr>
   <td> <%=ms.getFrom()[0] %> </td>
   <td> <%=ms.getSubject() %> </td>
   <td> <input type="radio" name="select" value=<%= String.valueOf(c) %> > </td>
   </tr>
   <% c++;  }
   %>
   <input type="submit" value="view" >
   
</table>
</form>

</body>
</html>
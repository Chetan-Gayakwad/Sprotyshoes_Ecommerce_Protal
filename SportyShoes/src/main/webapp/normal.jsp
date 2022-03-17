<%@page import="com.smplilearn.sportyshoes.entities.User"%>
<%
User user = (User) session.getAttribute("current-user");
if (user == null) {

	session.setAttribute("message", "you are not login !! login first");
	response.sendRedirect("login.jsp");
	return;

}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User login page</title>
<%@include file="components/cssAndJs.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<h2>User login page</h2>

</body>


</html>
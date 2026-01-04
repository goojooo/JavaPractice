<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<%
	String myname = (String)session.getAttribute("name_key");
%>
<h3>Welcom : <%= myname %></h3>
<a href="profile.jsp">Profile</a> &nbsp;&nbsp;
<a href="about.jsp">About</a>
</body>
</html>
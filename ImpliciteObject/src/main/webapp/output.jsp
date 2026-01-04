<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String myName = request.getParameter("name1");
	out.println(myName);
	%>
	
	<%
	String cName = (String)session.getAttribute("sess_name");
	out.println(cName);
	%>
</body>
</html>
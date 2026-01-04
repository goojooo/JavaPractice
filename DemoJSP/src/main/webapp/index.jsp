<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is my JSP page...</h1>
	<%!
		String name = "Nayan Dahare" ;
		int len = name.length();
	%>
	<%=len %>
	<%!
		int a = 10;
		int sqr()
		{
		return a*a;
		}
	%> 
	<br>
	<%=sqr() %>
	
	<%
	out.println("a : " + a); 
	out.println("Name : " + name);
	out.println(sqr());
	
	int x = 24;
	if(x < 100)
	{
		out.println("b is smaller than 100");
	} else{
		out.println("b is greater than 100");
	}
	
	for(int i = 1 ; i <= 5; i++)
	{
		out.println(i);
	}
	
	//String name = request.getParameter("-----")
	%>
	
	<br>
	<%= LocalDate.now() %>
	<br>
	<%= Math.random() %>
</body>
</html>
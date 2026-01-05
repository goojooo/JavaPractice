<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
	<form action="addStudent" method="post">
	Name : <input type="text" name="name" /> <br/> <br/>
	Email : <input type="email" name="email"/> <br/><br/>
	Course : <input type="text" name="course"/> <br/><br/>
	Age : <input type="number" name="age" /> <br/><br/>
	<input type="submit" value="Add Student" /> <br/>
	</form>
</body>
</html>
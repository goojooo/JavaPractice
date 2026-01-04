<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>
<body>
	<form action="regForm" method="post" >
		Name : <input type="text" name="name1" /> <br/> <br/>
		Email : <input type="text" name="email" /> <br/> <br/>
		Password : <input type="password" name="pass1" /> <br/> <br/>
		Gender : <input type="radio" name="gender1" value="Male" /> Male <input type="radio" name="gender1" value="Female" /> Female <br/> <br/> 
		City : <select name="city1">
				<option>Select city </option>
				<option>NAGPUR</option>
				<option>PUNE </option>
				<option>MUMBAI .</option>
			   </select> <br><br>
			   <input type="submit" value="Register" />
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="../logincontroller">
	
		Enter Username: <input type="text" name="username"></input>
		
		Enter password: <input type="password" name="password"></input>
		
		<input type="hidden" value="login" name="action"/>
		
		<input type="submit" value="login" name="login"></input>
		
	</form>
	
	<c:if test="${requestScope.invalidLogin}">
		
		<h1>Invalid Login</h1>
		
	</c:if>
	

</body>
</html>
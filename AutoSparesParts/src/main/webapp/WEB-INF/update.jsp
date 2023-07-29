<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<table>
		<form action="./update" method="post">
		<label>User ID</label><br>
<input type="text" name="userId" value="${user.userId }" ><br>
<label>Username</label><br>
<input type="text" name="userName" value="${user.userName }" ><br>
<label>FirstName</label><br>
<input type="text" name=firstName value="${user.firstName }"><br>
<label>LastName</label><br>
<input type="text" name="lastName" value="${user.lastName }"><br>
<label>Email</label><br>
<input type="text" name="email" value="${user.email }"><br>
<label>Password</label><br>
<input type="password" name="password" value="${user.password }" ><br>
<label>Mobile</label><br>
<input type="text" name="mobile" value="${user.mobile }"><br>
<label>Department</label><br>
<input type="text" name="department" value="${user.department }"><br>
 <label>Role</label><br>
 
 
 
 <c:forEach items="${ role}" var="r">
 <input type="checkbox" value="${r.roleId }" name="roles">${r.roleName }"
 
 
 </c:forEach>
<input type="submit" value="update" >
</form>

	</table>
</body>
</html>
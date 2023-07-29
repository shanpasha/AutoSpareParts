<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<h1>Add User</h1>


<form action="./save" method="post">

<input type="text" name="userName" placeholder="Username">
<input type="text" name=firstName placeholder="firstname">
<input type="text" name="lastName" placeholder="Lastname">
<input type="text" name="email" placeholder="Email">
<input type="password" name="password" placeholder="Password" >
<input type="text" name="mobile" placeholder="Mobile Number">
<input type="text" name="department" placeholder="Department"><br>
 
 <c:forEach items="${ Roles}" var="role">
 <input type="checkbox" value="${role.roleId }" name="roles">${role.roleName }"</input>
 
 
 </c:forEach>
<input type="submit" value="Save" >
</form>





</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
<h1>Users</h1>

<table border="3px">

<tr>
<th>User ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th>
<th>Mobile</th><th>Department</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${users}" var="user">
<tr><td><c:out value="${user.userId}" ></c:out></td>
<td><c:out value="${user.userName}"></c:out></td>
<td><c:out value="${user.firstName}"></c:out></td>
<td><c:out value="${user.lastName}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.mobile}"></c:out></td>
<td><c:out value="${user.department}"></c:out></td>
<td><a href="./updateUser?userId=${user.userId}" >Update</a></td>
<td><a href="./deleteUser?userId=${user.userId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
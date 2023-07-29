<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roles</title>
</head>
<body>
<h1>Roles</h1>

<table border="3px">

<tr>
<th>Role ID</th><th>Role Name</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${allRoles}" var="role">
<tr><td><c:out value="${role.roleId}" ></c:out></td>
<td><c:out value="${role.roleName}"></c:out></td>

<td><a href="./updateRole?roleId=${role.roleId}" >Update</a></td>
<td><a href="./deleteRole?roleId=${role.roleId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
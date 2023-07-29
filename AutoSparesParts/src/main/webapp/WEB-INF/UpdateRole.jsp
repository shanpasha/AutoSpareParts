<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<body>
	<table>
		<form action="updateRole" method="post">
		<label>Role ID</label><br>
<input type="text" name="roleId" value="${getRole.roleId }" readonly="readonly" ><br>
<label>Role Name</label><br>
<input type="text" name="roleName" value="${getRole.roleName }" ><br> 
<input type="submit"  value="Update">
		</body>
</html>
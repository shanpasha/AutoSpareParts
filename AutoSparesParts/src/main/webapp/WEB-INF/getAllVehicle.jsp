<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicles</title>
</head>
<body><h1>Vehicles</h1>
<table border="3px">
<tr>

<th>Vehicles ID</th><th>Vehicle Name</th>
<th>Update</th>
<th>Delete</th>
</tr>


<c:forEach items="${AllVehicle}" var="v">
<tr>
<td><c:out value="${v.vehicleId}" ></c:out></td>
<td><c:out value="${v.vehicleName}"></c:out></td>

<td><a href="./updateVehicle?vehicleId=${v.vehicleId}" >Update</a></td>
<td><a href="./deleteVehicle?vehicleId=${v.vehicleId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
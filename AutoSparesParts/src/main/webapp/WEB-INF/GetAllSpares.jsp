<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllSpares</title>
</head>
<body>
<h1>All Spare Parts</h1>
<table border="3px">

<tr>
<th>Part Id</th><th>Serial Number</th><th>Part Name</th><th>Description</th><th>Model</th>
<th>Manufacturer</th><th>Cost</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${allSpares}" var="s">
<tr><td><c:out value="${s.partId}" ></c:out></td>
<td><c:out value="${s.serialNumber}"></c:out></td>
<td><c:out value="${s.partName}"></c:out></td>
<td><c:out value="${s.description}"></c:out></td>
<td><c:out value="${s.model}"></c:out></td>
<td><c:out value="${s.manufacturer}"></c:out></td>
<td><c:out value="${s.cost}"></c:out></td>
<td><a href="./updateSparePart?partId=${s.partId}" >Update</a></td>
<td><a href="./deletePart?partId=${s.partId}">Delete</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
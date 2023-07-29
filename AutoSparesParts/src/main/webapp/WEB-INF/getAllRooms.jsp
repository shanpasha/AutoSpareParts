<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rooms</title>
</head>
<body>
<h1>Rooms</h1>

<table border="3px">

<tr>
<th>Room ID</th><th>Room Name</th><th>Address
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${AllRooms}" var="room">
<tr><td><c:out value="${room.roomId}" ></c:out></td>
<td><c:out value="${room.roomName}"></c:out></td>
<td><c:out value="${room.address}"></c:out></td>

<td><a href="./updateRoom?roomId=${room.roomId}" >Update</a></td>
<td><a href="./deleteRoom?roomId=${room.roomId}">Delete</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
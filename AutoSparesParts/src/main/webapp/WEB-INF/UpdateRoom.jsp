<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateRoom</title>
</head>
<body>
<h1>Update Room</h1>

<form action="./updateRoom" method="post">
<label>Room ID</label>
<input type="text" name="roomId" value="${getRoom.roomId }"  readonly="readonly"><br>
<label>Room name</label>
<input type="text" name="roomName" value="${getRoom.roomName }" ><br>
<label>Address</label>
<input type="text" name="address" value="${getRoom.address}">


<input type="submit" value="Update Room">
</form>
</body>
</html>
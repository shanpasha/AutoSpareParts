<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save spare parts</title>
</head>
<body>

<form action="./saveSparePart" method="post">

<input type="text" name="partId" placeholder="Part Id">
<input type="text" name="serialNumber" placeholder="Serial Number">
<input type="text" name="partName" placeholder="Part Name">
<input type="text" name="description" placeholder="Description">
<input type="text" name="model" placeholder="Model" >
<input type="text" name="manufacturer" placeholder="Manufacturer">
<input type="text" name="cost" placeholder="Cost"><br>


 
 <select name="vechicle">
 <c:forEach items="${vech}" var="v">
    <option value="${v.vehicleId}">${v.vehicleName}</option>
     </c:forEach>
</select>

<select name="room">
 <c:forEach items="${room}" var="r">
    <option value="${r.roomId}">${r.roomName}</option>
     </c:forEach>
</select>

<input type="submit" value="Save Spare Part">
</form>

</body>
</html>
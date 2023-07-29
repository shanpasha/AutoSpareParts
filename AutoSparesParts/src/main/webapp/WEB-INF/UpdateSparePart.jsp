<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<form action="./updateSparePart" method="post">
<label>Part Id</label><br>
<input type="text" name="partId" value="${part.partId }" placeholder="Part Id"><br>
<label>Serial Number</label><br>
<input type="text" name="serialNumber" value="${part.serialNumber }"placeholder="Serial Number"><br>
<label>Part Name</label><br>
<input type="text" name="partName" value="${part.partName }"placeholder="Part Name"><br>
<label>Description</label><br>
<input type="text" name="description" value="${part.description }" placeholder="Description"><br>
<label>Model</label><br>
<input type="text" name="model"  value="${part.model }" placeholder="Model" ><br>
<label>Manufacturer</label><br>
<input type="text" name="manufacturer" value="${part.manufacturer }" placeholder="Manufacturer"><br>
<label>Cost</label><br>
<input type="text" name="cost" value="${part.cost }" placeholder="Cost"><br>


 
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

<input type="submit" value="update Part">
</form>

</body>
</html>
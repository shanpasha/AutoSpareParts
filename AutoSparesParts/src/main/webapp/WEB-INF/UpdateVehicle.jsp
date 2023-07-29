<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h1>Update Vehicle</h1>

<form action="./updateVehicle" method="post">
<label>Vehicle ID</label>
<input type="text" name="vehicleId" value="${getVehicle.vehicleId }"  readonly="readonly"><br>
<label>Vehicle name</label>
<input type="text" name="vehicleName" value="${getVehicle.vehicleName }" ><br>


<input type="submit" value="Update Vehicle">
</form>
</body>
</html>
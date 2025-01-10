<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>Delete BY ID</title>
</head>
<body>
    <h1 class="heading">DELETE BY ID</h1>
    <div class="container">
        <form class="form-container" action="DeleteById">
            <label for="id">Employee ID: </label>
            <input type="text" name="id" id="id" placeholder="Enter Employee ID to delete details"/>
            <input type="submit" value="DELETE" />
        </form>
    <c:if test="${nora == '-1' and not empty param.id}">
        <h3 class="res-heading" style="color: red; font-weight:300;">No Employee Found for the ID: <strong>${id}</strong></h3>
    </c:if>
    <c:if test="${nora == '1' and not empty param.id}">
        <h3 class="res-heading" style="color: green; font-weight:300;">Employee with ID: <strong>${id}</strong> removed</h3>
    </c:if>
    </div>
    <a class="homelink" href="home.jsp">HOME</a>
    
</body>
</html>
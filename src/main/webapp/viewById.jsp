<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>View BY ID</title>
</head>
<body>
    <h1 class="heading">VIEW BY ID</h1>
    <div class="container">
        <form class="form-container" action="ViewById">
        	<input type="hidden" name="action" value="view">
            <label for="id">Employee ID: </label>
            <input type="text" name="id" id="id" placeholder="Enter Employee ID to fetch details"/>
            <input type="submit" value="SEARCH" />
        </form>
	
    <c:if test="${not empty employee}">
        <h2 class="res-heading">Employee Details:</h2>
        <table class="result-table">
            <tr>
                <td><strong>ID:</strong></td>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <td><strong>Name:</strong></td>
                <td>${employee.name}</td>
            </tr>
            <tr>
                <td><strong>Salary:</strong></td>
                <td>${employee.salary}</td>
            </tr>
            <tr>
                <td><strong>Email:</strong></td>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <td><strong>Phone:</strong></td>
                <td>${employee.phone}</td>
            </tr>
            <tr>
                <td><strong>Address:</strong></td>
                <td>${employee.address}</td>
            </tr>
        </table>
    </c:if>

    <!-- Show error message if no employee is found -->
    <c:if test="${empty employee and not empty param.id}">
        <h3 class="res-heading">No Employee Found for the given ID</h3>
    </c:if>
    </div>
    <a class="homelink" href="home.jsp">HOME</a>
</body>
</html>
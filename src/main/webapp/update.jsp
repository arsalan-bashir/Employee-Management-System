<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>UPDATE EMPLOYEE</title>
</head>
<body>
    <h1 class="heading">UPDATE EMPLOYEE DETAILS</h1>
    <div class="add-container">
        <form class="add-form-container" action="UpdateEmployee" method="post">
            <div class="form-group">
                <label for="id">ID: </label>
                <input type="text" name="id" id="id" value="${employee.id}" readonly/>
            </div>
            <div class="form-group">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" value="${employee.name}" />
            </div>
            <div class="form-group">
                <label for="salary">Salary: </label>
                <input type="text" name="salary" id="salary" value="${employee.salary}" />
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" name="email" id="email" value="${employee.email}" />
            </div>
            <div class="form-group">
                <label for="phone">Phone: </label>
                <input type="text" name="phone" id="phone" value="${employee.phone}" />
            </div>
            <div class="form-group">
                <label for="address">Address: </label>
                <input type="text" name="address" id="address" value="${employee.address}" />
            </div>
            <div class="buttons">
                <a class="homelink" href="updateById.jsp">RESET</a>
                <input class="homelink" type="submit" value="UPDATE" />
                <a class="homelink" href="home.jsp">HOME</a>
            </div>
        </form>
        <c:if test="${not empty id}">
        <h3 style="color:green;text-align:center;">Employee with ID: ${id} updated!!</h3>
    	</c:if>
    </div>
</body>
</html>
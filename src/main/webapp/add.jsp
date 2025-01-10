<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>ADD EMPLOYEE</title>
</head>
<body>
<body>
    <h1 class="heading">ADD EMPLOYEE</h1>
    <div class="add-container">
        <form class="add-form-container" action="AddEmployee" method="post">
            <div class="form-group">
                <label for="id">ID: </label>
                <input type="text" name="id" id="id" value="kod" />
            </div>
            <div class="form-group">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" />
            </div>
            <div class="form-group">
                <label for="salary">Salary: </label>
                <input type="text" name="salary" id="salary" />
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" name="email" id="email" />
            </div>
            <div class="form-group">
                <label for="phone">Phone: </label>
                <input type="text" name="phone" id="phone" />
            </div>
            <div class="form-group">
                <label for="address">Address: </label>
                <input type="text" name="address" id="address" />
            </div>
            <div class="buttons">
                <a class="homelink" href="add.jsp">RESET</a>
                <input class="homelink" type="submit" value="ADD" />
                <a class="homelink" href="home.jsp">HOME</a>
            </div>
        </form>
        <c:if test="${nora == '1'}">
        	<p style="text-align:center; color:green;font-weight:600;">Data Inserted Successfully..</p>
        </c:if>
        
        <c:if test="${nora == '-1'}">
        	<p style="text-align:center; color:red;font-weight:600;">ID Already Present!!</p>
        </c:if>
    </div>
</body>
</html>
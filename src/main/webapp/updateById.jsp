<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>Update BY ID</title>
</head>
<body>
    <h1 class="heading">UPDATE BY ID</h1>
    <div class="container">
        <form class="form-container" action="ViewById">
        	<input type="hidden" name="action" value="update">
            <label for="id">Employee ID: </label>
            <input type="text" name="id" id="id" placeholder="Enter Employee ID to fetch details"/>
            <input type="submit" value="FETCH" />
        </form>
    <c:if test="${empty employee and not empty param.id}">
        <h3 class="res-heading">No Employee Found for the given ID</h3>
    </c:if>
    </div>
    <a class="homelink" href="home.jsp">HOME</a>
    
</body>
</html>
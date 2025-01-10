<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>Employee Management System</title>
    </head>
<body> 
    <h1 class="heading">Employee Management System</h1>
    <div class="container">
        <a href="ViewEmployees">VIEW ALL EMPLOYEES</a>
        <a href="viewById.jsp">VIEW EMPLOYEE BY ID</a>
        <a href="${pageContext.request.contextPath}/add.jsp">ADD EMPLOYEE</a>
        <a href="delete.jsp">DELETE EMPLOYEE</a>
        <a href="updateById.jsp">UPDATE EMPLOYEE</a>
    </div>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
    <h1>Update User</h1>
    <form action="<c:url value="/user/update/${user.id}"/>" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br>
        
        <input type="submit" value="Update">
    </form>
    <a href="<c:url value="/user/${user.id}"/>">Back to User Details</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    <p>ID: ${user.id}</p>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <a href="<c:url value="/user/update/${user.id}"/>">Update User</a>
</body>
</html>

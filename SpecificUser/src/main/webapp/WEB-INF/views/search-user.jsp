<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search User</title>
</head>
<body>
    <h1>Search User</h1>
    <form action="<c:url value="/user/${userId}"/>" method="get">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="id" required><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f2f2f2;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        h2 {
            color: #555;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <h1>Manage Users</h1>

    <!-- Create New User -->
    <h2>Create New User</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="create">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username"><br>
        <input type="submit" value="Create User">
    </form>

    <!-- Update User -->
    <h2>Update User</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="update">
        <label for="userId">User ID:</label>
        <input type="text" name="userId" id="userId"><br>
        <label for="newUsername">New Username:</label>
        <input type="text" name="username" id="newUsername"><br>
        <input type="submit" value="Update User">
    </form>

    <!-- Delete User -->
    <h2>Delete User</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <label for="deleteUserId">User ID:</label>
        <input type="text" name="userId" id="deleteUserId"><br>
        <input type="submit" value="Delete User">
    </form>
</body>
</html>

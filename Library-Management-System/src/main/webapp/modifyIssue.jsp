<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Issues</title>
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
    <h1>Manage Issues</h1>

    <!-- Create New Issue -->
    <h2>Create New Issue</h2>
    <form action="BookIssue" method="post">
        <input type="hidden" name="action" value="issue">
        <label for="bookId">Book ID:</label>
        <input type="text" name="bookId" id="bookId"><br>
        <label for="userId">User ID:</label>
        <input type="text" name="userId" id="userId"><br>
        <input type="submit" value="Create Issue">
    </form>

    <!-- Return Book -->
    <h2>Return Book</h2>
    <form action="BookIssue" method="post">
        <input type="hidden" name="action" value="delete">
        <label for="issueId">Issue ID:</label>
        <input type="text" name="issueId" id="issueId"><br>
        <input type="submit" value="Return">
    </form>
</body>
</html>

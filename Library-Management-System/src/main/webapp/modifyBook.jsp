<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f2f2f2;
        }
        h1 {
            color: #333;
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
    <h1>Manage Books</h1>

    <!-- Create New Book -->
    <h2>Create New Book</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="create">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title"><br>
        <label for="author">Author:</label>
        <input type="text" name="author" id="author"><br>
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" id="isbn"><br>
        <input type="submit" value="Create Book">
    </form>

    <!-- Update Book -->
    <h2>Update Book</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="update">
        <label for="bookId">Book ID:</label>
        <input type="text" name="bookId" id="bookId"><br>
        <label for="newTitle">New Title:</label>
        <input type="text" name="newTitle" id="newTitle"><br>
        <input type="submit" value="Update Book">
    </form>

    <!-- Delete Book -->
    <h2>Delete Book</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <label for="deleteBookId">Book ID:</label>
        <input type="text" name="bookId" id="deleteBookId"><br>
        <input type="submit" value="Delete Book">
    </form>
</body>
</html>

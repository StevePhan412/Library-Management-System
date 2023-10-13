<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Issue Details</title>
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
        p {
            font-size: 18px;
            color: #555;
        }
        .content {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f9f9f9;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="content">
        <h1>Issue Details</h1>
        <table>
            <tr>
                <th>Issue ID</th>
                <th>Book ID</th>
                <th>User ID</th>
                <th>Issue Date</th>
                <th>Return Date</th>
            </tr>
            <c:forEach var="issue" items="${issues}">
                <tr>
                    <td>${issue.issueId}</td>
                    <td>${issue.bookId}</td>
                    <td>${issue.userId}</td>
                    <td>${issue.issueDate}</td>
                    <td>${issue.returnDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

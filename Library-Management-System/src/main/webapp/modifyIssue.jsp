<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Issues</title>
</head>
<body>
    <h1>Manage Issues</h1>

	<!-- Create New Issue -->
	<h2>Create New Issue</h2>
	<form action="BookIssue" method="post">
	    <input type="hidden" name="action" value="issue">
	    Book ID: <input type="text" name="bookId"><br>
	    User ID: <input type="text" name="userId"><br>
	    <input type="submit" value="Create Issue">
	</form>
	
	<!-- Return Book -->
	<h2>Return Book</h2>
	<form action="BookIssue" method="post">
	    <input type="hidden" name="action" value="delete">
	    Issue ID: <input type="text" name="issueId"><br>
	    <input type="submit" value="Return">
	</form>


</body>
</html>

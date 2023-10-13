<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #50b3a2;
            color: white;
            text-align: center;
            padding: 1em;
        }
        .container {
            margin: 2em auto;
            max-width: 600px;
            background-color: #fff;
            padding: 1em;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
        }
        ul {
            list-style: none;
            padding-left: 0;
        }
        ul li {
            background-color: #eee;
            margin: 8px 0;
            line-height: 2.5;
            text-align: center;
        }
        ul li a {
            text-decoration: none;
            color: #333;
            display: block;
            width: 100%;
        }
        ul li a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Library Management System</h1>
    </header>
    
    <div class="container">
        <h2>Operations:</h2>
        <ul>
            <li><a href="BookServlet">Display Books</a></li>
            <li><a href="modifyBook.jsp">Create/Modify Book</a></li>
            <li><a href="UserServlet">Display Users</a></li>
            <li><a href="modifyUser.jsp">Create/Modify User</a></li>
            <li><a href="BookIssue">Issued Books List</a></li>
            <li><a href="modifyIssue.jsp">Create/Modify Book Issue</a></li>
        </ul>
    </div>
</body>
</html>

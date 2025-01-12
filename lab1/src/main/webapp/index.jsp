<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }
        .container {
            text-align: center;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
        }
        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #4a90e2;
        }
        p {
            font-size: 1.2em;
            margin-bottom: 30px;
            color: #555;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 15px 30px;
            font-size: 1.2em;
            color: white;
            background-color: #4a90e2;
            text-decoration: none;
            border-radius: 25px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a:hover {
            background-color: #357abd;
            transform: translateY(-5px);
        }
        .emoji {
            font-size: 1.5em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Your <br> Task Management System!</h1>
        <p>Stay organized, boost productivity, and achieve your goals effortlessly. Let's make every task count!</p>
        <a href="/lab1/projects">Explore Projects</a>
        <a href="/lab1/tasks">View All Tasks</a>
    </div>
</body>
</html>
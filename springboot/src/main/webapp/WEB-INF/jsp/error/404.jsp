<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            background-color: #000;
            color: #fff;
            font-family: 'Courier New', Courier, monospace;
            text-align: center;
            padding: 50px;
        }
        .container {
            border: 3px solid red;
            padding: 20px;
            box-shadow: 0 0 15px red;
            display: inline-block;
            margin: 20px;
            background: linear-gradient(145deg, #1e1e1e, #272727);
        }
        h1 {
            font-size: 4rem;
            color: red;
            text-shadow: 0 0 10px red;
        }
        p {
            font-size: 1.5rem;
        }
        a {
            color: #0ff;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            color: red;
            text-shadow: 0 0 5px red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>404</h1>
    <p>Page Not Found</p>
    <p>Something went wrong in the matrix...</p>
    <p><a href="/">Return Home</a></p>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: flex-end;
            height: 100vh;
            background: #f8f8f8;
        }

        .container iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            border: none;
        }

        .text-overlay {
            position: sticky;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: #000;
            text-align: center;
            padding: 20px;
            border-radius: 10px;
        }

        .text-overlay h1 {
            font-size: 6rem;
            margin: 0;
            padding: 0;
        }

        .text-overlay p {
            font-size: 1.5rem;
            margin: 10px 0;
        }

        .text-overlay a {
            color: #000;
            text-decoration: none;
            font-weight: bold;
        }

        .text-overlay a:hover {
            color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <iframe src="http://slither.com/io" class="giphy-embed" allowfullscreen></iframe>
    <div class="text-overlay">
        <h2>The page you are looking for does not exist</h2>
        <p><a href="/">Return Home</a></p>
    </div>
</div>
</body>
</html>

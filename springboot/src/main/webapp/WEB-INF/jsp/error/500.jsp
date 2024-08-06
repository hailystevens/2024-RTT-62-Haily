<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500 - Internal Server Error</title>
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
        .stack-trace {
            text-align: left;
            display: inline-block;
            margin: 0 auto;
            background: #333;
            padding: 20px;
            border: 1px solid red;
            box-shadow: 0 0 10px red;
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
    <h1>500</h1>
    <p>Internal Server Error</p>
    <p>The system has encountered an error...</p>
    <p><a href="/">Return Home</a></p>
    <c:if test="${not empty message}">
        <div class="stack-trace">
            <h3>Error Message:</h3>
            <p>${message}</p>
            <h3>Stack Trace:</h3>
            <pre>${stackTrace}</pre>
            <c:if test="${not empty rootCause}">
                <h3>Root Cause:</h3>
                <p>${rootCause}</p>
                <pre>${rootTrace}</pre>
            </c:if>
        </div>
    </c:if>
</div>
</body>
</html>

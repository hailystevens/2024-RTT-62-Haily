<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<form:form action="login" method="post">
    <div>
        <label for="email">Email:</label>
        <form:input path="email" id="email"/>
    </div>
    <div>
        <label for="password">Password:</label>
        <form:password path="password" id="password"/>
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
</form:form>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h2>Create User</h2>
<form:form action="/users/create" method="post" modelAttribute="createAccountFormBean">
    <form:label path="username">Username:</form:label>
    <form:input path="username" /><br>
    <form:label path="email">Email:</form:label>
    <form:input path="email" type="email" /><br>
    <form:label path="password">Password:</form:label>
    <form:input path="password" type="password" /><br>
    <input type="submit" value="Create User">
</form:form>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
</body>
</html>

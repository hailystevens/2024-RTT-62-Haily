<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
</head>
<body>
<h2>Create Account</h2>
<form:form action="/account/create-account" method="post" modelAttribute="form">
    <form:label path="username">Username:</form:label>
    <form:input path="username" /><br>
    <form:errors path="username" cssClass="error" /><br>

    <form:label path="email">Email:</form:label>
    <form:input path="email" type="email" /><br>
    <form:errors path="email" cssClass="error" /><br>

    <form:label path="password">Password:</form:label>
    <form:input path="password" type="password" /><br>
    <form:errors path="password" cssClass="error" /><br>

    <input type="submit" value="Create Account">
</form:form>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
</body>
</html>

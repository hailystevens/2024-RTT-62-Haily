<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
</head>
<body>
<h2>Create Account</h2>

<form:form modelAttribute="form" action="create-account" method="post">
    <div>
        <label for="email">Email:</label>
        <form:input path="email" id="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label for="password">Password:</label>
        <form:password path="password" id="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label for="fullName">Full Name:</label>
        <form:input path="fullName" id="fullName"/>
        <form:errors path="fullName" cssClass="error"/>
    </div>
    <div>
        <button type="submit">Create Account</button>
    </div>
</form:form>

<c:if test="${not empty bindingResult}">
    <div class="errors">
        <ul>
            <c:forEach items="${bindingResult.allErrors}" var="error">
                <li><c:out value="${error.defaultMessage}"/></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

</body>
</html>

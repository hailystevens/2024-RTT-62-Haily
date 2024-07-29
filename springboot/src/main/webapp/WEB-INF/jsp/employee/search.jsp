<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Employees</title>
</head>
<body>
<h2>Search Employees</h2>

<form:form action="/employee/search" method="get">
    <div>
        <label for="search">Employee Name:</label>
        <form:input path="search" id="search"/>
        <button type="submit">Search</button>
    </div>
</form:form>

<c:if test="${not empty employees}">
    <h3>Search Results</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Office Code</th>
            <th>Job Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.firstName}"/></td>
                <td><c:out value="${employee.lastName}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.officeCode}"/></td>
                <td><c:out value="${employee.jobTitle}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty employees}">
    <p>No employees found.</p>
</c:if>

</body>
</html>

<jsp:include page="../include/footer.jsp"/>

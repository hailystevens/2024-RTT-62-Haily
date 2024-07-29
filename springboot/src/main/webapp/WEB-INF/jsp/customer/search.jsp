<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Customers</title>
</head>
<body>
<h2>Search Customers</h2>

<form:form action="/customer/search" method="get">
    <div>
        <label for="search">Customer Name:</label>
        <form:input path="search" id="search"/>
        <button type="submit">Search</button>
    </div>
</form:form>

<c:if test="${not empty customers}">
    <h3>Search Results</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Contact First Name</th>
            <th>Contact Last Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Postal Code</th>
            <th>Country</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.contactFirstName}"/></td>
                <td><c:out value="${customer.contactLastName}"/></td>
                <td><c:out value="${customer.phone}"/></td>
                <td><c:out value="${customer.addressLine1}"/>, <c:out value="${customer.addressLine2}"/></td>
                <td><c:out value="${customer.city}"/></td>
                <td><c:out value="${customer.state}"/></td>
                <td><c:out value="${customer.postalCode}"/></td>
                <td><c:out value="${customer.country}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty customers}">
    <p>No customers found.</p>
</c:if>

</body>
</html>

<jsp:include page="../include/footer.jsp"/>

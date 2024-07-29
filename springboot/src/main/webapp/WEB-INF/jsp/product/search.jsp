<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Products</title>
</head>
<body>
<h2>Search Products</h2>

<form:form action="/product/search" method="get">
    <div>
        <label for="search">Product Name or Code:</label>
        <form:input path="search" id="search"/>
        <button type="submit">Search</button>
    </div>
</form:form>

<c:if test="${not empty productsKey}">
    <h3>Search Results</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Product Line</th>
            <th>Product Scale</th>
            <th>Product Vendor</th>
            <th>Quantity In Stock</th>
            <th>Buy Price</th>
            <th>MSRP</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productsKey}">
            <tr>
                <td><c:out value="${product.productCode}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productLine}"/></td>
                <td><c:out value="${product.productScale}"/></td>
                <td><c:out value="${product.productVendor}"/></td>
                <td><c:out value="${product.quantityInStock}"/></td>
                <td><c:out value="${product.buyPrice}"/></td>
                <td><c:out value="${product.msrp}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty productsKey}">
    <p>No products found.</p>
</c:if>

</body>
</html>

<jsp:include page="../include/footer.jsp"/>

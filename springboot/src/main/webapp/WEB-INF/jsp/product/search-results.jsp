<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="../include/header.jsp"/>

<div class="container">
    <h1>Search Results</h1>
    <c:if test="${not empty products}">
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Category</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td><a href="${pageContext.request.contextPath}/product/detail?id=${product.id}">${product.name}</a>
                    </td>
                    </td>
                    <td>${product.brand}</td>
                    <td>${product.category}</td>
                    <td><fmt:formatNumber value="${product.price}" type="currency"/></td>
                    <td>${product.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty products}">
        <p>No products found matching your search criteria.</p>
    </c:if>
</div>

<jsp:include page="../include/footer.jsp"/>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Details</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">Details for: ${product.name}</h4>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <td>${product.id}</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td>${product.name}</td>
                    </tr>
                    <tr>
                        <th>Brand</th>
                        <td>${product.brand}</td>
                    </tr>
                    <tr>
                        <th>Category</th>
                        <td>${product.category}</td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="$"/></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>${product.description}</td>
                    </tr>
                    <tr>
                        <th>Image</th>
                        <td>
                            <img src="${pageContext.request.contextPath}/pub/imgs/${product.imageFileName}"
                                 alt="${product.name}" width="100">
                        </td>
                    </tr>
                    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                        <tr>
                            <th>Created At</th>
                            <td><fmt:formatDate value="${product.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="white-space:nowrap">
                                <a class="btn btn-primary btn-sm"
                                   href="${pageContext.request.contextPath}/product/edit?id=${product.id}">Edit</a>
                                <a class="btn btn-danger btn-sm"
                                   href="${pageContext.request.contextPath}/product/delete?id=${product.id}"
                                   onclick="return confirm('Are you sure?')">Delete</a>
                            </td>
                        </tr>
                    </sec:authorize>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

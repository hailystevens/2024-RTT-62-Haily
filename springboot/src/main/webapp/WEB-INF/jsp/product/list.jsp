<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product List</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${products.size()} product(s) found</h4>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Created At</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product/detail?id=${product.id}">${product.name}</a>
                            </td>
                            <td>${product.brand}</td>
                            <td>${product.category}</td>
                            <td>${product.price} $</td>
                            <td>
                                <img src="${pageContext.request.contextPath}/pub/imgs/${product.imageFileName}"
                                     alt="Product Image" width="100">
                            </td>
                            <td>${product.createdAt}</td>
                            <td style="white-space:nowrap">
                                <a class="btn btn-primary btn-sm"
                                   href="${pageContext.request.contextPath}/product/edit?id=${product.id}">Edit</a>
                                <a class="btn btn-danger btn-sm"
                                   href="${pageContext.request.contextPath}/product/delete?id=${product.id}"
                                   onclick="return confirm('Are you sure?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/product/create">Create Product</a>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<div class="text-center my-4">
    <h2>Shop Our Bestsellers</h2>
</div>

<div class="product-carousel">
    <div class="product-list-wrapper">
        <div class="product-list" id="product-list">
            <c:forEach var="product" items="${products}">
                <div class="product-card">
                    <a href="/product/detail?id=${product.id}">
                        <img src="${pageContext.request.contextPath}/pub/imgs/${product.imageFileName}" class="product-img" alt="${product.name}">
                    </a>
                    <div class="product-info">
                        <h5 class="product-title">${product.name}</h5>
                        <a href="/product/detail?id=${product.id}" class="btn btn-primary">View Details</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+Gl8xkZaf/ujB26rv6EB4KN5K8GHA" crossorigin="anonymous"></script>

<style>
    /* Custom styles for forms and buttons */

    .product-carousel {
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: visible;
        flex-grow: 1;
    }

    .product-list-wrapper {
        overflow: auto;
        flex-grow: 1;
    }

    .product-list {
        display: flex;
        flex-wrap: nowrap;
        transition: transform 0.3s ease;
    }

    .product-card {
        flex: 0 0 auto;
        width: 25%;
        box-sizing: border-box;
        margin-right: 10px;
        border: 1px solid #dee2e6;
        border-radius: 5px;
        overflow: hidden;
        background-color: #ffffff;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }

    .product-img {
        width: 100%;
        height: 500px;
        object-fit: contain;
    }

    .product-title {
        font-size: 1.25rem;
        margin-bottom: 0.75rem;
    }

    .product-info {
        padding: 10px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 100%;
    }

    .btn-primary {
        align-self: flex-end;
    }
</style>

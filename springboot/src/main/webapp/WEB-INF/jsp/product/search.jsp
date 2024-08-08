<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Search</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/product/search">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Search for a product:</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search"
                               placeholder="Enter search term"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
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
                        <th>Product Name</th>
                        <th>Brand</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Image</th>
                        <th>Created At</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td><a href="/product/${product.id}">${product.name}</a></td>
                            <td>${product.brand}</td>
                            <td>${product.category}</td>
                            <td>${product.price}</td>
                            <td>${product.description}</td>
                            <td><img src="/pub/imgs/${product.imageFile}" alt="Product Image" style="max-width:100px;"></td>
                            <td>${product.createdAt}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

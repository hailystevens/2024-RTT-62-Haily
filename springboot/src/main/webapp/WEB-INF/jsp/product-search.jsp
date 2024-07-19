<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<!-- Page header -->
<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col text-center">
                <h1>Search Page</h1>
            </div>
        </div>
    </div>
</section>

<!-- Search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/product-search" method="get">
                    <div class="mb-3">
                        <label for="search" class="form-label"><h4>Search</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search" placeholder="Enter search term" aria-describedby="searchHelp"/>
                        <small id="searchHelp" class="form-text text-muted">Enter the product name you are looking for.</small>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Search results -->
<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Products Found (${products.size()})</h2>
                <c:choose>
                    <c:when test="${not empty products}">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Edit</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${products}" var="product">
                                <tr>
                                    <td><a href="/products/${product.id}">${product.id}</a></td>
                                    <td>${product.productCode}</td>
                                    <td>${product.productName}</td>
                                    <td>${product.productDescription}</td>
                                    <td><a href="/products/edit/${product.id}">Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-info text-center" role="alert">
                            No products found matching your search criteria.
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />

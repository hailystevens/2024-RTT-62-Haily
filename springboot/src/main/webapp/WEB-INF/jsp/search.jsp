<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Find Products</h1>
        </div>
    </div>
</section>

<!-- a search form -->
<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center d-flex justify-content-center">
                <form action="/search">
                    <div class="mb-3">
                        <div class="d-flex gap-1 justify-content-center">
                            <input style="width: 350px" type="text" value="${search}" class="form-control" id="search"
                                   name="search" placeholder="Enter product name">
                            <button type="submit" class="btn btn-success">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-3">
            <div class="col-12">
                <h2 class="text-center">Products Found (${products.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-hover table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr onclick="window.location.href = '/?id=${product.id}'" class="clickable-row">
                            <td>${product.id}</td>
                            <td>${product.productCode}</td>
                            <td>${product.productName}</td>
                            <td>${product.productDescription}</td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </div>

</section>

<jsp:include page="include/footer.jsp"/>

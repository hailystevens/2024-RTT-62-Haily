<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Products</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <div class="col-12">
                <h4 class="text-center">${productsKey.size()} result(s)</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table">
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
                    <c:forEach items="${productsKey}" var="product">
                        <tr>
                            <td>${product.productCode}</td>
                            <td>${product.productName}</td>
                            <td>${product.productLine}</td>
                            <td>${product.productScale}</td>
                            <td>${product.productVendor}</td>
                            <td>${product.quantityInStock}</td>
                            <td>${product.buyPrice}</td>
                            <td>${product.msrp}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

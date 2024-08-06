<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

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
                <h4 class="text-center">${productsKey.size()} product(s) found</h4>
                <table class="table">
                    <tr>
                        <th>Product Code</th>
                        <th>Product Name</th>
                        <th>Product Line Id</th>
                        <th>Product Scale</th>
                        <th>Product Vendor</th>
                        <th>Quantity in Stock</th>
                        <th>Buy Price</th>
                        <th>MSRP</th>
                    </tr>
                    <c:forEach items="${productsKey}" var="product">
                        <tr>
                            <td>${product.productCode}</td>
                            <td><a href="../product/${product.id}">${product.productName}</a></td>
                            <td>${product.productLineId}</td>
                            <td>${product.productScale}</td>
                            <td>${product.productVendor}</td>
                            <td>${product.quantityInStock}</td>
                            <td>${product.buyPrice}</td>
                            <td>${product.msrp}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

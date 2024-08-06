<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Product Detail: ${productKey.productName}</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <div class="col-8">
                <table class="table">
                    <tr><td><b>Product Code</b></td>          <td>${productKey.productCode}</td></tr>
                    <tr><td><b>Product Name</b></td>          <td>${productKey.productName}</td></tr>
                    <tr><td><b>Product Line Id</b></td>       <td>${productKey.productLineId}</td></tr>
                    <tr><td><b>Product Scale</b></td>         <td>${productKey.productScale}</td></tr>
                    <tr><td><b>Product Vendor</b></td>        <td>${productKey.productVendor}</td></tr>
                    <tr><td><b>Product Description</b></td>   <td>${productKey.productDescription}</td></tr>
                    <tr><td><b>Quantity in Stock</b></td>     <td>${productKey.quantityInStock}</td></tr>
                    <tr><td><b>Buy Price</b></td>             <td>${productKey.buyPrice}</td></tr>
                    <tr><td><b>MSRP</b></td>                  <td>${productKey.msrp}</td></tr>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

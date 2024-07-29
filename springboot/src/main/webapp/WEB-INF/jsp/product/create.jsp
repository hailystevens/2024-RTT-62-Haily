<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                <c:if test="${empty form.id}">
                    Create Product
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Product
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form:form action="/product/createSubmit" method="post">
                    <input type="hidden" name="id" value="${form.id}">

                    <div class="row align-items-center pb-3">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="productCodeId" class="col-form-label">Product Code</label>
                            </div>
                            <div class="col-4">
                                <form:input path="productCode" id="productCodeId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productNameId" class="col-form-label">Product Name</label>
                            </div>
                            <div class="col-4">
                                <form:input path="productName" id="productNameId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productlineIdId" class="col-form-label">Product Line</label>
                            </div>
                            <div class="col-4">
                                <form:input path="productlineId" id="productlineIdId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productScaleId" class="col-form-label">Product Scale</label>
                            </div>
                            <div class="col-4">
                                <form:input path="productScale" id="productScaleId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productVendorId" class="col-form-label">Product Vendor</label>
                            </div>
                            <div class="col-4">
                                <form:input path="productVendor" id="productVendorId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="quantityInStockId" class="col-form-label">Quantity In Stock</label>
                            </div>
                            <div class="col-4">
                                <form:input path="quantityInStock" id="quantityInStockId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="buyPriceId" class="col-form-label">Buy Price</label>
                            </div>
                            <div class="col-4">
                                <form:input path="buyPrice" id="buyPriceId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="msrpId" class="col-form-label">MSRP</label>
                            </div>
                            <div class="col-4">
                                <form:input path="msrp" id="msrpId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productDescriptionId" class="col-form-label">Product Description</label>
                            </div>
                            <div class="col-4">
                                <form:textarea path="productDescription" id="productDescriptionId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row justify-content-center pt-3">
                            <div class="col-auto text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

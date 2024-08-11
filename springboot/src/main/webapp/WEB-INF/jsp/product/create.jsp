<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center"><c:if test="${empty form.id}">Create Product</c:if><c:if
                    test="${not empty form.id}">Edit Product</c:if></h1>
        </div>
    </div>
</section>

<!-- Only admins can access this form -->
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <section>
        <div class="container">
            <div class="row pt-5">
                <div class="col-12">
                    <form action="/product/create" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${form.id}">

                        <!-- Product Name Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productNameId" class="col-form-label">Product Name</label>
                            </div>
                            <div class="col-4">
                                <input type="text" id="productNameId" name="name"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('name')}">is-invalid</c:if>"
                                       value="${form.name}">
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('name')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div style="color:red">
                                        <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Brand Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="brandId" class="col-form-label">Brand</label>
                            </div>
                            <div class="col-4">
                                <input type="text" id="brandId" name="brand"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('brand')}">is-invalid</c:if>"
                                       value="${form.brand}">
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('brand')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div style="color:red">
                                        <c:forEach items="${bindingResult.getFieldErrors('brand')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Category Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="categoryId" class="col-form-label">Category</label>
                            </div>
                            <div class="col-4">
                                <input type="text" id="categoryId" name="category"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('category')}">is-invalid</c:if>"
                                       value="${form.category}">
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('category')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div style="color:red">
                                        <c:forEach items="${bindingResult.getFieldErrors('category')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Product Description Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="productDescriptionId" class="col-form-label">Product Description</label>
                            </div>
                            <div class="col-4">
                                <textarea id="productDescriptionId" name="description"
                                          class="form-control <c:if test="${bindingResult.hasFieldErrors('description')}">is-invalid</c:if>"
                                          rows="5">${form.description}</textarea>
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('description')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div style="color:red">
                                        <c:forEach items="${bindingResult.getFieldErrors('description')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Buy Price Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="buyPriceId" class="col-form-label">Buy Price</label>
                            </div>
                            <div class="col-4">
                                <input type="text" id="buyPriceId" name="price"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('price')}">is-invalid</c:if>"
                                       value="${form.price}">
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('price')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div style="color:red">
                                        <c:forEach items="${bindingResult.getFieldErrors('price')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Image File Input -->
                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="imageFile" class="col-form-label">Product Image</label>
                            </div>
                            <div class="col-4">
                                <input type="file" id="imageFile" name="imageFile"
                                       class="form-control <c:if test="${bindingResult.hasFieldErrors('imageFile')}">is-invalid</c:if>">
                            </div>
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('imageFile')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <div class="text-danger">
                                        <c:forEach items="${bindingResult.getFieldErrors('imageFile')}" var="error">
                                            ${error.defaultMessage}<br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <!-- Submit Button -->
                        <div class="row justify-content-center pt-3">
                            <div class="col-auto text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</sec:authorize>
<jsp:include page="../include/footer.jsp"/>

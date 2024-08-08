<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Edit Product</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form action="/product/edit" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${form.id}">

                    <!-- Product Name Input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="name" class="col-form-label">Product Name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="name" name="name" class="form-control <c:if test="${bindingResult.hasFieldErrors('name')}">is-invalid</c:if>" value="${form.name}">
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

                    <!-- Product Description Input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="description" class="col-form-label">Product Description</label>
                        </div>
                        <div class="col-4">
                            <textarea id="description" name="description" class="form-control <c:if test="${bindingResult.hasFieldErrors('description')}">is-invalid</c:if>" rows="5">${form.description}</textarea>
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

                    <!-- Brand Input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="brand" class="col-form-label">Brand</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="brand" name="brand" class="form-control <c:if test="${bindingResult.hasFieldErrors('brand')}">is-invalid</c:if>" value="${form.brand}">
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
                            <label for="category" class="col-form-label">Category</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="category" name="category" class="form-control <c:if test="${bindingResult.hasFieldErrors('category')}">is-invalid</c:if>" value="${form.category}">
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

                    <!-- Price Input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="price" class="col-form-label">Price</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="price" name="price" class="form-control <c:if test="${bindingResult.hasFieldErrors('price')}">is-invalid</c:if>" value="${form.price}">
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
                            <input type="file" id="imageFile" name="imageFile" class="form-control <c:if test="${bindingResult.hasFieldErrors('imageFile')}">is-invalid</c:if>">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('imageFile')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('imageFile')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="row pt-5">
                        <div class="col-4 offset-2">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />

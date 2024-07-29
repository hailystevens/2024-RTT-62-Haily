<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                <c:if test="${empty form.id}">
                    Create Order
                </c:if>
                <c:if test="${not empty form.id}">
                    Edit Order
                </c:if>
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <form:form action="/order/createSubmit" method="post">
                    <input type="hidden" name="id" value="${form.id}">

                    <div class="row align-items-center pb-3">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-2">
                                <label for="orderDateId" class="col-form-label">Order Date</label>
                            </div>
                            <div class="col-4">
                                <form:input path="orderDate" id="orderDateId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="requiredDateId" class="col-form-label">Required Date</label>
                            </div>
                            <div class="col-4">
                                <form:input path="requiredDate" id="requiredDateId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="shippedDateId" class="col-form-label">Shipped Date</label>
                            </div>
                            <div class="col-4">
                                <form:input path="shippedDate" id="shippedDateId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="statusId" class="col-form-label">Status</label>
                            </div>
                            <div class="col-4">
                                <form:input path="status" id="statusId" class="form-control"/>
                            </div>
                        </div>

                        <div class="row align-items-center justify-content-center pt-3">
                            <div class="col-2">
                                <label for="commentsId" class="col-form-label">Comments</label>
                            </div>
                            <div class="col-4">
                                <form:textarea path="comments" id="commentsId" class="form-control"/>
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

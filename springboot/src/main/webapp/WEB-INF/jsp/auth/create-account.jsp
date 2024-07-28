<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Account</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-auto justify-content-center">
                <form class="card" style="width: 500px;" action="/account/create-account" method="post">
                    <div class="card-body p-3">
                        <input type="hidden" name="id" value="${form.id}"/>
                        <div>
                            <label for="emailId" class="col-form-label">Email</label>
                            <input type="text" id="emailId" name="email"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                   value="${form.email}">
                            <c:if test="${bindingResult.hasFieldErrors('email')}">
                                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="passwordId" class="col-form-label">Password</label>
                            <input type="password" id="passwordId" name="password"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('password')}">is-invalid</c:if>"
                                   value="${form.password}">
                            <c:if test="${bindingResult.hasFieldErrors('password')}">
                                <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="firstNameId" class="col-form-label">First Name</label>
                            <input type="text" id="firstNameId" name="firstname"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('firstname')}">is-invalid</c:if>"
                                   value="${form.firstname}">
                            <c:if test="${bindingResult.hasFieldErrors('firstname')}">
                                <c:forEach items="${bindingResult.getFieldErrors('firstname')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <label for="lastNameId" class="col-form-label">Last Name</label>
                            <input type="text" id="lastNameId" name="lastname"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('lastname')}">is-invalid</c:if>"
                                   value="${form.lastname}">
                            <c:if test="${bindingResult.hasFieldErrors('lastname')}">
                                <c:forEach items="${bindingResult.getFieldErrors('lastname')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="mt-5">
                            <button type="submit" class="btn btn-success w-100">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

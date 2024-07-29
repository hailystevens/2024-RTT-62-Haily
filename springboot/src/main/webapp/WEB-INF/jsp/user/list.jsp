<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h2>User List</h2>

<table border="1">
    <thead>
    <tr>
        <th>Email</th>
        <th>Full Name</th>
        <th>Username</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.fullName}"/></td>
            <td><c:out value="${user.username}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

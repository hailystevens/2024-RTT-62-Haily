<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="include/header.jsp"/>

<main class="container flex-grow-1 my-4">
    <h1 class="text-center">Welcome to Our Database Management System</h1>
    <p class="text-center">
        Our Database Management System (DBMS) provides comprehensive tools and functionalities to efficiently store, retrieve, and manage your data.
    </p>

    <section>
        <div class="container">
            <div class="row pt-5">
                <div class="col-md-6">
                    <h3>Data Storage and Retrieval</h3>
                    <p>Efficiently organize and retrieve your data using advanced query processing and structured storage techniques.</p>
                </div>
                <div class="col-md-6">
                    <h3>Data Integrity and Consistency</h3>
                    <p>Ensure the accuracy and consistency of your data through robust validation rules, constraints, and transaction management.</p>
                </div>
            </div>
            <div class="row pt-5">
                <div class="col-md-6">
                    <h3>Data Security</h3>
                    <p>Protect your data with advanced access control, authentication, authorization, and encryption methods.</p>
                </div>
                <div class="col-md-6">
                    <h3>Backup and Recovery</h3>
                    <p>Regularly backup your data and ensure quick recovery in case of data loss or corruption.</p>
                </div>
            </div>
            <div class="row pt-5">
                <div class="col-md-6">
                    <h3>Performance Tuning</h3>
                    <p>Optimize database performance with efficient indexing, query optimization, and continuous monitoring.</p>
                </div>
                <div class="col-md-6">
                    <h3>Database Design and Modeling</h3>
                    <p>Create efficient database structures and models to represent data relationships and ensure scalability.</p>
                </div>
            </div>
            <div class="row pt-5">
                <div class="col-md-6">
                    <h3>Maintenance</h3>
                    <p>Keep your database up-to-date with regular updates, patches, and data archiving strategies.</p>
                </div>
                <div class="col-md-6">
                    <h3>Replication and Distribution</h3>
                    <p>Ensure high availability and redundancy with data replication and management of distributed databases.</p>
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>

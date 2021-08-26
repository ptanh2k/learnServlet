<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learn.entity.Book"%>

<!DOCTYPE html>
<html>
<head>
    <title>My book list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
</head>
<body>
    <form action="removeFromList" action="post">
        <table>
            <tr>
                <th>Book ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Published year</th>
            <tr>

        </table>
    </form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learn.entity.Book"%>
<%@page import="com.learn.entity.ReadList"%>

<!DOCTYPE html>
<html>
<head>
    <title>My book list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
</head>
<body>
    <table>
        <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Category</th>
            <th>Author</th>
            <th>Published year</th>
            <th>Borrow Date</th>
            <th>Due Date</th>
        <tr>
        <c:forEach items="${sessionScope.readList}" var="book">
            <form action="returnBook" method="get">
                <tr>
                    <td>${book.getBook_id()}<input type="hidden" name="book_id" value="${book.getBook_id()}" /></td>
                    <td>${book.getTitle()}</td>
                    <td>${book.getCategory_name()}</td>
                    <td>${book.getAuthor()}</td>
                    <td>${book.getPublished_year()}</td>
                    <td>${book.getDate_borrow()}</td>
                    <td>${book.getDate_return_target()}</td>
                    <td><input type="submit" value="Return book" /></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</body>
</html>
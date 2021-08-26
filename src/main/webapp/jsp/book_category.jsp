<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learn.entity.Book"%>
<%@page import="com.learn.entity.Category"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK BY CATEGORY</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
  </head>
  <body>
  <form method="post" action="addBookToList">
    <table>
        <tr>
          <th>Book ID</th>
          <th>Title</th>
          <th>Author</th>
          <th>Published year</th>
          <th>Category</th>
        </tr>
        <c:forEach items="${list_book_by_category}" var="book">
            <tr>
                <td>${book.getBook_id()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getPublished_year()}</td>
                <td>${category}</td>
                <td><input type="submit" value="Add to list"/></td>
            </tr>
        </c:forEach>
    </table>
  </form>
  </body>
</html>
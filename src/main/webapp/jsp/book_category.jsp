<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Book"%>
<%@page import="com.learn.entity.Category"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK BY CATEGORY</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book_category.css">
  </head>
  <body>
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
            </tr>
        </c:forEach>
    </table>   
  </body>
</html>
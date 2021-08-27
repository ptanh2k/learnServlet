<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
  </head>
  <body>
      <%-- <form action="addBookToList" method="post"> --%>
        <table>
          <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category ID</th>
            <th>Published year</th>
          </tr>
          <c:forEach items="${books}" var="book">
           <form action="addBookToList" method="post">
            <tr>
              <td>${book.getBook_id()}<input type="hidden" name="book_id" value="${book.getBook_id()}"/></td>
              <td>${book.getTitle()}<input type="hidden" name="title" value="${book.getTitle()}"/></td>
              <td>${book.getAuthor()}<input type="hidden" name="author" value="${book.getAuthor()}"/></td>
              <td>${book.getCategory_id()}<input type="hidden" name="category_id" value="${book.getCategory_id()}"/></td>
              <td>${book.getPublished_year()}<input type="hidden" name="published_year" value="${book.getPublished_year()}"/></td>
              <td><input type="submit" value="Add to list" /></td>
            </tr>
            </form>
          </c:forEach>
        </table>
      <%-- </form> --%>
  </body>
</html>

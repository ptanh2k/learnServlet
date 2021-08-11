<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
  </head>
  <body>
    <c:choose>
      <c:when test="${empty book}">
        <p>Book not available</p> <br>
      </c:when>
      <c:otherwise>
        <table>
          <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Published year</th>
          </tr>
          <tr>
            <td>${book.getBook_id()}</td>
            <td>${book.getTitle()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getPublished_year()}</td>
          </tr>
        </table> 
      </c:otherwise>
    </c:choose>
  </body>
</html>

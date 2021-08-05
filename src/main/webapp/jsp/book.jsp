<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
  </head>
  <body>
    <table>
      <c:forEach items="${books}" var="book">
        <tr>
          <td>${book.getBook_id()}</td>
          <td>${book.getTitle()}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

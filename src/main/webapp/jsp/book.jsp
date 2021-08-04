<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
  </head>
  <body>
    <c:forEach begin="0" end="${fn:length(books) - 1}" var="index" />
      <tr>
        <td><c:out value="${books[index]}" /></td>
      </tr>
  </body>
</html>

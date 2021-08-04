<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
  </head>
  <body>
    <c:forEach items="${books}" var="book">
      <p>${book}</p><br>
    </c:forEach>
  </body>
</html>

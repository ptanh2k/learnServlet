<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.learn.entity.Category"%>
<!DOCTYPE html>
<html>
  <head>
    <title>CATEGORIES</title>
    <link rel="stylesheet" href="../css/category.css" />
  </head>
  <body>
    <form method="get" action="getBookByCategory">
       <c:forEach items="${categories}" var="category" >
          <input type="submit" value="${category.getCategory_name()}" id="category" name="category" /> <br>
       </c:forEach>
    </form>
  </body>
</html>
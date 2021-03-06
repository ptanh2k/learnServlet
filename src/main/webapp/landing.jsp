<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learn.entity.User"%>
<%@page import="com.learn.entity.Category"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/landing.css">
  </head>
  <body>
    <c:choose>
        <c:when test="${not empty email}">
            <h1>BOOK MANAGEMENT SYSTEM</h1>
            <h3>Hello ${user.getUser_name()}</h3>
            <form action="searchBook" method="get">
             Search book <br>
                <input type="text" name="title" />
                <input type="submit" value="Search" />
            </form>
            <form action="getBookByCategory" method="get">
              <select name="category" id="category">
                <c:forEach items="${categoryList}" var="category">
                  <option value="${category.getCategory_name()}">
                    ${category.getCategory_name()}
                  </option>
                </c:forEach>
              </select>
              <input type="submit" value="Search" />            
            </form>
            <form action="viewReadList" method="get">
              View ${user.getUser_name()}'s read list
              <input type="submit" value="View read list" />
            </form> 
            <form action="logout" method="post">
              <input type="submit" name="logout" value="Logout"/>
            </form>
        </c:when>
        <c:otherwise>
            <c:redirect url="index.jsp" />
        </c:otherwise>
    </c:choose>
  </body>
</html>

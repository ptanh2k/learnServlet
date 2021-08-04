<%@page import="com.learn.entity.Book"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BOOK</title>
  </head>
  <body>
    <% Book book = (Book) request.getAttribute("book"); out.println(book); %>
  </body>
</html>

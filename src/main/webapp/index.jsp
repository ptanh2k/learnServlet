<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="css/index.css" />
  </head>
  <body>
    <h1>BOOK MANAGEMENT SYSTEM</h1>
    <form id="login-form" method="post" name="login">
      <table>
        <tr>
          <td>Email: </td>
          <td>
            <input
              type="email"
              name="email"
              id="email"
              placeholder="Enter your email address"
              required
            />
          </td>
        </tr>
        <tr>
          <td>Password: </td>
          <td>
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Enter your password"
              required
            />
          </td>
          <tr>
            <td>
              <input type="submit" name="submit" value="Login">
            </td>
            <td><a href="jsp/register.jsp">Register</a></td>
          </tr>
        </tr>
      </table>
    </form>
    <form action="getBook" method="get">
      Get book <br>
      <input type="text" name="book_id" />
      <input type="submit" />
    </form>
    <form action="getCategory" method="get">
      Get category <br>
      <input type="submit" name="category"/>
    </form>
  </body>
</html>

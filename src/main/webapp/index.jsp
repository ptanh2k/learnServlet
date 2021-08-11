<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  </head>
  <body>
    <h1>BOOK MANAGEMENT SYSTEM</h1>
    <form action="login" id="login" method="post" name="login">
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
  </body>
</html>

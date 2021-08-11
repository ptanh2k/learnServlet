<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
  </head>
  <body>
    <h1>BOOK MANAGEMENT SYSTEM</h1>
    <form id="register-form" method="post" action="register">
      <table>
        <tr>
          <td>Username:</td>
          <td>
            <input
              type="text"
              name="username"
              placeholder="Type in your Username"
              required
            />
          </td>
        </tr>
        <tr>
          <td>Email:</td>
          <td>
            <input
              type="email"
              name="email"
              placeholder="Enter your email address"
              required
            />
          </td>
        </tr>
        <tr>
          <td>Password:</td>
          <td>
            <input
              type="password"
              name="password"
              class="password"
              placeholder="Enter your password"
              required
            />
          </td>
        </tr>
        <tr>
          <td>Choose your role:</td>
          <td>
            <select name="role" id="role">
              <option value="Reader">Reader</option>
              <option value="Administrator">Administrator</option>
              <option value="Librarian">Librarian</option>
            </select>
          </td>
        </tr>
      </table>
      <input type="submit" name="register" value="Register" />
    </form>
  </body>
</html>

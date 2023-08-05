<%--
  Created by IntelliJ IDEA.
  User: Manish
  Date: 8/5/2023
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String user = null;
    if(session.getAttribute("username")==null){
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
      requestDispatcher.forward(request,response);

    }else
      user=(String) session.getAttribute("username");
  %>

  <h1>Welcome, <%= user %>!</h1>
  <form action="logout" method="POST">
    <input type="submit" value="Logout">
  </form>

</body>
</html>

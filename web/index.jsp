<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <div>
      <form action="/UserServlet" method="get">

        <c:forEach items="${userList}" var = "m">
          <option value="${m.name}">${m.name}</option>

        </c:forEach>

        <h1>${list}+**********************8</h1>
      </form>
    </div>


  </body>
</html>
<script>
  var list=${userList}
</script>
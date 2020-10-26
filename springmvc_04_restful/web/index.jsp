<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
  <head>
    <title>restful</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/book/100">查询id为1的图书</a><br>
  <a href="${pageContext.request.contextPath}/book">查询全部的图书</a><br>

  <form action="${pageContext.request.contextPath}/book" method="post">
    <input type="submit" value="添加图书">
  </form>

  <form action="${pageContext.request.contextPath}/book/1" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="修改图书">
  </form>

  <form action="${pageContext.request.contextPath}/book/1" method="post" >
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除图书">
  </form>
  </body>
</html>

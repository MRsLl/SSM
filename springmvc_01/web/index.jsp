
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="http://localhost:8080/springmvc_01/hello">SpringMvc hello</a>

  <form action="http://localhost:8080/springmvc_01/map4" method="post">
    <input type="submit" value="提交">
  </form>


  <form action="http://localhost:8080/springmvc_01/param/param7" method="get">
    姓名：<input type="text" name="name"> <br/>
    编号：<input type="text" name="id"> <br/>
    年龄：<input type="text" name="age"> <br/>
    电话：<input type="text" name="phone"> <br/>
    汽车品牌：<input type="text" name="car.name"> <br/>
    车牌号：<input type="text" name="car.carNo"> <br/>
    <input type="submit" value="提交">
  </form>

  </body>
</html>

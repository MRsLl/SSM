<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Request 域的中 requestKey1 的值 是${requestScope.requestKey1} <br>
Request 域的中 requestKey2 的值 是${requestScope.requestKey2} <br>
<hr/>
Session 域的中 seKey1 的值 是${sessionScope.seKey1} <br>
Session 域的中 seKey2 的值 是${sessionScope.seKey2} <br>
<hr/>
ServletContext 域的中 scKey1 的值 是${applicationScope.scKey1} <br>
ServletContext 域的中 scKey2 的值 是${applicationScope.scKey2} <br>
<hr/>
Request 域的中 mapKey1 的值 是${requestScope.mapKey1} <br>
Request 域的中 mapKey2 的值 是${requestScope.mapKey2} <br>
<hr/>
Request 域的中 mavKey1 的值 是${requestScope.mavKey1} <br>
Request 域的中 mavKey2 的值 是${requestScope.mavKey2} <br>
<hr/>
Request 域 key1 的值是： ${ requestScope.key1 } <br>
Reqeust 域 key2 的值是： ${ requestScope.key2 } <br>
Session 域 key1 的值是： ${ sessionScope.key1 } <br>
Session 域 key2 的值是： ${ sessionScope.key2 } <br>
<hr>

</body>
</html>

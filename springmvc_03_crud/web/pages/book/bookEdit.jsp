<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书列表</title>
		<%
			String basePath = request.getScheme() 
								+ "://"
								+ request.getServerName()
								+ ":"
								+ request.getServerPort()
								+ request.getContextPath()
								+ "/";
		%>
		<base href="<%=basePath %>" />
	</head>
	<body>
		<center>
			<h3>添加图书</h3>

			<c:if test="${empty requestScope.book}">
			<form action="${pageContext.request.contextPath}/book" method="post">
				</c:if>

				<c:if test="${not empty requestScope.book}">
				<form action="${pageContext.request.contextPath}/book/${requestScope.book.id}" method="post">
					<input type="hidden" name="id" value="${requestScope.book.id}">
					<input type="hidden" name="_method" value="PUT">
					</c:if>
				<table>
					<tr>
						<td>书名</td>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
					</tr>
					<tr>
						<td>作者</td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
					</tr>
					<tr>
						<td>价格</td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
					</tr>
					<tr>
						<td>销量</td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
					</tr>
					<tr>
						<td>库存</td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" />
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
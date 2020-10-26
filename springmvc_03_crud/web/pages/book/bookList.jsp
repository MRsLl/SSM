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
		<style type="text/css">
			table {
				border: 1px blue solid;
				width: 700px;
				border-collapse: collapse;
			}
			td,th{
				border: 1px green solid;
			}
			div.menu {
				width: 700px;
				text-align: right;
			}
		</style>
		<script src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			$(function () {
				$("a.deleteClass").click(function () {
					var name = $(this).parent().parent().find("td:first").text();
					if (confirm("你确定要删除【" + name + "】么？")) {
						//prev() 获取前一个兄弟元素，submit() 提交表单
						$(this).prev("form").submit();
					}
					return false;
				});
			});
		</script>
	</head>
	<body>
		<center>
			<h2>图书列表管理页面</h2>
			<div class="menu"><a href="${pageContext.request.contextPath}/pages/book/bookEdit.jsp">添加图书</a></div>
			<table>
				<tr bgcolor="#FF8888">
					<th>书名</th>
					<th>作者</th>
					<th>价格</th>
					<th>销量</th>
					<th>库存</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.books}" var="book">
					<tr>
						<td>${book.name}</td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td>${book.sales}</td>
						<td>${book.stock}</td>
						<td>
							<form action="${pageContext.request.contextPath}/book/${book.id}" method="post">
								<input type="hidden" name="_method" value="DELETE">
							</form>
							<a class="deleteClass" href="">删除</a>、
							<a href="${pageContext.request.contextPath}/book/${book.id}">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车页面</title>
</head>
<body>
<form action="login" method="post">

	<table align="left">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="upwd"></td>
		</tr>
		<tr>
			<td colspan>
				<input type="submit" name="登录">
			</td>
		</tr>
	</table>
	
	<table cellpadding="0" cellspacing="1">
		<thead>欢迎来到购物车页面</thead>
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>价格</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${listsp }" var="lst">
		<tr>
		 	<td>${lst.spid }</td>
		 	<td>${lst.spname }</td>
		 	<td>${lst.spprice }</td>
		 	<td>${lst.spdesc }</td>
		 	<td><a href="shopping?sid=${lst.spid }">加入购物车</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>
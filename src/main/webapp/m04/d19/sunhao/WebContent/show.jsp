<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
</head>
<body>
    <h1>购物车页面</h1>
    <table align="center" border="1">
    	<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>价格</th>
			<th>描述</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<tr>
			<td>${sp.spid}</td>
			<td>${sp.spname}</td>
			<td>
				<input type="text" id="num" name="num" value="1" size="5"/>
			</td>
			<td>${sp.spprice}</td>
			<td>${sp.spname}</td>
			<td>
				<input type="text" id="price" name="price" value="0" size="7"/>
			</td>
			<td>
				<a href="#">购买</a>
			</td>
		</tr>
    </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show.jsp</title>
</head>
<body>
<%
	String ntitle=request.getParameter("ntitle");
	String nauthor=request.getParameter("nauthor");
%>
	<h2>
		文件名：<%=request.getAttribute("filename") %>
		<br/>
		文件路径：<%=request.getAttribute("ppath") %>
	</h2>
	<img src="upload/<%=request.getAttribute("filename") %>">
	<h3>标题：<%=ntitle %></h3>
	<h3>作者：<%=nauthor %></h3>
</body>
</html>
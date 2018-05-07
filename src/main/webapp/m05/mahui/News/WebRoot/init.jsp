<%@page import="com.dt59.entity.CommentInfo"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" import="java.util.*"  pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'init.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  	BizDaoImpl bsi = new BizDaoImpl();
  	BizServiceImpl bdi = new BizServiceImpl();
  	bdi.setBizDao(bdi);
  	List<CommentInfo> commentInfo = bsi.getCommentInfo();
  	request.setAttribute("commentInfo", commentInfo);
  	request.getRequestDispatcher("index.jsp").forward(request, response);
  %>
<script>
</script>
  </body>
</html>

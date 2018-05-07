<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.dao.BizDao"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <%
	request.setCharacterEncoding("utf-8");  	
  	String uname = request.getParameter("uname");
  	String upwd = request.getParameter("upwd");
  	UserInfo user=new UserInfo();
  	user.setUsername(uname);
  	user.setPassword(upwd);
  	
  	BizDaoImpl bdi=new BizDaoImpl();
  	BizServiceImpl bsi=new BizServiceImpl();
  	bsi.setBizDao(bdi);
  	Page pg=new Page();
  	boolean flag=bsi.validateUser(user);
  	if(flag){
  		int totalInfo=bsi.getInfoCount();
  		int lastPageNo=(totalInfo%3==0?totalInfo/3:totalInfo/3+1);
  		pg.setPageNo(1);
  		pg.setLastPageNo(lastPageNo);
  		List<NewsInfo> newsInfo=bsi.getNewsByPage(pg);
  		request.setAttribute("pg", pg);
  		request.setAttribute("newsInfo", newsInfo);
  		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
  	}else{
  		response.sendRedirect("index.jsp");
  	}
  %>
  <body>
  </body>
</html>

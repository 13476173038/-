<%@page import="com.dt59.entity.NewsInfo"%>
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
  
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
    	String uname= request.getParameter("name");
    	String upwd= request.getParameter("pwd");
    	UserInfo user=new UserInfo();
    	user.setUsername(uname);
    	user.setPassword(upwd);
    	BizDaoImpl bdi=new BizDaoImpl();
    	BizServiceImpl bsi=new BizServiceImpl();
    	bsi.setBizDao(bdi);
    	boolean flag=bsi.validateUser(user);
    	if(flag){
    		session.setAttribute("uname", uname);
    		session.removeAttribute("error");
    		//session.setMaxInactiveInterval(60*60);
    		List<NewsInfo> listnews= bsi.getNews();
    		request.setAttribute("listnews", listnews);
    		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
    	}else{
    		session.setAttribute("error", "用户名或密码输入错误！");
    		//session.invalidate();让所有session失效
    		//重定向
    		response.sendRedirect("index.jsp");
    	}
     %>
  </body>
</html>

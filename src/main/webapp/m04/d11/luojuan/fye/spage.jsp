<%@page import="java.util.List"%>
<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spage</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String currentpage=request.getParameter("currentpage");
		Page pagee=new Page();
		pagee.setCurrentpage(Integer.parseInt(currentpage));
		BizDaoImpl bdi=new BizDaoImpl();
    	BizServiceImpl bsi=new BizServiceImpl();
    	bsi.setBizDao(bdi);//注入
    	List<NewsInfo> list=bsi.getNewsInfobyPage(pagee);
    	request.setAttribute("pagee", pagee);
    	request.setAttribute("listpage", list);
    	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
    	//String currentpage=request.getParameter("currentpage");
      	int currPageNo=Integer.parseInt(currentpage);
      	if(currPageNo<1){
      	  currPageNo=1;
      	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="neiz.entity.UInfo,neiz.dao.impl.BizDaoImpl,neiz.service.impl.BizServiceImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String uname=request.getParameter("uname");
	String upwd=request.getParameter("upwd");
	UInfo user=new UInfo();
	user.setUsername(uname);
	user.setPassword(upwd);
	BizDaoImpl bdi=new BizDaoImpl();
	//bdi.validateUser(user);
	BizServiceImpl bsi=new BizServiceImpl();
	bsi.setBizdao(bdi);
	boolean flag=bsi.validateUser(user);
	if(flag){
	    session.setAttribute("uname", uname);
	    //session.setMaxInactiveInterval(60*60);
	    request.getRequestDispatcher("admin.jsp").forward(request, response);
	}else{
	    response.sendRedirect("index.jsp");
	}
%>
</body>
</html>
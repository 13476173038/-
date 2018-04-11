<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%   	request.setCharacterEncoding("utf-8");
		//获取用户名
		String uname= request.getParameter("name");
		//获取密码
		String upwd= request.getParameter("pwd");
		//装箱
		UserInfo user=new UserInfo();
		user.setUsername(uname);
		user.setPassword(upwd);
		BizDaoImpl bdi=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bdi);//注入
		if(flag){
	session.setAttribute("uname", uname);
	session.removeAttribute("error");//移除session
	//session.setMaxInactiveInterval(60*60);//设置时间  以秒为单位
	//List<NewsInfo> listnews= bsi.getNews();
	page2.setCurrentpage(1);
	List<NewsInfo> listnews= bsi.getNewsInfoByPage(page2);
	request.setAttribute("page2", page2);
	request.setAttribute("listpage", listnews);
	//转发
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

%>
</body>
</html>
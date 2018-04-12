<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
    	request.setCharacterEncoding("utf-8");
    	String currentpage= request.getParameter("currentpage");
    	Page page2=new Page();
    	page2.setCurrentpage(Integer.parseInt(currentpage));
    	BizDaoImpl bdi=new BizDaoImpl();
    	BizServiceImpl bsi=new BizServiceImpl();
    	bsi.setBizDao(bdi);//注入
    	List<NewsInfo> list= bsi.getNewsInfoByPage(page2);
    	request.setAttribute("page2", page2);
    	request.setAttribute("listpage", list);
    	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
    
     %>
</body>
</html>
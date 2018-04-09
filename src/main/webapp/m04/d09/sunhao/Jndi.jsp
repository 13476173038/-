<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="javax.naming.*" %>
<%    //javax.naming.Context 提供了查找JNDI Resource的接口
  Context ctx=new InitialContext() ;
  //java:comp/env/为前缀
  String testnews=(String)ctx.lookup("java:comp/env/news");
  out.print("test news："+testnews);
%>
</body>
</html>
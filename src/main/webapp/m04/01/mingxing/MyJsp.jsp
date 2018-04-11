<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  <from action="info.jsp" method="post">
    <table>
    <tr>
    <td>用户名</td>
    <td><input type="text" name="userName"></td>
    </tr>
     <tr>
     <td>密码</td>
     <td><input type="password" name="password"></td>
    </tr>
     <tr>
     <td>信息来源</td>
     <td>
     <input type="checkbox" name="channel" value="报刊">报刊
     <input type="checkbox" name="channel" value="黄网">黄网
     <input type="checkbox" name="channel" value="杂志">杂志
     <input type="checkbox" name="channel" value="赌博网站">赌博网站
     </td>
    </tr>
    <tr>
    <td colspan="2">
    <input type="submit" value="提交">
    </td>
    </tr>
    </table>
    </from>
  </body>
</html>

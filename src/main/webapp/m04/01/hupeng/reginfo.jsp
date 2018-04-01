<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%   
    request.setCharacterEncoding("utf-8");
    String name=request.getParameter("name");
    String pwd=request.getParameter("pwd");
    String [] channels=request.getParameterValues("channels");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <div  align="center">
           请输入注册信息
   
     <table  align="center" border="0">
     <tr>
        <td>用户名：</td>
        <td><%=name %> </td>
     </tr>
     <tr>
        <td>密码：</td>
        <td><%=pwd %> </td>
     </tr>
    </table>
   </div>
</body>
</html>
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
        String ntitle=request.getParameter("ntitle");
        String nauthor=request.getParameter("nauthor"); 
        String nsummary=request.getParmeter("nsummary");
%>
    <h2>
                         标题：<%=ntitle %>
   	             作者：<%=nauthor %>
   	             摘要：<%=nsummary %>         
    	文件名：<%=request.getAttribute("filename") %>
    	<br/>
    	文件路径：<%=request.getAttribute("path2") %>
    </h2>
    <img src="upload/<%=request.getAttribute("filename") %>"/>
</body>
</html>
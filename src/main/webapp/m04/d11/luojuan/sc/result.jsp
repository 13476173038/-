<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
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
<title>result.jsp</title>
</head>
<body>
	<%
		SmartUpload su=new SmartUpload();
		su.initialize(super.getServletConfig(), request,response);
		String ok="jpg,png,gif,txt,word";
		String no="exe,rar";
		File upload;
		try{
		    su.setAllowedFilesList(ok);
		    su.setDeniedFilesList(no);
		    su.setMaxFileSize(6*1024*1024);
		    su.setCharset("utf-8");
		    su.upload();
		    upload=su.getFiles().getFile(0);
		    String ppath="upload\\";
		    String filename="";
		    if(!upload.isMissing()){
		        filename=UUID.randomUUID().toString()+".jpg";
		        //filename=upload.getFieldName();
		        ppath+=filename;
		        upload.saveAs(ppath,su.SAVE_VIRTUAL);
		    }
		    request.setAttribute("ppath", ppath);
		    request.setAttribute("filename", filename);
		    request.getRequestDispatcher("show.jsp").forward(request, response);
		}catch(Exception e){
		    e.printStackTrace();
		}
	%>
</body>
</html>
<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
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
    SmartUpload  su=new  SmartUpload();//实例化上传对象
    su.initialize(super.getServletConfig(), request, response);//初始化
    String one="jpg,png";
    String two="exe,rar,jsp";
    File upload;//接收文件夹
    try{
    	su.setAllowedFilesList(one);
    	su.setDeniedFilesList(two);
    	su.setMaxFileSize(5*1024*1024);
    	su.setCharset("utf-8");
    	su.upload();
    	upload=su.getFiles().getFile(0);
    	String path2="upload\\";
    	String filename="";
    	if(!upload.isMissing()){
    		//filename=upload.getFieldName();
    		filename=UUID.randomUUID().toString()+".jpg";
    		path2+=filename;
    		upload.saveAs(path2, su.SAVE_VIRTUAL);
    		
    	}
    	request.setAttribute("path2", path2);
    	request.setAttribute("filename", filename);
    	request.getRequestDispatcher("show.jsp").forward(request, response);
    }catch(Exception e){
    	e.printStackTrace();
    }
    %>
</body>
</html>
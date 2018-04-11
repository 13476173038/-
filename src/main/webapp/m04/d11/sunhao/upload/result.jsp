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
      SmartUpload su=new SmartUpload();//实例化上传对象
	  //初始化  ServletConfing; 请求，响应
	  su.initialize(super.getServletConfig(), request,response);
	  String can="jpg,png,gif,txt";//支持的格式
	  String cant="exe,rar,avi";//不支持的格式
	  File upload; //接收文件流
try{
	  su.setAllowedFilesList(can);
	  su.setDeniedFilesList(cant);
	  su.setMaxFileSize(5*1024*1024);//5M
	  su.setCharset("utf-8");
	  su.upload();
	  upload=su.getFiles().geFile(0);
	  String path2="upload\\";//路径
	  String filename="";//文件名
	  if(!upload.isMissing()){
			//如果文件存在，那么获取文件名
			//filename=upload.getFileName();
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
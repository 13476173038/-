<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.8.3.js"></script>
	<script src="js/json2.js"></script>
	<script>
		$(function(){
			//定义一个json对象
				var person={
					"id":110,
					"name":"鲁直伸",
					"salary":2000
				};
			$("#btn").click(function(){
				var tt="";
				$.ajax({
					url:"ajax",
					type:"POST",
					data:JSON.stringify(person),
					success:function(message){
						//alert(message);
						//alert(message.length);
						var mess=eval("("+message+")");//解析后台的json数组装的是(ArrayList)
						/* for(var i=0;i<mess.length;i++){//json数组
							//alert(mess[i]["id"]+"  "+mess[i]["name"]+"  "+mess[i]["salary"]);
							tt+=mess[i]["id"]+"-"+mess[i]["name"]+"-"+mess[i]["salary"];
						} */
						//alert(mess.length);
						for(var i=0;i<mess.length;i++){
							var mm=mess[i];//相当于java中的get();
							for(var j in mm){//类似于java中forEach
								//alert(j+"  "+mm[j]["id"]+"  "+mm[j]["name"]+"  "+mm[j]["salary"]);
								tt+=mm[j]["id"]+"  "+mm[j]["name"]+"  "+mm[j]["salary"]+"<br/>";
							}
						}
						$("#mydiv").html(tt);
					},
					error:function(){
						alert("error!");
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
   	<input type="button" id="btn" value="异步请求"/><br/>
   	<div id="mydiv" style="font-size:24px;color:red;"></div>
  </body>
</html>

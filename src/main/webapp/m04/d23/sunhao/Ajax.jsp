<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
	display: none
}
</style>
<script>
       var i=0;
	$(function() {
		$("#a").blur(function() {
			var city = $(this).childen[i].val();
			$.ajax({
				url : "ajax",
				type : "POST",
				date : "a=" + a,
				dataType : "text",
				success : function(message) {

					$("#b1").html(message);
				},
				error : function() {

					alert("ajax error!");
				}

			});
		});
	});
</script>


</head>
<body>
	<select id="a">
		<option id="a1">请选择</option>
		<option id="a2">湖北</option>
		<option id="a3">湖南</option>
		<option id="a4">广州</option>
	</select>
	<ul id="b1">
		<li>武汉</li>
		<li>武汉汉</li>
		<li>武汉汉汉</li>
	</ul>
	<ul id="b2">
		<li>长沙</li>
		<li>长沙沙</li>
		<li>长沙沙沙</li>
	</ul>
	<ul id="b3">
		<li>广州</li>
		<li>广州州</li>
		<li>广州州</li>
	</ul>
</body>
</html>
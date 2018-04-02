<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <div  align="center">
           请输入注册信息
   <form action="reginfo.jsp"  >
     <table  align="center" border="0">
     <tr>
        <td>用户名：</td>
        <td><input type="text" name="name"> </td>
     </tr>
     <tr>
        <td>密码：</td>
        <td><input type="password"  name="pwd"> </td>
     </tr>
     <tr>
        <td  align="center"  colspan="2">
           <input  type="submit"  name="Submit"   value="提交">
           <input  type="reset"  name="Reset"  value="取消">          
        </td>       
     </tr>
    </table>
   </form>

   </div>
</body>
</html>
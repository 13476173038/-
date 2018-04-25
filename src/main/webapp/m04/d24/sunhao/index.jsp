<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<span style="font-size: 14px;">var jsontext = '{"firstname":"Jesper","surname":"Aaberg","thirdname":"Mike"}';   
var contact = JSON.parse(jsontext);   
console.log(contact.surname + ", " + contact.firstname+","+contact.thirdname);   
function aa(key,v){   
   if (key===""){   
      return v;   
   }else{   
      var a="";   
      if (key=="firstname"){   
         a = "My"+v;   
         return a;   
      }else if (key=="surname"){   
         return undefined;   
      }else{   
         return null;   
      }   
  }   
}   
var c=JSON.parse(jsontext,aa);   
console.log(c);  
<!-- Aaberg, Jesper,Mike  
Object { firstname="MyJesper", thirdname=null}   -->
</span>  
</body>
</html>
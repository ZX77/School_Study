<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> 第一个Ajax </title>
  </head>
  <script>
  var req ;
  	function createXMLHttpRequest(){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){}
		try{
			return new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){}
		try{
			return new XMLHttpRequest();
		}catch(e){}
		
		alert("XMLHttpRequest 对象创建失败!");
		return null;
	}
  
  	function send(){
  		//构造XMLHttpRequest
  		req = createXMLHttpRequest();
  		alert("ok");
  		req.onreadystatechange=change;
  		req.open("post","${pageContext.request.contextPath}/myservlet",false);
  		req.send(null);
  		
  	}
  	function change(){
  		if(req.readystate==4){
  			if(req.status==200){
	  			var txt = req.responseText;
	  			alert(txt);
  			}
  			
  		}
  	}
  	
  	send();
  </script>
  <body>
   	
  </body>
</html>

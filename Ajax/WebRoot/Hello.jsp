<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Hello.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <script language="javascript">
  	var xmlhttp;
  	function createXMLRequest()
  	{
   		try{
  			return new ActiveXObject("Msxml2.XMLHTTP");
  		}catch(e){};
  		try{
  			return new ActiveXObject("Microsoft.XMLHTTP");
  		}catch(e){};
  		try{
  			return new XMLHttpRequest();
  		}catch(e){};
  		return null;
  	}
  	function send()
  	{
  		str = form1.username.value;
   		xmlhttp = createXMLRequest();
   		xmlhttp.onreadystatechange=change;
  		xmlhttp.open("post","${pageContext.request.contextPath}/Hello",true);
  		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  		xmlhttp.send("username="+str);
  		
   	}
  	function change()
  	{
  		var str;
  		//var msg;
  		//msg = document.getElementById("msg");
  		//alert(msg.innerHTML);
  		
  		if(xmlhttp.readystate==4){
  			msg.innerHTML="Received...";
  			if(xmlhttp.status==200){
   				str = xmlhttp.responseText;
  				msg.innerHTML=str;
  			}
  		}
  		
  		
  	}
  </script>
  <body>
  <form name="form1">
    请输入姓名：<input type="text" name="username" id="username"><input type="button" value="发送" onclick="send();">
    </form>
    <hr color="red">
    <div id="msg">显示在这里。。。</div>
  </body>
</html>

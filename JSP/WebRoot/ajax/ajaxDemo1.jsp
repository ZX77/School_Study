<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AJAX应用</title>
    <script type="text/javascript">
   		var xmlHttpRequest;
    	//创建XMLHttPRequest对象
    	function createXMLHttpRequest(){
    		try{
    			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
    		}catch(e){
    			try{
    				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    			}catch(e){
    				try{
    					xmlHttpRequest = new XMLHttpRequest();
    				}catch(e){
    					alert("游览器不支持XMLHttpRequest对象，创建失败");
    				}
    			}
    		}
    	}
    	//发送数据
    	function send(){
    		createXMLHttpRequest();
    		//提交方法（get|post)
    		var method="post";
    		//发送地址
    		var url="<%=basePath%>ajaxServlet";
    		//参数
    		var param = "num="+document.getElementById('num').value;
    		//绑定回调函数
    		xmlHttpRequest.onreadystatechange=callback;
    		//发送方式（true异步，false同步）
    		//get方式发送请求，数据必须封装在url后面,如果用post方式发送请求，则必须把参数放在send函数内部
    		//url = url +"?"+param;
    		//打开请求
    		xmlHttpRequest.open(method,url,true);
    		//Post方式提交请求时，必须设置头参数
    		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		//发送请求，如果get方式或者没有参数，传null，如果是post方式，并且有参数，则在send函数中必须传参数(键值对)
    		xmlHttpRequest.send(param);
    	}
    	//回调函数
    	function callback(){
    		//传输完成
    		if(xmlHttpRequest.readyState==4){
    			//响应成功
    			if(xmlHttpRequest.status==200){
    				//接收服务器端返回的数据xmlHttpRequest.responseText
    				//显示接收到的内容
    				var msg = xmlHttpRequest.responseText;
    				document.getElementById('msg').innerHTML=msg;
    			}else{
    				//异常
    				alert(xmlHttpRequest.status);
    			}
    		}
    	}
    </script>
	

  </head>
  
  <body>
    <h1>AJAX应用</h1>
    <input type="text" name="num" id="num" value="1">
    <input type="button" value="测试ajax传输数据" onclick="send();">
    <hr color="red"/>
    <p id="msg"></p>
  </body>
</html>

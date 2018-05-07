<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
 <script type="text/javascript">
 	var xmlhttp;
 	function createXmlRequest()
 	{
 		try{
 			return new ActiveXObject("Msxml2.XMLHTTP");
 		}catch(e){};
 		
 		try{
 			return new ActiveXObject("Microsoft.XMLHTTP");
 		}catch(e){};
 			
 		try{
 			return new XmlHttpRequest();
 		}catch(e){};
 		return null;
 	}
 	function send()
 	{
 		xmlhttp=createXmlRequest();
 		xmlhttp.onreadystatechange=change;
 		//xmlhttp.open("get","${pageContext.request.contextPath}/Ajax2.jsp?username=" + escape(form1.username.value),true);
 		xmlhttp.open("post","${pageContext.request.contextPath}/Ajax2.jsp?username=" + form1.username.value,true);
		xmlhttp.setrequestheader("cache-control","no-cache");  
    	xmlhttp.setrequestheader("Content-Type","application/x-www-form-urlencoded"); 
    	xmlhttp.setrequestheader("contentType","text/html;charset=uft-8")//指定发送数据的编码格式 

 		//xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
 		alert("AjaxDemo/Ajax2.jsp?username=" + form1.username.value);
 		xmlhttp.send(null);
 	}
 	function change()
 	{
 		if(xmlhttp.readystate==4){
 			if(xmlhttp.status==200){
  				var str = xmlhttp.responseText;
 				msg.innerHTML = str;
 			}
 			else
 			{
 				msg.innerHTML="欢迎你，" + xmlhttp.statusText;
 			}
 		}
 	}
 </script> 
  <body>
  <form name="form1">
    用户名：<input type="text" name="username"><input type="button" value="发送" onclick="send();">
    <hr color="red">
    <div id="msg">在这里显示</div>
    </form>
  </body>
</html>

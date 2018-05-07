<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DepList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<script>
	var xmlhttp;
	function createXMLHttpRequest()
	{
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){}
 		try{
			return new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){}
		try{
			return new XMLHttpRequest();
		}catch(e){}
		alert("无法创建XMLHTTPRequest对象");
		return null;
	}
	
	createXMLHttpRequest();
	function init()
	{
		xmlhttp = createHttpRequest();
		xmlhttp.onreadystatechange=change;
		xmlhttp.open("post","${pageContext.request.contextPath}/Dep",true);
  		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  		xmlhttp.send("id=1");		
 	}
	function change()
	{
 		if(xmlhttp.readystate==4)
		{
			if(xmlhttp.status==200)
			{
				var depdata = xmlhttp.responseText;
				var arr = depdata.split(";");
				var i,j;
				for(i=0;i<depdata.length;i++)
				{
					var arr1 = depdata[i].split(":");
					var row = myTab.insertRow();
					for(j=0;j<arr1.length;j++)
					{
						var cell = row.insertCell();
						cell.innerHTML=arr1[i];
					}
  				}
			}
		}
	}	
</script>
  
  <body>
    <center>
    <h1>Ajax测试：显示部门资料</h1><input type="button" value="显示" onClick="init();">
    <hr color="red">
    <table id="myTab" border="1" width="200">
    	<tr>
    		<td>部门编号</td>
    		<td>部门名称</td>
    	</tr>
    </table>
    </center>
  </body>
</html>

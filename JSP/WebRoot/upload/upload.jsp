<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 align="center">文件上传</h1>
    <hr/>
    <!-- 
    	文件上传注意事项：
    	1.一定要用表单form;
    	2.method="post",必须用post方法
    	3.enctype="multipart/form-data"
    
     -->
     <%
     	String msg = (String)request.getAttribute("msg");
     	if( msg!=null){
     %>
     	<h1 align="center"><%=msg %></h1>
     	<hr color="red"/>
     <%
     	}
      %>
     <form action="<%=basePath%>uploadServlet" name="form1" enctype="multipart/form-data" method="post">
     
     	请选择要上传的文件：<input type="file" name="file1"><br/>
     	
     	<input type="submit" value="上传">
     </form>
     <hr/>
     <img src="<%=basePath%>uploadfile/<%=request.getAttribute("fileName")%>"/>
  </body>
</html>

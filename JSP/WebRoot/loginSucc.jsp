<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录</title>
    
	
	<meta http-equiv="content-Type" content="text/html;charset=utf-8">
	

  </head>
  
  <body>
    <h1 align="center">登录成功!</h1>
    <a href="login.jsp">重新登录</a>
  </body>
</html>

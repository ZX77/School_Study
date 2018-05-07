<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request对象获取环境变量</title>
    
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
    <h1 align="center">request对象获取环境变量</h1>
    <hr/>
    获取绝对路径getRealPath：<%=request.getRealPath("/T5") %>
    <hr/>
    远程主机地址getRemoteAddr：<%=request.getRemoteAddr() %>
    <hr/>
    远程主机名称getRemoteHost：<%=request.getRemoteHost() %>
    <hr/>
    远程主机端口getRemotePort：<%=request.getRemotePort() %>
    <hr/>
    本地主机地址getLocalAddr：<%=request.getLocalAddr() %>
    <hr/>
    本地主机名称getLocalName：<%=request.getLocalName() %>
    <hr/>
    本地主机端口getLocalPort：<%=request.getLocalPort() %>
    <hr/>
    通信协议getProtocol:<%=request.getProtocol() %>
    <hr/>
    项目名称getContextPath：<%=request.getContextPath() %>
    <hr/>
    协议getScheme：<%=request.getScheme() %>
    <hr/>
    服务器名称getServerName：<%=request.getServerName() %>
    <hr/>
    提交方法getMethod：<%=request.getMethod() %>
   
    <hr/>
	<a href="<%=basePath%>T4/reg.jsp">系统登录</a>    
  </body>
</html>

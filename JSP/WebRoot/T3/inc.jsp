<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jsp:include动作元素</title>
  </head>
  
  <body>
    	<h1 align="center">系统登录</h1>
    	<hr/>
    	<form action="T3/check.jsp" method="post">
    	用户名称：<input type="text" name="username" value="<%=request.getParameter("username") %>"><br/>
    	登录密码：<input type="password" name="password" value="<%=request.getParameter("password") %>"><br/>
    	<input type="submit" value="登录">
    	</form>
  </body>
</html>

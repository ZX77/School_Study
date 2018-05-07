<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="java.io.PrintWriter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>错误页面</title>
  </head>
  
  <body>
    <h1 align="">出错了:</h1>
    <hr color="red"/>
    <!-- 只有在页面指定了isErrorPage=true时，才能使用exception语句 -->
    <%=exception %>
    <pre>
	问题如下：<% exception.printStackTrace(new PrintWriter(out)); %>
	</pre>
  </body>
</html>

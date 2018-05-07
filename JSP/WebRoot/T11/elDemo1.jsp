<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>标准标签库的使用</title>
    
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
    <h1 align="center">标准标签库的使用</h1>
    <hr/>
    <%
    	pageContext.setAttribute("username","pageContext");
    	request.setAttribute("username","request");
    	session.setAttribute("username","session");
    	application.setAttribute("username","application");
    	/*
    		表达式获取变量的值时，顺序:
    		1.pageContext;
    		2.request;
    		3.session;
    		4.application;
    		说明：
    			1.如果不存在同名的变量，则范围可以省略；
    			2.如果存在同名的变量，则必须指明范围（pageScope,requestScope,sessionScope,applicationScope）；
    	*/
    	
     %>
     page范围username的值:${username}<br/>
     request范围username的值:${requestScope.username}<br/>
     session范围username的值:${sessionScope.username}<br/>
     application范围username的值:${applicationScope.username}<br/>
     
     <a href="<%=basePath%>T11/elDemo2.jsp?bookid=1">购买图书</a>
     
  </body>
</html>

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
    
    <title>My JSP 'elDemo2.jsp' starting page</title>
    
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
    图书编号：${param.bookid}<br/>
    图书编号：<%=request.getParameter("bookid") %><br/>
    <hr/>
    <h2 align="center">求1+2+3....+100的和</h2>
    <!-- 
    	set标签：定义变量
    	forEach标签
    		1.begin:初始值;
    		2.end:结束值；
    		3.step:步长
    		4.var:变量名称
     -->
    <c:set var="sum" value="0"></c:set>
    <c:forEach begin="1" end="100" step="1" var="i">
    	<c:set var="sum" value="${sum+i}"></c:set>
    </c:forEach>
    <hr/>
    1+2+3...+100=${sum }
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计网站的访问人数</title>
    
  </head>
  
  <body>
    <h1 align="center">统计网站的访问人数</h1>
    <hr/>
    <jsp:useBean id="counter" scope="application" class="ht.bean.Counter"></jsp:useBean>
    
    
    您好，您是第<jsp:getProperty name="counter" property="count"/>位访问本网站的客人。
  </body>
</html>

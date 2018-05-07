<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getServletValue.jsp' starting page</title>
  </head>
  
  <body>
    <h1 align="center">获取appServlet中定义的变量</h1>
    <hr/>
    servletSession=<%=session.getAttribute("servletSession") %><br/>
    servletApp=<%=application.getAttribute("servletApp") %>
  </body>
</html>

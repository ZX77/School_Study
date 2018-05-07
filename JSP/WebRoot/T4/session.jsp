<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    

  </head>
  
  <body>
   <h1 align="center">获取pageContext,request,session,appliation变量的值</h1>
   <hr/>
     pageContext=<%=pageContext.getAttribute("pageContext") %><hr/>
     request=<%=request.getAttribute("request") %><hr/>
     session=<%=session.getAttribute("session") %><hr/>
     application=<%=application.getAttribute("application") %><hr/>
     <hr/>
     <a href="<%=basePath%>T4/removeAttr.jsp">删除变量</a>
  </body>
</html>

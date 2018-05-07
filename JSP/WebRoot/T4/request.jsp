<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>定义request变量</title>
    
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
    <h1 align="center">定义request变量</h1>
    <hr/>
    <%
    	pageContext.setAttribute("pageContext","pageContextValue");  
		request.setAttribute("request","requestValue"); 
		session.setAttribute("session","sessionValue");
		application.setAttribute("application","applicationValue"); 
     %>
     pageContext=<%=pageContext.getAttribute("pageContext") %><hr/>
     request=<%=request.getAttribute("request") %><hr/>
     session=<%=session.getAttribute("session") %><hr/>
     application=<%=application.getAttribute("application") %><hr/>
    <jsp:forward page="session.jsp"></jsp:forward>
  </body>
</html>

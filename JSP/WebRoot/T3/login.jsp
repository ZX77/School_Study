<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  	<!-- 
  		jsp:include动作元素包含inc.jsp页面
  		指令能自行判断被包含的文件是动态还是静态文件。
		若是静态文件，内容直接加到JSP网页中
		若是动态文件，被包含的文件也会被JSP引擎编译执行(jsp->java->class->html)
		通过jsp:param传递参数
		
		flush="true|false" 默认值是false，不刷新，如果希望页面每次运行都重新读取源文件
		则必须设置为true
		/斜杠代表根路径
  	 -->
    	<%
    		int a=10;
    	 %>

  	<jsp:include page="top.jsp" flush="true"></jsp:include>
    <jsp:include page="/T3/inc.jsp">
    	<jsp:param name="username" value="admin"/>
    	<jsp:param name="password" value="1234"/>
    </jsp:include>
  </body>
</html>

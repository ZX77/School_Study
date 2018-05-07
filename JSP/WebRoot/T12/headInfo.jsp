<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MIME信息</title>
    
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
    <h2>MIME信息</h2>
    <hr/>
    
    <%
    	Enumeration heads= request.getHeaderNames();
    	
    	while(heads.hasMoreElements()){
    	
    		String name = (String)heads.nextElement();//获取头参数名称;
    		//获取参数名称对应的值
    		out.print(name+"="+request.getHeader(name)+"<hr/>");
    	
    	}
     %>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录</title>
    
	
	<meta http-equiv="content-Type" content="text/html;charset=utf-8">
	

  </head>
  
  <body>
  
  	<%
  		//配置成servlet后，通过servlet映射地址运行才能获取到参数，如果通过jsp页面运行是不能获取参数
  		String loginName = config.getInitParameter("loginName");
  		
  	
  	 %>
  	 <%=loginName%>
    <h1 align="center">系统登录</h1>
    <hr color="red"/>
    <form name="form1" method="post" action="./servlet/SecondServlet">
    	用户名称:<input type="text" name="username"><br/>
    	登录密码:<input type="password" name="password"><br/>
    	<input type="submit" value="  登 录  "/>
    
    
    </form>
  </body>
</html>

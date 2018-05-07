<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jsp:include动作元素</title>
  </head>
  
  <body>
  		<%
  			String user="";
  			String pass="";
  			//读取cookie
  			Cookie[] cookies = request.getCookies();
  			if(cookies!=null){
  				for(int i=0;i<cookies.length;i++){
  					//读取username
  					if(cookies[i].getName().equals("username")){
  						//解码操作:URLDecoder.decode()方法
  						user = URLDecoder.decode(cookies[i].getValue());	
  					}
  					//读取密码
  					if(cookies[i].getName().equals("password")){
  						pass = URLDecoder.decode(cookies[i].getValue());
  					}
  				}
  			}
  		 %>
  
    	<h1 align="center">系统登录</h1>
    	<hr/>
    	<form action="T5/check.jsp" method="post">
    	用户名称：<input type="text" name="username" value="<%=user%>"><br/>
    	登录密码：<input type="password" name="password" value="<%=pass %>"><br/>
    	<input type="checkbox" name="cbrememberPwd" value="1">10天以内有效<br/>
    	<input type="submit" value="登录">
    	</form>
    	
    	sessionId=<%=session.getId() %><br/>
    	最大的不活动时间<%=session.getMaxInactiveInterval() %>
    	<br/>
    	最后访问时间：<%=new Date(session.getLastAccessedTime()).toLocaleString() %>
  </body>
</html>

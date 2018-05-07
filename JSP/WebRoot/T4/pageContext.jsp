<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>4个隐含对象的使用</title>

  </head>
  
  <body>
    <%
  		/*
  			1.pageContext:相当与Java中的this，仅在当前页面有效
  			2.request:一个页面发出请求到另一个页面之间（表单的action中指定的页面或者URL中指定页面），然后失效
  			3.session:一个用户持续和服务器所连接的时间，与服务器断线后失效，
  				当前用户(1个用户)所有页面可以访问,默认时间30分钟以内有效
  			4.application:服务器一开始到服务器关闭为止,
  				所有在线用户都可以访问,直到服务器关闭之前都有效
  		*/
  		//定义变量
		pageContext.setAttribute("pageContext","pageContextValue");  
		request.setAttribute("request","requestValue"); 
		session.setAttribute("session","sessionValue");
		application.setAttribute("application","applicationValue"); 
    
     %>
     <!-- 获取变量的值 -->
     pageContext=<%=pageContext.getAttribute("pageContext") %><hr/>
     request=<%=request.getAttribute("request") %><hr/>
     session=<%=session.getAttribute("session") %><hr/>
     application=<%=application.getAttribute("application") %><hr/>
   </body>
</html>

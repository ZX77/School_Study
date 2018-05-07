<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自动刷新页面</title>
  </head>
  
  <body>
    <h1 align="center">自动刷新页面</h1>
    <hr/>
    系统的当前时间是：<%=new Date().toLocaleString() %>
    <hr/>
    <%
    	int count=0;
    	//判断变量是否存在
    	if(application.getAttribute("cnt")==null){
    		//定义application变量
    		application.setAttribute("cnt",1);
    	}else{
    		//获取变量的值
    		count = (Integer)application.getAttribute("cnt");
    		count++;
    		//设置到application中
    		application.setAttribute("cnt",count);
    	}
    	//每隔1秒钟自动刷新一次,单位是秒
		//response.setIntHeader("refresh",1);
		//1秒钟以后跳转到指定的页面,只运行一次
		response.setHeader("refresh","1;URL=setIntHeader.jsp");
     %>
    cnt=<%=count %>
    
  </body>
</html>

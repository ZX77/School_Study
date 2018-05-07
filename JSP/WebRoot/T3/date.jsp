<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" contentType="text/html;charset=utf-8" buffer="10kb"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%
	/*
		page指令一般是页面中的第一条语句
		1.page指令允许出现多次;
		2.import允许出现多次;
		3.session属性只允许出现一次，他的值是true或者false，默认值是true
		4.pageEncoding属性只能出现一次，指定页面的字符集（utf-8,gbk,gb2312）,默认值是ISO-8859-1
		5.contentType属性只能出现一次，指定页面的响应字符集,用得比较少
		6.buffer=8KB,autoFlush=true,一般用默认值，很少改变
		7.language=java,默认为java，目前jsp程序只支持java语言
		8.errorPage=错误页面名称:如果页面报错以后，可以到指定的页面显示错误信息
		9.isErrorPage=true|false,默认是false;
		特别说明;errorPage与isErrorPage属性是互斥，在同一个页面2个属性不允许同时出现
	
	*/
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>page指令的使用方法</title>
    <meta http-equiv="contentType" content="text/html;charset=utf-8">
  </head>
  
  <body>
  	<!-- 
  		使用include指令元素包含其他文件时，会把整个文件的源代码拷贝到指定的定义
  		file属性的值必须是对应的跟路径的绝对路径，不允许使用变量动态生成路径
  		
  	 -->
  	<%@include file="top.jsp" %>
    <h1>page指令的使用方法</h1>
    <hr/>
    系统当前时间:<%=new Date().toLocaleString() %>
    <br/>
    
    <%
    	out.print("页面缓存大小="+out.getBufferSize()+"<br/>");
    	out.print("页面剩余缓存大小="+out.getRemaining()+"<br/>");
    	out.flush();
    	//out.close();
    	//out.print("报错了.............");
    	
     %>
	</body>
</html>

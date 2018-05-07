<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>3中元素的使用方法及区别</title>
  </head>
  
  <body>
   	<h1 align="center">3中元素的使用方法及区别</h1>
   	<hr/>
   	<%!
   		/*
   			1.可以定义变量，变量是在多个线程中共享，相当于静态变量
   			2.只有在该元素中可以声明方法；
   		*/
   		
   		int count=0;
   		
   		void test(){
   			System.out.println("定义方法");
   		}
   		String test2(){
   			return "返回字符串";
   		}
   	 %>
   	 <!-- java代码片段 -->
   	 <%
		count=count+1;
		//定义的变量，他的值不会共享，每次运行都是独立的，从新初始化
		int count2=0;
		
		count2=count2+1;   	
		//调用函数
		test(); 
		
   	  %>
   	 <!-- 显示变量或者表达式的值 -->
   	 count=<%=count %><br/>
   	 count2=<%=count2 %><br/>
   	 <!-- 元素内部以=号开头，只能是一个表达式(可以是简单的变量，也可以是复杂的表达式，必须返回一个值)，结束不能用分号,把结果显示在页面 -->
   	 test2函数的返回值=<%=test2()%>
   	 
   	 <hr/>
   	 <%out.println(test2()); %>
	</body>
</html>

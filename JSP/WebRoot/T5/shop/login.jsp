<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="ht.bean.Book"%>
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
		//系统第一次运行时创建application变量bookmap
		if(application.getAttribute("bookmap")==null){
			Book jsp = new Book(1,"JSP",99,100);
			Book java = new Book(2,"JAVA",199,200);
			Book sql = new Book(3,"SQL2005",88,50);
			Book js = new Book(4,"JavaScript",40,60);
			
			Map<Integer,Book> bookmap = new HashMap<Integer,Book>();
			bookmap.put(jsp.getBookId(),jsp);
			bookmap.put(java.getBookId(),java);
			bookmap.put(sql.getBookId(),sql);
			bookmap.put(js.getBookId(),js);
			application.setAttribute("bookmap",bookmap);
		}
		
	%>

  

  
    	<h1 align="center">系统登录</h1>
    	<hr/>
    	<form action="T5/shop/check.jsp" method="post">
    	用户名称：<input type="text" name="username"><br/>
    	登录密码：<input type="password" name="password"><br/>
    	<input type="submit" value="登录">
    	</form>
    	
  </body>
</html>

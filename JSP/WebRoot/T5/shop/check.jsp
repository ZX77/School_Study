<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("username");
	String pass = request.getParameter("password");
	System.out.println("name="+name);
	System.out.println("pass="+pass);
	if(name!=null && pass!=null){
		//定义session变量
		session.setAttribute("username",name);
		//重定向
		//response.sendRedirect("index.jsp");
%>
		<!-- 
			通过jsp:forward动作元素，转向到指定的页面
			可以通过jsp:param传递参数
			forward动作元素会把上一个页面的request,response对象自动带到转向的页面
			forward转向到行的页面后，地址栏的地址不会改变
		 -->
		<jsp:forward page="index.jsp"/>
<%		
	}
%>			

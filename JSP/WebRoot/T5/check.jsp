<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("username");
	String pass = request.getParameter("password");
	String cbrememberPwd = request.getParameter("cbrememberPwd");
	System.out.println("name="+name);
	System.out.println("pass="+pass);
	if(name!=null && pass!=null){
		//定义session变量
		session.setAttribute("username",name);
		
		if(cbrememberPwd!=null){
			//创建cookie
			//如果cookie的值含有中文，需要进行编码处理,用URLEncoder.encode()方法
			Cookie ckuser = new Cookie("username",URLEncoder.encode(name));
			Cookie ckpass = new Cookie("password",URLEncoder.encode(pass));
			//设置10天内有效期
			ckuser.setMaxAge(24*60*60*10);
			ckpass.setMaxAge(24*60*60*10);
			
			//设置保存路径
			ckuser.setPath(request.getContextPath());
			ckpass.setPath(request.getContextPath());
			
			//response对象保存cookie到游览器
			response.addCookie(ckuser);
			response.addCookie(ckpass);
		}
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

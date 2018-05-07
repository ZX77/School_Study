<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//删除指定的变量
	session.removeAttribute("username");
	//使所有session变量全部失效;
	session.invalidate();
	//清空cookie
	Cookie[] cookies = request.getCookies();
	Cookie user = null,pass=null;
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			//读取username
			if(cookies[i].getName().equals("username")){
				user = cookies[i];
			}
			//读取密码
			if(cookies[i].getName().equals("password")){
				pass = cookies[i];
			}
		}
		//设置cookie立即失效
		user.setMaxAge(0);
		pass.setMaxAge(0);
		//保存
		response.addCookie(user);
		response.addCookie(pass);
	}
	
	//重定向，回到登录页面
	response.sendRedirect("login.jsp");

%>
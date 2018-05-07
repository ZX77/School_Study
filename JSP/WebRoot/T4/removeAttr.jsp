<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.removeAttribute("request");
	session.removeAttribute("session");
	application.removeAttribute("application");
	
%>
<jsp:forward page="session.jsp"/>
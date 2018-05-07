<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String str=request.getParameter("username");
	//str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
	System.out.println(str);
	 str = java.net.URLDecoder.decode(str, "UTF-8"); 
	
	System.out.println("aaaaaaaaaaaa="+str);
	out.print("欢迎你，"+str);
 %>

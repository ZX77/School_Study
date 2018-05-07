<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//获取登录名称
	String name = request.getParameter("username");
 %>
 <h3>恭喜您登陆成功，您是：<%=name%></h3>
 <hr color="red"/>

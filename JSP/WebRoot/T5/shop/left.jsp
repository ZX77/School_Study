<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table width="100%" align="center" bgcolor="pink" height="450">
	<tr><td><a href="#">登录</a></td></tr>
	<tr><td><a href="<%=basePath%>T5/shop/bookinfo.jsp" target="mainFrame">查看图书信息</a></td></tr>
	<tr><td><a href="<%=basePath%>T5/shop/balance.jsp" target="mainFrame">我的购物车</a></td></tr>
</table>

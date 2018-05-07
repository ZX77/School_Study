<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//乱码处理
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String pwd = request.getParameter("pwd");
	String sex = request.getParameter("sex");
	//兴趣爱好是多选框，getParameterValues获取多个选中的值，返回是字符串数组
	String[] hobbit = request.getParameterValues("hobbit");
	String action = request.getParameter("action");
%>
username=<%=username%>
<hr/>
pwd=<%=pwd%>
<hr/>
sex=<%=sex%>
<hr/>
hobbit=

<%
	for(int i=0;i<hobbit.length;i++){
		out.println(hobbit[i]+",");
	}
%>
<hr/>
action=<%=action%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("username");
	String pass = request.getParameter("password");
	
	if(name!=null && pass!=null){
		if(name.equals("admin") && pass.equals("1234")){
%>
		<!-- 
			通过jsp:forward动作元素，转向到指定的页面
			可以通过jsp:param传递参数
		 -->
		<jsp:forward page="succ.jsp">
			<jsp:param name="aaaa" value="<%=name%>"/>	
		</jsp:forward>
<%		
		}
	}
%>
		<jsp:forward page="failed.jsp">
			<jsp:param name="bbbb" value="<%=name%>"/>	
		</jsp:forward>

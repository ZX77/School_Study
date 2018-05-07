<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//获取登录名称
	String name = (String)session.getAttribute("username");
 %>
 <table width="100%">
 	<tr>
 		<td><h3>恭喜您登陆成功，您是：<%=name%></h3></td>
 		<td align="right"><a href="T5/exit.jsp">安全退出</a></td>
 	</tr>
 </table>
 
 
 <hr color="red"/>

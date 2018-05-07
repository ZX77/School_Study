<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
  </head>
  
  <body>
    <table width="100%" border="0">
    	<tr>
    		<td colspan="2">
    			<jsp:include page="top.jsp" flush="true"></jsp:include>
    		</td>
    	</tr>
    	<tr height="500">
    		<td valign="top"><jsp:include page="left.jsp" flush="true"/> </td>
    		<td><jsp:include page="main.jsp" flush="true"/></td>
    	</tr>
    </table>
  </body>
</html>

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
  <%
  		if(session.getAttribute("username")==null){
  			response.sendRedirect("login.jsp");
  		}
   %>
  <body>
    <table width="100%" border="0" height="500px">
    	<tr height="50">
    		<td colspan="2">
    			<jsp:include page="top.jsp" flush="true"></jsp:include>
    		</td>
    	</tr>
    	<tr height="450px">
    		<td valign="top" width="200px"><jsp:include page="left.jsp" flush="true"/> </td>
    		<td>
				<iframe name="mainFrame" src="" frameborder="0" scrolling="no" height="450px" width="1100"></iframe>
			</td>
    	</tr>
    </table>
  </body>
</html>

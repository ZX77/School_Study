<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript">
	  	function s(){
			var c = window.document.body.scrollHeight;
			window.scroll(0,c); 
		}
  </script>
  </head>
  
  <body onload="s();">
    <%=application.getAttribute(session.getAttribute("username").toString()) %>
    <%
    	response.setIntHeader("refresh",2);
     %>
  </body>
</html>

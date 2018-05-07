<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>打招呼</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			if(form1.youName.value==""){
				alert("请输入您的名称");
				form1.youName.focus();
			}else{
				//提交
				form1.submit();
				//document.form1.submit();
				//document.all.form1.submit();
			}
		
		}
	</script>
  </head>
  
  <body>
    <form name="form1" method="post" action="<%=basePath%>T6/job/testB.jsp">
    	请输入您的姓名：<input type="text" name="youName">
    	<input type="button" value=" 进 入 " onclick="check();">
    </form>
  </body>
</html>

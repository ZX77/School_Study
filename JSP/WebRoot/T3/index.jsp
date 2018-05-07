<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我的第一个JSP网页文件</title>
  </head>
  
  <body>
    <H1>九九乘法表</H1>
    <hr color="red"/>
    <table border="1" align="center" width="600">
    <%
    	int i,j;
    	for(i=1;i<=9;i++){
    %>
    	<tr>
    	<%
    		for(j=1;j<=i;j++){
		%>
			<td><%=j %>*<%=i %>=<%=i*j %></td>
		<%
    		}
    	%>
    	</tr>
    <%
    	}
	%>
    
    </table>
    
    
    
    <hr color="red"/>
    <table border="1" align="center" width="600">
    <%
    	for(i=1;i<=9;i++){
    		out.print("<tr>");
    		for(j=1;j<=i;j++){
				out.println("<td>"+j+"*"+i+"="+(i*j)+"</td>");
    		}
    		out.print("</tr>");
    		System.out.println("打印在后台的调试信息");
    	}
	%>
    
    </table>
  </body>
</html>

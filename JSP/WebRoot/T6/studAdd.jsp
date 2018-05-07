<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册学生资料</title>
    
  </head>
  
  <body>
    <h1 align="center">注册学生资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>T6/studSave.jsp" method="post" onsubmit="">
    	<table width="800" align="center" border="1">
    		<tr>
    			<td align="right">学号</td>
    			<td><input type="text" name="studid"></td>
    		</tr>
    		<tr>
    			<td align="right">姓名</td>
    			<td><input type="text" name="studName"></td>
    		</tr>
    		<tr>
    			<td align="right">年龄</td>
    			<td><input type="text" name="age"></td>
    		</tr>
    		<tr>
    			<td align="right">性别</td>
    			<td>
	    			<input type="radio" name="sex" value="男" checked="checked">男
	    			<input type="radio" name="sex" value="女">女
    			</td>
    		</tr>
    		<tr>
    			<td align="right">婚姻状况</td>
    			<td>
	    			<input type="radio" name="marray" value="true" checked="checked">已婚
	    			<input type="radio" name="marray" value="false">未婚
    			</td>
    		</tr>
    		<tr>
    			<td align="right">兴趣爱好</td>
    			<td>
	    			<input type="checkbox" name="hobbit" value="篮球">篮球
	    			<input type="checkbox" name="hobbit" value="足球">足球
	    			<input type="checkbox" name="hobbit" value="羽毛球">羽毛球
	    			<input type="checkbox" name="hobbit" value="乒乓球">乒乓球
	    			<input type="checkbox" name="hobbit" value="网球">网球
    			</td>
    		</tr>
    		<tr height="40">
    			<td colspan="2" align="center"><Input type="submit" value=" 保 存 "></td>
    		</tr>
    	</table>
    
    
    </form>
  </body>
</html>

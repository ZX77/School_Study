<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增用户资料</title>
	    <script type="text/javascript">
	    	function check(){
	    		if(form1.userName.value==""){
	    			alert("请输入用户名称");
	    			form1.userName.focus();
	    			return false;
	    		}
	    		if(form1.password.value==""){
	    			alert("请输入密码");
	    			form1.password.focus();
	    			return false;
	    		}
	    		if(form1.password.value!=form1.password1.value){
	    			alert("登录密码与确认密码不一致");
	    			form1.password1.focus();
	    			return false;
	    		}
	    		return true;
	    	}
	    </script>
  </head>
  
  <body>
    <h2 align="center">新增用户资料</h2>
    <hr/>
    <form action="${pageContext.request.contextPath}/userServlet?action=add" method="post" name="form1" onsubmit="return check();">
    	<input type="hidden" name="username" value="${username}">
    	<table border="0" height="330">
    		<tr>
    			<td align="right" width="200">用户名称：</td>
    			<td>${username}</td>
    		</tr>
    		<tr>
    			<td align="right">登录密码：</td>
    			<td><input type="password" name="password" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">确认密码：</td>
    			<td><input type="password" name="password1" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">所属部门：</td>
    			<td>
    				<select name="depid"  style="width:300px">
    					<c:forEach items="${depList}" var="d">
    						<option value="${d.depid}">${d.depName}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">职务名称：</td>
    			<td><input type="text" name="jobname" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">联系电话：</td>
    			<td><input type="text" name="mobile" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">邮箱地址：</td>
    			<td><input type="text" name="email" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">QQ号码：</td>
    			<td><input type="text" name="qqcode" style="width:300px"></td>
    		</tr>
    		<tr>
    			<td align="right">家庭地址：</td>
    			<td><input type="text" name="addr" style="width:400px"></td>
    		</tr>
    		<tr>
    			<td align="right">备注：</td>
    			<td><input type="text" name="remark" style="width:400px"></td>
    		</tr>
    		<tr>
    			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
    		</tr>
    		
    	</table>
    
    </form>
    
  </body>
</html>

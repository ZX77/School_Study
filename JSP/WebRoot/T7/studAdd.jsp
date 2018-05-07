<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新增学生资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.studname.value==""){
    			alert("请输入学生姓名");
    			form1.studname.focus();
    			return false;
    		}
    		if(form1.studage.value==""){
    			alert("请输入年龄");
    			form1.studage.focus();
    			return false;
    		}
    		var age = form1.studage.value;
    		if(isNaN(age)){
    			alert("年龄必须为0~9之间的字符");
    			form1.studage.focus();
    			return false;
    		}
    		if(parseInt(age)<=0 || parseInt(age)>150){
    			alert("年龄必须在1~150之间");
    			form1.studage.focus();
    			return false;
    		}
			return true;    	
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">新增学生资料</h1>
    <hr/>
    <form action="<%=basePath%>studServlet?action=add" method="post" name="form1" onsubmit="return check();">
    	<table border="1" align="center" width="800">
    		<tr>
    			<td align="right">学生姓名：</td>
    			<td><input type="text" name="studname"></td>
    		</tr>
    		<tr>
    			<td align="right">学生年龄：</td>
    			<td><input type="text" name="studage"></td>
    		</tr>
    		<tr>
    			<td align="right">学生性别：</td>
    			<td>
    				<input type="radio" name="sex" value="男" checked>男
    				<input type="radio" name="sex" value="女">女
    			</td>
    		</tr>
    		<tr>
    			<td align="right">兴趣爱好：</td>
    			<td><input type="text" name="hobbit"></td>
    		</tr>
    		<tr>
    			<td align="right">所学专业：</td>
    			<td><input type="text" name="majorname"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit"  value=" 保 存 "></td>
    		</tr>
    	
    	</table>
    
    </form>
  </body>
</html>

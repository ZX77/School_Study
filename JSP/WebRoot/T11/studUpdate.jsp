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
    <title>修改学生资料</title>
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
    <h1 align="center">修改学生资料</h1>
    <hr/>
    <form action="<%=basePath%>elServlet?action=updateSave" method="post" name="form1" onsubmit="return check();">
    	<input type="hidden" name="studid" value="${stud.studid }">
    	<table border="1" align="center" width="800">
    		<tr>
    			<td align="right">学生姓名：</td>
    			<td><input type="text" name="studname" value="${stud.studName }" ></td>
    		</tr>
    		<tr>
    			<td align="right">学生年龄：</td>
    			<td><input type="text" name="studage" value="${stud.age }"></td>
    		</tr>
    		<tr>
    			<td align="right">学生性别：</td>
    			<td>
    				<c:if test="${stud.sex eq '男'}">
	    				<input type="radio" name="sex" value="男" checked>男
	    				<input type="radio" name="sex" value="女">女
    				</c:if>
    				<c:if test="${stud.sex eq '女'}">
	    				<input type="radio" name="sex" value="男">男
	    				<input type="radio" name="sex" value="女" checked>女
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">兴趣爱好：</td>
    			<td><input type="text" name="hobbit" value="${stud.hobbit }"></td>
    		</tr>
    		<tr>
    			<td align="right">所学专业：</td>
    			<td><input type="text" name="majorname" value="${stud.majorName}"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit"  value=" 保 存 "></td>
    		</tr>
    	
    	</table>
    	<!-- 
    		set标签可以修改javabean的值
    		target:request变量名称
    		property:javabean的属性名称
    		value:值
    	 -->
    <c:set target="${stud}" property="studName" value="错错错"></c:set>
    set标签修改了学生姓名：${stud.studName }
    </form>
  </body>
</html>

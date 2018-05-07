<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.username.value==""){
    			alert("请输入用户名称");
    			form1.username.focus();
    			return false;
    		}
    		if(form1.pwd.value==""){
    			alert("密码不能为空");
    			form1.pwd.focus();
    			return false;
    		}
    		return true;
    	}
    </script>

  </head>
  
  <body>
    <h1 align="center">用户注册</h1>
    <hr/>
    <form name="form1" action="T4/regSave.jsp?action=add" method="post" onsubmit="return check();">
    	用户名称：<input type="text" name="username"><br/>
    	登录密码：<input type="password" name="pwd"><br/>
    	性别：<input type="radio" name="sex" value="男" checked>男
    		<input type="radio" name="sex" value="女">女<br/>
    	兴趣爱好：<input type="checkbox" name="hobbit" value="篮球">篮球
    	<input type="checkbox" name="hobbit" value="足球">足球
    	<input type="checkbox" name="hobbit" value="羽毛球">羽毛球
    	<input type="checkbox" name="hobbit" value="上网">上网
    	<input type="checkbox" name="hobbit" value="玩游戏">玩游戏
    	<input type="checkbox" name="hobbit" value="听歌">听歌
    	<input type="checkbox" name="hobbit" value="旅游">旅游<br/>
    	
    	<input type="submit" value="保存">
    </form>
    
  </body>
</html>

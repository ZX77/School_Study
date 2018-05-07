<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>迷你聊天室</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.nickname.value==""){
    			alert("请输入昵称");
    			form1.nickname.focus();
    			return false;
    		}
			return true;    	
    	
    	}
    </script>

  </head>
  
  <body>
  	<!-- 登录 -->
  	<%
  		//乱码处理
  		request.setCharacterEncoding("utf-8");
  		//获取昵称
  		String nickname = request.getParameter("nickname");
  		if(nickname!=null && !nickname.equals("")){
  			//定义一个代表自己的session
  			session.setAttribute("username",nickname);
  			//定义application保存所有在线用户的信息
  			List allUsers = (List)application.getAttribute("allUsers");
  			//如果是第一个登录的用户，application为null
  			if(allUsers==null){
  				allUsers = new ArrayList();
  			}
  			//控制人数不能超过50人
  			if(allUsers.size()>=50){
				%>
					<h1 align="center">人数超过上限，请稍后再试！</h1>
				<%  			
  			}else{
				allUsers.add(nickname);
				application.setAttribute("allUsers",allUsers);
				//定义显示聊天内容的application变量
				String str = "欢迎【"+nickname+"】进入迷你聊天室<br/>";
				String chatContent = (String)application.getAttribute(nickname);
				application.setAttribute(nickname,str);
			}
			response.sendRedirect("main.html");
  		}
  	 %>
    <br/><br/><br/><br/><br/><br/><br/><br/>
    <h2 align="center"><font color="blue"><i>欢迎进入迷你聊天室</i></font></h2>
    <hr color="red"/>
    <br/><br/>
    <center>
    	<form name="form1" method="post" action="<%=basePath%>chat/login.jsp" onsubmit="return check();">
    		请输入昵称:<input type="text" name="nickname">
    		<input type="submit" value="进入">
    	
    	</form>
    </center>
  </body>
</html>

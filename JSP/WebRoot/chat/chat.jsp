<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
  	<%
  		//乱码处理
  		request.setCharacterEncoding("utf-8");
  		String face = request.getParameter("face");
  		String who = request.getParameter("who");
  		String fontname = request.getParameter("fontname");
  		String fontcolor = request.getParameter("fontcolor");
  		String fontsize = request.getParameter("fontsize");
  		String chatmsg = request.getParameter("chatMsg");
  		//点击发送按钮后才能进入
  		if(face!=null){
  			String str="<font name='"+fontname+"' color='"+fontcolor+"' size='"+fontsize+"'>";
  			str+="【"+session.getAttribute("username")+"】"+face+"的对";
  			//对所有人说
  			if(who.equals("all")){
  				str += "【所有人】说:"+chatmsg+"</font><br/>";
  				//获取所有用户
  				List allUsers = (List)application.getAttribute("allUsers");
  				for(int i=0;i<allUsers.size();i++){
  					//获取该用户的历史聊天内容
  					String msg = application.getAttribute(allUsers.get(i)+"").toString();
  					msg += str;
  					application.setAttribute(allUsers.get(i)+"",msg);
  				}
  			}else{
  				str += "【"+who+"】说:"+chatmsg+"</font><br/>";
  				String msg = application.getAttribute(who).toString();
				msg += str;
				application.setAttribute(who,msg);
				
				//发送给自己
				msg = application.getAttribute(session.getAttribute("username").toString()).toString();
				msg += str;
				application.setAttribute(session.getAttribute("username").toString(),msg);
  			}
  		}
  	
  	 %>
  
    <form action="<%=basePath%>chat/chat.jsp" method="post">
    	<select name="face" style="width:100px">
    		<option value="神采奕奕">神采奕奕</option>
    		<option value="悲伤">悲伤</option>
    	</select>
    	<select name="who" style="width:100px">
    		<option value="all">所有人</option>
    		<%
	    		List allUsers = (List)application.getAttribute("allUsers");
		    	String user="";
	    		for(int i=0;i<allUsers.size();i++){
	    			user = allUsers.get(i).toString();
	    			if(!user.equals(session.getAttribute("username"))){
		    		%>
						<option value="<%=user%>"><%=user%></option>   		
		    		<%
		    		}
	    		}
	    	 %>
    	</select>
    	<select name="fontname" style="width:100px">
    		<option value="宋体">宋体</option>
    		<option value="黑体">黑体</option>
    		<option value="隶书">隶书</option>
    	</select>
    	<select name="fontcolor" style="width:100px">
    		<option value="red">红色</option>
    		<option value="blue">蓝色</option>
    		<option value="green">绿色</option>
    		<option value="yellow">黄色</option>
    	</select>
    	<select name="fontsize" style="width:100px">
    		<option value="2">2号字</option>
    		<option value="3">3号字</option>
    		<option value="4">4号字</option>
    		<option value="5">5号字</option>
    		<option value="6">6号字</option>
    		<option value="7">7号字</option>
    	</select><br/>
    	<textarea name="chatMsg" style="width:1100px;height:80px">请输入聊天内容</textarea><br/>
    	<input type="submit" value=" 发 送 ">
    </form>
    
    
  </body>
</html>

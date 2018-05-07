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
    <h3>当前用户</h3>
    <b><font color="red"><%=session.getAttribute("username") %></font></b>
    <hr/>
    <%
    	List allUsers = (List)application.getAttribute("allUsers");
    	String user="";
    	if(allUsers!=null){
    		for(int i=0;i<allUsers.size();i++){
    			user = allUsers.get(i).toString();
    			if(!user.equals(session.getAttribute("username"))){
	    		%>
					<%=user%><hr/>    		
	    		<%
	    		}
    		}
    	}
    	response.setIntHeader("refresh",5);
     %>
    
    
  </body>
</html>

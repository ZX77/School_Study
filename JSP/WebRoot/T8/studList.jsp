<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ht.bean.StudVo"%>
<%@page import="ht.bean.PageObject"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生资料列表</title>
    <script type="text/javascript">
    	function del(){
    		if(confirm('删除确认')){
    			return true
    		}else{
    			return false
    		};
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">学生资料列表</h1>
    <hr color="red"/>
    <%
    	//获取分页参数，该pager参数是在pageServlet中定义的
    	PageObject pager  = (PageObject)request.getAttribute("pager");
     %>
    <table border="0" width="800" align="center">
    	<tr>
    		<td><a href="<%=basePath%>T8/studAdd.jsp">新增</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=first&curPage=1">首页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=piror&curPage=<%=pager.getCurPage()%>">上一页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=next&curPage=<%=pager.getCurPage()%>">下一页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=last&curPage=<%=pager.getPageCount()%>">末页</a></td>
    		<td>当前页：<%=pager.getCurPage() %>/<%=pager.getPageCount() %></td>
    		<td>记录总数：<%=pager.getRowCount() %></td>
    	</tr>
    </table>
    <table border="1" width="800" align="center">
    	<thead>
    		<tr>
    			<th>学号</th>
    			<th>姓名</th>
    			<th>年龄</th>
    			<th>性别</th>
    			<th>爱好</th>
    			<th>专业</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    	<%
    		//获取servlet中定义的request变量
    		List<StudVo> studList = (List<StudVo>)request.getAttribute("studList");
    		if(studList!=null && studList.size()>0){
    			for(int i=0;i<studList.size();i++){
    				StudVo s = studList.get(i);
    	 %>
    		<tr>
    			<td align="center"><%=s.getStudid() %></td>
    			<td align="center"><%=s.getStudName() %></td>
    			<td align="center"><%=s.getAge() %></td>
    			<td align="center"><%=s.getSex() %></td>
    			<td align="center"><%=s.getHobbit() %></td>
    			<td align="center"><%=s.getMajorName() %></td>
    			<td align="center" width="120"><a href="<%=basePath%>pageServlet?studid=<%=s.getStudid()%>&action=update">修改</a>&nbsp;&nbsp;<a href="<%=basePath%>pageServlet?studid=<%=s.getStudid()%>&action=del" onclick="return del();">删除</a></td>
    		</tr>
    	<%	}
    	} %>
    	</tbody>
    </table>
    <table border="0" width="800" align="center">
    	<tr>
    		<td><a href="<%=basePath%>T8/studAdd.jsp">新增</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=first&curPage=1">首页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=piror&curPage=<%=pager.getCurPage()%>">上一页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=next&curPage=<%=pager.getCurPage()%>">下一页</a></td>
    		<td><a href="<%=basePath%>pageServlet?opr=last&curPage=<%=pager.getPageCount()%>">末页</a></td>
    		<td>当前页：<%=pager.getCurPage() %>/<%=pager.getPageCount() %></td>
    		<td>记录总数：<%=pager.getRowCount() %></td>
    	</tr>
    </table>
    
  </body>
</html>

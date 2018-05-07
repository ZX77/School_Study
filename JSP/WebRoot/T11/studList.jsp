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
    <table border="0" width="800" align="center">
    	<tr>
    		<td><a href="<%=basePath%>T11/studAdd.jsp">新增</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=first&curPage=1">首页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=piror&curPage=${pager.curPage}">上一页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=next&curPage=${pager.curPage}">下一页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=last&curPage=${pager.pageCount}">末页</a></td>
    		<td>当前页：${pager.curPage}/${pager.pageCount}</td>
    		<td>记录总数：${pager.rowCount}</td>
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
    	<!--  
    		items:对应的page,request,session,application对象定义的变量名称（集合变量）
    		var:变量名称，对应集合中的当前元素
    	-->
    	 <c:forEach items="${studList}" var="d">
    		<tr>
    			<td align="center">${d.studid }</td>
    			<td align="center">${d.studName }</td>
    			<td align="center">${d.age }</td>
    			<td align="center">${d.sex }</td>
    			<td align="center">${d.hobbit }</td>
    			<td align="center">${d.majorName }</td>
    			<td align="center" width="120"><a href="<%=basePath%>elServlet?studid=${d.studid }&action=update">修改</a>&nbsp;&nbsp;<a href="<%=basePath%>elServlet?studid=${d.studid }&action=del" onclick="return del();">删除</a></td>
    		</tr>
    	</c:forEach>
    	</tbody>
    </table>
    <table border="0" width="800" align="center">
    	<tr>
    		<td><a href="<%=basePath%>T11/studAdd.jsp">新增</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=first&curPage=1">首页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=piror&curPage=${pager.curPage}">上一页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=next&curPage=${pager.curPage}">下一页</a></td>
    		<td><a href="<%=basePath%>elServlet?opr=last&curPage=${pager.pageCount}">末页</a></td>
    		<td>当前页：${pager.curPage}/${pager.pageCount}</td>
    		<td>记录总数：${pager.rowCount}</td>
    	</tr>
    </table>
    
  </body>
</html>

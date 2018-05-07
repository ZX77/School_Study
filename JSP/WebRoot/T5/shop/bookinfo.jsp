<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ht.bean.Book"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书信息</title>
    
  </head>
  
  <body>
    	<h1 align="center">图书库存信息</h1>
    	<hr/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="600px">
    		<tr>
    			<th>图书编号</th>
    			<th>图书名称</th>
    			<th>销售价格</th>
    			<th>库存数量</th>
    			<th>操作</th>
    		</tr>
    		<%
				//读取application的值
				Map<Integer,Book> bookmap = (Map<Integer,Book>)application.getAttribute("bookmap");
				Set set = bookmap.keySet();
				Iterator<Integer> it = set.iterator();
				Book book=null;
				while(it.hasNext()){
					book = bookmap.get(it.next());
    		 %>
    		 	<tr>
    		 		<td><%=book.getBookId()%></td>
    		 		<td><%=book.getBookName()%></td>
    		 		<td><%=book.getPrice()%></td>
    		 		<td><%=book.getCount()%></td>
    		 		<td><a href="<%=basePath%>T5/shop/buy.jsp?bookId=<%=book.getBookId()%>">加入购物车</a></td>
    		 	</tr>
    		 
    		 <%} %>
    	</table>
    
    
  </body>
</html>

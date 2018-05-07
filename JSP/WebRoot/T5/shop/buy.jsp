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
    <title>My JSP 'buy.jsp' starting page</title>
  </head>
  
  <body>
  	<%
  		//读取地址栏参数
  		int bookid = Integer.parseInt(request.getParameter("bookId").trim());
		//读取application的值
		Map<Integer,Book> bookmap = (Map<Integer,Book>)application.getAttribute("bookmap");
		//获取在图书库存页面选中的图书
		Book book = bookmap.get(bookid);
  	
  	 %>
    <h1 align="center">当前您选择的图书是《<%=book.getBookName()%>》</h1>
    <hr/>
    <form action="<%=basePath%>T5/shop/buySave.jsp">
    <input type="hidden" name="bookId" value="<%=book.getBookId() %>">
	    <table border="1" width="400" align="center">
	    	<tr>
	    		<td align="right">图书编号</td>
	    		<td><%=book.getBookId()%></td>
	    	</tr>
	    	<tr>
	    		<td align="right">图书名称</td>
	    		<td><%=book.getBookName()%></td>
	    	</tr>
	    	<tr>
	    		<td align="right">销售价格</td>
	    		<td><%=book.getPrice()%></td>
	    	</tr>
	    	<tr>
	    		<td align="right">库存数量</td>
	    		<td><%=book.getCount()%></td>
	    	</tr>
	    	<tr>
	    		<td align="right">购买数量</td>
	    		<td><input type="text" name="buyCnt" value="1"></td>
	    	</tr>
	    	<tr>
	    		<td align="center" colspan="2"><input type="submit" value="  购 买  "></td>
	    	</tr>
	    </table>
    </form>
    
    
  </body>
</html>

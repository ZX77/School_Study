<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ht.bean.Car"%>
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
    	<h1 align="center">购物车信息</h1>
    	<hr/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="600px">
    		<tr>
    			<th>图书编号</th>
    			<th>图书名称</th>
    			<th>销售价格</th>
    			<th>购买数量</th>
    			<th>小计</th>
    		</tr>
    		<%
    			int totalmoney=0;
				//读取application的值
				Map<Integer,Car> carmap = (Map<Integer,Car>)session.getAttribute("carmap");
				Set set = carmap.keySet();
				Iterator<Integer> it = set.iterator();
				Car car=null;
				while(it.hasNext()){
					car = carmap.get(it.next());
					totalmoney += car.getPrice()*car.getCount();
    		 %>
    		 	<tr>
    		 		<td><%=car.getBookId()%></td>
    		 		<td><%=car.getBookName()%></td>
    		 		<td><%=car.getPrice()%></td>
    		 		<td><%=car.getCount()%></td>
    		 		<td><%=car.getPrice()*car.getCount() %></td>
    		 	</tr>
    		 
    		 <%} %>
    	</table>
    	<hr/>
    	总金额：<%=totalmoney %>
  </body>
</html>

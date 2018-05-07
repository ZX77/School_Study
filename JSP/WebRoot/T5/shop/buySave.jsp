<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ht.bean.Book"%>
<%@page import="ht.bean.Car"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.setCharacterEncoding("utf-8");
	//读取application的值
	Map<Integer,Book> bookmap = (Map<Integer,Book>)application.getAttribute("bookmap");
	//读取购买的图书编号
	//buy.jsp页面中隐藏控件的名称bookId
	int bookid = Integer.parseInt(request.getParameter("bookId"));
	//buy.jsp页面中文本控件的名称buyCnt
	int cnt = Integer.parseInt(request.getParameter("buyCnt"));
	//取出application中改书的数据
	Book book = bookmap.get(bookid);
	//修改图书的库存数据
	book.setCount(book.getCount()-cnt);
	bookmap.put(book.getBookId(),book);
	//重新保存到application中
	application.setAttribute("bookmap",bookmap);
	Car car = new Car(bookid,book.getBookName(),book.getPrice(),cnt);
	//carmap表示当前用户购买的图书信息
	if(session.getAttribute("carmap")==null){
		Map<Integer,Car> carmap = new HashMap<Integer,Car>(); 
		carmap.put(car.getBookId(),car);
		session.setAttribute("carmap",carmap);
	}else{
		Map<Integer,Car> carmap = (Map<Integer,Car>)session.getAttribute("carmap"); 
		//判断以前是否买过该图书
		Car c = carmap.get(car.getBookId());
		if(c!=null){
			car.setCount(car.getCount()+c.getCount());
		}
		carmap.put(car.getBookId(),car);
		session.setAttribute("carmap",carmap);
	}
	//到结账显示结果
	response.sendRedirect("balance.jsp");

%>
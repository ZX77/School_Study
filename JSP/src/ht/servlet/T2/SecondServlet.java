package ht.servlet.T2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	String driver;
	String url;
	String username;
	String password;
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		//读取web.xml中配置的初始化参数
		driver=config.getInitParameter("driver");
		url=config.getInitParameter("url");
		username=config.getInitParameter("username");
		password=config.getInitParameter("password");
		System.out.println("driver="+driver);
		System.out.println("url="+url);
		System.out.println("username="+username);
		System.out.println("password="+password);
		
	}
	//点击超级链接、地址栏地址都是运行该方法（没有指明method=post的情况下，通通运行该函数），
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置页面的字符编码为utf-8字符集
		response.setContentType("text/html;charset=utf-8");
		//创建out对象
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	//一定要从页面的表单提交，并且method=post方法才能进入该函数
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//处理中文乱码
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost方法接收到请求...");
		//获取页面提交的数据
		//username是页面用户名称对应的控件名称
		String user = request.getParameter("username");
		//password是页面用户名称对应的控件名称
		String pass = request.getParameter("password");
		
		System.out.println("username="+user+",password="+pass);
		
		//从servlet内部重定向到页面
		response.sendRedirect("/JSP2017/loginSucc.jsp");
		
		
	}

}

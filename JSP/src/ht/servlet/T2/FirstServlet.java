package ht.servlet.T2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 手动创建servlet的步骤:
 * 	1.创建一个普通的类
 * 	2.继承HttpServlet类
 * 	3.重写init,doGet,doPost,destory等方法
 * 	4.在WebRoot/WEB-INF/web.xml文件中配置servlet
 * 
 * <servlet>
		<description>配置servlet</description>
		<!-- servlet-name可以用servlet类的名称，也可以自定义 -->
		<servlet-name>FirsetServlet</servlet-name>
		<servlet-class>ht.servlet.T2.FirstServlet</servlet-class>
	</servlet>
	配置映射地址
	<servlet-mapping>
		<servlet-name>FirsetServlet</servlet-name>
		<!-- 地址栏使用的名称，可以随便定义，必须以/斜杠开头 -->
		<url-pattern>/firstServlet</url-pattern>
	</servlet-mapping>
	5.使用servlet，在地址栏项目名称后面加上url对应映射地址
 * 
 * */
public class FirstServlet extends HttpServlet{

	//初始化函数，主要作用就是读取配置文件的参数
	@Override
	public void init(ServletConfig config) throws ServletException {
	
	}
	//如果是get方式提交的数据，自动运行doGet函数
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		System.out.println("doGet方法接收到请求");
	}
	//如果是post方式提交的数据，自动运行doPost函数
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	//销毁函数，销毁servlet时，做一下清理对象，清理内存垃圾等工作
	@Override
	public void destroy() {
	
	}
}

package ht.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext监听器
 * 1.实现ServletContextListener接口
 * 2.配置监听器
 * <listener>
		<listener-class>ht.listener.ApplicationListener</listener-class>
	</listener>
 * 3.系统自动运行
 * 
 * 监听属性就必须实现ServletContextAttributeListener
 * */
public class ApplicationListener implements ServletContextListener,ServletContextAttributeListener{

	//销毁ServletContext对象
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁ServletContext对象：");
	}

	//初始化ServletContext对象
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("创建了ServletContext对象："+arg0.getServletContext());
	}

	//创建application变量（属性）
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("创建了application变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}
	//删除application变量（属性）
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("删除了application变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}
	//修改application变量（属性）的值
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("修改了application变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}

}

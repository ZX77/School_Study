package ht.listener;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerDemo implements HttpSessionListener,HttpSessionAttributeListener{

	static int count=0;
	public void sessionCreated(HttpSessionEvent arg0) {
		
		System.out.println("创建了session对象");
		System.out.println("create session id="+arg0.getSession().getId());
		count++;
		System.out.println("现在在线人数是:"+count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("销毁了session对象");
		System.out.println("destroy session id="+arg0.getSession().getId());
		count--;
		System.out.println("现在在线人数是:"+count);
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		logout("创建了Session变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logout("创建了Session变量，名称="+arg0.getName()+",值="+arg0.getValue());
		System.out.println("删除session="+arg0.getSession().getId());
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logout("创建了Session变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}
	//日志文件
	public void logout(String message) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("c:/note.txt", true));
			out.print(message);
			out.close();
		} catch (Exception e) {
			out.close();
			e.printStackTrace();
		}
	}
}

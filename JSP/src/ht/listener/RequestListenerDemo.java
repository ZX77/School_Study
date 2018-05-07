package ht.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenerDemo implements ServletRequestListener,ServletRequestAttributeListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("销毁了request对象");
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("创建request对象");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("创建了Request变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("创建了Request变量，名称="+arg0.getName()+",值="+arg0.getValue());		
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("创建了Request变量，名称="+arg0.getName()+",值="+arg0.getValue());
	}

}

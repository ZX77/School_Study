package T6;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/*
 * 继承Frame类，就可以实现窗口程序
 * */
public class MyFrame extends Frame{
	
	Panel myPanel;
	public MyFrame() {
		//设置窗口标题
		super("我的第一个窗口应用程序");
//		setTitle("更改窗口标题");
		//取消布局
		setLayout(null);
		
		//设置窗口的大小（宽，高）
		setSize(500,600);
		//创建一个Panel类的对象
		myPanel = new Panel();
		//设置背景颜色
		myPanel.setBackground(Color.RED);
		//设置Panel的大小
		myPanel.setSize(100, 100);
		//把面板放在窗口上
		add(myPanel);
		
		//设置窗口的背景颜色,Color是一个颜色类，里面定义了一些常用颜色的常量
		setBackground(Color.PINK);
		//设置窗口可见
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}

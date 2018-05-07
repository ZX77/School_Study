package T6;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/*
 * 流布局(FlowLayout):
 * 	1.Panel和applet默认的布局方式是流布局；
 * 	2.流布局的特点是从左到右，从上到下的方式布局控件
 * 	3.控件的大小不会因为窗口的大小发生变化而改变;
 * */
public class FlowLayoutDemo extends Frame {
	//定义按钮数组
	Button btn[] = new Button[20];
	Button btnOK,btnClose;
	public FlowLayoutDemo() {
		super("流布局实例演示");
		//设置布局方式为FlowLayout,默认对齐方式是居中
		//FlowLayout.CENTER,FlowLayout.LEFT,FlowLayout.RIGHT
		//对齐方式，控件直接的水平距离，控件直接垂直方向距离
		setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
		//循环创建按钮，同时设置按钮的标题
		for(int i=0;i<btn.length;i++){
			btn[i] = new Button("按钮"+(i+1));
			add(btn[i]);
		}
		btnOK = new Button();
		btnOK.setLabel("确定");
		add(btnOK);
		btnClose = new Button("关闭");
		add(btnClose);
		setSize(400,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new FlowLayoutDemo();
	}
}

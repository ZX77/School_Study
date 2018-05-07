package T6;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutDemo extends Frame{

	/*
	 * 网格布局(FlowLayout):把这个布局设置成n行,m列，每个控件的大小一样
	 * 控件的大小随着窗口的大小改变而改变
	 * 
	 * */
	Button btn[] = new Button[20];
	public GridLayoutDemo() {
		setTitle("网格布局演示");
		/*
		 * 参数1：行
		 * 参数2：列
		 * 参数3：水平间隔
		 * 参数4：垂直间隔
		 * 
		 * */
		setLayout(new GridLayout(5,4,10,10));
		for(int i=0;i<btn.length;i++){
			btn[i]= new Button();
			btn[i].setLabel("按钮"+(i+1));
			add(btn[i]);
		}
		setSize(400,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new GridLayoutDemo();
	}
}

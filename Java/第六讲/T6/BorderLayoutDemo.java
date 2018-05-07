package T6;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutDemo extends Frame{

	/*
	 * BorderLayout布局，整个界面分成5个部分，控件的大小随着窗口的大小会发生变化
	 * Frame的默认布局是:BorderLayout
	 * */
	Button btnNorth,btnEast,btnSouth,btnWest,btnCenter;
	public BorderLayoutDemo() {
		super("Border布局演示");
		//设置BorderLayout布局
//		setLayout(new BorderLayout());
		btnNorth = new Button("北部按钮");
		btnEast = new Button("东部按钮");
		btnSouth = new Button("南部按钮");
		btnWest = new Button("西部按钮");
		btnCenter = new Button("中间按钮");
		//添加按钮时必须指明放的位置,如果没有指明默认就是中间
		add(btnNorth,BorderLayout.NORTH);
		add(btnEast,BorderLayout.EAST);
		add(btnSouth,BorderLayout.SOUTH);
		add(btnWest,BorderLayout.WEST);
		add(btnCenter);
		
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutDemo();
	}
}

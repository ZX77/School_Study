package T7;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MouseEventDemo1 extends JFrame{
	JLabel lblTip;
	public MouseEventDemo1() {
		super("鼠标事件演示");
		lblTip = new JLabel("鼠标当前坐标是：");
		add(lblTip,BorderLayout.SOUTH);
		//绑定窗口的鼠标事件
		MouseHandler hander =new MouseHandler();
		addMouseListener(hander);
		addMouseMotionListener(hander);
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//实现鼠标的适配器类
	//MouseAdapter抽象类，实现了MouseListener,MouseMotionListener
	class MouseHandler extends MouseAdapter{
		//重写点击事件
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "单击事件发生了，再点我");
		}
		//鼠标移动事件
		@Override
		public void mouseMoved(MouseEvent e) {
			//获取鼠标的x坐标;
			int x = e.getX();
			//获取鼠标的y坐标;
			int y = e.getY();
			String str = "鼠标的当前位置：x="+x+",y="+y;
			lblTip.setText(str);
		}
	}
	public static void main(String[] args) {
		new MouseEventDemo1();
	}
}

package T7;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MouseEventDemo extends JFrame implements MouseListener{
	
	
	public MouseEventDemo() {
		super("鼠标事件演示");
		//绑定窗口的鼠标事件
		addMouseListener(this);
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//单击鼠标时触发该事件
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		JOptionPane.showMessageDialog(this, "发生了点击事件");
	}
	//鼠标进入区域时触发该事件
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}
	//鼠标离开指定区域时触发该事件
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
	//鼠标按下时触发该事件
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}
	//鼠标释放时触发该事件
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}
	public static void main(String[] args) {
		new MouseEventDemo();
	}
}

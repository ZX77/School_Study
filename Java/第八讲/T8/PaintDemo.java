package T8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintDemo extends JFrame implements ActionListener{

	JButton btnDrawLine;
	//判断是否要画线
	boolean bDrawLine=false;
	public PaintDemo() {
		super("绘图演示");
		
		btnDrawLine = new JButton("画线");
		//绑定按钮事件
		btnDrawLine.addActionListener(this);
	
		add(btnDrawLine,BorderLayout.NORTH);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	//重写paint方法，进行绘图操作
	/*Graphics参数类，包含了所有的绘图函数，及工具
	 * 
	 * */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//设置图形颜色
//		g.setColor(Color.CYAN);
		g.setColor(new Color(11,23,99));
		//画矩形
		g.drawRect(50, 50, 200, 200);
		g.setColor(Color.RED);
		g.drawArc(350, 150, 100, 200, 0, 360);
		/*
		 * 画椭圆
		 * 参数1：圆心的x坐标;
		 * 参数2：圆心的y坐标;
		 * 参数3：水平方向的半径;
		 * 参数4：垂直方向的半径;
		 * 
		 * */
		
		g.fillOval(100, 100, 400, 200);
		g.drawOval(50, 50, 500, 300);
		if(bDrawLine){
			g.setColor(Color.YELLOW);
			g.drawLine(0, 300, 800, 300);
			bDrawLine=false;
		}
		//创建一个图片类
		Image image = new ImageIcon("images/boy1.gif").getImage();
		//画图
		g.drawImage(image, 600, 100, 140,226 , this);
	}
	public static void main(String[] args) {
		
		new PaintDemo();
	}
	//按钮事件的实现函数
	public void actionPerformed(ActionEvent e) {
		
		//获取操作的控件名称
		if(e.getSource()==btnDrawLine){
			bDrawLine=true;
			//repaint->update->paint
			//通过repaint函数去调用paint函数
			repaint();
			
		}
		
	}
}

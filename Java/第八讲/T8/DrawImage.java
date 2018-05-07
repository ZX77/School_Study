package T8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class DrawImage extends JFrame implements MouseListener,MouseMotionListener{

	int startx,starty;
	int endx,endy;
	boolean bDrawing=false;
	public DrawImage() {
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {
		//调用父类的paint方法,做初始化操作
//		super.paint(g);
		g.setColor(Color.RED);
		System.out.println("sx="+this.startx+",sy="+this.starty+":ex="+this.endx+",ey="+this.endy);
		g.drawLine(this.startx, this.starty, this.endx, this.endy);
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//按下鼠标时会触发该事件
	public void mousePressed(MouseEvent e) {

		bDrawing=true;
		System.out.println("bDrawing="+bDrawing);
	}
	//放开鼠标时会触发该事件
	public void mouseReleased(MouseEvent e) {
		
		bDrawing=false;
		System.out.println("bDrawing="+bDrawing);
	}

	//拖动鼠标时会触发该事件
	public void mouseDragged(MouseEvent e) {
		if(bDrawing){
			this.endx = e.getX();
			this.endy = e.getY();
			repaint();//系统会自动调用paint方法
//			this.startx = e.getX();
//			this.starty = e.getY();
			System.out.println("mouseDragged");
		}
		
	}

	//移动鼠标时会触发该事件
	public void mouseMoved(MouseEvent e) {
		//获取鼠标坐标
		this.startx = e.getX();
		this.starty = e.getY();
		System.out.println("mouseMoved");
		
	}
	public static void main(String[] args) {
		new DrawImage();
	}
}

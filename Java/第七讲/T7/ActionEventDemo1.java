package T7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 实现事件的三步走：
 * 	1.事件源（控件）btnOK；
 * 	2.实现事件对应的接口
 * 	3.事件源与接口的实现类进行绑定
 * 	btnOK.addActionListener(new ActionHandler());
 * */
public class ActionEventDemo1 extends JFrame implements ActionListener{
	JButton btnOK;
	public ActionEventDemo1() {
		super("ActionEvent事件演示");
		btnOK = new JButton("点我吧！");
		add(btnOK);
		//绑定事件
		btnOK.addActionListener(this);
		setSize(200,200);
		setVisible(true);
		//设置窗口居中
		setLocationRelativeTo(null);
		//关闭窗口并退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		//e.getSource获取事件源
		if(e.getSource()==btnOK){
			//弹出对话框
			JOptionPane.showMessageDialog(null, "点我干嘛?");
		}
	}
	
	public static void main(String[] args) {
		new ActionEventDemo1();
	}
	
	
	
}

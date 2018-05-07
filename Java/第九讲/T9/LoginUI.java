package T9;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginUI extends JFrame implements ActionListener{

	//标签：只能显示静态文字或者图片
	JLabel lblbg,lblReg,lblForgetPwd;
	//文本框：单行文本框
	JTextField txtUserName;
	//密码框
	JPasswordField txtPassWord;
	//按钮
	JButton btnLogin,btnClose;
	public LoginUI() {
		// super("Swing控件的使用");
		setTitle("QQ登录");
		// 设置流布局
		// setLayout(null);
		// 显示图片
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images/tubiao.png");
		setIconImage(img);
		
		ImageIcon icon = new ImageIcon("images/login.jpg");
		lblbg = new JLabel(icon);
		// 绝对布局
		lblbg.setLayout(null);
		add(lblbg);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("宋体", Font.PLAIN, 18));
		txtUserName.setBounds(130, 180, 193, 32);
		lblbg.add(txtUserName);
		txtPassWord = new JPasswordField();
		txtPassWord.setFont(new Font("宋体", Font.PLAIN, 18));
		txtPassWord.setBounds(130, 212, 193, 32);
		// 设置不同密码字符
		txtPassWord.setEchoChar('@');
		lblbg.add(txtPassWord);
		btnLogin = new JButton("登录(L)");
		//设置热键(ALT+L)
		btnLogin.setMnemonic('L');
		btnLogin.setBounds(130, 250, 190, 30);
		lblbg.add(btnLogin);

		btnClose = new JButton("退出(X)");
		//设置热键(ALT+X)
//		btnClose.setMnemonic('X');
//		btnClose.setBounds(330, 212, 80, 30);
//		lblbg.add(btnClose);
		btnLogin.addActionListener(this);
//		btnClose.addActionListener(this);
		
		MouseHandle handler = new MouseHandle();
		lblReg = new JLabel("注册账号");
		lblReg.setBounds(330, 180, 60, 30);
		lblbg.add(lblReg);
		lblReg.addMouseListener(handler);
		
		
		lblForgetPwd = new JLabel("忘记密码");
		lblForgetPwd.setBounds(330, 210, 60, 30);
		lblbg.add(lblForgetPwd);
		lblForgetPwd.addMouseListener(handler);
		
		//窗口显示在最上层
		setAlwaysOnTop(true);
		//不允许改变窗口的大小
		setResizable(false);
		setSize(430, 350);
		setVisible(true);
		// 设置通过右上角的关闭按钮，关闭应用程序
		/*
		 * JFrame.DISPOSE_ON_CLOSE:关闭窗口，但是不结束应用程序的运行
		 * JFrame.EXIT_ON_CLOSE:关闭窗口同时结束应用程序的运行
		 * 
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 设置窗口居中对齐
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new LoginUI();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin){
			//获取文本框的内容
			//trim()函数：删除左右2边的空格
			String qqcode = txtUserName.getText().trim();
			if(qqcode==null || qqcode.equals("")){
				JOptionPane.showMessageDialog(this, "请输入QQ号码");
				return;
			}
			String pwd = txtPassWord.getText();
			if(pwd==null || pwd.equals("")){
				JOptionPane.showMessageDialog(this, "登录密码不能为空");
				return;
			}
			JOptionPane.showMessageDialog(this, "恭喜您，登录成功！");
		}else if(e.getSource()==btnClose){
			System.exit(0);
		}
		
	}
	class MouseHandle extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==lblReg){
//				JOptionPane.showMessageDialog(null, "注册模块正在开发中");
				//打开注册界面
				new RegUserUI();
				return;
			}else if(e.getSource()==lblForgetPwd){
				JOptionPane.showMessageDialog(null, "正在开发中");
				return;
			}
		}
	}
	
}

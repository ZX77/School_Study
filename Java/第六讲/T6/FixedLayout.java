package T6;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class FixedLayout extends Frame{

	//标签类
	Label lblqqcode,lblPwd,lblTitle;
	TextField txtqqcode,txtpwd;
	Button btnLogin,btnClose;
	
	/*
	 * 绝对布局：
	 * */
	public FixedLayout() {
		super("绝对坐标布局");
		setLayout(null);
		lblqqcode = new Label("QQ号码：",Label.RIGHT);
		lblPwd = new Label("登录密码：",Label.RIGHT);
		lblTitle = new Label("系统登录",Label.CENTER);
		txtqqcode = new TextField();
		txtpwd = new TextField();
		btnLogin = new Button("登录");
		btnClose = new Button("关闭");
		
		/*
		 * x,y设置控件左上角坐标
		 * width:宽度
		 * height:高度
		 * */
		lblTitle.setBounds(10, 70, 380, 30);
		
		lblqqcode.setBounds(10, 120, 80, 30);
		txtqqcode.setBounds(90, 120, 250, 30);
		
		lblPwd.setBounds(10, 170, 80, 30);
		txtpwd.setBounds(90, 170, 250, 30);
		
		btnLogin.setBounds(100, 230, 90, 30);
		btnClose.setBounds(200, 230, 90, 30);
		
		add(lblTitle);
		add(lblqqcode);
		add(lblPwd);
		add(txtqqcode);
		add(txtpwd);
		add(btnLogin);
		add(btnClose);
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FixedLayout();
	}
}

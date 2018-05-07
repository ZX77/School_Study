package ht.ui;

import ht.bean.AccountVo;
import ht.db.BaseDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class LoginUI extends JFrame implements MouseListener,ActionListener,ItemListener,MouseMotionListener{
	JLabel lblMin,lblClose,lblHead,lblReg,lblForgetPwd;
	JButton btnLogin;
	JPasswordField txtPassword;
	JComboBox cbQQcode;
	JCheckBox cbpwd,cbAutoLogin;
	//保存曾经登录过的QQ号码
	HashMap<Integer, AccountVo> user =null;
	JLabel bg;
	
	public LoginUI() {
		//隐藏标题栏
		setUndecorated(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("head/touxiang.png");
		setIconImage(img);
		bg = new JLabel(new ImageIcon("images/login.jpg"));
		//绝对布局
		bg.setLayout(null);
		//用鼠标拖动窗口,所以要绑定鼠标MouseMotionListener事件
		bg.addMouseMotionListener(this);
		add(bg);
		lblMin = new JLabel("-");
		lblMin.setForeground(Color.WHITE);
		lblMin.setFont(new Font("黑体",Font.BOLD,20));
		lblClose = new JLabel("x");
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("黑体",Font.BOLD,18));
		lblMin.setBounds(380, 0, 20, 20);
		lblClose.setBounds(400, 0, 20, 20);
		lblMin.addMouseListener(this);
		lblClose.addMouseListener(this);
		bg.add(lblMin);
		bg.add(lblClose);
		lblHead = new JLabel(new ImageIcon("head/touxiang.png"));
		lblReg = new JLabel("        ");
		lblForgetPwd = new JLabel("      ");
		cbQQcode = new JComboBox();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("登录");
		cbpwd = new JCheckBox("记住密码");
		cbAutoLogin = new JCheckBox("自动登录");
		
		cbQQcode.setBounds(130, 185, 194, 30);
		//设置下拉框中可以直接输入内容
		cbQQcode.setEditable(true);
		cbQQcode.setToolTipText("账号");
		txtPassword.setBounds(130, 215, 195, 30);
		txtPassword.setToolTipText("密码");
		lblReg.setBounds(335, 185, 80, 30);
//		lblReg.setFont(new Font("楷体",Font.PLAIN,14));
//		lblReg.setForeground(Color.BLUE);
		lblForgetPwd.setBounds(335, 215, 80, 30);
		lblHead.setBounds(70, 185, 60, 60);
		btnLogin.setBounds(130, 278, 195, 30);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		cbpwd.setBounds(127, 243, 80, 30);
		cbAutoLogin.setBounds(254, 243, 80, 30);
		//透明背景
		cbpwd.setOpaque(false);
		cbAutoLogin.setOpaque(false);
		btnLogin.setOpaque(false);
		
		bg.add(cbQQcode);
		bg.add(txtPassword);
		bg.add(lblReg);
		bg.add(lblForgetPwd);
		bg.add(lblHead);
		bg.add(btnLogin);
		bg.add(cbpwd);
		bg.add(cbAutoLogin);
		
		lblReg.addMouseListener(this);
		lblForgetPwd.addMouseListener(this);
		cbpwd.addActionListener(this);
		cbAutoLogin.addActionListener(this);
		btnLogin.addActionListener(this);
		cbQQcode.addItemListener(this);
		//读取文件内容,在下拉框中显示已经登录过的QQ号码
		readFile();
		setSize(427, 321);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LoginUI();
//		new LoginUI();
	}

	//鼠标单击事件
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblMin){
			//setState方法设置窗口状态为隐藏状态：HIDE_ON_CLOSE
		this.setState(JFrame.HIDE_ON_CLOSE);
		}else if(e.getSource()==lblClose){
			System.exit(0);
		}else if(e.getSource()==lblReg){
//			JOptionPane.showMessageDialog(this, "注册账号");
			new RegUI();
		}else if(e.getSource()==lblForgetPwd){
			JOptionPane.showMessageDialog(this, "找回密码");
		}
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		x=this.getX();
		y=this.getY();
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		//登录
		if(e.getSource()==btnLogin){
			String qqcode="";
			//获取密码
			String pwd = txtPassword.getText().trim();
			//下拉框中没有QQ号码
			if(cbQQcode.getSelectedItem() == null){
				JOptionPane.showMessageDialog(this, "请输入QQ号码");
				return;
			}
			if(pwd.equals("")){
				JOptionPane.showMessageDialog(this, "请输入登录密码");
				return;
			}
			//获取输入或者选择的QQ号码
			qqcode = cbQQcode.getSelectedItem().toString();
			//-------------------------------------------
			//创建Account对象，设置QQ号码和密码到account中
			AccountVo account = new AccountVo();
			account.setQqCode(Integer.parseInt(qqcode));
			account.setPassword(pwd);
			account = new BaseDAO().login(account);
			if(account==null){
				JOptionPane.showMessageDialog(this, "登录失败，用户名或密码错误!");
				return;
			}else{
//				JOptionPane.showMessageDialog(this, "登录成功");
				//保存登录成功的QQ号码到文件中
				save(account);
				
				//登录成功后，关闭当前窗口，
				dispose();
//				显示主窗口,同时把登录成功的个人信息account对象，传递到主窗口
				new MainUI(account);
			}
			
			
		}else if(e.getSource()==cbpwd){
			JOptionPane.showMessageDialog(this, "记住密码");
		}
		
	}
	//保存登录成功的QQ号码到文件中
	public void save(AccountVo account){
		//account.dat文件，保存曾经登录过的QQ号码，如果不存在，则创建文件
		File file = new File("account.dat");
		try {
			if(!file.exists()){//第一次使用QQ
					file.createNewFile();
					user = new HashMap<Integer, AccountVo>();
			}else{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				//读取文件内容
				user = (HashMap<Integer, AccountVo>)ois.readObject();
				fis.close();
				ois.close();
			}
			//新登录的用户信息保存到hashMap中
			//AccountVo类必须序列化
			user.put(account.getQqCode(), account);
			//保存hashMap到文件中
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("account.dat"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取文件内容
	public void readFile(){
		try{
			File file = new File("account.dat");
			//文件不存在就结束
			if(!file.exists()){
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//成员变量，不是局部变量
			user = (HashMap<Integer, AccountVo>)ois.readObject();
			//读取所有的键集
			Set<Integer> set = user.keySet();
			//转换为iterator
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()){
				//往界面QQ号码下拉框中增加保存中文件中的QQ号码
				cbQQcode.addItem(it.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbQQcode){
			if(!cbQQcode.getSelectedItem().toString().equals("") && user!=null){
				//读取下拉框中选择的QQ号码
				int qqcode = Integer.parseInt(cbQQcode.getSelectedItem().toString());
				//通过QQ号码读取HashMap中保存的值
				AccountVo account = user.get(qqcode);
				if(account!=null){
//					if(cbpwd.isSelected()){
						txtPassword.setText(account.getPassword());
//					}
					//更新显示头像
					lblHead.setIcon(new ImageIcon(account.getHeadImg()));
				}
			}
		}
	}
	int x,y;
	public void mouseDragged(MouseEvent e) {
//		this.setLocation(e.getX()+x, e.getY()+y);
//		x=this.getX();
//		y=this.getY();
		//获取窗口在屏幕的实际坐标
		Point p = this.getLocationOnScreen();
		
		this.setLocation(e.getX()+p.x, e.getY()+p.y);
	}

	public void mouseMoved(MouseEvent e) {
		
	}
}

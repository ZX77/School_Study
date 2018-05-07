package T9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RegUserUI extends JFrame{

	JLabel lblbg;
	JLabel lblQQcode,lblNickName,lblHead,lblSex,lblAge,lblNation,lblBlood,lblStar;
	JLabel lblJob,lblSign,lblHobit,lblPwd,lblPwd2;
	//文本框
	JTextField txtQQcode,txtNickName,txtAge,txtJob;
	//密码框
	JPasswordField txtPwd,txtPwd2;
	//下拉列表框
	JComboBox cbHead,cbNation,rbBlood,rbStar;
	//单选框
	JRadioButton rbMale,rbRemale;
	//多选框
	JCheckBox cbHobit1,cbHobit2,cbHobit3,cbHobit4,cbHobit5;
	//文本区域框
	JTextArea taSign;
	//按钮
	JButton btnReg,btnClose;
	//头像数组
	static ImageIcon[] imgHead={
		new ImageIcon("head/0.png"),
		new ImageIcon("head/1.png"),
		new ImageIcon("head/2.png"),
		new ImageIcon("head/3.png"),
		new ImageIcon("head/4.png"),
		new ImageIcon("head/5.png"),
		new ImageIcon("head/6.png"),
		new ImageIcon("head/7.png"),
		new ImageIcon("head/8.png"),
		new ImageIcon("head/9.png"),
		new ImageIcon("head/10.png")
	};
	String sNation[]={
		"汉族","苗族","维吾尔族","畲族","高山族","回族","壮族","傣族","侗族"	
	};
	String sBlood[]={
			"A","B","AB","O"
	};
	String sStar[]={
			"白羊座","水瓶座","双鱼座","处女座","金牛座","摩羯座","天蝎座","狮子座",
			"射手座","双子座","天枰座","巨蟹座"
	};
	public RegUserUI() {
		super("用户注册");
		
		//设置界面风格
		//com.sun.java.swing.plaf.motif.MotifLookAndFeel
		//com.sun.java.swing.plaf.windows.WindowsLookAndFeel
		try {
			
			
			
			
			
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ImageIcon icon = new ImageIcon("images/bgreg5.jpg");
		lblbg = new JLabel(icon);
		lblbg.setLayout(null);
		add(lblbg);
		
		lblQQcode = new JLabel("QQ号码:",SwingConstants.RIGHT);
		
		lblQQcode.setBounds(30, 110, 60, 20);
		lblbg.add(lblQQcode);
		txtQQcode = new JTextField();
		
		
		txtQQcode.setBounds(90, 110, 100, 20);
		lblbg.add(txtQQcode);
		
		lblNickName = new JLabel("昵称:",SwingConstants.RIGHT);
		lblNickName.setBounds(200, 110, 60, 20);
		lblbg.add(lblNickName);
		txtNickName = new JTextField("张三丰");
		//只读
//		txtNickName.setEditable(false);
		//设置无效
		txtNickName.setEnabled(false);
		txtNickName.setBounds(260, 110, 100, 20);
		lblbg.add(txtNickName);
		
//		lblHead = new JLabel("头像:",SwingConstants.RIGHT);
		
		cbHead = new JComboBox(imgHead);
		cbHead.setBounds(150, 10, 80, 60);
		lblbg.add(cbHead);
		
		
		lblSex = new JLabel("性别:",SwingConstants.RIGHT);
		lblSex.setBounds(30, 140, 60, 20);
		lblbg.add(lblSex);
		rbMale = new JRadioButton("男");
		//默认选中
		rbMale.setSelected(true);
		rbRemale = new JRadioButton("女");
		rbMale.setBounds(90, 140, 40, 20);
		lblbg.add(rbMale);
		rbRemale.setBounds(130, 140, 40, 20);
		lblbg.add(rbRemale);
		//分组
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbRemale);
		
		lblAge = new JLabel("年龄:",SwingConstants.RIGHT);
		lblAge.setBounds(200, 140, 60, 20);
		lblbg.add(lblAge);
		txtAge = new JTextField("0");
		txtAge.setBounds(260, 140, 100, 20);
		lblbg.add(txtAge);
		
		lblNation = new JLabel("民族:",SwingConstants.RIGHT);
		lblNation.setBounds(30, 170, 60, 20);
		lblbg.add(lblNation);
		cbNation = new JComboBox(sNation);
		cbNation.setBounds(90, 170, 100, 20);
		lblbg.add(cbNation);
		
		lblBlood = new JLabel("血型:",SwingConstants.RIGHT);
		lblBlood.setBounds(200, 170, 60, 20);
		lblbg.add(lblBlood);
		rbBlood = new JComboBox(sBlood);
		rbBlood.setBounds(260, 170, 100, 20);
		lblbg.add(rbBlood);
		
		
		lblStar = new JLabel("星座:",SwingConstants.RIGHT);
		lblStar.setBounds(30, 200, 60, 20);
		lblbg.add(lblStar);
		rbStar = new JComboBox(sStar);
		rbStar.setBounds(90, 200, 100, 20);
		lblbg.add(rbStar);
		lblJob = new JLabel("工作:",SwingConstants.RIGHT);
		lblJob.setBounds(200, 200, 60, 20);
		lblbg.add(lblJob);
		txtJob = new JTextField();
		txtJob.setBounds(260, 200, 100, 20);
		lblbg.add(txtJob);

		lblPwd = new JLabel("登录密码:",SwingConstants.RIGHT);
		lblPwd.setBounds(30, 230, 60, 20);
		lblbg.add(lblPwd);
		txtPwd = new JPasswordField();
		txtPwd.setEchoChar('*');
		txtPwd.setBounds(90, 230, 100, 20);
		lblbg.add(txtPwd);
		
		
		lblPwd2 = new JLabel("确认密码:",SwingConstants.RIGHT);
		lblPwd2.setBounds(200, 230, 60, 20);
		lblbg.add(lblPwd2);
		txtPwd2 = new JPasswordField();
		txtPwd2.setEchoChar('#');
		txtPwd2.setBounds(260, 230, 100, 20);
		lblbg.add(txtPwd2);

		lblHobit = new JLabel("兴趣爱好:",SwingConstants.RIGHT);
		lblHobit.setBounds(30, 260, 60, 20);
		lblbg.add(lblHobit);
		cbHobit1 = new JCheckBox("玩游戏");
		cbHobit2 = new JCheckBox("上网");
		cbHobit3 = new JCheckBox("吃货");
		cbHobit4 = new JCheckBox("旅游");
		cbHobit5 = new JCheckBox("打篮球");
		cbHobit1.setBounds(90, 260, 65, 20);
		lblbg.add(cbHobit1);
		cbHobit2.setBounds(155, 260, 55, 20);
		lblbg.add(cbHobit2);
		cbHobit3.setBounds(210, 260, 55, 20);
		lblbg.add(cbHobit3);
		cbHobit4.setBounds(265, 260, 55, 20);
		lblbg.add(cbHobit4);
		cbHobit5.setBounds(320, 260, 65, 20);
		lblbg.add(cbHobit5);
		
		lblSign = new JLabel("备注:",SwingConstants.RIGHT);
		lblSign.setBounds(30, 290, 60, 20);
		lblbg.add(lblSign);
		taSign = new JTextArea();
		//创建滚动面板，把文本区域框放入滚动面板中
		JScrollPane sp = new JScrollPane(taSign);
		sp.setBounds(90, 290, 270, 60);
		lblbg.add(sp);
		
		btnReg = new JButton("注册(R)");
		btnReg.setMnemonic('R');
		btnReg.setBounds(120, 380, 80, 30);
		lblbg.add(btnReg);
		
		btnClose = new JButton("关闭(C)");
		btnClose.setMnemonic('C');
		btnClose.setBounds(230, 380, 80, 30);
		lblbg.add(btnClose);
		ActionHandler handler = new ActionHandler();
		btnReg.addActionListener(handler);
		btnClose.addActionListener(handler);
		
		//窗口显示在最上层
		setAlwaysOnTop(true);
		//不允许改变窗口的大小
		setResizable(false);
		setSize(430, 469);
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new RegUserUI();
	}
	
	class ActionHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnReg){
				if(txtQQcode.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入QQ号码");
					//设置焦点
					txtQQcode.requestFocus();
					return;
				}
				//判断性别
				if(rbMale.isSelected()){
					taSign.setText("你选择的性别是：男");
				}
				if(rbRemale.isSelected()){
					taSign.setText("你选择的性别是：女");
				}
				//验证年龄是整形
				try{
					int age = Integer.parseInt(txtAge.getText().trim());
					if(age<0 || age>=150){
						JOptionPane.showMessageDialog(null, "年龄必须在0~150之间");
						return;
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "年龄含有非法字符");
					return;
				}
				//1.密码不允许为空，2.密码与确认密码必须一致
				
				if(txtPwd.getText().equals("")){
					JOptionPane.showMessageDialog(null, "密码不允许为空");
					return;
				}
				if(txtPwd.getText().length()<6){
					JOptionPane.showMessageDialog(null, "密码必须大于等于6位数");
					return;
				}
				if(!txtPwd.getText().equals(txtPwd2.getText())){
					JOptionPane.showMessageDialog(null, "登录密码与确认密码不一致");
					return;
				}
				JOptionPane.showMessageDialog(null, "注册成功");
			}else if(e.getSource()==btnClose){
				//关闭程序
				System.exit(0);
			}
		}
		
	}
}

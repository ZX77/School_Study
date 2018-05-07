package ht.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ht.bean.AccountVo;
import ht.db.BaseDAO;

public class UpdateInfoUI extends JFrame implements ActionListener{
	private JLabel lblQQcode,lblnickName,lblAge;
	private JLabel lblSex,lblNation,lblStar,lblBlood;
	private JLabel lblRemark,lblHobit,lblHeadImg;
	private JTextField txtQQcode,txtNickName,txtAge,txtHobit;
	private JRadioButton rbMale,rbRemale;
	private JComboBox cbNation,cbStar,cbBlood,cbHeadImg;
	private JTextArea taRemark;
	private ButtonGroup bg;
	private JLabel lblBg;
	private JButton btnSave,btnClose;
	private String sNation[]={
			"汉族","苗族","壮族","高山族","回族","侗族",
			"傣族","藏族","朝鲜族","其他"
	};
	private String sStar[]={
			"双鱼座","金牛座","摩羯座","天蝎座","处女座","狮子座","白羊座",
			"水瓶座","射手座","天秤座","巨蟹座","双子座",
	};
	private String sBlood[]={"A","B","O","AB"};
	private String sHeadImg[] = {
			"head/0.png","head/1.png","head/2.png",
			"head/3.png","head/4.png","head/5.png",
			"head/6.png","head/7.png","head/8.png",
			"head/9.png","head/10.png"
	};
	private ImageIcon[] headIcon = {
			new ImageIcon(sHeadImg[0]),
			new ImageIcon(sHeadImg[1]),
			new ImageIcon(sHeadImg[2]),
			new ImageIcon(sHeadImg[3]),
			new ImageIcon(sHeadImg[4]),
			new ImageIcon(sHeadImg[5]),
			new ImageIcon(sHeadImg[6]),
			new ImageIcon(sHeadImg[7]),
			new ImageIcon(sHeadImg[8]),
			new ImageIcon(sHeadImg[9]),
			new ImageIcon(sHeadImg[10])
	};
	MainUI mainUI;
	public UpdateInfoUI(AccountVo myInfo,MainUI mainUI){
		this.mainUI = mainUI;
		String msg = "修改("+myInfo.getNickName()+")的个人资料";
		setTitle(msg);
		setIconImage(new ImageIcon("images/tubiao.jpg").getImage());
		lblBg = new JLabel(new ImageIcon("images/bgreg.jpg"));
		add(lblBg);
		//绝对布局
		lblBg.setLayout(null);
		
		JLabel title = new JLabel(msg,JLabel.CENTER);
		title.setFont(new Font("楷体",Font.BOLD,20));
		title.setForeground(Color.RED);
		title.setBounds(0,30,230,40);
		lblBg.add(title);
		lblQQcode = new JLabel("QQ号码:",JLabel.RIGHT);
		lblnickName = new JLabel("昵称:",JLabel.RIGHT);
		lblHeadImg = new JLabel("头像:",JLabel.RIGHT);
		lblAge = new JLabel("年龄:",JLabel.RIGHT);
		lblSex = new JLabel("性别:",JLabel.RIGHT);
		lblNation = new JLabel("民族:",JLabel.RIGHT);
		lblStar = new JLabel("星座:",JLabel.RIGHT);
		lblBlood = new JLabel("血型:",JLabel.RIGHT);
		lblHobit = new JLabel("爱好:",JLabel.RIGHT);
		lblRemark = new JLabel("备注:",JLabel.RIGHT);
		
		txtQQcode = new JTextField(10);
		txtQQcode.setText(myInfo.getQqCode()+"");
		//只读
		txtQQcode.setEditable(false);
		txtNickName = new JTextField(10);
		txtNickName.setText(myInfo.getNickName());
		cbHeadImg = new JComboBox(headIcon);
		for(int i=0;i<sHeadImg.length;i++){
			if(sHeadImg[i].equals(myInfo.getHeadImg())){
				cbHeadImg.setSelectedIndex(i);
				break;
			}
		}
		txtAge = new JTextField(5);
		txtAge.setText(myInfo.getAge()+"");
		//默认选择男
		if(myInfo.getSex().equals("男")){
			rbMale = new JRadioButton("男",true);
			rbRemale = new JRadioButton("女");
		}else{
			rbMale = new JRadioButton("男");
			rbRemale = new JRadioButton("女",true);

		}
		//一组的单选按钮必须加到一个组里面
		bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbRemale);
		cbNation = new JComboBox(sNation);
		
		for(int i=0;i<sNation.length;i++){
			if(sNation[i].equals(myInfo.getNation())){
				cbNation.setSelectedIndex(i);
				break;
			}
		}
		cbStar = new JComboBox(sStar);
		for(int i=0;i<sStar.length;i++){
			if(sStar[i].equals(myInfo.getStar())){
				cbStar.setSelectedIndex(i);
				break;
			}
		}
		cbBlood = new JComboBox(sBlood);
		for(int i=0;i<sBlood.length;i++){
			if(sBlood[i].equals(myInfo.getBlood())){
				cbBlood.setSelectedIndex(i);
				break;
			}
		}
		txtHobit = new JTextField(20);
		txtHobit.setText(myInfo.getHobit());
		taRemark  = new JTextArea(3,80);
		taRemark.setText(myInfo.getRemark());
		lblQQcode.setBounds(0, 100, 100, 20);
		txtQQcode.setBounds(100, 100, 150, 20);
		lblnickName.setBounds(0, 140, 100, 20);
		txtNickName.setBounds(100, 140, 150, 20);
		//设置透明
//		txtNickName.setOpaque(false);
		
		lblHeadImg.setBounds(280, 100, 80, 60);
		cbHeadImg.setBounds(360, 100, 80, 60);
		

		lblAge.setBounds(0, 220, 100, 20);
		txtAge.setBounds(100, 220, 150, 20);
		lblSex.setBounds(280, 220, 80, 20);
		rbMale.setBounds(360, 220, 40, 20);
		//透明背景
		rbMale.setOpaque(false);
		rbRemale.setBounds(400, 220, 40, 20);
		//透明背景
		rbRemale.setOpaque(false);
		
		lblNation.setBounds(0, 260, 100, 20);
		cbNation.setBounds(100, 260, 150, 20);
		lblStar.setBounds(280, 260, 80, 20);
		cbStar.setBounds(360, 260, 150, 20);
		
		lblBlood.setBounds(0, 300, 100, 20);
		cbBlood.setBounds(100, 300, 150, 20);
		lblHobit.setBounds(0, 340, 100, 20);
		txtHobit.setBounds(100, 340, 410, 20);

		
		lblRemark.setBounds(0, 420, 100, 20);
		taRemark.setBounds(100, 420, 410, 80);
		
		lblBg.add(lblQQcode);
		lblBg.add(txtQQcode);
		lblBg.add(lblnickName);
		lblBg.add(txtNickName);
		lblBg.add(lblHeadImg);
		lblBg.add(cbHeadImg);
		lblBg.add(lblAge);
		lblBg.add(txtAge);
		lblBg.add(lblSex);
		lblBg.add(rbMale);
		lblBg.add(rbRemale);
		lblBg.add(lblNation);
		lblBg.add(cbNation);
		lblBg.add(lblStar);
		lblBg.add(cbStar);
		lblBg.add(lblBlood);
		lblBg.add(cbBlood);
		lblBg.add(lblHobit);
		lblBg.add(txtHobit);
		lblBg.add(lblRemark);
		lblBg.add(taRemark);
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnClose = new JButton("关闭(X)");
		btnClose.setMnemonic('X');
		
		btnSave.setBounds(180, 520, 100, 40);
		btnClose.setBounds(350, 520, 100, 40);
		lblBg.add(btnSave);
		lblBg.add(btnClose);
		btnSave.addActionListener(this);
		btnClose.addActionListener(this);
		//隐藏标题栏
		setUndecorated(true);
		//不允许改变窗口大小
		setResizable(false);
		
		setSize(550, 580);
		setVisible(true);
		setLocationRelativeTo(null);
		//关闭窗口，不退出应用程序
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new UpdateInfoUI(null,null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnSave){
			String nickname = txtNickName.getText().trim();
			//判断有没有输入昵称
			if(nickname.equals("")){
				JOptionPane.showMessageDialog(this, "请输入昵称");
				//设置默认焦点
				txtNickName.requestFocus();
				return;
			}
			int age = 0;
			String sage = txtAge.getText().trim();
			if(sage.equals("")){
				JOptionPane.showMessageDialog(this, "请输入年龄");
				txtAge.setText("0");
				return;
			}
			try{
				age = Integer.parseInt(sage);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this, "请输入0~150之间的年龄");
				txtAge.requestFocus();
				return;
			}
			if(age<0 || age>150){
				JOptionPane.showMessageDialog(this, "请输入0~150之间的年龄");
				txtAge.requestFocus();
				return;
			}
			//------------------------------------------------
			//把界面输入的值设置到Account bean中
			AccountVo account = new AccountVo();
			account.setQqCode(Integer.parseInt(txtQQcode.getText().trim()));
			account.setNickName(nickname);
			account.setHeadImg(sHeadImg[cbHeadImg.getSelectedIndex()]);
			account.setAge(age);
			if(rbMale.isSelected()){
				account.setSex("男");
			}else{
				account.setSex("女");
			}
			account.setNation(sNation[cbNation.getSelectedIndex()]);
			account.setStar(sStar[cbStar.getSelectedIndex()]);
			account.setBlood(sBlood[cbBlood.getSelectedIndex()]);
			account.setHobit(txtHobit.getText().trim());
			account.setRemark(taRemark.getText().trim());
			//------------------------操作数据库
			BaseDAO baseDAO = new BaseDAO();
			//修改信息保存到数据库中的account表
			baseDAO.updateAccount(account);
			//------------------------------------------
			JOptionPane.showMessageDialog(this, "恭喜你修改成功");
			String str = account.getNickName()+"("+account.getQqCode()+")   "+account.getRemark();
			mainUI.lblHead.setIcon(new ImageIcon(account.getHeadImg()));
			mainUI.lblHead.setText(str);
		}else if(e.getSource()==btnClose){
			dispose();
		}
	}
	
}

package T7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserReg extends JFrame{

	JLabel lblbg;
	JPanel southPanel;
	JLabel lblqqcode,lblnickname,lblage,lblsex,lblremark;
	JTextField txtqqcode,txtnickname,txtage;
	//单选框
//	JRadioButton rbmale,rbwomale;
	//下拉框
	JComboBox cbSex;
	String sSex[] ={"男","女"};
	JTextArea txtRemark;
	JButton btnSave,btnExit;
	public UserReg() {
		super("用户注册");
		lblbg = new JLabel(new ImageIcon("images/bgreg.jpg"));
		lblbg.setLayout(new GridLayout(5,2,10,10));
		add(lblbg);
		lblqqcode = new JLabel("QQ号码：",JLabel.RIGHT);
		lblnickname = new JLabel("昵称：",JLabel.RIGHT);
		lblage = new JLabel("年龄：",JLabel.RIGHT);
		lblsex = new JLabel("性别：",JLabel.RIGHT);
		lblremark = new JLabel("备注：",JLabel.RIGHT);
		txtqqcode = new JTextField();
		txtnickname = new JTextField();
		txtage = new JTextField();
//		rbmale = new JRadioButton("男");
//		rbwomale = new JRadioButton("女");
		cbSex = new JComboBox(sSex);
		txtRemark = new JTextArea(5,50);
		lblbg.add(lblqqcode);
		lblbg.add(txtqqcode);
		lblbg.add(lblnickname);
		lblbg.add(txtnickname);
		lblbg.add(lblage);
		lblbg.add(txtage);
		lblbg.add(lblsex);
		lblbg.add(cbSex);
		lblbg.add(lblremark);
		lblbg.add(txtRemark);
		
		southPanel=new JPanel();
		southPanel.setLayout(new FlowLayout());
		btnSave = new JButton("保存");
		btnExit = new JButton("关闭");
		southPanel.add(btnSave);
		southPanel.add(btnExit);
		
		add(southPanel,BorderLayout.SOUTH);
		
		
		setSize(550, 650);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UserReg();
	}
}

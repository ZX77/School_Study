package ht.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ht.bean.AccountVo;
import ht.net.Cmd;
import ht.net.SendBody;
import ht.net.SendMsg;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ChatUI extends JFrame implements ActionListener,ItemListener{
	JTextPane txtReceive,txtSend;
	JLabel lblBoy,lblGril,lblInfo;
	JButton btnSend,btnClose,btnShake,btnFace,btnSendFile,btnColor;
	JComboBox cbFont,cbSize,cbStyle;
	String sfont[]={"宋体","楷体","黑体"};
	String sSize[]={"10","12","14","16","18","20","24","36","48","72"};
	String sStyle[]={"普通","粗体","斜体"};
	AccountVo self,friend;
	public ChatUI(AccountVo self,AccountVo friend) {
		this.self = self;
		this.friend = friend;
		String str = self.getNickName()+"("+self.getQqCode()+")正在与";
		str+= friend.getNickName()+"("+friend.getQqCode()+")聊天中...";
		
//		lblInfo = new JLabel(str);
//		add(lblInfo,BorderLayout.NORTH);
		setTitle(str);
		//设置图标
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.createImage(friend.getHeadImg());
		setIconImage(image);
		//------------------------------------------
		//右(东)边平分2半，显示QQ秀
		JPanel rightPanel = new JPanel(new GridLayout(2,1,5,5));

		lblBoy = new JLabel(new ImageIcon("images/boy.gif"));
		lblGril = new JLabel(new ImageIcon("images/girl.gif"));
		rightPanel.add(lblBoy);
		rightPanel.add(lblGril);
		add(rightPanel,BorderLayout.EAST);
		//-------------------------------------------
		//中间平分为2半
		JPanel partPanel = new JPanel(new GridLayout(2,1,0,0));
		//上面显示接收框
		txtReceive = new JTextPane();
		//设置只读
		txtReceive.setEditable(false);
		partPanel.add(new JScrollPane(txtReceive));
		//下半部分，添加一个panel为borderlayout布局
		JPanel sendPanel = new JPanel(new BorderLayout());
		
		JPanel norPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cbFont = new JComboBox(sfont);
		cbSize = new JComboBox(sSize);
		cbStyle = new JComboBox(sStyle);
		//在按钮上添加图片
		btnShake = new JButton(new ImageIcon("images/zd.png"));
		//设置按钮的大小与图片大小一致
		btnShake.setMargin(new Insets(0,0,0,0));
		btnFace = new JButton(new ImageIcon("images/sendFace.png"));
		btnFace.setMargin(new Insets(0,0,0,0));
		btnSendFile = new JButton(new ImageIcon("images/musictb.png"));
		btnSendFile.setMargin(new Insets(0,0,0,0));
		btnColor = new JButton("颜色");
		btnColor.setMargin(new Insets(0,0,0,0));
		norPanel.add(cbFont);
		norPanel.add(cbSize);
		norPanel.add(cbStyle);
		norPanel.add(btnColor);
		norPanel.add(btnShake);
		norPanel.add(btnFace);
		norPanel.add(btnSendFile);
		sendPanel.add(norPanel,BorderLayout.NORTH);
		txtSend = new JTextPane();
		sendPanel.add(txtSend);
		JPanel souPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSend = new JButton("发送(S)");
		btnSend.setMnemonic('S');
		btnClose = new JButton("关闭(C)");
		btnClose.setMnemonic('C');
		souPanel.add(btnSend);
		souPanel.add(btnClose);
		sendPanel.add(souPanel,BorderLayout.SOUTH);
		partPanel.add(sendPanel);
		add(partPanel);
		
		btnColor.addActionListener(this);
		btnShake.addActionListener(this);
		btnFace.addActionListener(this);
		btnSendFile.addActionListener(this);
		btnSend.addActionListener(this);
		btnClose.addActionListener(this);
		
		cbFont.addItemListener(this);
		cbSize.addItemListener(this);
		cbStyle.addItemListener(this);
		
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new ChatUI(null,null);
	}
	//抖动函数
	public void shake(){
		//抖动的原理就是不断的改变窗口的位置
		//获取窗口的原始位置
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		for(int i=0;i<=20;i++){
			if(i%2==0){
				setLocation(x+5, y+5);
			}else{
				setLocation(x-5, y-5);
			}
			try {
				//窗口移动一次暂停100毫秒
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnClose){//关闭窗口
			dispose();
		}else if(e.getSource()==btnColor){//设置发送框字体颜色
			//弹出颜色对话框
			JColorChooser colordlg = new JColorChooser(Color.BLACK);
			Color color = colordlg.showDialog(this, "字体颜色",Color.BLACK);
			txtSend.setForeground(color);
		}else if(e.getSource()==btnShake){
			SendBody body = new SendBody();
			body.cmd = Cmd.CMD_SHAKE;
			body.self = self;
			body.friend = friend;
			SendMsg.send(body);
			shake();
		}else if(e.getSource()==btnFace){
			Point p = btnFace.getLocationOnScreen();
			new BqUI(this,p.x,p.y-330);
		}else if(e.getSource()==btnSend){
			
			StyledDocument doc = txtSend.getStyledDocument();
			if(doc.getLength()<=0){
				JOptionPane.showMessageDialog(this, "发送内容不能为空");
				return;
			}
			
			//发送消息
			SendBody body = new SendBody();
			body.cmd = Cmd.CMD_CHAT;
			body.self = self;
			body.friend = friend;
			body.doc = doc;
			//发送
			SendMsg.send(body);
			//显示到接收框--------------------------
			try {
				appendView(self.getNickName(), doc);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			//清空发送内容-----------
			txtSend.setText("");
		}else if(e.getSource()==btnSendFile){//发送文件
			//发送文件
			JFileChooser fileDlg = new JFileChooser();
			fileDlg.setDialogType(JFileChooser.OPEN_DIALOG);
			String imgName ="";
			if(fileDlg.showDialog(this, "选择文件")==JFileChooser.APPROVE_OPTION){
				File file = fileDlg.getSelectedFile();
				//控制文件必须在64K以内
				long size = file.length();
				if(size>62*1024){
					JOptionPane.showMessageDialog(this, "文件不能大于64K");
					return;
				}
				try {
					FileInputStream fis = new FileInputStream(file);
					byte b[] = new byte[(int)size];
					//读取文件内容
					fis.read(b);
					//发送文件
					SendBody body = new SendBody();
					body.cmd = Cmd.CMD_FILE;
					body.self = self;
					body.friend = friend;
					body.b = b;
					body.fileName = file.getName();
					SendMsg.send(body);

					fis.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
		
	}
	String fontName="宋体";
	int fontSize=12;
	int fontStyle=Font.PLAIN;
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==cbFont){
			fontName = sfont[cbFont.getSelectedIndex()];
		}else if(e.getSource()==cbSize){
			fontSize = Integer.parseInt(sSize[cbSize.getSelectedIndex()]);
		}else if(e.getSource()==cbStyle){
			if(sStyle[cbStyle.getSelectedIndex()].equals("粗体")){
				fontStyle =Font.BOLD; 
			}else if(sStyle[cbStyle.getSelectedIndex()].equals("斜体")){
				fontStyle =Font.ITALIC;
			}else{
				fontStyle =Font.PLAIN;
			}
		}
		//设置发送框字体
		Font font = new Font(fontName,fontStyle,fontSize);
		txtSend.setFont(font);
	}
	//把发送框的内容提交到接收框，同时清除发送框的内容
	public  void appendView(String name, StyledDocument xx)throws BadLocationException {
		//文字1 图片1 文字2 图片2 文字3 图片3 文字4

		//获取接收框的文档（内容）
		StyledDocument vdoc = txtReceive.getStyledDocument();//获取接收框的内容
		// 格式化时间
		Date date = new Date();//获取系统当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //设置显示时分秒的格式
		String time = sdf.format(date);//获取时分秒
		//创建一个属性集合
		SimpleAttributeSet as = new SimpleAttributeSet();
		// 显示谁说
		//vdoc.getLength()获取接收框中的原来内容的长度
		String s =name + "    " + time + "\n";
//		saveRecord(name,s);//保存聊天记录
		vdoc.insertString(vdoc.getLength(), s, as);
		int end = 0;
		//处理显示的内容
		while (end < xx.getLength()) {
			// 获得一个元素
			Element e0 = xx.getCharacterElement(end);
			//获取对应的风格，
			SimpleAttributeSet as1 = new SimpleAttributeSet();
			StyleConstants.setForeground(as1, StyleConstants.getForeground(e0.getAttributes()));
			StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0.getAttributes()));
			StyleConstants.setFontFamily(as1, StyleConstants.getFontFamily(e0.getAttributes()));
			//获取该元素的内容
			s = e0.getDocument().getText(end, e0.getEndOffset() - end);
			// 将元素加到浏览窗中
			if("icon".equals(e0.getName())){
				vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
			}
			else{
				vdoc.insertString(vdoc.getLength(), s, as1);
//				saveRecord(name,s+"\n");//保存聊天记录
			}
			//getEndOffset（）函数就是获取当前元素的长度
			end = e0.getEndOffset(); 
		}
		// 输入一个换行
		vdoc.insertString(vdoc.getLength(), "\n", as);
		
		// 设置显示视图加字符的位置与文档结尾，以便视图滚动
		txtReceive.setCaretPosition(vdoc.getLength());
	}
}

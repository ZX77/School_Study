package ht.ui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Vector;

import ht.bean.AccountVo;
import ht.common.Sound;
import ht.db.BaseDAO;
import ht.net.Cmd;
import ht.net.SendBody;
import ht.net.SendMsg;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.Popup;
import javax.swing.UIManager;

import txz.TxzGame;

public class MainUI extends JFrame implements MouseListener,ActionListener,ItemListener,WindowListener{
	
	/*
	 * QQ主界面
	 * */
	JLabel lblHead,lblSign,lblbg;
	JTabbedPane tab;
	//好友分4组，好友，家人，同学，黑名单
	JList lstFriend,lstFamily,lstClassMate,lstBlack;
	//每个list对象定义一个Vector对象
	Vector<AccountVo> vAllInfo,vFriend,vFamily,vClassMate,vBlack;
	//状态
	JComboBox cbState;
	//查找好友
	JButton btnFind,btnchangeFace,btnTxz;
	//保存登录窗口传过来的个人登录成功的信息
	AccountVo self,friend;
	
	//右键的弹出菜单
	JPopupMenu popup;
	JMenuItem miChat,miLook,miMoveToFri,miMoveToFam,miMoveToMate,miMoveToBlack,miDel;
	
	//托盘菜单
	PopupMenu trayPopup;
	MenuItem miOpen,miExit,miOnline,miBuys,miHidden;
	//托盘
	TrayIcon trayIcon;
	//保存聊天窗口
	HashMap<Integer, ChatUI> chatWin = new HashMap<Integer, ChatUI>();
	BaseDAO base = new BaseDAO();
	public MainUI(AccountVo self) {
		super("QQ2017");
		this.self = self;
		
		//背景图片
		lblbg = new JLabel(new ImageIcon("images/bgmain.jpg"));
		lblbg.setLayout(new BorderLayout());
		add(lblbg);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.createImage("head/touxiang.png");
		//设置图标
		setIconImage(image);
		
		//个人头像
		ImageIcon iconHead = new ImageIcon(self.getHeadImg());
		//qq号码，昵称
		String nickname = self.getNickName()+"("+self.getQqCode()+")   "+self.getRemark();
		lblHead = new JLabel(nickname,iconHead,JLabel.LEFT);
		lblHead.addMouseListener(this);
		lblbg.add(lblHead,BorderLayout.NORTH);
		//-----------------------
		vFriend = new Vector<AccountVo>();
		vFamily = new Vector<AccountVo>();
		vClassMate = new Vector<AccountVo>();
		vBlack = new Vector<AccountVo>();
		
		lstFriend = new JList();
		lstFamily = new JList();
		lstClassMate = new JList();
		lstBlack = new JList();
		lstFriend.setBackground(new Color(0,0,0,0));
		lstFriend.setOpaque(false);
		lstFamily.setOpaque(false);
		lstClassMate.setOpaque(false);
		lstBlack.setOpaque(false);

		lstFriend.addMouseListener(this);
		lstFamily.addMouseListener(this);
		lstClassMate.addMouseListener(this);
		lstBlack.addMouseListener(this);
		//刷新列表
		refresh();
		//只允许单选
//		lstFriend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//JTabbedPane设置透明
		UIManager.put("TabbedPane.contentOpaque", false);
		tab = new JTabbedPane();
		tab.setBackground(new Color(0,0,0,0));
		//---------------------------------
		JScrollPane sp1 = new JScrollPane(lstFriend);
		JScrollPane sp2 = new JScrollPane(lstFamily);
		JScrollPane sp3 = new JScrollPane(lstClassMate);
		JScrollPane sp4 = new JScrollPane(lstBlack);
		//滚动面板设置透明
		sp1.getViewport().setOpaque(false); 
		sp1.setOpaque(false);
		//--------------------------------
		sp2.setOpaque(false);
		sp3.setOpaque(false);
		sp4.setOpaque(false);
		tab.addTab(Cmd.GROUPFRIEND, sp1);
		tab.addTab(Cmd.GROUPFAMILY, sp2);
		tab.addTab(Cmd.GROUPMATE, sp3);
		tab.addTab(Cmd.GROUPBLACK, sp4);
		
		
		lblbg.add(tab);
		//------------------------------
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bottomPanel.setOpaque(false);
		JLabel lblState = new JLabel("更改状态");
		cbState = new JComboBox(Cmd.STATUS);
		cbState.addItemListener(this);
		//删除离线状态
		cbState.removeItemAt(1);
		cbState.setOpaque(false);
		btnFind = new JButton("查找(F)");
		btnchangeFace = new JButton("换肤");
		btnTxz = new JButton("推箱子");
		//按钮透明
		btnFind.setContentAreaFilled(false); 
		btnchangeFace.setContentAreaFilled(false); 
		btnTxz.setContentAreaFilled(false); 
		//--------------------------------
		btnFind.setMnemonic('F');
		bottomPanel.add(lblState);
		bottomPanel.add(cbState);
		bottomPanel.add(btnFind);
		bottomPanel.add(btnchangeFace);
		bottomPanel.add(btnTxz);
		btnFind.addActionListener(this);
		btnchangeFace.addActionListener(this);
		btnTxz.addActionListener(this);
		
		lblbg.add(bottomPanel,BorderLayout.SOUTH);
		//启动线程----------------------------
		new ReceiveThread().start();
		//上线通知
		SendMsg.sendAll(vAllInfo, self, Cmd.CMD_ONLINE);
		//----------------------------------
		
		//窗口监听window事件
		addWindowListener(this);
		//创建菜单
		createMenu();
		//创建托盘菜单，图标
		createTrayIcon();
		//不能改变窗口大小
		setResizable(false);
		setSize(350, 650);
		//获取屏幕的分辨率
		int width = toolkit.getScreenSize().width;
		int height = toolkit.getScreenSize().height;
		//设置窗口初始位置
		setLocation(width-300, 40);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//刷新函数
	public void refresh(){
		//清空原来的数据
		vFriend.clear();
		vFamily.clear();
		vClassMate.clear();
		vBlack.clear();
		//读数据
		vAllInfo = base.allInfo(self.getQqCode());
		for (AccountVo acc : vAllInfo) {
			if(acc.getGroupName().equals(Cmd.GROUPFRIEND)){
				vFriend.add(acc);
			}else if(acc.getGroupName().equals(Cmd.GROUPFAMILY)){
				vFamily.add(acc);
			}else if(acc.getGroupName().equals(Cmd.GROUPMATE)){
				vClassMate.add(acc);
			}else if(acc.getGroupName().equals(Cmd.GROUPBLACK)){
				vBlack.add(acc);
			}
		}
		lstFriend.setModel(new DataModel(vFriend));
		lstFriend.setCellRenderer(new MyHeadImg(vFriend));
		
		lstFamily.setModel(new DataModel(vFamily));
		lstFamily.setCellRenderer(new MyHeadImg(vFamily));
		
		lstClassMate.setModel(new DataModel(vClassMate));
		lstClassMate.setCellRenderer(new MyHeadImg(vClassMate));
		
		lstBlack.setModel(new DataModel(vBlack));
		lstBlack.setCellRenderer(new MyHeadImg(vBlack));
		
	}
	
	//创建弹出菜单
	public void createMenu(){
		miChat = new JMenuItem("聊天");
		miLook = new JMenuItem("查看好友资料");
		miMoveToFri = new JMenuItem("移到好友组");
		miMoveToFam = new JMenuItem("移到家人组");
		miMoveToMate = new JMenuItem("移到同学组");
		miMoveToBlack = new JMenuItem("移到黑名单组");
		miDel = new JMenuItem("删除好友");
		popup = new JPopupMenu();
		popup.add(miChat);
		popup.add(miLook);
		popup.add(miMoveToFri);
		popup.add(miMoveToFam);
		popup.add(miMoveToMate);
		popup.add(miMoveToBlack);
		popup.add(miDel);
		//添加按钮事件
		miChat.addActionListener(this);
		miLook.addActionListener(this);
		miMoveToFam.addActionListener(this);
		miMoveToFri.addActionListener(this);
		miMoveToMate.addActionListener(this);
		miMoveToBlack.addActionListener(this);
		miDel.addActionListener(this);
		
	}
	//鼠标事件-----------------------------
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lstFriend){
			int index = lstFriend.getSelectedIndex();
			if(index<0){
				return;
			}
			friend = vFriend.get(index);
			//双击
			if(e.getClickCount()==2){
				ChatUI chat = openWin(friend.getQqCode());
			}
			if(e.getButton()==3){
				popup.show(lstFriend, e.getX(), e.getY());
			}
		}else if(e.getSource()==lstFamily){
			int index = lstFamily.getSelectedIndex();
			if(index<0){
				return;
			}
			friend = vFamily.get(index);
			if(e.getButton()==3){
				popup.show(lstFamily, e.getX(), e.getY());
			}
			
		}else if(e.getSource()==lstClassMate){
			int index = lstClassMate.getSelectedIndex();
			if(index<0){
				return;
			}
			friend = vClassMate.get(index);
			if(e.getButton()==3){
				popup.show(lstClassMate, e.getX(), e.getY());
			}
		}else if(e.getSource()==lstBlack){
			int index = lstBlack.getSelectedIndex();
			if(index<0){
				return;
			}
			friend = vBlack.get(index);
			//双击
			if(e.getClickCount()==2){
				JOptionPane.showMessageDialog(this, "不能与黑人聊天");
				return;
			}
			if(e.getButton()==3){
				popup.show(lstBlack, e.getX(), e.getY());
			}
		}else if(e.getSource()==lblHead){//修改个人资料
			new UpdateInfoUI(self,this);
		}
	}

	public void mouseEntered(MouseEvent e) {

		
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==miChat){
			if(friend.getGroupName().equals(Cmd.GROUPBLACK)){
				JOptionPane.showMessageDialog(this, "不能与黑人聊天");
				return;
			}
			ChatUI chat = openWin(friend.getQqCode());
		}else if(e.getSource()==btnchangeFace){
			//更换皮肤
			JFileChooser fileDlg = new JFileChooser();
			fileDlg.setDialogType(JFileChooser.OPEN_DIALOG);
			String imgName ="";
			if(fileDlg.showDialog(this, "选择图片")==JFileChooser.APPROVE_OPTION){
//				imgName = fileDlg.getSelectedFile().getName();
//				System.out.println("imgName="+imgName);
//				lblbg.setIcon(new ImageIcon("images/"+imgName));
				imgName = fileDlg.getSelectedFile().getPath();
				System.out.println("imgName="+imgName);
				lblbg.setIcon(new ImageIcon(imgName));

			}
		}else if(e.getSource()==miLook){
			new LookInfoUI(friend);
		}else if(e.getSource()==btnFind){
			//添加好友
			new FindUI(self);
		}else if(e.getSource()==miMoveToFam){//移动好友到家人组
			base.updateGroup(self.getQqCode(), friend.getQqCode(), Cmd.GROUPFAMILY);
			refresh();
		}else if(e.getSource()==miMoveToFri){//移动好友到朋友组
			base.updateGroup(self.getQqCode(), friend.getQqCode(), Cmd.GROUPFRIEND);
			refresh();
		}else if(e.getSource()==miMoveToMate){////移动好友到同学组
			base.updateGroup(self.getQqCode(), friend.getQqCode(), Cmd.GROUPMATE);
			refresh();
		}else if(e.getSource()==miMoveToBlack){//移动好友到黑名单组
			base.updateGroup(self.getQqCode(), friend.getQqCode(), Cmd.GROUPBLACK);
			refresh();
		}else if(e.getSource()==miDel){//删除好友
			
		}else if(e.getSource()==miOpen){
			MainUI.this.setVisible(true);
		}else if(e.getSource()==miExit){
			System.exit(0);
		}else if(e.getSource()==miOnline){
			String picname=self.getHeadImg();//默认在线图标
			//1.修改自己的状态
			base.updateStatus(self.getQqCode(), Cmd.STATUS[0]);
			//2.更改状态显示
			lblHead.setIcon(new ImageIcon(picname));
			//3.发送通知
			SendBody body = new SendBody();
			body.cmd = Cmd.CMD_ONLINE;
			SendMsg.sendAll(vAllInfo, self, body.cmd);
			
		}else if(e.getSource()==miBuys){
			String picname=self.getHeadImg();//默认在线图标
			int pos = picname.lastIndexOf('.');
			String pre = picname.substring(0,pos);
			String fix = picname.substring(pos,picname.length());
			picname = pre + "_l"+fix;
			//1.修改自己的状态
			base.updateStatus(self.getQqCode(), Cmd.STATUS[2]);
			//2.更改状态显示
			lblHead.setIcon(new ImageIcon(picname));
			//3.发送通知
			SendBody body = new SendBody();
			body.cmd = Cmd.CMD_BUYS;
			SendMsg.sendAll(vAllInfo, self, body.cmd);
		}else if(e.getSource()==miHidden){
			String picname=self.getHeadImg();//默认在线图标
			int pos = picname.lastIndexOf('.');
			String pre = picname.substring(0,pos);
			String fix = picname.substring(pos,picname.length());
			picname = pre + "_w"+fix;
			//1.修改自己的状态
			base.updateStatus(self.getQqCode(), Cmd.STATUS[3]);
			//2.更改状态显示
			lblHead.setIcon(new ImageIcon(picname));
			//3.发送通知
			SendBody body = new SendBody();
			body.cmd = Cmd.CMD_HIDDEN;
			SendMsg.sendAll(vAllInfo, self, body.cmd);
		}else if(e.getSource()==btnTxz){
			//推箱子游戏
			new TxzGame();
			
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/*
	 * 打开聊天窗口的3种情况：
	 * 1.在列表中双击好友头像；
	 * 2.弹出菜单，点击聊天菜单项
	 * 3.在线程中接收到好友信息
	 * 
	 * */
	//判断聊天窗口是否存在，存在就显示，不存在就创建并且显示
	public ChatUI openWin(int qqCode){
		
		ChatUI chat=chatWin.get(qqCode);
		if(chat==null){
			chat = new ChatUI(self,friend);
			chatWin.put(qqCode, chat);
		}
		chat.setVisible(true);
		return chat;
	}
	//创建接收消息的线程内部类
	class ReceiveThread extends Thread{
		
		@Override
		public void run() {
			try{
				DatagramSocket socket = new DatagramSocket(self.getPort());
				byte b[]=new byte[64*1024];
				DatagramPacket p = new DatagramPacket(b,0,b.length);
				System.out.println("线程启动成功，正在"+self.getPort()+"端口接收消息");
				while(true){
					//接收消息
					System.out.println("ok1");
					socket.receive(p);
					System.out.println("ok2");
					//获取接收到的内容的byte数组
					byte data[]=p.getData();
					//---把byte数组转换为SendBody类
					ByteArrayInputStream bais = new ByteArrayInputStream(data);
					ObjectInputStream bis = new ObjectInputStream(bais);
					SendBody msg = (SendBody)bis.readObject();
					//--------------------------------------------
					System.out.println("接收消息成功");
					friend = msg.self;
					self = msg.friend;
					ChatUI chat = null;
					switch(msg.cmd){
					case Cmd.CMD_CHAT:
						//聊天界面
						chat = openWin(friend.getQqCode());
						chat.appendView(friend.getNickName(), msg.doc);
						break;
					case Cmd.CMD_ONLINE:
						refresh();
						//显示提示窗口
						new TipUI(friend);
						break;
					case Cmd.CMD_OFFLINE:
						refresh();
						//显示提示窗口
						new TipUI(friend);
						break;
					case Cmd.CMD_BUYS:
					case Cmd.CMD_HIDDEN:
						//1.从新获取数据库最新的数据；2.更新界面的显示
						refresh();
						break;
					case Cmd.CMD_SHAKE:
						chat = openWin(friend.getQqCode());
						//抖动
						chat.shake();
						break;
					case Cmd.CMD_ADDFRI:
						SendBody body = new SendBody();
						body.self = self;
						body.friend = friend;
						String str = friend.getNickName()+"("+friend.getQqCode()+")请求添加你为好友，请确定？";
						if(JOptionPane.showConfirmDialog(null,str,"添加好友",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
							if(!base.isExist(self.getQqCode(),friend.getQqCode())){
								//添加对方为好友
								base.addFriend(self.getQqCode(), friend.getQqCode());
								//对方添加自己为好友
								base.addFriend(friend.getQqCode(),self.getQqCode());
							}
							body.cmd = Cmd.CMD_AGREEFRI;
							refresh();
						}else{
							body.cmd = Cmd.CMD_REFUSEFRI;
						}
						SendMsg.send(body);
						break;
					case Cmd.CMD_AGREEFRI:
						refresh();
//						JOptionPane.showMessageDialog(null, self.getNickName()+"同意添加你为好友");
						break;
					case Cmd.CMD_REFUSEFRI:
						JOptionPane.showMessageDialog(null, friend.getNickName()+"拒绝了您的好友请求");
						break;
					case Cmd.CMD_FILE:
						body = new SendBody();
						body.self = self;
						body.friend = friend;
						str = friend.getNickName()+"("+friend.getQqCode()+")发送了一个文件（"+body.fileName+"），是否接收？";
						if(JOptionPane.showConfirmDialog(null,str,"接收文件",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
							JFileChooser fileDlg = new JFileChooser();
							fileDlg.setDialogType(JFileChooser.SAVE_DIALOG);
//							if(fileDlg.showDialog(null, "选择文件")==JFileChooser.APPROVE_OPTION){
//								String imgName =fileDlg.getName();
//								System.out.println("imgName="+imgName);
//								
//							}
							//保存文件
							String filename = "d://"+msg.fileName;
							FileOutputStream fos = new FileOutputStream(filename);
							fos.write(msg.b);
							fos.close();
							JOptionPane.showMessageDialog(null, "接收文件成功");
						}else{
							body.cmd = Cmd.CMD_FILEREFUSE;
							SendMsg.send(body);
						}
						break;
					case Cmd.CMD_FILEREFUSE:
						JOptionPane.showMessageDialog(null, "对方拒绝接收文件");
						break;
					}
					
					//声音提示
					new Sound(msg.cmd);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	//------------------内部类--------------------
	//显示文本信息
	class DataModel extends AbstractListModel {
		Vector<AccountVo> data;
		public DataModel() {}
		public DataModel(Vector<AccountVo> data) {
			this.data = data;
		}
	    //系统自动运行，下标从0开始计算,负责显示List控件列表中的每一项内容
	    public Object getElementAt(int index) {
	    	AccountVo info = data.get(index);
	    	return info.getNickName()+"("+info.getQqCode()+")【"+info.getRemark()+"】";
	    }
	    public int getSize() {
	        return data.size();
	    }
	}
	// 获取好友头像
	class MyHeadImg extends DefaultListCellRenderer {
		Vector<AccountVo> datas;
		public MyHeadImg(Vector<AccountVo> datas) {
			this.datas = datas;
		}
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			
			//控制鼠标点击在数据项上面才执行
			if (index >= 0 && index < datas.size()) {
				AccountVo user =  datas.get(index);
				//返回当前记录的在线状态
				String status = user.getOnlinestatus();
				//获取头像对应的文件名
				String headImg = user.getHeadImg();
//				STATUS={"在线","离线","忙碌","隐身"};
				String filename = "";
				if(status.equals(Cmd.STATUS[0])){
					filename = headImg;
				}else if(status.equals(Cmd.STATUS[1])){
					//images/0.png
					//pre=images/0
					//fix=.png
					//images/0_h.png
					
					//获取.号在字符串中的索引（位置）
					int pos = headImg.lastIndexOf('.');
					//获取.号之前的字符串
					String pre = headImg.substring(0,pos);
					//获取.号之后的字符串
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "_h"+fix;
				}else if(status.equals(Cmd.STATUS[2])){
					int pos = headImg.lastIndexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "_l"+fix;
				}else if(status.equals(Cmd.STATUS[3])){
					int pos = headImg.lastIndexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "_w"+fix;
				}
				// 给列表中好友状态设置头像
//				System.out.println(filename);
				//在List中显示对应的头像
				setIcon(new ImageIcon(filename));
				//设置文本内容
				setText(user.getNickName()+"("+user.getQqCode()+")【"+user.getRemark()+"】");
//				System.out.println(user.getHeadImg());
			}
			// 设置字体颜色
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			//设置有效
			setEnabled(list.isEnabled());
			//设置默认字体
			setFont(list.getFont());
//			设置透明
			setOpaque(false);
			return this;
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbState){
			int nIndex = cbState.getSelectedIndex();
//			STATUS={"0在线","1离线","2忙碌","3隐身"};
			String status="";
			String picname=self.getHeadImg();//默认在线图标
			int pos = picname.lastIndexOf('.');
			String pre = picname.substring(0,pos);
			String fix = picname.substring(pos,picname.length());
			int cmd = Cmd.CMD_ONLINE;
			switch(nIndex){
			case 0:
				status=Cmd.STATUS[0];
				break;
			case 1:
				status=Cmd.STATUS[2];
				//images/4.0.png
				//indexOf方法是从前往后找第一个字符出现的位置
				//lastIndexOf方法是从后往前找第一个字符出现的位置
				picname = pre + "_l"+fix;
				cmd = Cmd.CMD_BUYS;
				break;
			case 2:
				status=Cmd.STATUS[3];
				picname = pre + "_w"+fix;
				cmd = Cmd.CMD_HIDDEN;
			}
			//1.修改自己的状态
			base.updateStatus(self.getQqCode(), status);
			//2.更改状态显示
			System.out.println(picname);
			lblHead.setIcon(new ImageIcon(picname));
			//3.发送通知
			SendBody body = new SendBody();
			body.cmd = cmd;
			SendMsg.sendAll(vAllInfo, self, cmd);
			//4.修改线程代码
		}
		
	}

	//激活窗口
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	//窗口已关闭
	public void windowClosed(WindowEvent e) {
		
	}
	//正在关闭窗口
	public void windowClosing(WindowEvent e) {
		//1.修改自己的状态
		base.updateStatus(self.getQqCode(), Cmd.STATUS[1]);
		self.setOnlinestatus(Cmd.STATUS[1]);
		//2.发送广播通知
		SendMsg.sendAll(vAllInfo, self,Cmd.CMD_OFFLINE);
	}

	//窗口处于非激活状态
	public void windowDeactivated(WindowEvent e) {
		
	}

	//
	public void windowDeiconified(WindowEvent e) {
		
	}
	//点击窗口最小化时，在状态栏显示图标，隐藏窗口
	public void windowIconified(WindowEvent e) {
		//获取系统托盘
		SystemTray tray = SystemTray.getSystemTray();
		if(tray!=null){
			tray.remove(trayIcon);
		}
		try {
			
			tray.add(trayIcon);
			MainUI.this.setVisible(false);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
	}

	//打开窗口
	public void windowOpened(WindowEvent e) {
		
	}
	//创建托盘菜单
	public void createTrayMenu(){
		miOpen = new MenuItem("打开");
		miExit = new MenuItem("退出");
		miOnline = new MenuItem("在线");
		miBuys = new MenuItem("忙碌");
		miHidden = new MenuItem("隐身");
		trayPopup = new PopupMenu();
		trayPopup.add(miOpen);
		trayPopup.add(miExit);
		trayPopup.add(miOnline);
		trayPopup.add(miBuys);
		trayPopup.add(miHidden);
		miOpen.addActionListener(this);
		miExit.addActionListener(this);
		miOnline.addActionListener(this);
		miBuys.addActionListener(this);
		miHidden.addActionListener(this);
	}
	//创建托盘图标
	public void createTrayIcon(){
		createTrayMenu();
		Image image = new ImageIcon("head/touxiang.png").getImage();
		trayIcon = new TrayIcon(image,"QQ2017",trayPopup);
		//系统自动调整图片大小
		trayIcon.setImageAutoSize(true);
	}
}

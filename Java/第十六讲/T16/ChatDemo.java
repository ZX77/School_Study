package T16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatDemo extends JFrame implements ActionListener{
	
	
	//接收框，发送框
	JTextArea txtReceive,txtSend;
	//发送按钮，关闭按钮，连接按钮
	JButton btnSend,btnClose,btnConn;
	//标签
	JLabel lblSelfAddr,lblSelfPort,lblPartnerAddr,lblPartnerPort;
	//文本框
	JTextField txtSelfAddr,txtSelfPort,txtPartnerAddr,txtPartnerPort;
	public ChatDemo(int aa,int bb) {
		
	}
	private ChatDemo(int aa) {
		
	}
	public ChatDemo() {
		super("UDP通信聊天软件");
		//顶部面板
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel centerPanel = new JPanel(new GridLayout(2,1,10,5));
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		
		
		lblSelfAddr = new JLabel("本地IP");
		lblSelfPort = new JLabel("本地端口");
		lblPartnerAddr = new JLabel("对方IP");
		lblPartnerPort = new JLabel("对方端口");
		txtSelfAddr = new JTextField("127.0.0.1",8);
		txtSelfPort = new JTextField("8888",4);
		txtPartnerAddr = new JTextField("127.0.0.1",8);
		txtPartnerPort = new JTextField("9999",4);
		btnConn = new JButton("连接(C)");
		btnConn.setMnemonic('C');
		topPanel.add(lblSelfAddr);
		topPanel.add(txtSelfAddr);
		topPanel.add(lblSelfPort);
		topPanel.add(txtSelfPort);
		topPanel.add(lblPartnerAddr);
		topPanel.add(txtPartnerAddr);
		topPanel.add(lblPartnerPort);
		topPanel.add(txtPartnerPort);
		topPanel.add(btnConn);
		add(topPanel,BorderLayout.NORTH);
		txtReceive = new JTextArea();
		JScrollPane sp1 = new JScrollPane(txtReceive);
		txtSend = new JTextArea();
		JScrollPane sp2 = new JScrollPane(txtSend);
		centerPanel.add(sp1);
		centerPanel.add(sp2);
		add(centerPanel);
		btnSend = new JButton("发送(S)");
		btnSend.setMnemonic('S');
		
		btnClose = new JButton("关闭(X)");
		btnClose.setMnemonic('X');
		
		bottomPanel.add(btnSend);
		bottomPanel.add(btnClose);
		add(bottomPanel,BorderLayout.SOUTH);
		
		btnConn.addActionListener(this);
		btnClose.addActionListener(this);
		btnSend.addActionListener(this);
		
		
		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ChatDemo();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnClose){
			System.exit(0);
		}else if(e.getSource()==btnConn){
			//启动接收线程
			new ReceiveThread().start();
			btnConn.setEnabled(false);
		}else if(e.getSource()==btnSend){
			//本地IP
			String localAddr = txtSelfAddr.getText().trim();
			//本地端口
			int localPort = Integer.parseInt(txtSelfPort.getText().trim());
			//远程IP
			String remoteAddr = txtPartnerAddr.getText().trim();
			//远程端口
			int remotePort = Integer.parseInt(txtPartnerPort.getText().trim());
			try{
				
				//创建DatagramSocket;
				DatagramSocket socket = new DatagramSocket();
				//获取要发送的内容
				String msg = txtSend.getText().trim();
				//把发送的字符串转换为字节数组
				byte b[] = msg.getBytes();
				//封装发送的数据报
				InetAddress addr1 = InetAddress.getByName(remoteAddr);
				DatagramPacket p = new DatagramPacket(b,0,b.length,addr1,remotePort);
				//发送信息
				socket.send(p);
				socket.close();
				//把发送内容显示在接收框，同时清空聊天内容
				String str = txtReceive.getText().trim();
				if(!str.equals("")){//第一行不会出现空行
					str += "\n";
				}
				str += "发送:"+msg+"\t"+new Date().toLocaleString()+"\n";
				//显示到接收框
				txtReceive.setText(str);
				//清空聊天内容
				txtSend.setText("");
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	//创建接收消息的线程
	
	class ReceiveThread extends Thread{
		@Override
		public void run() {
			//远程端口
			int localPort = Integer.parseInt(txtSelfPort.getText().trim());
			try{
				//创建DatagramSocket,远程的端口;
				DatagramSocket socket = new DatagramSocket(localPort);
				//接收内容
				byte b[] = new byte[4096];
				DatagramPacket p = new DatagramPacket(b,b.length);
				System.out.println("启动接收线程");
				while(true){
					//接收
					socket.receive(p);
					System.out.println("接收到信息");
					//把接收到的信息转换为字符串
					String msg = new String(b,0,p.getLength())+"\t"+new Date().toLocaleString()+"\n";
					//获取接收框的内容
					String str = txtReceive.getText().trim();
					if(!str.equals("")){//第一行不会出现空行
						str += "\n";
					}
					str += "接收:"+msg;
					//显示到接收框
					txtReceive.setText(str);
					System.out.println("接收内容是："+msg);
				}
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	}

}

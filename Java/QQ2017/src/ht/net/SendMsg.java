package ht.net;

import ht.bean.AccountVo;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Vector;

public class SendMsg {

	//发送一条信息
	public static void send(SendBody msg){
		try{
			//生成发送内容（字节数组）
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//把发送的内容输出到ByteArrayOutputStream中
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(msg);
			//转换为DatagramPacket需要的字节数组
			byte[] b= baos.toByteArray();
			//---------------------------------
			DatagramSocket socket = new DatagramSocket();
			InetAddress addr = InetAddress.getByName(msg.friend.getIpAddr());
			DatagramPacket p = new DatagramPacket(b,0,b.length,addr,msg.friend.getPort());
			//发送
			socket.send(p);
			System.out.println("发送消息成功，IP="+msg.friend.getIpAddr()+",端口="+msg.friend.getPort());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//发送多条信息(上线，离线，忙碌，隐身通知)
	public static void sendAll(Vector<AccountVo> allInfo,AccountVo self,int cmd){
		try{
			for (AccountVo acc : allInfo) {
				
				//自己不能发送给自己
				if(acc.getQqCode()==self.getQqCode()){
					continue;
				}
				//好友不在线就不发送广播
				if(!acc.getOnlinestatus().equals(Cmd.STATUS[1])){
					SendBody body = new SendBody();
					body.cmd = cmd;
					body.self=self;
					body.friend=acc;
					//调用上面的send方法
					send(body);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

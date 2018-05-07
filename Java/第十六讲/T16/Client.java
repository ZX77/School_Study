package T16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/*
	 *TCP/IP客户端程序 
	 * */
	public static void main(String[] args) {
		
		
		try {
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			//1.创建客户端socket,连接到服务器
			//地址是服务器地址，端口是服务器端口
			Socket client = new Socket(addr,8000);
			//2.创建输出流
			OutputStream os = client.getOutputStream();
			PrintStream ps = new PrintStream(os,true);
			//3.发送消息给服务器
			ps.println("客户端发送给服务器的信息，收到请回答！！！");
			//4.创建输入流
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//5.接收服务器发送的信息
			String line = br.readLine();
			System.out.println("服务器回复："+line);
			client.close();
			System.out.println("客户端结束：");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

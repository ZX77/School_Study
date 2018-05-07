package T16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	/*TCP/IP编程的步骤
	 * 1.创建服务器socket
	 * 2.监听，等待客户连接
	 * */
	public static void main(String[] args) {
		InetAddress addr;
		try {
			//指定服务器地址
			addr = InetAddress.getByName("127.0.0.1");//192.168.80.75
			//1.创建服务器socket
			//参数1：端口；参数2：允许等待的客户数；参数3：服务器地址
			ServerSocket serverSocket = new ServerSocket(8000,5,addr);
			System.out.println("服务器启动成功，"+serverSocket);
			//2.监听，等待客户连接
			Socket client = serverSocket.accept();
			System.out.println("port="+client.getPort());
			//3.获取输入流
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//4.读取客户端的数据
			String str = br.readLine();
			System.out.println("客户端说："+str);
			//5.获取输出流
			OutputStream os = client.getOutputStream();
			//true清空缓存
			PrintStream ps = new PrintStream(os,true);
			//6.发送消息给客户端
			ps.println("服务器发送的信息");
			//7.关闭服务器
			ps.close();
			br.close();
			client.close();
			serverSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

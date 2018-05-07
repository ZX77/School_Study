package T14;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 数据库操作步骤：
 * 	1.启动数据库的服务
 * 	2.启用TCP/IP协议，确保所有的连接端口为1433
 * 	3.确保数据库登录是混合模式(SQL Server和windows身份验证模式)
 * 	4.建立ODBC数据源
 * 	5.调入驱动Class.forName
 * */
public class DBconn {

	public static void main(String[] args) {
		
		try{
			
			//1.调入驱动
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//2.连接数据库
			//jdbc:odbc:数据源，数据源是在控制面板中设置的ODBC DSN名称，不是数据库的名称
			String url="jdbc:odbc:TestDB";
			String username = "sa";
			String password = "123456";
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("连接数据库成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

package T15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 数据库的连接类，负责数据库的连接与关闭
 * 
 * */
public class DBConn {

	static Connection conn=null;
	static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url="jdbc:sqlserver://localhost\\SQL2005:1433;databasename=Test";
	static String user="sa";
	static String password="123456";
	//静态语句块
	static{
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection openDB(){
		try{
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(url, user, password);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeDB(){
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

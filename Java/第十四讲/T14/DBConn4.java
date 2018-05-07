package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/*通过第三方的jar包连接数据库
 * 	1.把sqljdbc4.jar包导入项目
 * 	2.调用驱动
 * 
 * */
public class DBConn4 {

	public static void main(String[] args) {
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//databasename=数据库名称
		//\\SQL2005是数据库的实例名称，大家要根据自己电脑的安全情况进行修改，如果是默认实例名称则可以删除
		/*服务器地址
		 * 1.localhost
		 * 2.(local)
		 * 3.127.0.0.1
		 * 4.计算机名称
		 * 5.IP地址（有网络时才有IP地址）
		 * 6.域名
		 * */
		String url="jdbc:sqlserver://localhost\\SQL2005:1433;databasename=Test";
		String username="sa";
		String password="123456";
		Connection conn = null;
		try{
			//1.装载驱动
			Class.forName(driver);
			//2.连接数据库
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("数据库连接成功！");
			//3.创建Statement执行对象，statement对象可以执行查询分析器中的所有SQL语句
			Statement stmt = conn.createStatement();
			String sql = "select * from student";

			ResultSet rs = stmt.executeQuery(sql);
			//获取表结构
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();//列数
			for(int i=1;i<=cols;i++){
				System.out.println("字段名称："+rsmd.getColumnName(i)+",数据类型："+rsmd.getColumnClassName(i)+",长度："+rsmd.getColumnDisplaySize(i));
			}
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

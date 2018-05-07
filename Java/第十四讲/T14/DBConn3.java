package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*通过第三方的jar包连接数据库
 * 	1.把sqljdbc4.jar包导入项目
 * 	2.调用驱动
 * 
 * */
public class DBConn3 {

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
		try{
			//1.装载驱动
			Class.forName(driver);
			//2.连接数据库
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功！");
			//3.创建Statement执行对象，statement对象可以执行查询分析器中的所有SQL语句
			Statement stmt = conn.createStatement();
			String sql = "";
			sql = "insert into student values(4,'李小龙','361001199008081122','男',15,'341000,getdate(),2)";
//			sql = "delete student where 学号=4";
//			sql = "update student set 姓名='张三丰' where 学号=4";
			//4.返回查询结果,ResultSet的一个内存中的表
			//执行查询语句:executeQuery(sql);返回值就是ResultSet
			//更新SQL语句：executeUpdate(sql);返回值是整形值，更新的记录数
			//执行SQL语句:execute(sql);返回值是boolean，执行成功返回true，否则为false
			//关闭对象：close();
			System.out.println(sql);
			int result=stmt.executeUpdate(sql);
			System.out.println("result="+result);
			//5.关闭对象
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

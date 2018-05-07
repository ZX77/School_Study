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
public class DBConn2 {

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
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//			第一个参数：游标类型
//			ResultSet.TYPE_FORWARD_ONLY只读,默认值
//			ResultSet.TYPE_SCROLL_INSENSITIVE可以前后滚动,只能得到当前查询的值
//			ResultSet.TYPE_SCROLL_SENSITIVE可以前后滚动,可以得到数据库中的实时数据
			//第二个参数
//			ResultSet.CONCUR_READ_ONLY只读读取数据
//			ResultSet.CONCUR_UPDATABLE;可以修改数据
			
			String sql = "select * from student";
			//4.返回查询结果,ResultSet的一个内存中的表
			//执行查询语句:executeQuery(sql);返回值就是ResultSet
			//更新SQL语句：executeUpdate(sql);返回值是整形值，更新的记录数
			//执行SQL语句:execute(sql);返回值是boolean，执行成功返回true，否则为false
			//关闭对象：close();
			ResultSet rs = stmt.executeQuery(sql);
//			rs.first();
			//5.处理数据,next函数不断移动指针，直到最后一条记录，当所有读完后，返回false
//			绝对定位：rs.absolute(10);
//			移动到第一条记录：rs.first();
//			移动到下一条记录：rs.next();
//			移动到上一条记录：rs.previous();
//			移动到最后一条记录:rs.last();
			//关闭数据集：rs.close();
			//取一条记录
//			if(rs.next()){
//				
//			}
			//取多条记录
			while(rs.next()){
				System.out.println("学号="+rs.getInt(1));//传索引号，从1开始
				System.out.println("姓名="+rs.getString("姓名"));//传字段名称
//				rs.getLong(columnIndex);长整形
//				rs.getInt(columnIndex)整形
//				rs.getString(columnIndex)字符串
//				rs.getDate(columnIndex)日期
//				rs.getTime(columnIndex)时间
//				rs.getTimestamp(columnLabel)返回日期和时间
//				rs.getDouble(columnIndex)双精度类型
//				rs.getFloat(columnIndex)单精度类型
			}
			//6.关闭对象
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

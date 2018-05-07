package T15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

	/*
	 * 调用存储过程
	 * */
	
	public static void main(String[] args) {
		Connection conn = new DBConn().openDB();
		String sql = "{call up_orderId()}";
//		try {
//			CallableStatement call = conn.prepareCall(sql);
//			call.executeUpdate();
//			System.out.println("执行成功......");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		//调用带输入，输出参数的存储过程
		sql = "{call up_calcDay(?,?,?)}";
		try {
			int year = 2009;
			int month =2;
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, year);
			call.setInt(2, month);
			//输出参数
			call.registerOutParameter(3, Types.INTEGER);
			call.executeQuery();
			int days = call.getInt(3);
			System.out.println(year+"年"+month+"月份有"+days+"天");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

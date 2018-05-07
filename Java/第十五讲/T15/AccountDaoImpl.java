package T15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/*
 * 接口的实现类
 * */
public class AccountDaoImpl implements AccountADO{

	public void add(AccountInfo account) {
		//连接数据库
		Connection conn = DBConn.openDB();
//		String sql = "insert into Account values(";
//		sql += account.getQqcode() +",'";
//		sql += account.getNickName()+"','";
//		sql += account.getSex() +"',";
//		sql += account.getAge() +",'";
//		sql += account.getNation() +"','";
//		sql += account.getBlood() +"','";
//		sql += account.getStar() +"','";
//		sql += account.getJob() +"','";
//		sql += account.getPwd() +"','";
//		sql += account.getHobit() +"','";
//		sql += account.getRemark() +"')";
//		
//		System.out.println(sql);
//		try{
//			Statement stmt = conn.createStatement();
//			//新增到数据库
//			stmt.executeUpdate(sql);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		//?叫做占位符
		String sql = "insert into Account values(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			//预处理Statement
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//对每个字段设值
			pstmt.setInt(1, account.getQqcode());
			pstmt.setString(2, account.getNickName());
			pstmt.setString(3, account.getSex());
			pstmt.setInt(4, account.getAge());
			pstmt.setString(5, account.getNation());
			pstmt.setString(6, account.getBlood());
			pstmt.setString(7, account.getStar());
			pstmt.setString(8, account.getJob());
			pstmt.setString(9, account.getPwd());
			pstmt.setString(10, account.getHobit());
			pstmt.setString(11, account.getRemark());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void delete(AccountInfo account) {
		
	}

	public Vector find() {
		Vector accountList = new Vector();
		//连接数据库
		Connection conn = DBConn.openDB();
		String sql ="select * from account";
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vector v = new Vector();
				v.addElement(rs.getInt(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getInt(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString("star"));
				v.addElement(rs.getString("job"));
				v.addElement(rs.getString("pwd"));
				v.addElement(rs.getString("hobit"));
				v.addElement(rs.getString("remark"));
				accountList.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return accountList;
	}

	public void update(AccountInfo account) {
		
	}

}

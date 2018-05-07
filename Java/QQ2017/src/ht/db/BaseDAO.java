package ht.db;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import ht.bean.AccountVo;
import ht.net.Cmd;

public class BaseDAO {

	public AccountVo saveAccount(AccountVo acc){
		//获取QQ号码
		int qqcode = getQQCode();
		acc.setQqCode(qqcode);
		//连接数据库
		Connection conn = DBConn.openDB();
		try{
			//创建SQL运行环境的statement对象
			Statement stmt = conn.createStatement();
			//动态生成SQL语句
			String sql = "insert into account values(";
			sql += qqcode + ",'";
			sql += acc.getNickName().trim()+"','";
			sql += acc.getHeadImg() + "','";
			sql += acc.getPassword() +"',";
			sql += acc.getAge() +",'";
			sql += acc.getSex() +"','";
			sql += acc.getStar()+"','";
			sql += acc.getBlood() +"','";
			sql += acc.getNation() +"','";
			sql += acc.getHobit() +"','";
			sql += acc.getIpAddr() +"',";
			sql += "0,'"+Cmd.STATUS[1]+"','";
			sql += acc.getRemark()+"')";
			
			System.out.println(sql);
			//执行SQL语句，保存用户信息到account数据表
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		acc.setPort(0);
		acc.setOnlinestatus(Cmd.STATUS[1]);
		return acc;
	}
	//随机生成QQ号码
	private int getQQCode(){
		int qqcode = 0;
		Random rnd = new Random();
		//生成4位的QQ号码,abs函数取绝对值，保证随机数字是正整数
		
		Connection c=DBConn.openDB();
		String sql = "";
		try{
			sql = "select * from account where qqcode=?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			while(true){
				qqcode = Math.abs(rnd.nextInt(9000))+1000;
				pstmt.setInt(1, qqcode);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					//说明QQ号码已经被别人使用,继续循环直到生成的号码没有被人使用
					rs.close();
					continue;
				}
				//号码可以使用，终止循环
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return qqcode;
	}
	//登录
	public AccountVo login(AccountVo acc){
		
		//连接数据库
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from account where qqcode="+acc.getQqCode()+" and password='"+acc.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				acc.setNickName(rs.getString("nickName").trim());
				acc.setHeadImg(rs.getString("headImg").trim());
				acc.setAge(rs.getInt("age"));
				acc.setSex(rs.getString("sex").trim());
				acc.setStar(rs.getString("star").trim());
				acc.setBlood(rs.getString("blood").trim());
				acc.setNation(rs.getString("nation").trim());
				acc.setHobit(rs.getString("hobit").trim());
				acc.setRemark(rs.getString("remark").trim());
				rs.close();
				//设置登录时的状态，端口及IP
				acc = loginUpdate(acc);
			}else{//登录失败
				acc=null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return acc;
	}
	//设置登录时的状态，端口及IP
	public AccountVo loginUpdate(AccountVo acc){
		int port=0;
		Random rnd = new Random();
		Connection c=DBConn.openDB();
		String sql = "";
		try{
			sql = "select * from account where port=? and onlinestatus<>?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			while(true){
				//生成4位的QQ号码,abs函数取绝对值，保证随机数字是正整数
				port = Math.abs(rnd.nextInt(64000))+1024;
				pstmt.setInt(1, port);
				pstmt.setString(2, Cmd.STATUS[1]);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					//说明端口已经被别人使用,继续循环直到生成的端口没有被人使用
					rs.close();
					continue;
				}
				//号码可以使用，终止循环
				break;
			}
			pstmt.close();
			//设置端口
			acc.setPort(port);
			//设置状态
			acc.setOnlinestatus(Cmd.STATUS[0]);
			//设置地址
			InetAddress addr = InetAddress.getLocalHost();
			acc.setIpAddr(addr.getHostAddress());
			//更新用户的ip,端口和状态
			sql = "update account set ipAddr='"+acc.getIpAddr()+"',port="+acc.getPort()+",onlinestatus='"+acc.getOnlinestatus()+"' where qqcode="+acc.getQqCode();
			Statement stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return acc;
	}
	//查找所有的好友信息（朋友，家人，同学，黑名单）
	public Vector<AccountVo> allInfo(int qqcode){
		
		Vector<AccountVo> vAllInfo = new Vector<AccountVo>();
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			//好友，这部分代码需要在做完添加好友功能后修改
//			String sql = "select * from account";
			String sql = "select a.*,f.groupname from account a inner join friends f on a.qqcode = f.friendqqcode where myqqcode="+qqcode;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				AccountVo acc = new AccountVo();
				acc.setQqCode(rs.getInt("qqcode"));
				acc.setNickName(rs.getString("nickName").trim());
				acc.setHeadImg(rs.getString("headImg").trim());
				acc.setPassword(rs.getString("password"));
				acc.setAge(rs.getInt("age"));
				acc.setSex(rs.getString("sex").trim());
				acc.setStar(rs.getString("star").trim());
				acc.setBlood(rs.getString("blood").trim());
				acc.setNation(rs.getString("nation").trim());
				acc.setHobit(rs.getString("hobit").trim());
				acc.setIpAddr(rs.getString("ipaddr"));
				acc.setPort(rs.getInt("port"));
				acc.setOnlinestatus(rs.getString("onlinestatus"));
				acc.setRemark(rs.getString("remark").trim());
				//好友，这部分代码需要在做完添加好友功能后修改
				acc.setGroupName(rs.getString("groupname"));
				vAllInfo.add(acc);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vAllInfo;
	}
	//修改个人资料
	public void updateAccount(AccountVo acc){
		//连接数据库
		Connection conn = DBConn.openDB();
		try{
			//创建SQL运行环境的statement对象
			Statement stmt = conn.createStatement();
			//动态生成SQL语句
			String sql = "update account set ";
			sql += "nickname='"+acc.getNickName().trim()+"',";
			sql += "headimg='"+acc.getHeadImg() + "',";
			sql += "age="+acc.getAge() +",";
			sql += "sex='"+acc.getSex() +"',";
			sql += "star='"+acc.getStar()+"',";
			sql += "blood='"+acc.getBlood() +"',";
			sql += "nation='"+acc.getNation() +"',";
			sql += "hobit='"+acc.getHobit() +"',";
			sql += "remark='"+acc.getRemark()+"'";
			sql += " where qqcode="+acc.getQqCode();
			System.out.println(sql);
			//执行SQL语句，修改用户信息到account数据表
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//查找好友
	public Vector findFriend(final String sql){
		Vector data = new Vector();
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vector<String> rowData = new Vector<String>();
				rowData.addElement(rs.getString("qqcode"));
				rowData.addElement(rs.getString("nickname"));
				rowData.addElement(rs.getString("headimg"));
				rowData.addElement(rs.getString("age"));
				rowData.addElement(rs.getString("sex"));
				rowData.addElement(rs.getString("star"));
				rowData.addElement(rs.getString("blood"));
				rowData.addElement(rs.getString("nation"));
				rowData.addElement(rs.getString("hobit"));
				rowData.addElement(rs.getString("onlinestatus"));
				data.addElement(rowData);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
	//判断用户是否为好友
	public boolean isExist(int myqqcode,int friendqqcode){
		boolean b=false;
		Connection conn = DBConn.openDB();
		try{
			String sql = "select * from friends where myqqcode="+myqqcode+" and friendqqcode="+friendqqcode;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				b=true;
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return b;
	}
	//添加好友
	public void addFriend(int myqqcode,int friendqqcode){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "insert into friends values("+myqqcode+","+friendqqcode+",'"+Cmd.GROUPFRIEND+"')";
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//通过QQ号码操作用户资料;
	public AccountVo findByQQcode(int qqcode){
		Connection conn = DBConn.openDB();
		AccountVo acc = new AccountVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from account where qqcode="+qqcode;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				acc.setQqCode(rs.getInt("qqcode"));
				acc.setNickName(rs.getString("nickName").trim());
				acc.setHeadImg(rs.getString("headImg").trim());
				acc.setPassword(rs.getString("password"));
				acc.setAge(rs.getInt("age"));
				acc.setSex(rs.getString("sex").trim());
				acc.setStar(rs.getString("star").trim());
				acc.setBlood(rs.getString("blood").trim());
				acc.setNation(rs.getString("nation").trim());
				acc.setHobit(rs.getString("hobit").trim());
				acc.setIpAddr(rs.getString("ipaddr"));
				acc.setPort(rs.getInt("port"));
				acc.setOnlinestatus(rs.getString("onlinestatus"));
				acc.setRemark(rs.getString("remark").trim());
				//好友，这部分代码需要在做完添加好友功能后修改
				acc.setGroupName(Cmd.GROUPFRIEND);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
	//修改自己的状态
	public void updateStatus(int qqcode,String status){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="update account set onlinestatus='"+status+"' where qqcode="+qqcode;
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//修改好友的分组
	public void updateGroup(int mycode,int friendcode,String groupName){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="update friends set groupName='"+groupName+"' where myqqcode="+mycode +" and friendqqcode="+friendcode;
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

package ht.db;

import ht.bean.ForumVo;
import ht.bean.StudVo;
import ht.bean.UserVo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.vo.DepVo;


public class BaseDAO {

	//查询学生资料
	
	public List<StudVo> findStudent(){
		
		List<StudVo> list = new ArrayList<StudVo>();
		//创建Connection对象
//		Connection conn = DBPool.openDB();
		Connection conn = DBConn.openDB();
		
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from 学生表";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudVo s = new StudVo();
				s.setStudid(rs.getInt("学号"));
				s.setStudName(rs.getString("姓名").trim());
				s.setAge(rs.getInt("年龄"));
				s.setSex(rs.getString("性别").trim());
				s.setHobbit(rs.getString("爱好").trim());
				s.setMajorName(rs.getString("专业").trim());
				list.add(s);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//根据学号删除学生资料
	public void del(String studid){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "delete 学生表 where 学号="+studid;
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//新增学生资料
	public void save(StudVo s){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "insert into 学生表 values('";
			sql += s.getStudName() +"','";
			sql += s.getSex() +"',";
			sql += s.getAge() +",'";
			sql += s.getHobbit() +"','";
			sql += s.getMajorName()+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//通过学号查询一个学生的信息
	public StudVo findByStudId(String studid){
//		Connection conn = DBPool.openDB();
		Connection conn = DBConn.openDB();
		StudVo s = new StudVo();
		
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from 学生表 where 学号="+studid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				s.setStudid(rs.getInt("学号"));
				s.setStudName(rs.getString("姓名").trim());
				s.setAge(rs.getInt("年龄"));
				s.setSex(rs.getString("性别").trim());
				s.setHobbit(rs.getString("爱好").trim());
				s.setMajorName(rs.getString("专业").trim());
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
		
	}
	//修改学生资料
	public void update(StudVo s){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "update 学生表 set 姓名='";
			sql += s.getStudName() +"',性别='";
			sql += s.getSex() +"',年龄=";
			sql += s.getAge() +",爱好='";
			sql += s.getHobbit() +"',专业='";
			sql += s.getMajorName()+"' where 学号="+s.getStudid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//统计记录总数
	public int findStudentCount(){
		int cnt=0;
		//创建Connection对象
//		Connection conn = DBPool.openDB();
		Connection conn = DBConn.openDB();
		
		try{
			Statement stmt = conn.createStatement();
			String sql = "select count(*) cnt from 学生表";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cnt;
	}
	//分页查询学生资料
	public List<StudVo> findByPage(int pageSize,int curPage){
		
		List<StudVo> list = new ArrayList<StudVo>();
		//创建Connection对象
//		Connection conn = DBPool.openDB();
		Connection conn = DBConn.openDB();
		//计算起始位置
		int startPos = (curPage-1)*pageSize;
		try{
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from 学生表 where 学号 not in(";
			sql += "select top "+startPos+" 学号 from 学生表";
			sql +=")";
			System.out.println("sql="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudVo s = new StudVo();
				s.setStudid(rs.getInt("学号"));
				s.setStudName(rs.getString("姓名").trim());
				s.setAge(rs.getInt("年龄"));
				s.setSex(rs.getString("性别").trim());
				s.setHobbit(rs.getString("爱好").trim());
				s.setMajorName(rs.getString("专业").trim());
				list.add(s);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//分页查询用户资料
	public List<UserVo> userList(){
		
		List<UserVo> list = new ArrayList<UserVo>();
		//创建Connection对象
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select u.*,d.depname from users u inner join dep d on u.depid=d.depid";
			System.out.println("sql="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				UserVo u = new UserVo();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username").trim());
				u.setAddr(rs.getString("addr").trim());
				u.setDepid(rs.getInt("depid"));
				u.setEmail(rs.getString("email").trim());
				u.setJobname(rs.getString("jobname").trim());
				u.setMobile(rs.getString("mobile").trim());
				u.setPassword(rs.getString("password").trim());
				u.setQqcode(rs.getString("qqcode").trim());
				u.setRemark(rs.getString("remark").trim());
				u.setStatus(rs.getInt("status"));//1有效，0：无效
				u.setDepName(rs.getString("depName").trim());
				list.add(u);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//新增留言
	public boolean addForum(ForumVo forum){
		boolean b=false;
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "insert into forum values('";
			sql += forum.getUsername() +"','";
			sql += forum.getChatMsg() +"',getdate())";
			b=stmt.execute(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//留言列表
	public List<ForumVo> listForum(){
		
		List<ForumVo> forumList = new ArrayList<ForumVo>();
		
		//创建Connection对象
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from forum";
			System.out.println("sql="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ForumVo forum = new ForumVo();
				forum.setForumId(rs.getInt("forumId"));
				forum.setUsername(rs.getString("username").trim());
				forum.setChatMsg(rs.getString("chatMsg"));
				forum.setOprTime(rs.getTimestamp("oprTime"));
				forumList.add(forum);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return forumList;
	}
	//检查用户是否存在
	public boolean checkUser(String username){
		boolean isExists=false;
		try{
			Connection conn = DBConn.openDB();
			Statement stmt = conn.createStatement();
			String sql = "select * from users where username='"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isExists=true;
			}
			rs.close();
			stmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return isExists;
	}
	//查询所有部门资料列表
	public List<DepVo> listDept(){
		
		List<DepVo> listDep = new ArrayList<DepVo>();
		try{
			Connection conn = DBConn.openDB();
			Statement stmt = conn.createStatement();
			String sql = "select * from dep ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				DepVo d = new DepVo();
				d.setDepid(rs.getInt("depid"));
				d.setDepName(rs.getString("DEPNAME").trim());
				listDep.add(d);
			}
			rs.close();
			stmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listDep;
	}
}


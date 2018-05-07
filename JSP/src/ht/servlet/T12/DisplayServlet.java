package ht.servlet.T12;

import ht.bean.ForumVo;
import ht.db.BaseDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create table Forum
	(
		forumId int identity(1,1) primary key,
		username varchar(50) not null,
		chatMsg varchar(2000) not null,
		oprTime datetime default getdate()
	)
 * */
public class DisplayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//获取application对象
		ServletContext application = getServletContext();

		
		//获取用户名，密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username!=null){
			session.setAttribute("username", username);
		}else{
			username = (String)session.getAttribute("username");
		}
		//未登录
		if(username==null){
			request.getRequestDispatcher("T12/login.jsp").forward(request, response);
			return;
		}
		
		
		//获取留言信息
		String msg = request.getParameter("msg");
		
		//把留言内容保存到application变量中
//		if(msg !=null && !msg.equals("")){
//			if(application.getAttribute("content")==null){
//				//创建session变量
//				msg += "【"+username+"】"+msg+"<hr/>";
//				application.setAttribute("content", msg);
//			}else{
//				String content = (String)application.getAttribute("content");
//				content += "【"+username+"】"+msg +"<hr/>";
//				application.setAttribute("content", content);
//			}
//		}
		//把留言内容保存到数据库
		ForumVo forum = new ForumVo();
		forum.setUsername(username);
		forum.setChatMsg(msg);
		BaseDAO base = new BaseDAO();
		//保存留言数据到数据库
		if(forum.getChatMsg()!=null){
			base.addForum(forum);
		}
		//从数据库查询所有的留言数据
		List<ForumVo> listForum = base.listForum();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>留言板</TITLE></HEAD>");
		out.println("  <BODY>");
		//显示留言的内容
		out.println("留言内容如下：<hr>");
//		String content = (String)application.getAttribute("content");
//		if(content==null)
//			content="";
//		out.println(content);
		for (ForumVo forumVo : listForum) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = forumVo.getOprTime();
			
			out.println(sdf.format(d)+"&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("【"+forumVo.getUsername()+"】");
			out.println(forumVo.getChatMsg()+"<hr/>");
		}
		//包含
		RequestDispatcher rd = request.getRequestDispatcher("/chatServlet");
		rd.include(request, response);
	}

}

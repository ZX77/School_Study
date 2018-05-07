package ht.servlet.T11;

import ht.bean.PageObject;
import ht.bean.StudVo;
import ht.db.BaseDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELServlet extends HttpServlet {
	BaseDAO base = new BaseDAO(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("utf-8");
		//获取参数
		String action = request.getParameter("action");
		System.out.println("action="+action);
		if(action==null || action.equals("list")){
			list(request,response);
		}else if(action.equals("del")){//删除
			String studid = request.getParameter("studid");
			//删除
			base.del(studid);
			list(request,response);
		}else if(action.equals("add")){
			StudVo s = new StudVo();
			s.setStudName(request.getParameter("studname").trim());
			s.setAge(Integer.parseInt(request.getParameter("studage").trim()));
			s.setSex(request.getParameter("sex"));
			s.setHobbit(request.getParameter("hobbit").trim());
			s.setMajorName(request.getParameter("majorname").trim());
			//新增
			base.save(s);
			
			list(request,response);
		}else if(action.equals("update")){//获取需要修改的学生资料
			String studid = request.getParameter("studid");
			//查询列表
			StudVo stud = base.findByStudId(studid);
			//定义request变量，在jsp页面中使用
			request.setAttribute("stud", stud);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T11/studUpdate.jsp").forward(request, response);

		}else if(action.equals("updateSave")){
			StudVo s = new StudVo();
			s.setStudid(Integer.parseInt(request.getParameter("studid")));
			s.setStudName(request.getParameter("studname").trim());
			s.setAge(Integer.parseInt(request.getParameter("studage").trim()));
			s.setSex(request.getParameter("sex"));
			s.setHobbit(request.getParameter("hobbit").trim());
			s.setMajorName(request.getParameter("majorname").trim());
			//修改
			base.update(s);
			list(request,response);
		}
		
	}
	//分页查询
	private void list(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		PageObject pager = new PageObject();
		//读取页面的参数
		String opr = request.getParameter("opr");
		String curPage = request.getParameter("curPage");
		if(curPage==null){
			curPage="1";
		}
		//第一步：计算总记录数
		int cnt =base.findStudentCount();
		//自动计算总页数
		pager.setRowCount(cnt);
		//设置当前页
		pager.setCurPage(Integer.parseInt(curPage));
		//计算下一个当前页
		pager.setOpr(opr);
		
		//查询列表
		List<StudVo> studList = base.findByPage(pager.getPageSize(), pager.getCurPage());
		//定义request变量，在jsp页面中使用
		request.setAttribute("studList", studList);
		//分页参数
		request.setAttribute("pager", pager);
		//转向到列表页面,这个语句相当于jsp:forward动作元素
		request.getRequestDispatcher("/T11/studList.jsp").forward(request, response);
		
	}
}

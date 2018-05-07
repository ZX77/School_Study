package ht.servlet.T7;

import ht.bean.StudVo;
import ht.db.BaseDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
//		request.setCharacterEncoding("utf-8");
		//获取参数
		String action = request.getParameter("action");
		System.out.println("action="+action);
		BaseDAO base = new BaseDAO();
		if(action==null || action.equals("list")){
			//查找学生资料
			List<StudVo> studList = base.findStudent();
			//定义request变量，在jsp页面中使用
			request.setAttribute("studList", studList);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T7/studList.jsp").forward(request, response);
		}else if(action.equals("del")){//删除
			String studid = request.getParameter("studid");
			//删除
			base.del(studid);
			//查询列表
			List<StudVo> studList = base.findStudent();
			//定义request变量，在jsp页面中使用
			request.setAttribute("studList", studList);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T7/studList.jsp").forward(request, response);
		}else if(action.equals("add")){
			StudVo s = new StudVo();
			s.setStudName(request.getParameter("studname").trim());
			s.setAge(Integer.parseInt(request.getParameter("studage").trim()));
			s.setSex(request.getParameter("sex"));
			s.setHobbit(request.getParameter("hobbit").trim());
			s.setMajorName(request.getParameter("majorname").trim());
			//新增
			base.save(s);
			
			//查询列表
			List<StudVo> studList = base.findStudent();
			//定义request变量，在jsp页面中使用
			request.setAttribute("studList", studList);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T7/studList.jsp").forward(request, response);
		}else if(action.equals("update")){//获取需要修改的学生资料
			String studid = request.getParameter("studid");
			//查询列表
			StudVo stud = base.findByStudId(studid);
			//定义request变量，在jsp页面中使用
			request.setAttribute("stud", stud);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T7/studUpdate.jsp").forward(request, response);
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
			//查询列表
			List<StudVo> studList = base.findStudent();
			//定义request变量，在jsp页面中使用
			request.setAttribute("studList", studList);
			//转向到列表页面,这个语句相当于jsp:forward动作元素
			request.getRequestDispatcher("/T7/studList.jsp").forward(request, response);
		}
		
	}
}

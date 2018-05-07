package ht.servlet.T13;

import ht.db.BaseDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.vo.DepVo;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		//获取用户名称
		if(action.equals("check")){
			String username = request.getParameter("username").trim();
			BaseDAO base = new BaseDAO();
			
			if(base.checkUser(username)){
				request.setAttribute("tip", "此用户已经被注册，请选择其他用户名称。");
				request.getRequestDispatcher("/T13/inputUser.jsp").forward(request, response);
			}else{
				List<DepVo> depList = base.listDept();
				request.setAttribute("username", username);
				request.setAttribute("depList", depList);
				request.getRequestDispatcher("/T13/userAdd.jsp").forward(request, response);
			}
			
		}
	}

}

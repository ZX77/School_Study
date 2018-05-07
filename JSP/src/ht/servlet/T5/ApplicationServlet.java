package ht.servlet.T5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplicationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取session
		
		HttpSession session = request.getSession();
		//获取application
		ServletContext application = getServletContext();
		
		session.setAttribute("servletSession", "servlet中定义的session");
		application.setAttribute("servletApp", "servlet中定义的application");
		
		response.sendRedirect("T5/getServletValue.jsp");
		
		
		
	}

}

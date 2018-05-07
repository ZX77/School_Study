package ht.servlet.T12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//定义request变量；
		request.setAttribute("name", "firstServletDemo");
		
		//exampleServlet是ExampleServlet的配置的映射地址
		RequestDispatcher rd = request.getRequestDispatcher("exampleServlet");
		//转向
		rd.forward(request, response);
		
//		request.getRequestDispatcher("exampleServlet").forward(request, response);
	}

}

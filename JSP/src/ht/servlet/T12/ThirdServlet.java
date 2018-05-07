package ht.servlet.T12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc = getServletContext();

		// 定义application变量；
		sc.setAttribute("name", "ThirdServlet");
		// exampleServlet是ExampleServlet的配置的映射地址
//		RequestDispatcher rd = sc.getRequestDispatcher("/exampleServlet");
		// ExampleServlet是ExampleServlet的配置的名称
		RequestDispatcher rd = sc.getNamedDispatcher("ExampleServlet");
		rd.forward(request, response);
	}

}

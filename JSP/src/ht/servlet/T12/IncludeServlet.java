package ht.servlet.T12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//确保out对象输出的内容不会出现乱码，即服务器响应的中文乱码处理
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("我是IncludeServlet<br/>");
		out.println("<hr/>");
		// 定义request变量；
		request.setAttribute("name", "IncludeServlet");

		// exampleServlet是ExampleServlet的配置的映射地址
		RequestDispatcher rd = request.getRequestDispatcher("exampleServlet");
		// 转向
		rd.include(request, response);
//		rd.forward(request, response);

	}
}

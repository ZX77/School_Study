package ht.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String num = request.getParameter("num");
		//响应请求，发送数据到客户端
		if(num==null){
			out.println("没有测试num");
		}else if(num.equals("1")){
			out.println("参数的值为1");
		}else{
			out.println("测试成功！，值= "+num);
		}
		out.flush();
		out.close();
	}

}

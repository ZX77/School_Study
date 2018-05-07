package ht.servlet.T13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		
		//获取绝对路径
		String url = request.getHeader("referer");
		System.out.println("url="+url);
		if(url.indexOf('?')!=-1){
			//删除参数
			url = url.substring(0,url.indexOf('?'));
		}
		System.out.println("url="+url);
		//必须使用绝对路径,url重写
		url=response.encodeUrl(url);
		System.out.println("url="+url);
		//必须使用绝对路径,url重写
		url=response.encodeRedirectURL(url);
		System.out.println("url="+url);
		url+="?action="+action +"&id="+id;
		//重定向
		System.out.println("url="+url);
		response.sendRedirect(url);
	}

}

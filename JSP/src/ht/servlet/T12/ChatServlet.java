package ht.servlet.T12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>留言板</TITLE></HEAD>");	
		out.println("<script type='text/javascript'>");
		out.println("function check(){");
		out.println("var msg = form1.msg.value;");
		out.println("if(msg==''){");
		out.println("alert('请输入留言内容');");
		out.println("form1.msg.focus();");
		out.println("return false;");
		out.println("}else{");
		out.println("return true;");
		out.println("}");
		out.println("}");
		out.println("</script>");
//		out.println("  <BODY>");
		out.print("<form name='form1' action='displayServlet' method='post' onsubmit='return check();'>");
		out.println("<h1>请输入你的留言：</h1>");
		out.println("<textarea name='msg' style='width:800px;height:100px'></textarea><br/>");
		out.println("<input type='submit' value='发布留言' >");
		out.println("</form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

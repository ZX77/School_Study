package ht.servlet.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/*
	 * 文件上传： 1.要把cos.jar文件拷贝到WEB-INF/lib文件夹 2.创建上传的jsp页面，页面的表单必须有如下2个属性，并且值是固定的
	 * 1.enctype="multipart/form-data" 2.method = "post"
	 * 3.FileRenameUtil改类主要功能是对文件进行重命名，该类必须实现FileRenamePolicy接口
	 * 4.创建文件上传的servlet，实现文件上传
	 * 
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保存文件的路径，必须是tomcat里面当前项目下的子路径
		//获取项目的跟路径:request.getRealPath("/")
		//C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\JSP2017
		String filePath = request.getRealPath("/") + "uploadfile";
		System.out.println(filePath);// 输出存放上传文件所到的路径
		File uploadPath = new File(filePath);
		// 检查文件夹是否存在 不存在 创建一个
		if (!uploadPath.exists()) {
			// 创建文件夹
			uploadPath.mkdir();
		}
		// 文件最大容量 3M
		int fileMaxSize = 3 * 1024 * 1024;
		// 存放文件描述
		@SuppressWarnings("unused")
		String[] fileDiscription = { null, null };
		// 文件名
		String fileName = null;
		// 上传文件数
		int fileCount = 0;
		// 重命名策略
		RenamePolicy rfrp = new RenamePolicy();
		// 上传文件
		MultipartRequest mulit = null;
		try {
			mulit = new MultipartRequest(request, filePath, fileMaxSize,"UTF-8", rfrp);// 取得上传文件
		} catch (Exception e) {
			request.setAttribute("msg", "上传文件的大小不能超过3M");
			getServletContext().getRequestDispatcher("/upload/upload.jsp").forward(
					request, response);
			return;
		}
		Enumeration filesname = mulit.getFileNames();// 取得上传的所有文件(相当于标识)
		while (filesname.hasMoreElements()) {
			// 控件名称
			String name = (String) filesname.nextElement();
			System.out.println(name);
			fileName = mulit.getFilesystemName(name); // 取得文件名
			String contentType = mulit.getContentType(name);// 工具标识取得的文件类型
			System.out.println("文件名：" + fileName);
			System.out.println("contentType="+contentType);
		}
		//返回页面显示的文件名称
		request.setAttribute("fileName", fileName);
		request.getRequestDispatcher("upload/upload.jsp").forward(request, response);
	}

}

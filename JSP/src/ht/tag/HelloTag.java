package ht.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
 * 实现自定义标签的步骤：
 * 1.通过实现tag接口创建hello标签
 * 2.在WEB-INF/tld/文件夹下面创建mytag.tld标签库文件
 * 		1.配置标签库的信息
 * 			<description>自定义标签描述</description>
			<tlib-version>标签库的版本号，自定义</tlib-version>
			<short-name>标签库的名称，自定义</short-name>
			<uri>/demotag标签库的访问地址,以斜杠开头</uri>
		2.配置标签，每个标签对应一个tag标记
			<tag>
				<description>标签描述</description>
				<name>标签名称，页面调用该标签的名称</name>
				<tag-class>标签类的路径</tag-class>
				<body-content>空标签empty，非空标签JSP</body-content>
			</tag>  
	3.在web.xml文件载入mytag.tld
	<jsp-config>
		<taglib>
			<taglib-uri>/demotag页面访问的uri</taglib-uri>
			<taglib-location>/WEB-INF/tld/mytag.tld文件所在的路径</taglib-location>
		</taglib>
	</jsp-config>
	4.在页面调用标签
		1.导入标签库
			<%@ taglib prefix="demo" uri="/demotag"%>
		2.调用标签
			<demo:hello/>
 * */
public class HelloTag implements Tag{

	private PageContext pageContext;
	private Tag parent;
	//打印结束标签时，系统会自动调用该方法
	public int doEndTag() throws JspException {

		try {
			pageContext.getOut().println("Hello World!世界，你好！<br/>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//执行完该标签后，让页面继续执行其他内容
		return EVAL_PAGE;
	}

	//打印开始标签时，系统会自动调用该方法
	public int doStartTag() throws JspException {
//		EVAL_BODY_INCLUDE如果不是空标签，就返回该常量对应的值
		//空标签，直接跳过标签体
		return SKIP_BODY;
	}

	public Tag getParent() {
		
		return parent;
	}

	//释放资源
	public void release() {
		
		
	}

	//返回页面的上下文环境,主要获取页面的out对象
	public void setPageContext(PageContext pageContext) {
		
		this.pageContext = pageContext;
		
	}

	//获取父标签，如果没有父标签就返回null值
	public void setParent(Tag parent) {
		
		this.parent = parent;
		
	}

}

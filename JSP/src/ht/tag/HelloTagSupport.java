package ht.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/*
 * 继承TagSupport类实现自定义标签
 * 含有标签体的标签
 * */
public class HelloTagSupport extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		
		try {
			pageContext.getOut().write("Hello，");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("，您好！<br/>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}

package ht.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ForTag extends BodyTagSupport{

	private int count;

	@Override
	public void setBodyContent(BodyContent b) {
		this.bodyContent=b;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		super.doInitBody();
	}
	@Override
	public int doStartTag() throws JspException {
		if(count>0){
			try {
				pageContext.getOut().write("第"+count+"次循环：");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}
	@Override
	public int doAfterBody() throws JspException {
		if(--count>0){
			//继续循环
			try {
				pageContext.getOut().write("第"+count+"次循环：");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
	}
}

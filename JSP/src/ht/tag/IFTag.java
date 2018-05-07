package ht.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
/**
 * 继承BodyTagSupport类，实现复杂的自定义标签
 * 1.定义带属性的标签
 * 		1.定义私有变量，并且生成对应的set,get方法;
 * 		2.重写doStartTag,doEndTag,doInitBody,doAfterBody方法;
 * */
public class IFTag extends BodyTagSupport{

	private int counts;

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}
	//初始化方法，只会运行一次
	@Override
	public void doInitBody() throws JspException {
		
	}
	//开始标签时执行
	@Override
	public int doStartTag() throws JspException {
		
		if(counts>0){
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	//如果循环标签，就必须重写该方法，EVAL_BODY_AGAIN;
	@Override
	public int doAfterBody() throws JspException {
		
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}
	
}

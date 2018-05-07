package ht.tag;

import ht.bean.UserVo;
import ht.db.BaseDAO;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class UserListTag extends BodyTagSupport{

	private String align;
	private String bgcolor;
	List<UserVo> userList=null;
	@Override
	public void doInitBody() throws JspException {
	}
	@Override
	public int doStartTag() throws JspException {
		//获取用户资料
		BaseDAO base = new BaseDAO();
		userList = base.userList();
		if(userList!=null && userList.size()>0){
			try{
				JspWriter out =  pageContext.getOut();
				out.write("<table border='1' width='1000' align='"+align+"' ");
				if(bgcolor!=null && !bgcolor.equals("")){
					out.write(" bgcolor='"+bgcolor+"'>");
				}else{
					out.write(">");
				}
				
				out.write("<tr>");
				out.write("<td>用户id</td>");
				out.write("<td>用户名称</td>");
				out.write("<td>部门名称</td>");
				out.write("<td>岗位名称</td>");
				out.write("<td>电话</td>");
				out.write("<td>邮箱</td>");
				out.write("<td>QQ号码</td>");
				out.write("<td>家庭地址</td>");
				out.write("<td>备注</td>");
				out.write("</tr>");
				for (UserVo user : userList) {
					out.write("<tr>");
					out.write("<td>"+user.getUserid()+"</td>");
					out.write("<td>"+user.getUsername()+"</td>");
					out.write("<td>"+user.getDepName()+"</td>");
					out.write("<td>"+user.getJobname()+"</td>");
					out.write("<td>"+user.getMobile()+"</td>");
					out.write("<td>"+user.getEmail()+"</td>");
					out.write("<td>"+user.getQqcode()+"</td>");
					out.write("<td>"+user.getAddr()+"</td>");
					out.write("<td>"+user.getRemark()+"</td>");
					out.write("</tr>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		try{
			pageContext.getOut().write("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
}

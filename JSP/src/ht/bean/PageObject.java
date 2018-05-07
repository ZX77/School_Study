package ht.bean;

import java.io.Serializable;
/*
 * 分页对象
 * 1.rowCount;记录总数;
 * 2.pageSize;每页显示的记录数
 * 3.pageCount;总页数
 * 4.curPage;当前页
 * 5.opr;操作类型（first,next,piror,last）
 * 
 * */
public class PageObject implements Serializable{

	private int rowCount;//记录总数;
	private int pageSize=3;//每页显示的记录数
	private int pageCount;//总页数
	private int curPage=1;//当前页
	private String opr="first";
	public String getOpr() {
		return opr;
	}
	/*调用该函数时必须先对rowCount赋值，curPage赋值,pageCount赋值
	 * 
	 * */
	public void setOpr(String opr) {
		
		if(opr==null || opr.equals("")){
			opr="first";
		}
		if(opr.equals("first")){//首页（第一页）
			curPage=1;
		}else if(opr.equals("next")){//下一页
			curPage = curPage+1;
			if(curPage>pageCount){//如果大于最后一页，那么就设置为最后一页
				curPage=pageCount;
			}
		}else if(opr.equals("piror")){//上一页
			curPage = curPage-1;
			if(curPage<1){
				curPage=1;
			}
		}else if(opr.equals("last")){//最后一页（末页）
			curPage=pageCount;
		}
		this.opr = opr;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		//计算总页数
		pageCount = (int)Math.ceil((double)rowCount/(double)pageSize);
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
}

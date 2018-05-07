package ht.bean;

import java.io.Serializable;

public class Counter implements Serializable{

	private int count=0;
	
	private String youName;
	
	public String getYouName() {
		return youName;
	}
	
	public void setYouName(String youName) {
		//调用convertToUTF8方法，处理中文乱码问题
		this.youName = convertToUTF8(youName);
//		this.youName = youName;
	}
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		
		return count++;
	}
	
	/*中文乱码处理
	 * 1.通过地址栏（get）传中文参数
	 * 2.没有使用request.setCharacterEncoding方法的情况下
	 * 
	 * */
	public static String convertToUTF8(String str){
		try{
			str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	
}

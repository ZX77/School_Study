package T12;

import java.io.Serializable;
/*
 * 序列化接口：Serializable，
 * 	1.对象保存到文件，或者通过网络传输等操作时必须进行序列化操作，否则无法读取(强制转换不了)
 * 
 * */
public class QQInfo implements Serializable{

	private int qqcode;
	private String name;
	private String pwd;
	
	public QQInfo() {
		
	}
	public QQInfo(int qqcode,String name,String pwd) {
		this.name = name;
		this.pwd  = pwd;
		this.qqcode = qqcode;
	}
	
	@Override
	public String toString() {
		
		return "qqcode="+this.qqcode+",name="+name+",pwd="+this.pwd;
	}
	public int getQqcode() {
		return qqcode;
	}
	public void setQqcode(int qqcode) {
		this.qqcode = qqcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

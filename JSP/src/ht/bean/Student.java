package ht.bean;

/**
 * JAVABEAN
 * 1.必须是public类
 * 2.必须有默认的构造方法
 * 3.私有的属性，对应公有的set，get方法
 * 		set+变量名称，变量名称的首字母变大写
 * 		get+变量名称，变量名称的首字母变大写
 * 
 * 
 * */
public class Student {

	//学号
	private int studId;
	//姓名
	private String studName;
	//性别
	private String sex;
	//年龄
	private int age;
	//婚否
	private boolean marray;
	
	//兴趣爱好
	
	private String[] hobbit;
	//班级
	private String className;
	
	public void setHobbit(String[] hobbit){
		
		this.hobbit = hobbit;
	}
	//返回数组
	public String[] getHobbit(){
		
		return hobbit;
	}
	//获取设置的知道索引的元素
	public String getHobbit(int index){
		
		return hobbit[index];
	}
	//boolean类型的get方法，不是叫get，而是叫is
	
	
	
	
	//定义set方法:set+变量名称，变量名称的首字母变大写
	public void setStudId(int studId){
		this.studId = studId;
	}
	//定义get方法：get+变量名称，变量名称的首字母变大写
	public int getStudId(){
		
		return this.studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//boolean类型的变量对应的get方法，要改成is开头
	public boolean isMarray() {
		return marray;
	}
	public void setMarray(boolean marray) {
		this.marray = marray;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}

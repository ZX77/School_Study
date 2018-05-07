package ht.bean;

import java.io.Serializable;

public class StudVo implements Serializable{

	private int studid;
	private String studName;
	private String sex;
	private int age;
	private String hobbit;
	private String majorName;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
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
	public String getHobbit() {
		return hobbit;
	}
	public void setHobbit(String hobbit) {
		this.hobbit = hobbit;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
}

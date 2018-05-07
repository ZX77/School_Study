package T15;

import java.io.Serializable;
//实体bean,对应数据库中的account表
public class AccountInfo implements Serializable{

	private int qqcode;
	private String nickName;
	private String sex;
	private int age;
	private String nation;
	private String blood;
	private String star;
	private String job;
	private String pwd;
	private String hobit;
	private String remark;
	public int getQqcode() {
		return qqcode;
	}
	public void setQqcode(int qqcode) {
		this.qqcode = qqcode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getHobit() {
		return hobit;
	}
	public void setHobit(String hobit) {
		this.hobit = hobit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "qqcode="+this.qqcode+",昵称="+this.nickName;
	}
	
}

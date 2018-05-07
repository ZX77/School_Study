package ht.bean;

import java.io.Serializable;

public class Calc implements Serializable{

	private double num1;
	private double num2;
	private String opr;
	private double result;
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOpr() {
		if(opr==null || opr.equals("")){
			opr="+";
		}
		return opr;
	}
	public void setOpr(String opr) {
		this.opr = opr;
	}
	public double getResult() {
 		if(opr==null || opr.equals("")){
			opr="+";
			return 0;
		}
		if(opr.equals("+")){
			result = num1+num2;
		}else if(opr.equals("-")){
			result = num1-num2;
		}else if(opr.equals("*")){
			result = num1*num2;
		}else if(opr.equals("/")){
			result = num1/num2;
		}
		return result;
	}
}

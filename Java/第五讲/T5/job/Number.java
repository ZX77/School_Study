package T5.job;

public class Number {

	private int n1;
	private int n2;
	
	public Number(){
		n1=10;
		n2=20;
	}
	public Number(int n1,int n2){
		this.n1=n1;
		this.n2=n2;
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public int addition(){
		return n1+n2;
	}
	public int subtration(){
		return n1-n2;
	}
	public int multiplication(){
		return n1*n2;
	}
	public double division(){
		return n1*1.0/n2;
	}
	public static void main(String[] args) {
		Number num = new Number();
		int sum = num.addition();
		System.out.println("sum="+sum);
		Number num1 = new Number(88,99);
		sum = num1.multiplication();
		System.out.println("sum="+sum);
		num1.setN1(100);
		num1.setN2(1000);
		double d=num1.division();
		System.out.println("d="+d);
		
		
	}
}

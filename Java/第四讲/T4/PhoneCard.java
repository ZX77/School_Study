package T4;

/*
 * 6.1.	创建一个电话卡的类（PhoneCard)？
		帐号:cardNumber ；初始金额：initMoney 使用时间：time 
		记费方式：minMoney
		创建两个电话卡的子类——IP卡和201卡
		他们记费方式不同（每分钟费用分别为0.3和0.45）；
		给定一个时间time=5,和初始金额30，分别计算出剩余金额。

 * */
public class PhoneCard {

	String cardNumber;
	double initMoney;
	int time;
	double minMoney;
	
	public double remainMoney(){
		
		return initMoney-minMoney*time;
	}
}

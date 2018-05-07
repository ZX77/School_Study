package T4;

public class Card201 extends PhoneCard{
	public Card201() {
		cardNumber="88888888";
		initMoney=30;
		time=5;
		minMoney=0.45;
	}
	public Card201(String cardNumber,double initMoney,int time) {
		this.cardNumber = cardNumber;
		this.initMoney = initMoney;
		this.time = time;
		minMoney=0.45;
	}
}

package T4;

public class IPCard extends PhoneCard{

	public IPCard() {
		cardNumber="88888888";
		initMoney=30;
		time=5;
		minMoney=0.3;
	}
	public IPCard(String cardNumber,double initMoney,int time) {
		this.cardNumber = cardNumber;
		this.initMoney = initMoney;
		this.time = time;
		minMoney=0.3;
	}
}

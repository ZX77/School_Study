package T4;

import T3.Student;;
public class PhoneTest {

	public static void main(String[] args) {
		PhoneCard ipcard = new IPCard();
		double money=ipcard.remainMoney();
		System.out.println("IP卡还剩："+money+"元");
		PhoneCard card201 = new Card201();
		money=card201.remainMoney();
		System.out.println("201卡还剩："+money+"元");
		
//		Student s = new Student();
//		T4.Student s2 = new T4.Student();
		Student.count=1;
		
	}
	
}

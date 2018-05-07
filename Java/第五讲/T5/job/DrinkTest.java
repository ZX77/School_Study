package T5.job;

public class DrinkTest {

	public static void main(String[] args) {
		Drink drink;
		try {
			drink = Drink.getDrink(1);
			drink.taste();
			drink = Drink.getDrink(2);
			drink.taste();
			drink = Drink.getDrink(3);
			drink.taste();
			drink = Drink.getDrink(6);
			drink.taste();
		} catch (DrinkNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}

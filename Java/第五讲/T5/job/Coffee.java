package T5.job;

public class Coffee extends Drink{

	public Coffee() {
	}
	public Coffee(String name) {
		super(name);
	}
	@Override
	void taste() {
		System.out.println(name+":很苦");
		
	}

}

package T5.job;

public class Milk extends Drink{
	public Milk() {
	}
	public Milk(String name) {
		super(name);
	}
	@Override
	void taste() {
		System.out.println(name+",很浓香");
	}

	
}

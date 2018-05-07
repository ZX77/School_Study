package T5.job;

public class Beer extends Drink{
	public Beer() {
	}
	public Beer(String name) {
		super(name);
	}
	@Override
	void taste() {
		System.out.println(name+":很爽");
	}

}

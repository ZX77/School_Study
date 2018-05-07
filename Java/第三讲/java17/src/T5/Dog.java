package T5;

/*
 * 子类必须实现父类中所有的抽象方法
 * */
public class Dog extends Animal{

	@Override
	public void eat() {
		System.out.println("狗狗正在津津有味的啃骨头");
	}

	@Override
	public void play() {
		System.out.println("狗狗正在草地上玩耍");
	}

	@Override
	public void sleep() {
		System.out.println("狗狗正在树底下睡觉");
	}

	
}

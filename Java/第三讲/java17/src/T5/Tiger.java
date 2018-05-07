package T5;

public class Tiger extends Animal {

	@Override
	public void eat() {
		System.out.println("老虎正在吃羊。。。。");
	}

	@Override
	public void play() {
		System.out.println("老虎正在玩耍。。。。");
	}

	@Override
	public void sleep() {
		System.out.println("老虎正在睡觉。。。。");
	}
	public void watch(){
		
		System.out.println("老虎看到一只鹿，准备攻击.....");
	}
}

package T5;

/*
 * 实现接口，用implements关键字
 * 一个类可以同时实现多个接口，用逗号分隔
 * 类通过实现接口可以弥补单重多层继承的缺陷
 * */
public class Cat implements IAnimal,IAnimal2{

	//实现
	public void eat() {
		System.out.println("猫在吃鱼....");
	}

	public void play() {
		
	}

	public void sleep() {
		
	}

	public void watch() {
		
	}

	public void display() {
		System.out.println("我是一只小花猫...");
	}

}

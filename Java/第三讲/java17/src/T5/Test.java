package T5;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//抽象类不能创建对象
//		Animal animal = new Animal();
		
		Animal dog = new Dog();
		dog.eat();
		dog.play();
		dog.sleep();
		Animal tiger = new Tiger();
		tiger.eat();
		tiger.play();
		tiger.sleep();
		Tiger t = (Tiger)tiger;
		t.watch();
//		IAnimal an = new IAnimal();错误，接口不能实例化（不能创建对象）
		IAnimal cat = new Cat();
		cat.eat();
		IAnimal littlecat = new LittleCat();
		littlecat.eat();
	}

}

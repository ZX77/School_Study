package T5;
/*
 * 定义类的同时继承父类和实现多个接口
 * 
 * */
public class LittleCat extends Cat implements ICat,ICat2{

	public void sing() {
		
	}

	public void dance() {
		
	}
	@Override
	public void eat() {
		System.out.println("小猫喜欢吃小鱼......");
	}

	public void display(){
//		IAnimal.name="";常量，不能修改
		System.out.println("name="+IAnimal.name);
	}
	public void test(){
		
	}
}

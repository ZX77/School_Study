package T5;
/*
 *抽象类：含有abstract关键字的类叫做抽象类
 *	1.抽象类中可以没有抽象方法；
 *	2.抽象类不能直接实例化,必须通过他的子类才能实实例化，并且子类必须实现所有的抽象方法
 * 	2.含有abstract关键字的方法叫做抽象方法,有抽象方法的类必须定义为抽象类
 * 	3.抽象方法只能声明，不能实现;
 * 	4.抽象类是基于普通类与接口之间的特殊类
 * */
public abstract class Animal {

	public String name;
	//吃东西的抽象方法
	public abstract void eat();
	//睡觉的抽象方法
	public abstract void sleep();
	//玩的抽象方法
	public abstract void play();
	
	//不是抽象方法
	public String getName(){
		return this.name;
	}
	
}

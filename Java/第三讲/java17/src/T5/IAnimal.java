package T5;
/*
 * 接口(interface):
 * 	1.接口中所有的方法都必须是抽象的，共有的；所有可以省略public ,abstract
 * 	2.接口中定义的变量都是常量,具有public,static,final特性，
 * 		可以省略public,static,final关键字，
 * 	3.接口不能直接创建对象（不能实例化）,必须通过他的实现类，实现所有的抽象方法；
 * 		同过实现类创建对象
 * 	4.接口可以继承其他接口
 * 	5.如果多个接口中有相同的方法，只实现一次
 * 
 * 接口的作用：
 * 	1.用接口可以实现多层继承；
 * 	2.用接口实现群组常量的定义；
 * 	3.接口可以扩展
 * 	4.接口对程序的通用函数进行规范
 * 
 * */
public interface IAnimal {
	//接口中的常量
	public static final String name="动物";
	public abstract void eat();
	//睡觉的抽象方法
	public void sleep();
	//玩的抽象方法
	abstract void play();
	void watch();
}

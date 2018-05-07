package T5.job;
/*1、建立一个Java抽象类Drink，应当： 
a、声明一个抽象方法taste()，该方法负责输出饮料的味道； 
b、声明int型常量来代表不同的饮料类型（咖啡、啤酒、牛奶），如： 
c、声明静态工厂方法getDrink(int drinkType)，根据传入的参数创建不同的饮料对象，并返回该对象，
建议使用switch语句。该方法要求声明DrinkNotFoundException，当没有相对应的饮料类型时，抛出该异常。 
2、建立Drink的具体子类： 
a、分别建立Drink的子类：Coffee（代表咖啡），Beer（代表啤酒），Milk（代表牛奶）; 
b、实现taste()方法，要求在控制台打印各自的味道特征。
3、建立异常类DrinkNotFoundException 
a、继承Exception 
b、在Drink的方法getDrink(int drinkType)中声明引发DrinkNotFoundException异常，
当传入的参数没有相对应的饮料类型时，抛出异常。 
c、在使用getDrink方法的类中捕捉该异常。
4、建立Test测试类，测试以上内容的正确性 
a、编写main方法，通过命令行传参的方式传入某种饮料的类型。 
b、在main方法中，调用Drink类的getDrink方法，获得相应的饮料对象。注意捕获DrinkNotFoundException。 
c、然后调用该饮料对象的taste()方法，输出该饮料的味道。 
5、编译程序，并运行。  
四、 注意事项 
1、仔细审题，把题目要求理解准确； 
2、请注意多态性的运用； 
3、请注意代码的书写、命名符合规范，应有适当的注释。

 * 
 * */
public abstract class Drink {

	int drinkType;
	String name;
	public Drink() {
	}
	public Drink(String name) {
		this.name=name;
	}
	
	abstract void taste();
	public static Drink getDrink(int drinkType) throws DrinkNotFoundException{
		Drink drink=null;
		switch(drinkType){
			case 1:
				drink = new Coffee("咖啡");
				break;
			case 2:
				drink = new Beer("啤酒");
				break;
			case 3:
				drink = new Milk("牛奶");
				break;
			default:
				throw new DrinkNotFoundException(drinkType);
		}
		
		return drink;
	}
}

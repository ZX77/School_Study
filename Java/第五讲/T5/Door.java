package T5;

/*【练习题】24.抽象类、继承、接口综合 设计一个系统： 
XXX门的实现过程： 流程： 
设计一张抽象的门Door，那么对于这张门来说，就应该拥有所有门的共性，开门openDoor()和关门closeDoor()；
然后对门进行另外的功能设计,防盗--theftproof()、防水--waterproof()、
防弹--bulletproof()、防火、防锈…… 要求：利用继承、抽象类、接口的知识设计该门 
  

 * */
public abstract class Door implements IDoor{

	//防盗
	public void theftproof(){
		System.out.println("防盗门");
	}
	public void waterproof(){
		System.out.println("防水门");
	} 
	public void bulletproof(){
		System.out.println("防弹门");
	}
}

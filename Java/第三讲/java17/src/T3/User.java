package T3;

/*
 * （1）设计一个User类，其中包括用户名、口令等属性以及构造方法（至少重载2 个）。
 * 获取和设置口令的方法，显示和修改用户名的方法等。编写应用程序测试User类。  

 * */
public class User {

	String username;
	String password;
	
	public User(){
		System.out.println("默认构造函数");
	}
	
	public User(String username){
		System.out.println("一个参数的构造函数");
		this.username = username;
	}
	public User(String username,String password){
		System.out.println("2个参数的构造函数");
		this.username = username;
		this.password = password;
	}
	//获取口令
	public String getPassword(){
		
		return this.password;
	}
	//设置口令
	public void setPassword(String password){
		this.password = password;
	}
	//修改用户名
	public void setUsername(String username){
		this.username = username;
	}
	//显示内容
	public void display(){
		System.out.println("username="+username+";password="+this.password);
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.username = "张三";
		user.password = "123456";
		user.display();
		user.setPassword("888888");
		user.display();
		user.setUsername("丽丽");
		user.display();
		
		User user1 = new User("李小龙","8848");
		user1.display();
		System.out.println("username="+user1.username+";password="+user1.password);
	}
}

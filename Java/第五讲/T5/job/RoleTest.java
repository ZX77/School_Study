package T5.job;

public class RoleTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("张三",18,"男",2000,"ht001");
		Employee emp2 = new Employee("小丽",16,"女",3000,"ht002");
		System.out.println(emp1);
		System.out.println(emp2);
		Manager manager = new Manager("张三丰",30,"男",4000,"ht003");
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(manager);
//		manager.vehicle="总经理";常量的值不能修改
	}
}

package T3;

public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(2.5);
		Circle c2 = new Circle();
		c2.radius = 10;
		System.out.println("c1的周长："+c1.findPerimeter());
		System.out.println("c1的面积："+c1.findArea());
		System.out.println("c2的周长："+c2.findPerimeter());
		System.out.println("c2的面积："+c2.findArea());
		
	}
}

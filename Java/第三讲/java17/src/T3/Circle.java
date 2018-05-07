package T3;

/*
 *  (1)定义一个圆形类Circle
	属性：
	    半径 radius : double
        构造方法：
            Circle(double r)
        方法：
            求周长：public double findPerimeter()
            求面积：public double findArea()
    定义一个测试类TestCircle
    在测试类的主方法中创建两个Circle对象c1,c2，其中c1的半径为2.5，c2的半径为10，
    分别输出c1和c2各自的周长和面积。
 * */
public class Circle {
	double radius;
	public Circle(){}
	public Circle(double r){
		this.radius = r;
	}
	public double findPerimeter(){
		return 2*3.14*this.radius;
	}
	public double findArea(){
		return 3.14*radius*radius;
	}
}

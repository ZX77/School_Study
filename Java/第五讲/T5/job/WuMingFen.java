package T5.job;

public class WuMingFen {

	String theMa;
	int quantity;
	boolean likeSoup;

	public WuMingFen() {
		theMa = "酸辣面";
		quantity = 2;
		likeSoup = true;
	}
	public WuMingFen(String theMa, int quantity) {
		this.theMa = theMa;
		this.quantity = quantity;
	}
	public WuMingFen(String theMa, int quantity, boolean likeSoup) {
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}
	@Override
	public String toString() {
		String str=this.theMa+","+this.quantity+"两,";
		if(this.likeSoup){
			str+="带汤";
		}else{
			str+="不带汤";
		}
		return str;
	}
	public static void main(String[] args) {
		WuMingFen f3 = new WuMingFen();
		System.out.println(f3);
		WuMingFen f1 = new WuMingFen("牛肉面",3,true); 
		System.out.println(f1);
		WuMingFen f2 = new WuMingFen("牛肉面",2); 
		System.out.println(f2);
	}
}

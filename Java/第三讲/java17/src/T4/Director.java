package T4;

public class Director extends Teacher{

	String assistantName;
	public Director(String num, String name, double workAge, String job, String assistantName){
		super(num,name,workAge,job);
		this.assistantName = assistantName;
	}
	@Override
	public void print() {
		System.out.println("主任的工号是："+num+",助理是："+assistantName);
	}
}

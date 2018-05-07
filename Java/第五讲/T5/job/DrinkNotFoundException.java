package T5.job;

public class DrinkNotFoundException extends Exception{

	int type;
	public DrinkNotFoundException() {
		type=1;
	}
	public DrinkNotFoundException(int type) {
		this.type = type;
	}
	@Override
	public String getMessage() {
		String msg="";
		if(type>3){
			msg="您选择的饮料不存在！";
		}
		return msg;
	}
	
}

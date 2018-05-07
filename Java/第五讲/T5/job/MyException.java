package T5.job;


public class MyException extends Exception{

	double r;
	public MyException(){
		
	}
	public MyException(double r ){
		this.r = r;
	}
	@Override
	public String getMessage() {
		String msg="";
		if(r<0){
			msg=r+"小于0，半径不能为负数，请重新输入合法的半径";
		}
		return msg;
	}
}

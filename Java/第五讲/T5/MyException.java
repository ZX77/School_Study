package T5;

/*
 * 自定义的异常类
 * */
public class MyException extends Exception{

	int errorCode;
	String msg="";

	public MyException() {
		errorCode=0;
	}
	public MyException(int errorCode) {
		this.errorCode = errorCode;
	}
	public MyException(String msg) {
		super(msg);
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		switch(errorCode){
			case 1:
				msg="分母不能为0";
				break;
			case 2:
				msg="错误2";
				break;
			case 3:
				msg="错误3";
				break;
			default:
				msg="未知错误";
			break;
		}
		System.out.println("出错了："+msg);
		return msg;
	}
	
}

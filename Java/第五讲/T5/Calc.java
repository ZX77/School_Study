package T5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Calc {

	/*
	 * 在函数内部不处理异常,让调用该函数的函数去处理该异常
	 * 
	 * */
	
	public double div(double a,double b){
		double c = 0;
		if(b==0){
			//抛出新的异常
//			new MyException(1).getMessage();
			throw new ArithmeticException();
		}
		c=a/b;
		return c;
	}
	public double add(double a,double b){
		return a+b;
	}
	
	//打开一个文件
	public void openFile(String filename){
		
		try {
			FileInputStream fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
		}
	}
	//在函数内部不处理异常,让调用该函数的函数去处理该异常
	public void openFile2(String filename) throws FileNotFoundException{
		
		FileInputStream fis = new FileInputStream(new File(filename));
	}

}

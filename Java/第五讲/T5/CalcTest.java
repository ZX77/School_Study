package T5;

import java.io.FileNotFoundException;

public class CalcTest {

	void test(){
		
	}
	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.div(10, 0);
		calc.openFile("");
		try {
			calc.openFile2("d:\\text.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

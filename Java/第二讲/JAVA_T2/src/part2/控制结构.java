package part2;

public class ���ƽṹ {
	public static void main(String[] args) {
		// 1��ѡ��ṹ
		// if - else
		boolean bln;
		int a = 10, b = 20;
		bln = a > b;
		if (bln) {
			System.out.println("A>b");
		} else {
			System.out.println("A<b");
		}

		// switch case
		char c = 'a';
		switch (c) {
		case 'a':
			System.out.println("����Ԫ����ĸa");
			break;
		case 'e':
			System.out.println("����Ԫ����ĸe");
			break;
		case 'i':
			System.out.println("����Ԫ����ĸi");
			break;
		case 'o':
			System.out.println("����Ԫ����ĸo");
			break;
		case 'u':
			System.out.println("����Ԫ����ĸu");
			break;
		default:
			System.out.println("����Ԫ����ĸ");
		}

		// 2��ѭ���ṹ
		// while do-while for
		for (int i = 0; i < 10; i++) { // ѭ����������ֱ���� for�����ж���
			System.out.println("i = " + i);
		}
		
		//3��break ����ѭ�� ����ִ��  �� continue  ��������ѭ�� ������һ��ѭ��
	}
}

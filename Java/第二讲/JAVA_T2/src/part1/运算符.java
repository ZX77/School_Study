package part1;

public class ����� {
	public static void main(String[] args) {
		// 1����������� + - * / % ++ --
		// �ַ���������+��ƴ��
		String a = "He";
		String b = "llo";
		System.out.println(a + b);

		// ���ͳ������� ���������
		System.out.println(3510 / 1000 * 1000);

		// 2����ֵ�����= += -= *= /= %=
		int i = 10, j = 0;
		j = i++;
		System.out.println("i�Ľ���� " + i + " j�Ľ���� " + j);

		// 3���Ƚ������ == > < >= <= != instanceof
		boolean bln;
		bln = 1 > 2;
		System.out.println("�����" + bln);

		// �� ����
		����� s = new �����();
		System.out.println("����� " + (s instanceof �����));

		// 4���߼������
		// & �߼��� | �߼��� ^��� !�� &&��·�� ||��·��
		// &��&&������:&���κ��������ȥ�ж����ߵı��ʽ
		int m = 10, n = 20;
		System.out.println("�߼���  "+(m > n & m == 10));
		
		//��� ^
		//1 ^ 0  1
		//0 ^ 1  1
		//1 ^ 1  0
		//0 ^ 0  0
		System.out.println("��� "+(m > n ^ m != 10));
		
		//5����Ŀ�����
		int days=24,salary=0;
		salary = days==24?3000:2500;
		System.out.print("�����µ� ��н�� "+salary);

	}
}

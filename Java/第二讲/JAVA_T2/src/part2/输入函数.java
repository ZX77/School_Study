package part2;

import java.util.Scanner;

public class ���뺯�� {
	public static void main(String[] args) {

		System.out.print("������һ����:");
		
		//�õ���������Ķ���
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt(); // ����һ������
		
		System.out.print("��������һ����:");
		
		int b = scan.nextInt();
		
		System.out.print("����� "+(a+b));
		
		System.out.print("������һ�仰:");
		
		
		//���������ַ��� ��Ҫʹ����һ��scanner����
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//�����ַ��� 
		System.out.print("������Ļ��� :"+str);
	}
}

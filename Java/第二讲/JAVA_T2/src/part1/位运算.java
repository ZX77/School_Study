package part1;

public class λ���� {
	public static void main(String[] args) {
		//λ����
		int a=6;
		int b=2;
		int c=0;
		//1�� ~ ��λ�� /ȡ��   (�ȼ�1 ��ȡ��)
		//8    4    9     -5
		//-9   -5   -10   4
		c = ~a;
		System.out.println("C �Ľ�� �� "+c);
		
		//2��& ��λ��  (����Ϊ1 �����1 ����Ϊ0)
		c = a & b;
		//110   a
		//011   b
		//010   c
		System.out.println("C �Ľ�� �� "+c);
		
		//3��|��λ��  ��������1 ���Ϊ1 ����Ϊ0��
		c = a | b;
		//110  a
		//010  b
		//110
		System.out.println("C �Ľ�� �� "+c);
		
		//4��^��λ���(���²�ͬΪ1 ��ͬΪ0)
		c = a ^ b;
		//110  a
		//010  b
		//100
		System.out.println("C �Ľ�� �� "+c);
		
		//5��>> ����  �������������������ƶ� ��λ��0��
		//110  a
		//011
		c = a>>1;
		System.out.println("C �Ľ�� �� "+c);
		
		//6��<< ����
		c = a << 2;
		//110
	//  11000 
		System.out.println("C �Ľ�� �� "+c);
	}
}

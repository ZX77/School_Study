package part1;

public class ���� {
	public static void main(String[] args){
		//����ע��
		/*
		 * ����ע��
		 */
		//println �����е����
		//1��byte ���� -128 - 127 (1�ֽ�)
		byte b=127;
		System.out.println(b+100);
		
		//2������ (4�ֽ�)
		int a=2000,cb=0;
		System.out.println(a+cb);
		
		//3��char�ַ� (2�ֽ�)
		char c='a';
		
		//4��String �ַ���
		String s="����javaר�е��ַ���";
		
		System.out.println("��������ַ���������:"+s);
		
		//5��boolean ������ (����߼�ֵ true/false)
		boolean bln=true;
		System.out.println(bln);
		
		
		//�Զ���������ת�� (����С���������͸�ֵ�����ȴ����������)
		int i=0;
		byte b1=10;
		i=b1;
		
		//ǿ����������ת��
		b1 =(byte) i;
		
		
		//���ַ����͸����ͼ���ʱ �ַ���ת����ASCII����м���
		System.out.println('a'+1);
		
		//�ַ���
		System.out.println("�����ַ���"+1);	
		System.out.println('a'+1+"");
		
		
	}
}

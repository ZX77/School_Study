package part2;

public class ���� {
	public static void main(String[] args){
		//һά����
		
		int i = 10;
		int[] a1 =new int[5];//��������ʱ���ʼ�������С
		
		
		int a2[];//������
		
		a2=new int[i];//�ٳ�ʼ�������С (�����ñ�����Ϊ�����С)
		
		
		//һά���龲̬��ֵ
		int b[]={1,2,3,4};
		int b2[]=new int[]{1,2,3,4,5};
		
		for(int j=0;j<b.length;j++){
			System.out.println(b[j]);
		}
		
		
		
		int b3[];
		//b3[0]=10;// ���� ��   ����ʹ��֮ǰҪ��ʼ��
		
		
		
		//��ά����
		int c[][]=new int[3][4];
		
		//��̬��ֵ
		int d[][]={{1,2,3},{1,34,3},{1,2,34}};
		
		
		//���ָ���������ά����
		int xx[][]=new int [3][];//��ָ��һ��3��N�е�����
		xx[0]=new int[3];// ����һ����������Ϊ3
		xx[1]=new int[1]; //���ڶ�����������Ϊ1
		xx[2]=new int[2]; //���ڶ�����������Ϊ2
		
		xx[1][1]=10;//���� �ڶ���ֻ��1��
		
		System.out.println(xx[1][1]);
		
		
		
	}
}

/* Note:Your choice is C IDE */
#include "stdio.h"

void sums();


//�ֲ�����
//1���������Զ��庯�����������еı��������÷�Χ�����ڱ������У�
//2����ͬ�����ľֲ���������Ӱ�죬���ƿ�����ͬ��
//3���ֲ������Ǻ���˽�е�
void main()
{
	int sum=0;
    sums();//���ú���
    printf("��������sum��ֵ��%d",sum);
    
    {//������䣺�ں�����ʹ�ô�����ָ���ķ�Χ
    	int sum=5;//�ֲ��������������ľֲ�������
    	printf("��������е�sum %d",sum);
    }
}

void sums(){
	int a,b,sum=0;//�ֲ�����
	printf("��������������");
	scanf("%d %d",&a,&b);
	sum=a+b;
	printf("sum��ֵ�� %d",sum);
}
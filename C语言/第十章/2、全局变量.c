/* Note:Your choice is C IDE */
#include "stdio.h"

void sums();

int sum=0;//ȫ�ֱ���

void main()
{
    //ȫ�ֱ���
    //1���ں������涨�壬���÷�Χ����������
    //2��ȫ�ֱ����ǹ����
    //3���ֲ�������ȫ�ֱ�������ͬ���������Ȼ�ȡ�ֲ�������ֵ��
    int sum=0;//�ֲ�����
    sums();
    printf("��������sum��ֵ��%d",sum);
}

void sums(){
	int a,b;
	printf("��������������");
	scanf("%d %d",&a,&b);
	sum=a+b;
	printf("sum��ֵ��%d",sum);
}
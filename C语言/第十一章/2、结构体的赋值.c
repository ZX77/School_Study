/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�ṹ���ʹ��
    
    
    //1���ṹ�������
    struct student{
    	int num;//���
    	char stuname[20];//����
    	int age;//����
    	char sex;
    	float height;//���
    };
	
	//2���ṹ��ľ�̬��ֵ (��ֵʱ��Ҫע�� �ṹ���Ա����������������)
	struct student stu1={1000,"����",20,'M',180},stu2,stu3;
	
	stu1.num=2000;
	
	//3���ṹ�徲̬ȡֵ
	//ʹ�ýṹ������㣨.���ṹ���Ա���� 
	//ռλ����Ҫ�ͽṹ���Ա����������һ��
	printf("ѧ���ı����%d ѧ����������%s ѧ����������%d,ѧ�����Ա���%c,ѧ���������%.2f\n",stu1.num,stu1.stuname,stu1.age,stu1.sex,stu1.height);
	
	
	
	//�ṹ������Ķ�̬��ֵ
	//�ü���������ṹ�������ֵ
	printf("������ѧ����ţ�");
	scanf("%d",&stu2.num);
	printf("������ѧ��������");
	fflush(stdin);//������̻���
	scanf("%s",&stu2.stuname);
	printf("������ѧ������:");
	scanf("%d",&stu2.age);
	
	printf("ѧ��2�ı����%d,������%s,������ %d\n",stu2.num,stu2.stuname,stu2.age);
	
	
	//�ṹ������������帳ֵ����һ���ṹ���ֵȫ����������һ���ṹ�壩
	stu3=stu2;
	
	stu3.age=30;
	
	printf("ѧ��3�ı����%d,������%s,������ %d",stu3.num,stu3.stuname,stu3.age);
}
/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���� Ƕ�׽ṹ��
    struct date{
    	int year;
    	int month;
    	int day;	
    };
    
    //ѧ���ṹ��
    struct stuent{
    	int num;
    	char stuname[20];
    	struct date birthday;//Ƕ�׽ṹ��
    }stu1;
    
    
    //��Ƕ�׽ṹ�帳ֵ
    stu1.num=1000;
    
    //����
    printf("������ѧ��������");
    scanf("%s",&stu1.stuname);
    
    //����
    //bithday����stu1��˵�ǳ�Ա
    //year month day��bithday�ĳ�Ա
    stu1.birthday.year=1991;
    stu1.birthday.month=9;
    stu1.birthday.day=1;
    
    
    
    printf("ѧ���ı���� %d ,������%s,������%d-%d-%d",stu1.num,stu1.stuname,stu1.birthday.year,stu1.birthday.month,stu1.birthday.day);
    
    
    
}
/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�����������ĺͣ���ʾ�������n�˳�������������
    int a,b;
    char c;
    do{
	    printf("�����������������ÿո������");
	    scanf("%d %d",&a,&b);
	    printf("�����%d\n",a+b);
	    
	    printf("����e�˳���������������");
	    fflush(stdin);//������̻��棨����һ�����룬Ȼ���������ַ����������Ҫ������̻��棩
	    scanf("%c",&c);
    }while(c!='e');
}
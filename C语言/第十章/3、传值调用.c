/* Note:Your choice is C IDE */
#include "stdio.h"
void tt(int);

void main()
{
	//���Զ��庯�����ݲ�����Ϊ
	//��ֵ���ã�ֻ�ǽ�������ֵ���ݹ�ȥ����û�иı�������ڴ��ַ��
	//��ַ����
	int a=0;
	tt(a);
	printf("a��ֵ��%d",a);
}

void tt(int a){
	printf("a = %d",a);
	a=10;
}

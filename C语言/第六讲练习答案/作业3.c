/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����һ�����֣������ֵ�ǰ��˳��ת
    int a;
    printf("������һ��������");
    scanf("%d",&a); // 3456
    while(a!=0){
    	printf("%d",a%10);//6543
    	a=a/10;//0
    }
}
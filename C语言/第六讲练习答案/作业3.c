/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入一串数字，将数字的前后顺序倒转
    int a;
    printf("请输入一个整数：");
    scanf("%d",&a); // 3456
    while(a!=0){
    	printf("%d",a%10);//6543
    	a=a/10;//0
    }
}
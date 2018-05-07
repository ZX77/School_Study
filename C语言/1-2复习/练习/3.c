/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //3、输入两个整数，并计算这两个数的 和、差、积、商、余数（%）
    int a,b;
    printf("请输入两个整数，用逗号隔开：");
    scanf("%d,%d",&a,&b);
    printf("%d + %d = %d \n",a,b,a+b);
    printf("%d - %d = %d \n",a,b,a-b);
    printf("%d * %d = %d \n",a,b,a*b);
    printf("%d / %d = %d \n",a,b,a/b);
    printf("%d %% %d = %d \n",a,b,a%b);
}
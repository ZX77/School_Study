/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1、梯形的面积 （输入上底、下底、高）
    float a,b,h;
    printf("请输入梯形的上底、下底、高(用空格分开，回车结束)：");
    scanf("%f %f %f",&a,&b,&h);
    printf("梯形的面积是 %.2f 平方米",(a+b)*h/2);
}
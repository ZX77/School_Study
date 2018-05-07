/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //写一个计算圆柱体体积的程序
    float r,h,v;
    printf("请输入圆柱体的半径：");
    scanf("%f",&r);
    printf("请输入圆柱体的高：");
    scanf("%f",&h);
    v = 3.14*r*r*h;
    printf("圆柱体的体积是 %.2f",v);
}
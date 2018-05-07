/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输出函数
    //%d 整型
    //%f 浮点型
    //%c 字符型
    
    // 输出整型
    int i = 40;
    float f=1.34346;
    
    char c ='c';
    
    short s =10;
    int v;
    float ff;
    
    printf("i变量的值是 %d \n",i);
    
    
    //输出浮点型(浮点型默认精确到6位小数，不够添0)
    printf("f 的值是  %f \n",f);
    
    //%.2f取两位小数
    printf("f 显示所有小数 %.2f\n",f);
    
    //%.0f 取整数部分
    printf("f 取整数部分 %.0f\n",f);
    
    //输出字符(以%c形式输出就是输出该字符  如果以%d的形式输出就是输出这个字符的ASCII码)
    printf("这个字符是  %c",c);
    
    printf("这个字符的ASCII码是 %d \n",c);
    
    
    //如果一个整型以%c的形式输出，那么会以整型作为ASCII输出对应字符
    printf(" 整型以字符形式输出 %c  \n",i);
    
    //ASCII码
    //A-Z （65-90）
    //a-z  (97-122)
    //0-9  (48-57)
    
    //自动数据类型转换（低精度的数据类型可以自动转换为高精度的数据类型）数值类型
    //short - int - long - float - double
    v = s;
    ff = s ;
    printf("V的值是 %d ff 的值是 %f \n",v,ff);
    
    
    //高精度转换低精度（强制转换，可能会影响原来的结果）
    printf("  值是  %d",(int)1.5);
}